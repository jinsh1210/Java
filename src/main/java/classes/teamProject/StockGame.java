package classes.teamProject;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.io.*;
import java.util.*;

public class StockGame extends JFrame {
    private JLabel lblCash, lblStockCount, lblTotalAsset, lblPrice;
    private JComboBox<String> comboStocks;
    private JButton btnBuy, btnSell;
    private Map<String, Integer> stockPrices = new HashMap<>();
    private Map<String, Integer> stockCounts = new HashMap<>();
    private ArrayList<Integer> priceHistory = new ArrayList<>();
    private JLabel lblAveragePrice;
    private Map<String, Integer> stockAveragePrices = new HashMap<>();
    private int cash = 500000;  // 초기 보유 현금
    private Timer timer;
    private Random random = new Random();
    private StockChartPanel chartPanel;
    private final int TARGET_ASSET = 2000000; // 목표 자산 (200만원)

    // 생성자: 게임 초기화
    public StockGame() {
        setTitle("주식 게임");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initStocks(); // 종목과 초기 주식 수 설정

        Font font = new Font("맑은 고딕", Font.BOLD, 16);

        // 상단 정보 패널
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        lblCash = createLabel("보유 현금: " + cash + "원", font);
        lblStockCount = createLabel("보유 주식: 0주", font);
        lblTotalAsset = createLabel("총 자산: " + calculateTotalAsset() + "원", font);
        lblAveragePrice = createLabel("평균 매수가: -원", font);
        lblPrice = createLabel("", font);
        comboStocks = new JComboBox<>(stockPrices.keySet().toArray(new String[0]));
        comboStocks.setFont(font);

        topPanel.add(lblCash);
        topPanel.add(lblStockCount);
        topPanel.add(lblTotalAsset);
        topPanel.add(lblAveragePrice);
        topPanel.add(comboStocks);
        topPanel.add(lblPrice);

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

        priceHistory.add(stockPrices.get(comboStocks.getSelectedItem()));
        updateLabels();

        // 콤보박스 선택 변경 시
        comboStocks.addActionListener(e -> updateStockSelection());

        // 매수 버튼 클릭
        btnBuy.addActionListener(e -> {
            if (isMarketOpen()) buyStock();
            else showMessage("⏰ 시장이 열려있지 않습니다!");
        });

        // 매도 버튼 클릭
        btnSell.addActionListener(e -> {
            if (isMarketOpen()) sellStock();
            else showMessage("⏰ 시장이 열려있지 않습니다!");
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
        for (String stock : stockPrices.keySet()) {
            stockCounts.put(stock, 0);
            stockAveragePrices.put(stock, 0);
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
        priceHistory.clear();
        priceHistory.add(stockPrices.get(comboStocks.getSelectedItem()));
        updateLabels();
        chartPanel.repaint();
    }

    // 주가 랜덤 업데이트
    private void updateStockPrices() {
        for (String stock : stockPrices.keySet()) {
            int change = random.nextInt(201) - 100; // -100 ~ +100 변동
            stockPrices.put(stock, Math.max(stockPrices.get(stock) + change, 1000));
        }
        priceHistory.add(stockPrices.get(comboStocks.getSelectedItem()));
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
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour >= 9 && hour < 15;
    }

    // 주식 매수 처리
    private void buyStock() {
        String stock = (String) comboStocks.getSelectedItem();
        String input = JOptionPane.showInputDialog(stock + " 몇 주를 매수하시겠습니까?");
        try {
            int quantity = Integer.parseInt(input);
            int cost = stockPrices.get(stock) * quantity;
            if (cost > cash) {
                showMessage("현금이 부족합니다.");
            } else {
                cash -= cost;
                int prevCount = stockCounts.get(stock);
                int prevTotal = stockAveragePrices.get(stock) * prevCount;
                int newCount = prevCount + quantity;
                int newAveragePrice = (prevTotal + cost) / newCount;

                stockCounts.put(stock, stockCounts.get(stock) + quantity);
                stockAveragePrices.put(stock, newAveragePrice);

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
                cash += stockPrices.get(stock) * quantity;
                stockCounts.put(stock, stockCounts.get(stock) - quantity);
                updateLabels();
            }
        } catch (Exception ex) {
            showMessage("숫자를 입력하세요.");
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
            for (String stock : stockPrices.keySet()) {
                writer.write(stock + " 보유 수량: " + stockCounts.get(stock) + "주\n");
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
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (priceHistory.size() < 1) return;

            int width = getWidth();
            int height = getHeight();
            int margin = 50;
            int chartWidth = width - 2 * margin;
            int chartHeight = height - 2 * margin;

            //그래프 y축 눈금
            final int maxPrice = 300000;
            final int minPrice = 0;

            int totalMinutes = Math.max(1, priceHistory.size() / 10);
            int xStep = Math.max(1, chartWidth / totalMinutes);

            String stock = (String) comboStocks.getSelectedItem();
            int averagePrice = stockAveragePrices.getOrDefault(stock, 0);

            // 축
            g.setColor(Color.BLACK);
            g.drawLine(margin, height - margin, width - margin, height - margin);
            g.drawLine(margin, margin, margin, height - margin);

            // y축 눈금
            for (int p = minPrice; p <= maxPrice; p += 50000) {
                int y = margin + chartHeight - (p * chartHeight / maxPrice);
                g.drawLine(margin - 5, y, margin + 5, y);
                g.drawString(p + "", 5, y + 5);
            }

            // x축 라벨
            g.drawString("시간(초)", width / 2, height - 10);
            g.drawString("주가(원)", 10, margin - 10);

            // 주가 선 그리기
            for (int i = 0; i < priceHistory.size() - 1; i++) {
                int price = priceHistory.get(i);

                if (averagePrice > 0) {
                    if (price > averagePrice) {
                        g.setColor(Color.RED); // 수익 구간 빨간색
                    } else if (price < averagePrice) {
                        g.setColor(Color.BLUE); // 손실 구간 파란색
                    } else {
                        g.setColor(Color.BLACK); // 같으면 검정
                    }
                } else {
                    g.setColor(Color.BLACK); // 평균 매수가 없으면 검정
                }

                int x = margin + (i / 10) * xStep;
                int barWidth = Math.max(5, xStep / 2); // 막대 너비
                int barHeight = (price * chartHeight) / maxPrice;
                int y = margin + chartHeight - barHeight;

                g.fillRect(x, y, barWidth, barHeight);
            }
        }
    }

    public static void main(String[] args) {
        new StockGame();
    }
}
