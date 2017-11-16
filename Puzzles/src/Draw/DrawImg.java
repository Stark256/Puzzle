package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Controller.Cube;

public class DrawImg {
	
	private BufferedImage gameImg;
	
	public DrawImg(BufferedImage gameImg) {
		this.gameImg = gameImg;
	}

	public void draw(Graphics2D graphic,Cube cube,int x,int y){
		graphic.drawImage(cube.getImage(), x, y, null);
	}
	
	public void mix(List<Cube> cubes){
	    int x;
	    int y;
	    int z;
	    boolean [][] em = new boolean[4][4];
	    
	    for(int i=0; i<cubes.size(); i++){
	      x = (int)Math.round(Math.random()*(4-1));
	      y = (int)Math.round(Math.random()*(4-1));
	      z = (int)(Math.random()*4+1);
	      cubes.get(i).setCurrent_orient(z);
	      if(!em[x][y]){
	    	 
	    	  cubes.get(i).setCurrent_X(x);
	    	  cubes.get(i).setCurrent_Y(y);
	        em[x][y]=true;
	      }else{
	        while(em[x][y]){
	          x++;
	          if(x>=4){
	            x=0;
	            y++;
	          }
	          if(y>=4){
	            y=0;
	          }
	          if(!em[x][y]){
	        	  cubes.get(i).setCurrent_X(x);
		    	  cubes.get(i).setCurrent_Y(y);
	            
	          }
	        }
	        em[x][y]=true;
	      }

	    }
	  }
	
	public void drawAll(Graphics2D graphic,List<Cube> cubes){
		for (Cube cube : cubes) {
			double rotationRequired=0.0;
			switch (cube.getCurrent_orient()) {
			case 1:{
				rotationRequired = Math.toRadians(0);
			}
			break;
			case 2:{
				rotationRequired = Math.toRadians(-90);
			}
			break;
			case 3:{
				rotationRequired = Math.toRadians(-180);
			}
			break;
			case 4:{
				rotationRequired = Math.toRadians(-270);
			}
			break;
			default:
				break;
			}
			
			
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, cube.getImage().getWidth()/2, cube.getImage().getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		 
		graphic.drawImage(op.filter(cube.getImage(),null), cube.getCurrent_X()*115, cube.getCurrent_Y()*115, null);
	//	graphic.setColor(new Color(80,80,80));
	//	graphic.drawRect(cube.getCurrent_X()*115, cube.getCurrent_Y()*115, cube.getImage().getWidth(),cube.getImage().getHeight());
		}
	}	
	
	
	
	
	
}
