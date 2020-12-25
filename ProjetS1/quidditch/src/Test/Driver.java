package Test;
import javax.swing.*;
import java.awt.*;

public class Driver extends JFrame{
	JPanel1 one = new JPanel1();
	JPanel two = new JPanel();
	
	 public Driver() {
		 super("Graphics test");
		 setBounds(100,100,500,500);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 add(one);
		 setVisible(true);
	 }
	 
	 public static void main(String args[]) {
		 Driver two = new Driver();
	 }

}
