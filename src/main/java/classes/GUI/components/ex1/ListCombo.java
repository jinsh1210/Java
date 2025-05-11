package classes.GUI.components.ex1;
import javax.swing.*;
import java.awt.*;
public class ListCombo extends JFrame {
    private JTextField textField;
    private JButton addButton, moveButton;
    private DefaultListModel<String> listModel;
    private DefaultComboBoxModel<String> comboModel;
    private JList<String> list;
    private JComboBox<String> comboBox;

    public ListCombo() {
        setTitle("리스트와 콤보 기능");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // 화면 중앙

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        textField = new JTextField(10);
        addButton = new JButton("추가");
        inputPanel.add(textField);
        inputPanel.add(addButton);

        JPanel centerPanel = new JPanel(null);
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(30, 30, 100, 150);
        centerPanel.add(scrollPane);

        moveButton = new JButton(">>");
        moveButton.setBounds(180, 70, 60, 30);
        centerPanel.add(moveButton);

        comboModel = new DefaultComboBoxModel<>();
        comboBox = new JComboBox<>(comboModel);
        comboBox.setBounds(250, 70, 100, 30);
        centerPanel.add(comboBox);

        add(inputPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        addButton.addActionListener(e -> {
            String text = textField.getText().trim();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                textField.setText(""); // 입력창 비우기
            }
        });

        moveButton.addActionListener(e -> {
            String selected = list.getSelectedValue();
            if (selected != null) {
                comboModel.addElement(selected);
                listModel.removeElement(selected);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new ListCombo();
    }
}
