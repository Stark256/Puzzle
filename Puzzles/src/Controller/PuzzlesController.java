package Controller;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Draw.DrawImg;
import Frame.Panel;

public class PuzzlesController {

	private BufferedImage gameImg;
	
	private DrawImg drawImg;
	
	private List<Cube> cubes;
	
	private MoveCube move; 
	
	boolean space;
	
public	PuzzlesController(){
		drawImg=new DrawImg();
		
		try {
			gameImg=ImageIO.read(new File("src/img/img4.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		CutCube cutCube=new CutCube(gameImg);
		cutCube.cut();
		cubes=cutCube.getCubes();
		drawImg.mix(cubes);
		
		move= new MoveCube(findOneCube(0,0).getImage().getWidth(),findOneCube(0,0).getImage().getHeight());
		//move.setIsEmpty(true);
	}
	
	public void render(Graphics2D graphic){
		if(!space){
			drawImg.drawAll(graphic,cubes);
		}else{
			drawImg.drawCorrect(graphic,cubes);
		}
		move.draw(graphic);
	}
	
	public void draw(){
		
	}
	
	public void update(){
		move.update();
	}
	
	public Cube findOneCube(int x,int y){
		for (Cube cube : cubes) {
			if(x==cube.getCurrent_X() &&	y==cube.getCurrent_Y()){
				return cube;
			}
		}
		return null;
	}
	
	public int findCubeIndex(int x,int y){
		for (int i=0;i<cubes.size();i++) {
			if(x==cubes.get(i).getCurrent_X() &&	y==cubes.get(i).getCurrent_Y()){
				return i;
			}
		}
		return 0;
	}

	private void replace(int mouseX, int mouseY) {
			
			move.setCurrentX(mouseX);
			if (mouseX >= Panel.WIDTH)
				move.setCurrentX(Panel.WIDTH - 5);
			if (mouseX < 0)
				move.setCurrentX(5);
			move.setCurrentY(mouseY);
			if (mouseY >= Panel.HEIGHT)
				move.setCurrentY(Panel.HEIGHT - 5);
			if (mouseY < 0)
				move.setCurrentY(5);
			
			if (move.getImage() != null) {
				Cube puz1 = findOneCube(move.getX(), move.getY());
				Cube puz2 = findOneCube(move.getCurrentX(), move.getCurrentY());
	
				puz1.setCurrent_X(move.getCurrentX());
				puz1.setCurrent_Y(move.getCurrentY());
	
				puz2.setCurrent_X(move.getX());
				puz2.setCurrent_Y(move.getY());
	
				move.clear();
			}
		}
		
	private void take(int mouseX, int mouseY) {
		move.setMouseX(mouseX);
		move.setMouseY(mouseY);
		move.setX((mouseX) / move.getWidth());
		move.setY((mouseY) / move.getHeight());
		if (move.getImage() == null) {
			Cube cube = findOneCube(move.getX(), move.getY());
			move.set(cube);
		}
	
	}
	
	public List<KeyListener> getKeyListeners() {
		List<KeyListener> listeners = new ArrayList<>();
		listeners.add(move.getKeyListener());
		listeners.add(new GameKeyListener());
		return listeners;
	}
	
	public List<MouseListener> getMouseListeners() {
		List<MouseListener> listeners = new ArrayList<>();
		listeners.add(new GameMouseListener());
		return listeners;
	}
	
	public List<MouseMotionListener> getMouseMotionListeners() {
		List<MouseMotionListener> listeners = new ArrayList<>();
		listeners.add(move.getGameMouseMotionListener());
		return listeners;
	}
	
	private class GameKeyListener implements KeyListener {
	
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_SPACE) {
				space=true;
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_SPACE) {
				space=false;
			}
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
	
		}
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
				take(e.getX(), e.getY());
			}
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				replace(e.getX(), e.getY());
			}
		}
	}
}
