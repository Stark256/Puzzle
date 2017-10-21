package Controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Frame.Panel;

public class MenuController {

	
	
	
	
	public void render(Graphics2D graphic){
		graphic.setColor(new Color(50,50,50));
		graphic.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
	}
	
	public void update(){
		
	}
	
	
	
	private class GameMouseListener implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
	
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
	
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
	
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
			}
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
			}
		}
	}
	

	
	
}
