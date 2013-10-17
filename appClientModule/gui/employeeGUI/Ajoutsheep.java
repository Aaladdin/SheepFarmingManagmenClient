package gui.employeeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import delegate.SheepServicesDelegate;

import persistance.Batiment;
import persistance.Sheep;

public class Ajoutsheep extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajoutsheep frame = new Ajoutsheep();
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
	public Ajoutsheep() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(80, 44, 28, 20);
		contentPane.add(comboBox);
		comboBox.addItem("gharbi");
		comboBox.addItem("baldi");
		comboBox.addItem("cherki");

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(254, 38, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(254, 64, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sheep sheep=new Sheep();
				sheep.setCode_sheep(Integer.parseInt(textField.getText()));
			//	sheep.setDate_birth(textField_1.getText().toString());
				
			//	sheep.setDate_date_input(textField_2.getText().toString());
				sheep.setPrice_input(Integer.parseInt(textField_3.getText()));
			
				sheep.setRace_sheep(comboBox.getSelectedItem().toString());
				if(rdbtnNewRadioButton.isSelected())
			          {
			           sheep.setSexe_sheep("femelle");
			          }
			            if(rdbtnNewRadioButton_1.isSelected())
			          {
			            sheep.setSexe_sheep("fame");
			          }
				Batiment batiment = new Batiment();
				batiment.setName_batiment(textField_4.getText());
				sheep.setBatiment(batiment);
			

				
				
				

				SheepServicesDelegate.createSheep(sheep);
				
			}
		});
		btnNewButton.setBounds(296, 211, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(59, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(59, 75, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(59, 123, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(59, 178, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(59, 212, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(59, 243, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
