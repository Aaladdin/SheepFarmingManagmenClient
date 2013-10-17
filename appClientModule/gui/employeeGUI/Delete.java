package gui.employeeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import delegate.EmployeeServiceDelegate;

import persistance.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEmployee = new JLabel("ID Employee");
		lblIdEmployee.setBounds(80, 95, 87, 14);
		contentPane.add(lblIdEmployee);
		
		textField = new JTextField();
		textField.setBounds(226, 92, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Employee employee = new Employee();
					employee = EmployeeServiceDelegate.findEmployeeById(Integer.parseInt(textField.getText()));
					System.out.println(employee.toString());
					EmployeeServiceDelegate.deleteEmployee(employee);
				
			}
		});
		btnDelete.setBounds(151, 184, 89, 23);
		contentPane.add(btnDelete);
	}
}
