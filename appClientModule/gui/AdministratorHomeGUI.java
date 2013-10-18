package gui;

import gui.messages.retypePassword;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistance.Admin;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class AdministratorHomeGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginField;
	private JTextField emailField;
	private JTextField avatarField;
	private JPasswordField passwordField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministratorHomeGUI(Admin admin) {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdministratorHomeGUI.class.getResource("/images/icon-sheep.png")));
		setTitle("AdministratorHomeGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1426, 733);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnFile.add(menuItem);
		
		JMenu mnSheeps = new JMenu("Sheeps");
		menuBar.add(mnSheeps);
		
		JMenu mnEmployees = new JMenu("Employees");
		menuBar.add(mnEmployees);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1362, 673);
		contentPane.add(tabbedPane);
		
		JPanel profilPanel = new JPanel();
		tabbedPane.addTab("           My Profil           ", null, profilPanel, null);
		profilPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(58, 11, 228, 271);
		profilPanel.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(399, 136, 782, 459);
		profilPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login        :");
		lblLogin.setBounds(93, 89, 111, 28);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setBounds(93, 168, 111, 28);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblPassword);
		
		JLabel lblEmail = new JLabel("E-mail       :");
		lblEmail.setBounds(93, 245, 111, 28);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblEmail);
		
		JLabel lblAvatar = new JLabel("Avatar       :");
		lblAvatar.setBounds(93, 321, 111, 28);
		lblAvatar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblAvatar);
		
		loginField = new JTextField();
		loginField.setBounds(408, 97, 219, 20);
		loginField.setText(admin.getLogin());
		panel.add(loginField);
		loginField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(408, 253, 219, 20);
		loginField.setText(admin.getEmail());
		panel.add(emailField);
		
		avatarField = new JTextField();
		avatarField.setColumns(10);
		avatarField.setBounds(408, 329, 219, 20);
		panel.add(avatarField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(408, 176, 219, 20);
		panel.add(passwordField);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(637, 328, 89, 23);
		panel.add(btnBrowse);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText()!= null){
					retypePassword r = new retypePassword();
					r.setVisible(true);
				}
			}
		});
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnApply.setBounds(352, 399, 89, 23);
		panel.add(btnApply);
		
		JLabel lblWelcomeAdmin = new JLabel("WELCOME ADMIN");
		lblWelcomeAdmin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 44));
		lblWelcomeAdmin.setBounds(673, 45, 245, 43);
		profilPanel.add(lblWelcomeAdmin);
		
		JPanel farmPanel = new JPanel();
		tabbedPane.addTab("           Farms           ", null, farmPanel, null);
		farmPanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(24, 49, 607, 546);
		farmPanel.add(panel_2);
		panel_2.setLayout(null);
		/*************/
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(59, 47, 459, 309);
		panel_2.add(table);
		/******/
		
		
		
		
		/************/
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(723, 49, 607, 546);
		farmPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel batimentPanel = new JPanel();
		tabbedPane.addTab("           Batiments           ", null, batimentPanel, null);
		
		JPanel employeePanel = new JPanel();
		tabbedPane.addTab("           Employees           ", null, employeePanel, null);
		
		JPanel sheepPanel = new JPanel();
		tabbedPane.addTab("           Sheeps           ", null, sheepPanel, null);
	}
}
