package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

class BackImage extends JComponent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image i;
    public BackImage(Image i) {this.i = i;}
 
//Overriding the paintComponent method
@Override
public void paintComponent(Graphics g) {
 
g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
 
}
}