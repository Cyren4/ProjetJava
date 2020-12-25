package quidditch;

import java.awt.FlowLayout;
import java.awt.event.*; 
import javax.swing.*; 

public final class Start {

	public static void main(String[] args) {
		   JFrame frame = new JFrame("Quidditch Tournament");  
	        JPanel panel = new JPanel();  
	        panel.setLayout(new FlowLayout());  
	        JLabel label = new JLabel("Do you want to play Quidditch?");  
	        JButton button = new JButton();
	        ImageIcon test = new ImageIcon("Image/start.jpg");
	 //       JLabel image = new JLabel(test);
	        button.setText("Start");  
	        panel.add(label);  
	        panel.add(button);  
	        frame.add(panel); 
	        frame.add(test);
	        frame.setSize(1000, 500);  
	        frame.setLocationRelativeTo(null);  
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        frame.setVisible(true);  
	    
	}

}
