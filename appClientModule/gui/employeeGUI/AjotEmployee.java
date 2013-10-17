package gui.employeeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import delegate.EmployeeServiceDelegate;

import persistance.Employee;


public class AjotEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField adresse;
	private JTextField cin;
	private JTextField telephone;
	private JTextField poste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjotEmployee frame = new AjotEmployee();
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
	public AjotEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(62, 52, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(62, 103, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCin = new JLabel("Cin");
		lblCin.setBounds(285, 52, 46, 14);
		contentPane.add(lblCin);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(285, 103, 56, 14);
		contentPane.add(lblTelephone);
		
		JLabel lblPoste = new JLabel("Poste");
		lblPoste.setBounds(119, 149, 46, 14);
		contentPane.add(lblPoste);
		
		name = new JTextField();
		name.setBounds(113, 49, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(113, 100, 86, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);
		
		cin = new JTextField();
		cin.setBounds(320, 49, 86, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(338, 100, 86, 20);
		contentPane.add(telephone);
		telephone.setColumns(10);
		
		poste = new JTextField();
		poste.setBounds(181, 146, 86, 20);
		contentPane.add(poste);
		poste.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Employee employee=new Employee();
				employee.setFirstName(name.getText());
				employee.setCin(cin.getText());
				employee.setAdress(adresse.getText());
				employee.setPhone(telephone.getText());
				employee.setPoste(poste.getText());
				
				
				
				EmployeeServiceDelegate.createEmployee(employee);
			
			}
	});
		btnAjouter.setBounds(178, 195, 89, 23);
		contentPane.add(btnAjouter);
}}
