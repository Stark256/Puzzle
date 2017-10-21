package Controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import Draw.DrawSolid;
import Frame.Panel;

public class MenuController {

	private List<DrawSolid> drawSoled;
	
	
	
	public MenuController() {
		this.drawSoled = new ArrayList<>();
		drawSoled.add(new DrawSolid("src/img/img1.jpg",0,115));
		drawSoled.add(new DrawSolid("src/img/img2.jpg",115,115));
		drawSoled.add(new DrawSolid("src/img/img3.jpg",230,115));
		drawSoled.add(new DrawSolid("src/img/img4.jpg",345,115));
		drawSoled.add(new DrawSolid("src/img/img5.jpg",0,230));
		drawSoled.add(new DrawSolid("src/img/img6.jpg",115,230));
		drawSoled.add(new DrawSolid("src/img/img7.jpg",230,230));
		drawSoled.add(new DrawSolid("src/img/img8.jpg",345,230));
		drawSoled.add(new DrawSolid("src/img/img9.jpg",0,345));
		drawSoled.add(new DrawSolid("src/img/img10.jpg",115,345));
		drawSoled.add(new DrawSolid("src/img/img11.jpg",230,345));
		drawSoled.add(new DrawSolid("src/img/img12.jpg",345,345));
	}

	public void render(Graphics2D graphic){
		graphic.setColor(new Color(50,50,50));
		graphic.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
		for (DrawSolid drawSolid : drawSoled) {
			drawSolid.draw(graphic);
		}
	}
	
	public String update(){
		return clicked();
	}
	
	public String clicked(){
		if(MainController.isMenu){
			for (DrawSolid drawSolid : drawSoled) {
				if(drawSolid.getIsClick()){
					System.out.println("+");
					return drawSolid.getImageName();
				}
			}
		}
		return null;
	}
	
	
	
	public List<MouseListener> getMouseListenersMenu(){
		List<MouseListener> listener =new ArrayList<>();
		for (DrawSolid drawSolid : drawSoled) {
			listener.add(drawSolid.getListener());
		}
		return listener;
	}

	
	
}
