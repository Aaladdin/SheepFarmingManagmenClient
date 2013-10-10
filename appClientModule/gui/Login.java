package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Toolkit;

 
//Creating JFrame
public class Login extends JFrame {
 
       
public static void main(String[] args) throws IOException {
	
	JFrame.setDefaultLookAndFeelDecorated(true);
    try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}
	catch (Exception e){System.out.println(e);}
    
    Login f = new Login();
    f.setVisible(true);
}

public Login() throws IOException {
	setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/icon-sheep.png")));
	 
	this.setSize(742, 449);
	this.setTitle("|----  Sheep Farming Managment  ---|");
	BufferedImage bf = ImageIO.read(getClass().getResource("/images/farmheader2.jpg"));
	this.setContentPane(new BackImage(bf));
	JButton b = new JButton("Click");
	JTextField tf=new JTextField();
	 b.setBounds(318, 143, 98, 27);
	tf.setBounds(235, 104, 180, 27);
	 
	getContentPane().add(b);
	getContentPane().add(tf);
	}
 
}