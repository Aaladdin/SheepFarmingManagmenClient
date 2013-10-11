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
		
		JLabel lblCreateFarm = new JLabel("AUTHENTICATION");
		lblCreateFarm.setForeground(UIManager.getColor("Button.focus"));
		lblCreateFarm.setFont(new Font("SketchFlow Print", Font.ITALIC, 26));
		lblCreateFarm.setBounds(246, 43, 242, 50);
		contentPane.add(lblCreateFarm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setBounds(490, 346, 89, 23);
		contentPane.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "wellcome", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(186, 104, 362, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(32, 54, 73, 14);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setBounds(32, 130, 61, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(161, 51, 122, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 127, 122, 20);
		panel.add(passwordField);
		
		final JLabel notification = new JLabel("");
		notification.setBounds(10, 187, 310, 14);
		panel.add(notification);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
		 	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	
		 		
		       if(textField.getText().isEmpty()){ notification.setText("User name missed ...");  }
		     else if (passwordField.getText().isEmpty()) {	notification.setText("Password missed ..."); } 
		       else{
		    	  
		    	   UserServicesRemote userServicesRemote = null ;
		    	   try {
					Context context =  new InitialContext();
					userServicesRemote = (UserServicesRemote) context.lookup("ejb:/SheepFarmingManagment/UserServices!services.userServices.UserServicesRemote");
					
					User user = new User();
					Admin admin = new Admin() ;
					Employee employee = new Employee();
					System.out.println("tt");
					user = UserServiceDelegate.authenticate(textField.getText(), passwordField.getText().toString());
					
					
	                if(user == null){System.out.println("user not found");}
	                else if(user.getClass().equals(employee.getClass())){
	                	employee = (Employee) UserServiceDelegate.findUserById(user.getIdUser());
	                	EmployeeHomeGUI employeegui = new EmployeeHomeGUI(employee);
	                	employeegui.setVisible(true);
	                }else {
	                  admin = (Admin) UserServiceDelegate.findUserById(user.getIdUser());
                      AdministratorHomeGUI admingui = new AdministratorHomeGUI(admin);
                      admingui.setVisible(true);
	                }
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	  
		       }
			   }
		}); 
		btnLogin.setBounds(136, 346, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AuthenticationGUI.class.getResource("/images/sheepauth.jpg")));
		label.setBackground(Color.WHITE);
		label.setBounds(-14, 11, 271, 388);
		contentPane.add(label);
	}
}
