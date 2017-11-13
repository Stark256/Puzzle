package Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class CutCube {

public BufferedImage image;

public List<Cube> cubes = new ArrayList<>();
	
	public CutCube(BufferedImage image) {
		super();
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void cut(){
		BufferedImage[][] images=new BufferedImage[4][4];
		int offset_x=0;
		for(int x=0;x<4;x++){
			
			int offset_y=0;
			
			for(int y=0;y<4;y++){
				
				images[x][y]=new BufferedImage(image.getWidth()/4,image.getHeight()/4,image.getType());
					
					writeImg(images[x][y],x,y,offset_x,offset_y);
					offset_y+=image.getHeight()/4;
			}	
			
			offset_x+=image.getWidth()/4;
		}
	}
	
	private void writeImg(BufferedImage current_image,int xx,int yy,int offset_x,int offset_y){
		for(int x=0;x<image.getWidth()/4;x++){
			for(int y=0;y<image.getHeight()/4;y++){
			
				current_image.setRGB(x,y,image.getRGB(x+offset_x,y+offset_y));
				
			}		  
		}
		String name="src/croppedImg/image_"+xx+"_"+yy+".jpg";
			try {
				ImageIO.write(current_image, "jpg", new File(name));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Cube cube= new Cube(current_image,xx,yy,1);
			cube.setName(name);
			cubes.add(cube);
	}	
	
	public List<Cube> getCubes() {
		List<Cube> cube1 = new ArrayList<>();
		for(int i = cubes.size()-1; i >=0; i--){
			cube1.add(cubes.get(i));
		}
		return cube1;
	}

	public void setCubes(List<Cube> cubes) {
		this.cubes = cubes;
	}
}
