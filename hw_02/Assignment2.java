package hw_02;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Contains the JFrame component that is executed in the main method.
 * 
 * @author aaron stahley
 * @version 1.0 jan 26, 2017.
 *
 */

public class Assignment2 extends JPanel {

	private static JFrame frame;
	
	public static void main(String[] args) {
		
		MainPanel mp = new MainPanel(); 
		
		frame = new JFrame("");
		frame.setContentPane(mp);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 230);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		
		frame.setVisible(true);

	}
	
	/**
	 * 
	 * @return returns the JFrame
	 */
public JFrame getFrame(){
	
	return frame;
}
	

}
