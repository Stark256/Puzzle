package Frame;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Panel panel = new Panel();
		JFrame frame = new JFrame("Pazl");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// frame.getContentPane().add(panel);
		 //frame.setUndecorated(true);
		// frame.setSize(new Dimension(Panel.WIDTH,Panel.HEIGHT));
		// frame.setMaximumSize(new Dimension(Panel.WIDTH,Panel.HEIGHT));
		// frame.setMinimumSize(new Dimension(Panel.WIDTH,Panel.HEIGHT));
		 frame.setResizable(false);
		 frame.setContentPane(panel);
		 
		 frame.pack();
	     frame.setVisible(true);
	     frame.setLocationRelativeTo(null);
	     
	     panel.start();
	} 
}
