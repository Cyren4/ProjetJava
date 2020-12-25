package Test;
import javax.swing.*;
import java.awt.*;

public class JPanel1 extends JPanel{

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D j = (Graphics2D) g;
		j.setPaint(Color.BLUE);
		j.fillOval(100, 100, 10, 10);
	}
}
