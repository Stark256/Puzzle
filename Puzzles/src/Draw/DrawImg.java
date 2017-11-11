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
		graphic.setColor(new Color(80,80,80));
		graphic.drawRect(cube.getCurrent_X()*115, cube.getCurrent_Y()*115, cube.getImage().getWidth(),cube.getImage().getHeight());
		}
	}	
	
	
	/*public void drawCorrect(Graphics2D graphic,List<Cube> cubes){
		for (Cube cube : cubes) {
				graphic.drawImage(cube.getImage(), cube.getCorrect_X()*115, cube.getCorrect_Y()*115, null);
				graphic.setColor(new Color(80,80,80));
				graphic.drawRect(cube.getCorrect_X()*115, cube.getCorrect_Y()*115, cube.getImage().getWidth(),cube.getImage().getHeight());
		}
	}*/
	///////////////////example1////////////
	
	public void verifyWithSolid(List<Cube> cubes){
		//List<Cube> correctCubs=new ArrayList<>(cubes);
		int ofX=0;
		int ofY=0;
		//int n=0;
		int c=cubes.size();
		while(c>0){
			int x=0;
			int y=0;
			for (int i=0;i<cubes.size();i++) {
				
				int ver=verifyCube(cubes.get(i),ofX,ofY);
				if(ver==cubes.get(i).getImage().getWidth()*cubes.get(i).getImage().getHeight()){
					cubes.get(i).setCurrent_orient(1);
					//if(cubes.get(i).getCurrent_X()!=x && cubes.get(i).getCurrent_Y()!=y){
						
						swapToCubes(findOneCube(cubes,x,y),cubes.get(i));
					//}
				
				break;
				}
				if(y!=3){
					y++;
				}else if(y==3){
					y=0;
					x++;
				}
				
			}
			
			if(ofY!=345){
				ofY+=115;
			}else if(ofX==345 && ofY==345){
				ofX=0;
				ofY=0;
			}else if(ofY==345){
				
				ofY=0;
				ofX+=115;
			}
			c--;
		}
	}
	
	private void swapToCubes(Cube cube1,Cube cube2){
		int x=cube1.getCurrent_X();
		int y=cube1.getCurrent_Y();
		cube1.setCurrent_X(cube2.getCurrent_X());
		cube1.setCurrent_Y(cube2.getCurrent_Y());
		cube2.setCurrent_X(x);
		cube2.setCurrent_Y(y);
		//System.out.println("/1/---"+cube1.getCurrent_X()+"/"+cube1.getCurrent_Y());
		//System.out.println("/1/---"+cube2.getCurrent_X()+"/"+cube2.getCurrent_Y());
		
	}	
	
	public Cube findOneCube(List<Cube> cubes,int x,int y){
		for (Cube cube : cubes) {
			if(x==cube.getCurrent_X() &&	y==cube.getCurrent_Y()){
				return cube;
			}
		}
		return null;
	}
	
	private int verifyCube(Cube cube,int ofX,int ofY){
		int i=0;
		for(int x=0;x<cube.getImage().getWidth();x++){
			for(int y=0;y<cube.getImage().getHeight();y++){
				if(gameImg.getRGB(x+ofX, y+ofY)==cube.getImage().getRGB(x, y)){
					i++;
					//System.out.println(x+"/"+y);
				}
			}
		}
		return i;
	}
	
	/*
	private int upANDdown(Cube cube1,Cube cube2){
		for(int x=0;x<cube1.getImage().getWidth();x++){
						
			int clr1=cube1.getImage().getRGB(x, cube1.getImage().getHeight()-1);
			
			int  red1   = (clr1 & 0x00ff0000) >> 16;
			int  green1 = (clr1 & 0x0000ff00) >> 8;
			int  blue1  =  clr1 & 0x000000ff;
		  
			int clr2=cube2.getImage().getRGB(x, 0);
		  
			int  red2   = (clr2 & 0x00ff0000) >> 16;
			int  green2 = (clr2 & 0x0000ff00) >> 8;
			int  blue2  =  clr2 & 0x000000ff;
		  
			int red=Math.abs(red1-red2);
			int green=Math.abs(green1-green2);
			int blue=Math.abs(blue1-blue2);
			
		  /*System.out.println("----------"+x+"----------");
		  System.out.println("Red Color value = "+ red);
		  System.out.println("Green Color value = "+ green);
		  System.out.println("Blue Color value = "+ blue);
		}
		return 0;
	}
	private int leftANDright(Cube cube1,Cube cube2){
		for(int y=0;y<cube1.getImage().getHeight();y++){
			
			int clr1=cube1.getImage().getRGB(cube1.getImage().getWidth()-1, y);
			
			int  red1   = (clr1 & 0x00ff0000) >> 16;
			int  green1 = (clr1 & 0x0000ff00) >> 8;
			int  blue1  =  clr1 & 0x000000ff;
		  
			int clr2=cube2.getImage().getRGB(0, y);
		  
			int  red2   = (clr2 & 0x00ff0000) >> 16;
			int  green2 = (clr2 & 0x0000ff00) >> 8;
			int  blue2  =  clr2 & 0x000000ff;
		  
			int red=Math.abs(red1-red2);
			int green=Math.abs(green1-green2);
			int blue=Math.abs(blue1-blue2);
			
		  /*System.out.println("----------"+x+"----------");
		  System.out.println("Red Color value = "+ red);
		  System.out.println("Green Color value = "+ green);
		  System.out.println("Blue Color value = "+ blue);
		}
		return 0;
	}*/
	
	
}
