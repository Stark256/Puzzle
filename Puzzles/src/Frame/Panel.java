package Frame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Controller.MainController;
import Draw.Background;

public class Panel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 460;
	public static int HEIGHT = 460;
	
	private Thread thread = new Thread(this);
	
	private BufferedImage image;
	private Graphics2D graphic;
	
	private Background background;
	
	private MainController mainController;
	
	private int FPS;
	private long timerFPS;
	private double milisToFPS;
	private int sleepTime;
	
	
	
	public Panel() {
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void update(){
		mainController.update();
	}
	
	public void render(){
		background.draw(graphic);
		mainController.render(graphic);
	}
	
	public void draw(){
		Graphics graphic2=this.getGraphics();
		graphic2.drawImage(image, 0, 0, null);
		graphic2.dispose();
	}
	
	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		
		FPS=60;
		milisToFPS=1000/FPS;
		sleepTime=0;
		
		image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		graphic=(Graphics2D)image.getGraphics();
		
		background= new Background();
		
		
		mainController=new MainController();
	
		
		for (MouseListener mouseListener : mainController.getMouseListenersMenu()) {
			addMouseListener(mouseListener);
		}
		
		while(true){
			if(!MainController.isMenu){
				for (KeyListener keyListener : mainController.getKeyListeners()) {
					addKeyListener(keyListener);
				}
				for (MouseListener mouseListener : mainController.getMouseListeners()) {
					addMouseListener(mouseListener);
				}
				for (MouseMotionListener mouseMotionListener : mainController.getMouseMotionListeners()) {
					addMouseMotionListener(mouseMotionListener);
				}
			}
			
			
			timerFPS=System.nanoTime();
					
			update();
			render();
			draw();
			
			timerFPS=(System.nanoTime()-timerFPS)/1000000;
			if(milisToFPS>timerFPS){
				sleepTime=(int)(milisToFPS - timerFPS);
			}else{
				sleepTime=1;
			}
			
			
			try {
				thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timerFPS=0;
			sleepTime=1;
		}
	}
}
