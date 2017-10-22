package Frame;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Panel panel = new Panel();
		JFrame frame = new JFrame("Puzzles");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 frame.setResizable(false);
		 frame.setContentPane(panel);
		 
		 frame.pack();
	     frame.setVisible(true);
	     frame.setLocationRelativeTo(null);
	     
	     panel.start();
	} 
}
