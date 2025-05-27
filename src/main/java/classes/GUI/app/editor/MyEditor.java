package classes.GUI.app.editor;

import classes.GUI.components.ex1.MyChat;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;

public class MyEditor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem menuItemChat;
	private RSyntaxTextArea taEditor;

	public RSyntaxTextArea getTaEditor() {
		return this.taEditor;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyEditor frame = new MyEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyEditor() {
		setTitle("My Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 472);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuItemRun = new JMenuItem("Run");
		menuFile.add(menuItemRun);

		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuFile.add(menuItemOpen);

		JMenuItem menuItemSave = new JMenuItem("Save");
		menuFile.add(menuItemSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFunc();
			}
		});
		menuFile.add(menuItemExit);

		JMenu menuOpt = new JMenu("Options");
		menuBar.add(menuOpt);

		JMenuItem menuItemColor = new JMenuItem("Color");
		menuOpt.add(menuItemColor);

		JMenu menuApps = new JMenu("Apps");
		menuBar.add(menuApps);

		menuItemChat = new JMenuItem("MyChat");
		menuItemChat.addActionListener(this);
		/*
		 * (new ActionListener() { public void actionPerformed(ActionEvent e) { MyChat
		 * chat = new MyChat("채팅창",this); chat.getFrmMychat().setVisible(true);
		 * chat.getTfInput().setText("홍길동"); } });
		 */
		menuApps.add(menuItemChat);

		JMenu menuInfo = new JMenu("Help");
		menuBar.add(menuInfo);

		JMenuItem menutItemInfo = new JMenuItem("Info");
		menutItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "MyEditor\nProgram by 진승현", "프로그램 정보", JOptionPane.WARNING_MESSAGE);
			}
		});
		menuInfo.add(menutItemInfo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		/*
		 * JScrollPane scrollPane = new JScrollPane();
		 * 
		 * 
		 * JTextArea textArea = new JTextArea();
		 */

		taEditor = new RSyntaxTextArea();
		taEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		taEditor.setCodeFoldingEnabled(true);

		RTextScrollPane sp = new RTextScrollPane(taEditor);

		JToolBar toolBar = new JToolBar();
		sp.setColumnHeaderView(toolBar);

		contentPane.add(sp, BorderLayout.CENTER);

		JButton btnNew = new JButton("");
		btnNew.addActionListener(e -> {
			newFunc();
		});
		btnNew.setIcon(
				new ImageIcon("/Users/jinsh1210/Coding/java/Java-eclipse/src/main/java/classes/GUI/img/new.png"));
		toolBar.add(btnNew);

		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(e -> {
			openFunc();
		});
		btnOpen.setIcon(
				new ImageIcon("/Users/jinsh1210/Coding/java/Java-eclipse/src/main/java/classes/GUI/img/open.png"));
		toolBar.add(btnOpen);

		JButton btnSave = new JButton("");
		btnSave.addActionListener(e -> {
			saveFunc();
		});
		btnSave.setIcon(
				new ImageIcon("/Users/jinsh1210/Coding/java/Java-eclipse/src/main/java/classes/GUI/img/save.png"));
		toolBar.add(btnSave);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFunc();
			}
		});
		btnExit.setIcon(
				new ImageIcon("/Users/jinsh1210/Coding/java/Java-eclipse/src/main/java/classes/GUI/img/exit.png"));
		toolBar.add(btnExit);
	}

	private void newFunc() {
		int res =JOptionPane.showConfirmDialog(this, "새 파일을 만들까요?", "새 파일",
				JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION){
			taEditor.setText("");
		}
	}

	private void saveFunc() {
		JFileChooser fc = new JFileChooser();
		File curDir = new File("/Users/jinsh1210/Coding/java/Java-eclipse/Temp");
		fc.setCurrentDirectory(curDir);

		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt"));
		fc.setAcceptAllFileFilterUsed(true);

		fc.showSaveDialog(this);

		File selectedFile = fc.getSelectedFile();

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(selectedFile));
			String str = taEditor.getText();
			bw.write(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void openFunc() {
		JFileChooser fc = new JFileChooser();
		File curDir = new File("/Users/jinsh1210/Coding/java/Java-eclipse/Temp");
		fc.setCurrentDirectory(curDir);

		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt"));
		fc.setAcceptAllFileFilterUsed(true);

		fc.showOpenDialog(this);

		File selectedFile = fc.getSelectedFile();

		BufferedReader br = null;
		String line = null;

		try {
			br = new BufferedReader(new FileReader(selectedFile));
			while ((line = br.readLine()) != null) {
				taEditor.append(line + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void exitFunc() {
		int res = JOptionPane.showConfirmDialog(this, "정말 끝낼까요?", "끝내기", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemChat) {
			MyChat chat = new MyChat("채팅창", this);
			chat.getFrmMychat().setVisible(true);
			chat.getTfInput().setText("홍길동");
			// this.setVisible(false);
		}
	}

}
