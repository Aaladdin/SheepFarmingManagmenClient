package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistance.Admin;

import java.awt.Toolkit;
import javax.swing.JLabel;

public class AdministratorHomeGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Admin var  ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
/*				try {
					
			//		 new AdministratorHomeGUI(Admin).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} */
			} 
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministratorHomeGUI(Admin admin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdministratorHomeGUI.class.getResource("/images/icon-sheep.png")));
		setTitle("Administrator Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(138, 45, 164, 37);
		contentPane.add(label);
		if(admin != null){
			this.var = admin ;
			label.setText(admin.getLogin());			
		}


	}
}
