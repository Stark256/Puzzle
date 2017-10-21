package Draw;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawSolid {

	private BufferedImage image;
	
	private String imageName;
	
	private int x;
	
	private int y;
	
	private boolean isClick;
	
	
	
	public DrawSolid(String imageName, int x, int y) {
		try {
			image=ImageIO.read(new File(imageName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageName = imageName;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics2D graphic){
		try {
			graphic.drawImage(ImageIO.read(new File("src/img/header.jpg")), 0, 0, 460, 115, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphic.drawImage(image, x, y, 115, 115, null);
	}
	
	public void update(){
		
	}
	
	public MouseListener getListener(){
		
		return new GameMouseListener(); 
	}
	
private class GameMouseListener implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if(x<=e.getX() && y<=e.getY() && x+115>e.getX() && y+115>e.getY()){
					isClick=true;
					//System.out.println("x="+x+"/y="+y);
				}
				
				
			}
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
	
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
	
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getIsClick() {
		if(isClick){
			isClick=false;
			return true;
		}
		return false;
	}

	public void setIsClick(boolean isClick) {
		this.isClick = isClick;
	}
	
	
	
}
