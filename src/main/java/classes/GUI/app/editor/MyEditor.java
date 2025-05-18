package classes.GUI.app.editor;

import classes.GUI.components.ex1.MyChat;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MyEditor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem menuItemChat;
	private RSyntaxTextArea taEditor;

	public RSyntaxTextArea getTaEditor() {
		return this.taEditor;
	}

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
				/*(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyChat chat = new MyChat("채팅창",this);
				chat.getFrmMychat().setVisible(true);
				chat.getTfInput().setText("홍길동");
			}
		});*/
		menuApps.add(menuItemChat);
		
		JMenu menuInfo = new JMenu("Help");
		menuBar.add(menuInfo);
		
		JMenuItem menutItemInfo = new JMenuItem("Info");
		menutItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null
						, "MyEditor\nProgram by 진승현"
						, "프로그램 정보"
						, JOptionPane.WARNING_MESSAGE);
			}
		});
		menuInfo.add(menutItemInfo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/*JScrollPane scrollPane = new JScrollPane();


		JTextArea textArea = new JTextArea();*/

		taEditor = new RSyntaxTextArea();
		taEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		taEditor.setCodeFoldingEnabled(true);

		RTextScrollPane sp = new RTextScrollPane(taEditor);

		JToolBar toolBar = new JToolBar();
		sp.setColumnHeaderView(toolBar);

		contentPane.add(sp, BorderLayout.CENTER);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon("C:\\Coding\\Java_Eclipse\\src\\main\\java\\classes\\GUI\\img\\new.png"));
		toolBar.add(btnNew);
		
		JButton btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon("C:\\Coding\\Java_Eclipse\\src\\main\\java\\classes\\GUI\\img\\open.png"));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon("C:\\Coding\\Java_Eclipse\\src\\main\\java\\classes\\GUI\\img\\save.png"));
		toolBar.add(btnSave);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFunc();
			}
		});
		btnExit.setIcon(new ImageIcon("C:\\Coding\\Java_Eclipse\\src\\main\\java\\classes\\GUI\\img\\exit.png"));
		toolBar.add(btnExit);
	}
	
	private void exitFunc() {
		int res = JOptionPane.showConfirmDialog(this,"정말 끝낼까요?",
				"끝내기", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION) System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuItemChat){
			MyChat chat = new MyChat("채팅창",this);
			chat.getFrmMychat().setVisible(true);
			chat.getTfInput().setText("홍길동");
//			this.setVisible(false);
		}
	}

}
