package Controller;

import java.awt.Color;
import java.awt.Graphics2D;

import Frame.Panel;

public class GameOver {

	public void update(){
		
	}
	
	public void draw(Graphics2D graphic){
		graphic.setColor(new Color(50,50,50));
		graphic.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
		graphic.setColor(new Color(200,200,200));
		graphic.drawString("WON",  Panel.WIDTH/2, Panel.HEIGHT/2);
	}
}
