package classes.teamProject;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class StockGame extends JFrame {
    private JLabel lblCash, lblStockCount, lblTotalAsset, lblPrice, lblMarketTime;
    private JComboBox<String> comboStocks;
    private JButton btnBuy, btnSell;
    private Map<String, Integer> stockPrices = new HashMap<>();
    private Map<String, Integer> stockCounts = new HashMap<>();
    private Map<String, ArrayList<Integer>> priceHistories = new HashMap<>();
    private Map<String, ArrayList<StockChartPanel.CandleData>> candleDatas = new HashMap<>();
    private Map<String, ArrayList<Integer>> volumeHistories = new HashMap<>();
    private ArrayList<Integer> priceHistory;
    private JLabel lblAveragePrice;
    private Map<String, Integer> stockAveragePrices = new HashMap<>();
    private int cash = 500000; // 초기 보유 현금
    private Timer timer;
    private Random random = new Random();
    private StockChartPanel chartPanel;
    private final int TARGET_ASSET = 2000000; // 목표 자산 (200만원)
    private final double TRADING_FEE = 0.00015; // 거래 수수료 0.015%
    private ArrayList<String> tradingHistory = new ArrayList<>();
    private JTextArea tradingHistoryArea;
    private int gameDifficulty = 1; // 1: 쉬움, 2: 보통, 3: 어려움

    // 생성자: 게임 초기화
    public StockGame() {
        setTitle("주식 게임");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initStocks(); // 종목과 초기 주식 수 설정

        Font font = new Font("맑은 고딕", Font.BOLD, 16);

        // 상단 정보 패널
        JPanel topPanel = new JPanel(new GridLayout(4, 2));
        lblCash = createLabel("보유 현금: " + cash + "원", font);
        lblStockCount = createLabel("보유 주식: 0주", font);
        lblTotalAsset = createLabel("총 자산: " + calculateTotalAsset() + "원", font);
        lblAveragePrice = createLabel("평균 매수가: -원", font);
        lblPrice = createLabel("", font);
        lblMarketTime = createLabel("", font);
        comboStocks = new JComboBox<>(stockPrices.keySet().toArray(new String[0]));
        comboStocks.setFont(font);

        topPanel.add(lblCash);
        topPanel.add(lblStockCount);
        topPanel.add(lblTotalAsset);
        topPanel.add(lblAveragePrice);
        topPanel.add(comboStocks);
        topPanel.add(lblPrice);
        topPanel.add(lblMarketTime);

        add(topPanel, BorderLayout.NORTH);

        // 매수/매도 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnBuy = createButton("매수", Color.GREEN, Color.BLACK, font);
        btnSell = createButton("매도", Color.RED, Color.WHITE, font);
        buttonPanel.add(btnBuy);
        buttonPanel.add(btnSell);
        add(buttonPanel, BorderLayout.SOUTH);

        // 차트 패널
        chartPanel = new StockChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        // 거래 내역 패널
        JPanel historyPanel = new JPanel(new BorderLayout());
        tradingHistoryArea = new JTextArea();
        tradingHistoryArea.setEditable(false);
        tradingHistoryArea.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(tradingHistoryArea);
        historyPanel.add(scrollPane, BorderLayout.CENTER);
        add(historyPanel, BorderLayout.EAST);

        String selectedStock = (String) comboStocks.getSelectedItem();
        priceHistory = priceHistories.get(selectedStock);
        priceHistory.add(stockPrices.get(selectedStock));
        chartPanel.setChartData(
                priceHistory,
                candleDatas.get(selectedStock),
                volumeHistories.get(selectedStock));
        updateLabels();

        // 콤보박스 선택 변경 시
        comboStocks.addActionListener(e -> updateStockSelection());

        // 매수 버튼 클릭
        btnBuy.addActionListener(e -> {
            if (isMarketOpen())
                buyStock();
            else
                showMessage("⏰ 시장이 열려있지 않습니다!");
        });

        // 매도 버튼 클릭
        btnSell.addActionListener(e -> {
            if (isMarketOpen())
                sellStock();
            else
                showMessage("⏰ 시장이 열려있지 않습니다!");
        });

        // 주가 업데이트 시간 설정
        timer = new Timer(1000, e -> {
            updateStockPrices();
            maybeTriggerNews();
            updateLabels();
            checkWinOrLose();
            chartPanel.repaint();
        });
        timer.start();

        setVisible(true);
    }

    // 주식 종목 및 초기 가격 설정
    private void initStocks() {
        stockPrices.put("삼성전자", 70000);
        stockPrices.put("네이버", 150000);
        stockPrices.put("카카오", 80000);
        stockPrices.put("LG전자", 100000);
        stockPrices.put("SK하이닉스", 120000);
        for (String stock : stockPrices.keySet()) {
            stockCounts.put(stock, 0);
            stockAveragePrices.put(stock, 0);
            priceHistories.put(stock, new ArrayList<>());
            candleDatas.put(stock, new ArrayList<>());
            volumeHistories.put(stock, new ArrayList<>());
        }
    }

    // 라벨 생성
    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        return label;
    }

    // 버튼 생성
    private JButton createButton(String text, Color bg, Color fg, Font font) {
        JButton button = new JButton(text);
        button.setBackground(bg);
        button.setForeground(fg);
        button.setFont(font);
        return button;
    }

    // 콤보박스에서 종목 변경 시 호출
    private void updateStockSelection() {
        String selectedStock = (String) comboStocks.getSelectedItem();
        priceHistory = priceHistories.get(selectedStock);
        chartPanel.setChartData(
                priceHistory,
                candleDatas.get(selectedStock),
                volumeHistories.get(selectedStock));
        updateLabels();
        chartPanel.repaint();
    }

    // 주가 랜덤 업데이트
    private void updateStockPrices() {
        for (String stock : stockPrices.keySet()) {
            int change = random.nextInt(201) - 100; // -100 ~ +100 변동
            change = (int) (change * (1 + (gameDifficulty - 1) * 0.5));
            stockPrices.put(stock, Math.max(stockPrices.get(stock) + change, 1000));
            priceHistories.get(stock).add(stockPrices.get(stock));
        }
    }

    // 뉴스 발생 (10% 확률)
    private void maybeTriggerNews() {
        if (random.nextInt(100) < 10) {
            int type = random.nextInt(8);
            switch (type) {
                case 0 -> {
                    showMessage("🚀 삼성전자 신제품 발표! 삼성전자 주가 급등!");
                    adjustStock("삼성전자", +0.3);
                }
                case 1 -> {
                    showMessage("📉 카카오 개인정보 유출 사고! 카카오 주가 급락!");
                    adjustStock("카카오", -0.3);
                }
                case 2 -> {
                    showMessage("🌍 글로벌 경제 호조! 전체 주식 상승!");
                    adjustAllStocks(+0.2);
                }
                case 3 -> {
                    showMessage("⚡ 네이버 AI 기술 대박! 네이버 주가 급등!");
                    adjustStock("네이버", +0.25);
                }
                case 4 -> {
                    showMessage("🔥 삼성전자 리콜 사고! 삼성전자 주가 급락!");
                    adjustStock("삼성전자", -0.25);
                }
                case 5 -> {
                    showMessage("💸 기준금리 인상 발표! 전체 주식 하락!");
                    adjustAllStocks(-0.2);
                }
                case 6 -> {
                    showMessage("🛡️ 카카오톡 보안 강화 성공! 카카오 주가 상승!");
                    adjustStock("카카오", +0.2);
                }
                case 7 -> {
                    showMessage("💀 글로벌 경제 불황 선언! 전체 주식 폭락!");
                    adjustAllStocks(-0.3);
                }
            }
        }
    }

    // 특정 종목 주가 조정
    private void adjustStock(String stock, double rate) {
        int price = stockPrices.get(stock);
        int newPrice = (int) (price * (1 + rate));
        stockPrices.put(stock, Math.max(newPrice, 1000));
    }

    // 전체 종목 주가 조정
    private void adjustAllStocks(double rate) {
        for (String stock : stockPrices.keySet()) {
            adjustStock(stock, rate);
        }
    }

    // 화면 정보 업데이트
    private void updateLabels() {
        String stock = (String) comboStocks.getSelectedItem();
        int currentPrice = stockPrices.get(stock);
        int averagePrice = stockAveragePrices.getOrDefault(stock, 0);

        lblCash.setText("보유 현금: " + cash + "원");
        lblStockCount.setText("보유 주식: " + stockCounts.get(stock) + "주");
        lblTotalAsset.setText("총 자산: " + calculateTotalAsset() + "원");
        lblAveragePrice.setText("평균 매수가: " + (averagePrice > 0 ? averagePrice + "원" : "-원"));

        // 시장 시간 표시 (개장/폐장 기능 일시 비활성화)
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());
        lblMarketTime.setText("시장 상태: 개장 (" + currentTime + ")");
        lblMarketTime.setForeground(Color.GREEN);

        if (averagePrice > 0) {
            if (currentPrice > averagePrice) {
                lblPrice.setText("현재 주가 (" + stock + "): " + currentPrice + "원 ▲");
                lblPrice.setForeground(Color.RED);
            } else if (currentPrice < averagePrice) {
                lblPrice.setText("현재 주가 (" + stock + "): " + currentPrice + "원 ▼");
                lblPrice.setForeground(Color.BLUE);
            } else {
                lblPrice.setText("현재 주가 (" + stock + "): " + currentPrice + "원");
                lblPrice.setForeground(Color.BLACK);
            }
        } else {
            lblPrice.setText("현재 주가 (" + stock + "): " + currentPrice + "원");
            lblPrice.setForeground(Color.BLACK);
        }
    }

    // 총 자산 계산
    private int calculateTotalAsset() {
        int total = cash;
        for (String stock : stockPrices.keySet()) {
            total += stockPrices.get(stock) * stockCounts.get(stock);
        }
        return total;
    }

    // 장 열림 여부 확인
    private boolean isMarketOpen() {
        // 개장/폐장 기능 일시 비활성화
        return true;

        /*
         * 기존 코드 주석 처리
         * Calendar cal = Calendar.getInstance();
         * int hour = cal.get(Calendar.HOUR_OF_DAY);
         * return hour >= 9 && hour < 15;
         */
    }

    // 주식 매수 처리
    private void buyStock() {
        String stock = (String) comboStocks.getSelectedItem();
        String input = JOptionPane.showInputDialog(stock + " 몇 주를 매수하시겠습니까?");
        try {
            int quantity = Integer.parseInt(input);
            int price = stockPrices.get(stock);
            int cost = price * quantity;
            int fee = (int) (cost * TRADING_FEE);
            int totalCost = cost + fee;

            if (totalCost > cash) {
                showMessage("현금이 부족합니다. (수수료 포함: " + fee + "원)");
            } else {
                cash -= totalCost;
                int prevCount = stockCounts.get(stock);
                int prevTotal = stockAveragePrices.get(stock) * prevCount;
                int newCount = prevCount + quantity;
                int newAveragePrice = (prevTotal + cost) / newCount;

                stockCounts.put(stock, stockCounts.get(stock) + quantity);
                stockAveragePrices.put(stock, newAveragePrice);

                // 거래 내역 기록
                String history = String.format("[매수] %s %d주 @ %d원 (수수료: %d원)",
                        stock, quantity, price, fee);
                addTradingHistory(history);

                updateLabels();
            }
        } catch (Exception ex) {
            showMessage("숫자를 입력하세요.");
        }
    }

    // 주식 매도 처리
    private void sellStock() {
        String stock = (String) comboStocks.getSelectedItem();
        String input = JOptionPane.showInputDialog(stock + " 몇 주를 매도하시겠습니까?");
        try {
            int quantity = Integer.parseInt(input);
            if (quantity > stockCounts.get(stock)) {
                showMessage("보유 주식이 부족합니다.");
            } else {
                int price = stockPrices.get(stock);
                int revenue = price * quantity;
                int fee = (int) (revenue * TRADING_FEE);
                int netRevenue = revenue - fee;

                cash += netRevenue;
                stockCounts.put(stock, stockCounts.get(stock) - quantity);

                // 거래 내역 기록
                String history = String.format("[매도] %s %d주 @ %d원 (수수료: %d원)",
                        stock, quantity, price, fee);
                addTradingHistory(history);

                updateLabels();
            }
        } catch (Exception ex) {
            showMessage("숫자를 입력하세요.");
        }
    }

    // 거래 내역 추가
    private void addTradingHistory(String history) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date());
        tradingHistory.add(time + " " + history);
        tradingHistoryArea.setText("");
        for (String h : tradingHistory) {
            tradingHistoryArea.append(h + "\n");
        }
    }

    // 승리 또는 패배 체크
    private void checkWinOrLose() {
        if (calculateTotalAsset() >= TARGET_ASSET) {
            gameOver("목표 달성! 승리했습니다!");
        } else if (cash <= 0 && totalStockValue() == 0) {
            gameOver("파산했습니다. 게임 종료.");
        }
    }

    // 보유 주식 가치 합산
    private int totalStockValue() {
        int total = 0;
        for (String stock : stockPrices.keySet()) {
            total += stockPrices.get(stock) * stockCounts.get(stock);
        }
        return total;
    }

    // 게임 종료 처리
    private void gameOver(String message) {
        timer.stop();
        showMessage(message);
        saveResultToFile();
        System.exit(0);
    }

    // 게임 결과 파일 저장
    private void saveResultToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_result.txt"))) {
            writer.write("===== 게임 결과 =====\n");
            writer.write("최종 보유 현금: " + cash + "원\n");
            writer.write("총 자산: " + calculateTotalAsset() + "원\n");
            writer.write("거래 수수료: " + TRADING_FEE * 100 + "%\n");
            writer.write("게임 난이도: " + gameDifficulty + "\n\n");
            writer.write("보유 주식 현황:\n");
            for (String stock : stockPrices.keySet()) {
                writer.write(stock + " 보유 수량: " + stockCounts.get(stock) + "주\n");
            }
            writer.write("\n거래 내역:\n");
            for (String history : tradingHistory) {
                writer.write(history + "\n");
            }
            writer.write("=====================\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 메시지 표시
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // 차트 패널 클래스
    class StockChartPanel extends JPanel {
        private static final int CANDLE_WIDTH = 10;
        private static final int CANDLE_SPACING = 5;
        private static final int MA_PERIOD = 20; // 20일 이동평균선
        private ArrayList<CandleData> candleData = new ArrayList<>();
        private ArrayList<Double> ma5Data = new ArrayList<>();
        private ArrayList<Double> ma20Data = new ArrayList<>();
        private ArrayList<Double> ma60Data = new ArrayList<>();
        private static final int DEFAULT_MAX_PRICE = 300000;
        private static final int DEFAULT_MIN_PRICE = 0;
        private int scrollPosition = 0;
        private static final int VISIBLE_CANDLES = 30; // 한 화면에 표시할 캔들 수
        private long lastCandleTime = 0;
        private static final long CANDLE_INTERVAL = 10000; // 10초
        // 마우스 오버용
        private int mouseX = -1, mouseY = -1;
        private int lastHoverCandleIdx = -1;
        private String lastTooltip = null;
        // 거래량 기록용 리스트
        private ArrayList<Integer> volumeHistory = new ArrayList<>();
        // 종목별 priceHistory 참조용 필드 추가
        private ArrayList<Integer> priceHistory;

        class CandleData {
            int open, high, low, close;
            boolean isUp;
            long timestamp;
            int volume;

            CandleData(int open, int high, int low, int close, int volume) {
                this.open = open;
                this.high = high;
                this.low = low;
                this.close = close;
                this.isUp = close >= open;
                this.timestamp = System.currentTimeMillis();
                this.volume = volume;
            }
        }

        public StockChartPanel() {
            setPreferredSize(new Dimension(800, 400));
            setBackground(Color.WHITE);
            // 마우스 휠 이벤트 처리
            addMouseWheelListener(e -> {
                int notches = e.getWheelRotation();
                int maxScroll = Math.max(0, candleData.size() - VISIBLE_CANDLES);
                scrollPosition = Math.max(0, Math.min(scrollPosition + notches, maxScroll));
                repaint();
            });
            // 마우스 이동 이벤트 처리
            addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                @Override
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    mouseX = e.getX();
                    mouseY = e.getY();
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (priceHistory.size() < 2)
                return;
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            int margin = 50;
            int chartWidth = width - 2 * margin;
            int chartHeight = height - 2 * margin;
            updateCandleData();
            updateMAData();
            int maxPrice = DEFAULT_MAX_PRICE;
            int minPrice = DEFAULT_MIN_PRICE;
            if (!candleData.isEmpty()) {
                maxPrice = Integer.MIN_VALUE;
                minPrice = Integer.MAX_VALUE;
                for (CandleData candle : candleData) {
                    maxPrice = Math.max(maxPrice, candle.high);
                    minPrice = Math.min(minPrice, candle.low);
                }
                int priceRange = maxPrice - minPrice;
                if (priceRange > 0) {
                    maxPrice += priceRange * 0.1;
                    minPrice -= priceRange * 0.1;
                } else {
                    maxPrice = DEFAULT_MAX_PRICE;
                    minPrice = DEFAULT_MIN_PRICE;
                }
            }
            drawGrid(g2d, width, height, margin, maxPrice, minPrice);
            // 이동평균선 그리기 (MA5, MA20, MA60)
            drawMA(g2d, margin, chartWidth, chartHeight - 60, maxPrice, minPrice, ma5Data, 5,
                    new Color(255, 0, 0, 180));
            drawMA(g2d, margin, chartWidth, chartHeight - 60, maxPrice, minPrice, ma20Data, 20,
                    new Color(0, 128, 0, 180));
            drawMA(g2d, margin, chartWidth, chartHeight - 60, maxPrice, minPrice, ma60Data, 60,
                    new Color(0, 0, 255, 180));
            if (!candleData.isEmpty()) {
                drawCandles(g2d, margin, chartWidth, chartHeight, maxPrice, minPrice, width, height);
            }
            // 평균 매수가 라인 그리기
            String stock = (String) comboStocks.getSelectedItem();
            int averagePrice = stockAveragePrices.getOrDefault(stock, 0);
            if (averagePrice > 0) {
                int y = margin + (chartHeight - 60)
                        - (int) ((averagePrice - minPrice) * (chartHeight - 60) / (maxPrice - minPrice));
                g2d.setColor(new Color(0, 0, 255, 100));
                g2d.setStroke(
                        new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0));
                g2d.drawLine(margin, y, width - margin, y);
            }
            // 마우스 오버 툴팁
            drawTooltip(g2d, margin, chartWidth, chartHeight, maxPrice, minPrice);
        }

        private void updateCandleData() {
            long currentTime = System.currentTimeMillis();
            // 10초마다 새로운 캔들 생성
            if (currentTime - lastCandleTime >= CANDLE_INTERVAL && priceHistory.size() >= 10) {
                int lastIndex = priceHistory.size() - 1;
                int open = priceHistory.get(lastIndex - 9);
                int close = priceHistory.get(lastIndex);
                int high = open;
                int low = open;
                for (int i = lastIndex - 9; i <= lastIndex; i++) {
                    high = Math.max(high, priceHistory.get(i));
                    low = Math.min(low, priceHistory.get(i));
                }
                // 거래량 집계 (10초 동안의 합)
                int volume = 0;
                int vStart = Math.max(0, volumeHistory.size() - 9);
                for (int i = vStart; i < volumeHistory.size(); i++) {
                    volume += volumeHistory.get(i);
                }
                candleData.add(new CandleData(open, high, low, close, volume));
                lastCandleTime = currentTime;
                if (candleData.size() > VISIBLE_CANDLES) {
                    scrollPosition = candleData.size() - VISIBLE_CANDLES;
                }
            }
        }

        private void drawCandles(Graphics2D g2d, int margin, int chartWidth, int chartHeight, int maxPrice,
                int minPrice, int width, int height) {
            if (candleData.size() <= 1)
                return;
            int xStep = chartWidth / VISIBLE_CANDLES;
            int startIndex = Math.min(scrollPosition, candleData.size() - 1);
            int endIndex = Math.min(startIndex + VISIBLE_CANDLES, candleData.size());
            // 거래량 차트 영역
            int volumeChartHeight = 60;
            int candleChartHeight = chartHeight - volumeChartHeight;
            int maxVolume = 1;
            for (int i = startIndex; i < endIndex; i++) {
                maxVolume = Math.max(maxVolume, candleData.get(i).volume);
            }
            // 캔들 차트
            for (int i = startIndex; i < endIndex; i++) {
                CandleData candle = candleData.get(i);
                int x = margin + (i - startIndex) * xStep;
                int bodyTop = margin + candleChartHeight - (int) ((Math.max(candle.open, candle.close) - minPrice)
                        * candleChartHeight / (maxPrice - minPrice));
                int bodyBottom = margin + candleChartHeight - (int) ((Math.min(candle.open, candle.close) - minPrice)
                        * candleChartHeight / (maxPrice - minPrice));
                int bodyHeight = bodyBottom - bodyTop;
                int wickTop = margin + candleChartHeight
                        - (int) ((candle.high - minPrice) * candleChartHeight / (maxPrice - minPrice));
                int wickBottom = margin + candleChartHeight
                        - (int) ((candle.low - minPrice) * candleChartHeight / (maxPrice - minPrice));
                g2d.setColor(candle.isUp ? Color.RED : Color.BLUE);
                g2d.drawLine(x + CANDLE_WIDTH / 2, wickTop, x + CANDLE_WIDTH / 2, wickBottom);
                if (candle.isUp) {
                    g2d.setColor(Color.RED);
                } else {
                    g2d.setColor(Color.BLUE);
                }
                g2d.fillRect(x, bodyTop, CANDLE_WIDTH, bodyHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, bodyTop, CANDLE_WIDTH, bodyHeight);
                // x축 라벨 (10개마다만, 45도 회전)
                if ((i - startIndex) % 10 == 0) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String time = sdf.format(new Date(candle.timestamp));
                    g2d.setColor(Color.BLACK);
                    java.awt.geom.AffineTransform orig = g2d.getTransform();
                    g2d.rotate(-Math.PI / 4, x, candleChartHeight + margin + 25);
                    g2d.drawString(time, x, candleChartHeight + margin + 25);
                    g2d.setTransform(orig);
                }
                // 거래량 막대
                int vBarHeight = (int) ((double) candle.volume / maxVolume * volumeChartHeight);
                g2d.setColor(new Color(100, 100, 200, 180));
                g2d.fillRect(x, margin + candleChartHeight + volumeChartHeight - vBarHeight, CANDLE_WIDTH, vBarHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, margin + candleChartHeight + volumeChartHeight - vBarHeight, CANDLE_WIDTH, vBarHeight);
            }
            // 스크롤 위치 표시
            if (candleData.size() > VISIBLE_CANDLES) {
                g2d.setColor(Color.BLACK);
                g2d.drawString("스크롤: " + (scrollPosition + 1) + " ~ "
                        + Math.min(scrollPosition + VISIBLE_CANDLES, candleData.size()) + " / " + candleData.size(), 10,
                        height - 10);
            }
        }

        private void updateMAData() {
            ma5Data.clear();
            ma20Data.clear();
            ma60Data.clear();
            if (candleData.size() >= 5) {
                for (int i = 4; i < candleData.size(); i++) {
                    double sum = 0;
                    for (int j = 0; j < 5; j++)
                        sum += candleData.get(i - j).close;
                    ma5Data.add(sum / 5);
                }
            }
            if (candleData.size() >= 20) {
                for (int i = 19; i < candleData.size(); i++) {
                    double sum = 0;
                    for (int j = 0; j < 20; j++)
                        sum += candleData.get(i - j).close;
                    ma20Data.add(sum / 20);
                }
            }
            if (candleData.size() >= 60) {
                for (int i = 59; i < candleData.size(); i++) {
                    double sum = 0;
                    for (int j = 0; j < 60; j++)
                        sum += candleData.get(i - j).close;
                    ma60Data.add(sum / 60);
                }
            }
        }

        private void drawGrid(Graphics2D g2d, int width, int height, int margin, int maxPrice, int minPrice) {
            g2d.setColor(new Color(200, 200, 200));
            g2d.setStroke(new BasicStroke(1));

            // 수평 그리드
            int priceStep = (maxPrice - minPrice) / 5;
            for (int i = 0; i <= 5; i++) {
                int y = margin + (int) ((5 - i) * (height - 2 * margin) / 5.0);
                g2d.drawLine(margin, y, width - margin, y);
                g2d.setColor(Color.BLACK);
                g2d.drawString(String.format("%,d", minPrice + i * priceStep), 5, y + 5);
                g2d.setColor(new Color(200, 200, 200));
            }

            // 수직 그리드
            int timeStep = (width - 2 * margin) / 5;
            for (int i = 0; i <= 5; i++) {
                int x = margin + i * timeStep;
                g2d.drawLine(x, margin, x, height - margin);
            }
        }

        private void drawMA(Graphics2D g2d, int margin, int chartWidth, int chartHeight, int maxPrice, int minPrice,
                ArrayList<Double> maData, int period, Color color) {
            if (maData.isEmpty())
                return;
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(2));
            int xStep = chartWidth / VISIBLE_CANDLES;
            int startIndex = Math.min(scrollPosition, candleData.size() - 1);
            for (int i = 0; i < maData.size() - 1; i++) {
                int x1 = margin + (i + period - 1 - startIndex) * xStep;
                int x2 = margin + (i + period - startIndex) * xStep;
                if (x1 < margin || x2 < margin || x1 > margin + chartWidth || x2 > margin + chartWidth)
                    continue;
                int y1 = margin + chartHeight
                        - (int) ((maData.get(i) - minPrice) * chartHeight / (maxPrice - minPrice));
                int y2 = margin + chartHeight
                        - (int) ((maData.get(i + 1) - minPrice) * chartHeight / (maxPrice - minPrice));
                g2d.drawLine(x1, y1, x2, y2);
            }
        }

        private void drawTooltip(Graphics2D g2d, int margin, int chartWidth, int chartHeight, int maxPrice,
                int minPrice) {
            if (mouseX < 0 || mouseY < 0)
                return;
            int xStep = chartWidth / VISIBLE_CANDLES;
            int startIndex = Math.min(scrollPosition, candleData.size() - 1);
            int endIndex = Math.min(startIndex + VISIBLE_CANDLES, candleData.size());
            int candleIdx = -1;
            for (int i = startIndex; i < endIndex; i++) {
                int x = margin + (i - startIndex) * xStep;
                if (mouseX >= x && mouseX <= x + CANDLE_WIDTH) {
                    candleIdx = i;
                    break;
                }
            }
            if (candleIdx != -1 && candleIdx < candleData.size()) {
                CandleData c = candleData.get(candleIdx);
                String tip = String.format("시가: %,d\n고가: %,d\n저가: %,d\n종가: %,d\n거래량: %,d", c.open, c.high, c.low,
                        c.close, c.volume);
                lastTooltip = tip;
                lastHoverCandleIdx = candleIdx;
                // 툴팁 박스 크기 동적 계산
                String[] lines = tip.split("\\n");
                int boxW = 0;
                FontMetrics fm = g2d.getFontMetrics();
                for (String line : lines) {
                    boxW = Math.max(boxW, fm.stringWidth(line));
                }
                boxW += 16; // 좌우 여백
                int boxH = lines.length * fm.getHeight() + 12; // 위아래 여백
                // 툴팁 박스 위치 조정 (화면 벗어나지 않게)
                int boxX = mouseX + 10;
                int boxY = mouseY - 10;
                if (boxX + boxW > getWidth())
                    boxX = getWidth() - boxW - 5;
                if (boxY + boxH > getHeight())
                    boxY = getHeight() - boxH - 5;
                if (boxY < 0)
                    boxY = 5;
                g2d.setColor(new Color(255, 255, 200, 230));
                g2d.fillRoundRect(boxX, boxY, boxW, boxH, 10, 10);
                g2d.setColor(Color.BLACK);
                g2d.drawRoundRect(boxX, boxY, boxW, boxH, 10, 10);
                for (int i = 0; i < lines.length; i++) {
                    g2d.drawString(lines[i], boxX + 8, boxY + fm.getAscent() + 6 + i * fm.getHeight());
                }
            }
        }

        public void setChartData(ArrayList<Integer> priceHistory, ArrayList<CandleData> candleData,
                ArrayList<Integer> volumeHistory) {
            this.priceHistory = priceHistory;
            this.candleData = candleData;
            this.volumeHistory = volumeHistory;
            this.scrollPosition = Math.max(0, candleData.size() - VISIBLE_CANDLES);
        }
    }

    public static void main(String[] args) {
        new StockGame();
    }
}
