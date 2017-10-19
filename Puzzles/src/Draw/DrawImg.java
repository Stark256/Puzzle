package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;


import Controller.Cube;

public class DrawImg {

	public void update(){
		
	}
	
	public void draw(Graphics2D graphic,Cube cube,int x,int y){
		graphic.drawImage(cube.getImage(), x, y, null);
	}
	
	public void mix(List<Cube> cubes){
	    int x;
	    int y;
	    boolean [][] em = new boolean[4][4];
	    
	    for(int i=0; i<cubes.size(); i++){
	      x = (int)Math.round(Math.random()*(4-1));
	      y = (int)Math.round(Math.random()*(4-1));
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
				graphic.drawImage(cube.getImage(), cube.getCurrent_X()*115, cube.getCurrent_Y()*115, null);
				graphic.setColor(new Color(80,80,80));
				graphic.drawRect(cube.getCurrent_X()*115, cube.getCurrent_Y()*115, cube.getImage().getWidth(),cube.getImage().getHeight());
		}
	}	
	
	public void drawCorrect(Graphics2D graphic,List<Cube> cubes){
		for (Cube cube : cubes) {
				graphic.drawImage(cube.getImage(), cube.getCorrect_X()*115, cube.getCorrect_Y()*115, null);
				graphic.setColor(new Color(80,80,80));
				graphic.drawRect(cube.getCorrect_X()*115, cube.getCorrect_Y()*115, cube.getImage().getWidth(),cube.getImage().getHeight());
		}
	}
}
