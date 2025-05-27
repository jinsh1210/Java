package toc.gui.ex3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class DbTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;
	private DefaultTableModel tableModel;
	private DefaultComboBoxModel<String> comModel;

	public DbTable() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		comModel = new DefaultComboBoxModel<>();
		JComboBox cbItem = new JComboBox(comModel);
		cbItem.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		cbItem.setBounds(17, 38, 104, 26);
		contentPane.add(cbItem);

		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		tfSearch.setBounds(133, 38, 199, 26);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(e -> {
			Object selectedItem = cbItem.getSelectedItem();
			if (selectedItem == null) {
				String sql = "SELECT * FROM items ORDER BY id";
				loadTableData(sql);
				return;
			}
			String selectItem = selectedItem.toString();
			String searchText = tfSearch.getText();

			String sql = "SELECT * FROM items WHERE " + selectItem + " LIKE '%" + searchText + "%'";

			comModel.removeAllElements();
			loadTableData(sql);
		});

		btnSearch.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnSearch.setBounds(344, 38, 77, 26);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 76, 404, 253);
		contentPane.add(scrollPane);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<>(tableModel);
		table.setRowSorter(tableSorter);

		String sql = "SELECT * FROM items ORDER BY id";

		loadTableData(sql);
	}

	private void loadTableData(String sql) {

		try {
			ResultSet rs = DB.executeQuery(sql);

			if (rs != null) {
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();

				// Vector 변환 해보기
				String[] colNames = new String[columnCount];
				Vector<String> cbNames = new Vector<>();

				for (int i = 0; i < colNames.length; i++) {
					colNames[i] = metaData.getColumnName(i + 1);
					cbNames.add(colNames[i]);
				}
				tableModel.setColumnIdentifiers(colNames);
				comModel.addAll(cbNames);

				tableModel.setRowCount(0);

				while (rs.next()) {
					Object[] rowData = { rs.getInt("id"), rs.getString("name"), rs.getInt("stock"), rs.getInt("price"),
							rs.getString("kind") };
					tableModel.addRow(rowData);
				}
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(50);
				columnModel.getColumn(1).setPreferredWidth(100);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
