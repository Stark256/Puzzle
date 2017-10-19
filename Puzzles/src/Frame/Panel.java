package Frame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Controller.PuzzlesController;
import Draw.Background;

public class Panel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 460;
	public static int HEIGHT = 460;
	
	private Thread thread = new Thread(this);
	
	private BufferedImage image;
	private Graphics2D graphic;
	
	private Background background;
	
	private PuzzlesController controller;
	
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
		background.update();
		controller.update();
		
	}
	
	//Update graphic components
	public void render(){
		background.draw(graphic);
		controller.render(graphic);
	
	}
	
	public void draw(){
		Graphics graphic2=this.getGraphics();
		graphic2.drawImage(image, 0, 0, null);
		graphic2.dispose();
		controller.draw();
		
	}
	
	
	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		
		FPS=30;
		milisToFPS=1000/FPS;
		sleepTime=0;
		
		image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		graphic=(Graphics2D)image.getGraphics();
		
		background= new Background();
		
		
		controller=new PuzzlesController();
		for (KeyListener keyListener : controller.getKeyListeners()) {
			addKeyListener(keyListener);
		}
		for (MouseListener mouseListener : controller.getMouseListeners()) {
			addMouseListener(mouseListener);
		}
		for (MouseMotionListener mouseMotionListener : controller.getMouseMotionListeners()) {
			addMouseMotionListener(mouseMotionListener);
		}
		//addKeyListener(controller.getListener());
		//addKeyListener(controller.getControllerListener());
		
		while(true){
			
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
