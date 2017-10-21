package Controller;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class MainController {

	private PuzzlesController controller;
	
	private MenuController menuController;
	
	private boolean isMenu;
	
	public MainController(){
		isMenu=true;
		controller=new PuzzlesController();
		menuController=new MenuController();
		
	}
	
	
	
	public void update(){
		controller.update();
	}
	public void render(Graphics2D graphic){
		controller.render(graphic);
	}
	
	public void draw(){
		controller.draw();
	}
	
	
	public List<KeyListener> getKeyListeners(){
		return controller.getKeyListeners();
	}
	
	public List<MouseListener> getMouseListeners(){
		return controller.getMouseListeners();
	}
	
	public List<MouseMotionListener> getMouseMotionListeners(){
		return controller.getMouseMotionListeners();
	}
}
