package Controller;

import java.awt.image.BufferedImage;

public class Cube {

	public BufferedImage image;
	
	public final int correct_X;
	public final int correct_Y;
	public final int correct_orient;
	
	public int current_X;
	public int current_Y;
	public int current_orient;
	
	public Cube(BufferedImage image, int correct_X, int correct_Y, int correct_orient) {
		super();
		this.image = image;
		this.correct_X = correct_X;
		this.correct_Y = correct_Y;
		this.correct_orient = correct_orient;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public int getCurrent_X() {
		return current_X;
	}
	
	public void setCurrent_X(int current_X) {
		this.current_X = current_X;
	}
	
	public int getCurrent_Y() {
		return current_Y;
	}
	
	public void setCurrent_Y(int current_Y) {
		this.current_Y = current_Y;
	}
	
	public int getCurrent_orient() {
		return current_orient;
	}
	
	public void setCurrent_orient(int current_orient) {
		this.current_orient = current_orient;
	}
	
	public int getCorrect_X() {
		return correct_X;
	}
	
	public int getCorrect_Y() {
		return correct_Y;
	}
	
	public int getCorrect_orient() {
		return correct_orient;
	}
}
