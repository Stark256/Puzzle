package Controller;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class MainController {

	private PuzzlesController controller;
	
	private MenuController menuController;
	
	public static boolean isMenu;
	
	public MainController(){
		isMenu=true;
		menuController=new MenuController();
	}
	
	public void update(){
		if(isMenu){
		   String name=	menuController.update();
		   if(name!=null){
			   controller=new PuzzlesController(name);
			   isMenu=false;
		   }
		}else{
			controller.update();
		}
	}
	
	public void render(Graphics2D graphic){
		
		if(isMenu){
			menuController.render(graphic);
		}else{
			controller.render(graphic);
		}
	}
	
	public List<MouseListener> getMouseListenersMenu(){
		return menuController.getMouseListenersMenu();
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
