package gui;


import java.awt.EventQueue;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.io.IOException;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import delegate.UserServiceDelegate;

import persistance.Admin;
import persistance.Employee;
import persistance.User;
import services.userServices.UserServicesRemote;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthenticationGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{

		EventQueue.invokeLater(new Runnable() {
			public void run() {


				JFrame.setDefaultLookAndFeelDecorated(true);
			    try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}
				catch (Exception e){System.out.println(e);}
	
				    AuthenticationGUI frame = new AuthenticationGUI();
			    	frame.setVisible(true);
					frame.setLocationRelativeTo(null);
			    	
			    	
			    	


			}

		});
	}

	/**
	 * Create the frame.
	 */
	public AuthenticationGUI(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(AuthenticationGUI.class.getResource("/images/icon-sheep.png")));
		setTitle("          +-  Sheep Farming Managment  -+");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBackground(Color.GREEN);
		lblUserName.setBounds(236, 147, 89, 42);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(236, 219, 89, 50);
		contentPane.add(lblPassword);
		
		JLabel lblCreateFarm = new JLabel("AUTHENTICATION");
		lblCreateFarm.setForeground(new Color(0, 128, 128));
		lblCreateFarm.setFont(new Font("Stencil", Font.ITALIC, 29));
		lblCreateFarm.setBounds(236, 43, 262, 50);
		contentPane.add(lblCreateFarm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setBounds(490, 346, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setBounds(136, 346, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AuthenticationGUI.class.getResource("/images/sheepauth.jpg")));
		label.setBackground(Color.WHITE);
		label.setBounds(-70, 11, 319, 388);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(370, 158, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(370, 234, 122, 20);
		contentPane.add(passwordField);
		
		final JLabel notification = new JLabel("");
		notification.setForeground(new Color(220, 20, 60));
		notification.setBounds(490, 289, 140, 14);
		contentPane.add(notification);
		btnLogin.addActionListener(new ActionListener() {
		 	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		       if(textField.getText().isEmpty()){ notification.setText("*User name missed ...");  }
		     else if (passwordField.getText().isEmpty()) {	notification.setText("*Password missed ..."); } 
		       else{
		    	   User user = new User();
				   Admin admin = new Admin() ;
				   Employee employee = new Employee();
				   user = UserServiceDelegate.authenticate(textField.getText(), passwordField.getText().toString());	
				if(user.getClass().equals(employee.getClass())){
					employee = (Employee) UserServiceDelegate.findUserById(user.getIdUser());
					EmployeeHomeGUI employeegui = new EmployeeHomeGUI(employee);
					employeegui.setVisible(true);
				}else if(user.getClass().equals(admin.getClass())){
				  admin = (Admin) UserServiceDelegate.findUserById(user.getIdUser());
				  AdministratorHomeGUI admingui = new AdministratorHomeGUI(admin);
				  admingui.setVisible(true);
				}else{
					notification.setText("*user not found");
				}
		    	  
		       }
			   }
		}); 
	}
}
