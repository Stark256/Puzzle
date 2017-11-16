package Controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Algorithm.ColorTest;

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
		int offset_y=0;
		
		for(int y=0;y<4;y++){
		
			int offset_x=0;
			
			
			for(int x=0;x<4;x++){
				
				images[x][y]=new BufferedImage(image.getWidth()/4,image.getHeight()/4,image.getType());
					
					writeImg(images[x][y],x,y,offset_x,offset_y);
					
					offset_x+=image.getWidth()/4;
			}	
			offset_y+=image.getHeight()/4;
			
		}
		//findT();
	}
	
	
	private void changePix(ColorTest test,List<Cube> leftcubs,List<Cube> bottomcubs,int i){
		System.out.println("----/"+(i+1)+"/----");
		System.out.println(cubes.get(i).getCorrect_X()+"/"+cubes.get(i).getCorrect_Y());
		System.out.println("ліво");
		if(leftcubs.size()!=0 &&leftcubs.size()>1){
			for(int p=0;p<leftcubs.size();p++){
				
				System.out.println(leftcubs.get(p).getCorrect_X()+"/"+leftcubs.get(p).getCorrect_Y());
			}
		}else  if(leftcubs.size()!=0 &&leftcubs.size()==1){
			
			System.out.println(leftcubs.get(0).getCorrect_X()+"/"+leftcubs.get(0).getCorrect_Y());
		}
		System.out.println("низ");
		if(bottomcubs.size()!=0 &&bottomcubs.size()>1){
			for(int p=0;p<bottomcubs.size();p++){
				
				System.out.println(bottomcubs.get(p).getCorrect_X()+"/"+bottomcubs.get(p).getCorrect_Y());
			}
		}else if(bottomcubs.size()!=0 &&bottomcubs.size()==1){
			
			System.out.println(bottomcubs.get(0).getCorrect_X()+"/"+bottomcubs.get(0).getCorrect_Y());
		}
		
		
	}
	
	private void findTT(){
		ColorTest test=new ColorTest();
		List<Cube> leftcubs;
		List<Cube> bottomcubs;
		test.setPixelKoef(0.8);
		test.setColorDef(20);
			for(int i=0;i<cubes.size();i++){
				leftcubs = new ArrayList<>();
				bottomcubs = new ArrayList<>();
				Cube cubec=cubes.get(i);
				for(int y=0;y<4;y++){//(i+1)/4
					for(int x=0;x<4;x++){//(i+1)%4
						Cube cube=findOneByCorrectXY(x,y);
						if(!cube.equals(cubec)){
							if(i!=3||i!=7||i!=11||i!=15){
								if(test.compareImages(cubes.get(i).getImage(),cube.getImage())==2 && x!=0){
								leftcubs.add(cube);
								}
							}
							if(i!=12||i!=13||i!=14||i!=15){
								if(test.compareImages(cubes.get(i).getImage(),cube.getImage())==3 && y!=0){
									bottomcubs.add(cube);
								}
							}
						}	
						
						
					}
				}
				changePix(test,leftcubs,bottomcubs,i);
			}
	}
	
	
	
	private void findT(){
		ColorTest test=new ColorTest();
		List<Cube> leftcubs;
		List<Cube> bottomcubs;
		
			for(int i=0;i<cubes.size();i++){
				leftcubs = new ArrayList<>();
				bottomcubs = new ArrayList<>();
				Cube cubec=cubes.get(i);
				for(int y=0;y<4;y++){//(i+1)/4
					for(int x=0;x<4;x++){//(i+1)%4
						Cube cube=findOneByCorrectXY(x,y);
						if(!cube.equals(cubec)){
							if(i!=3||i!=7||i!=11||i!=15){
								if(test.compareImages(cubes.get(i).getImage(),cube.getImage())==2 && x!=0){
								leftcubs.add(cube);
								}
							}
							if(i!=12||i!=13||i!=14||i!=15){
								if(test.compareImages(cubes.get(i).getImage(),cube.getImage())==3 && y!=0){
									bottomcubs.add(cube);
								}
							}
						}	
						
						
					}
				}
				changePix(test,leftcubs,bottomcubs,i);
				test.boost(cubes.get(i), leftcubs, bottomcubs);
			}
			System.out.println("/////////////////////////////////////////////////////");
			System.out.println("-----------------------------------------------------");
			System.out.println("/////////////////////////////////////////////////////");
			findTT();
			
		
		
	}
	
	private Cube findOneByCorrectXY(int x, int y) {
		for (int i = 0; i < cubes.size(); i++) {
			if (cubes.get(i).getCorrect_X() == x && cubes.get(i).getCorrect_Y() == y) {
				return cubes.get(i);
			}
		}
		return null;
	}
	
	private void writeImg(BufferedImage current_image,int xx,int yy,int offset_x,int offset_y){
		int [][] cs=new int[9][9];
		int a=50;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				cs[i][j]=a;
				a++;
			}
		}
		
		
		for(int x=0;x<image.getWidth()/4;x++){
			for(int y=0;y<image.getHeight()/4;y++){
				current_image.setRGB(x,y,image.getRGB(x+offset_x,y+offset_y));
				Color color = new Color(image.getRGB(x+offset_x,y+offset_y));
				if(x==56 && y==0){//верх
					current_image.setRGB(x,y,new Color(cs[xx*2+1][yy*2],color.getGreen(),color.getBlue()).getRGB());
				}
				if(x==0 && y==56){//ліво
					current_image.setRGB(x,y, new Color(cs[xx*2][yy*2+1],color.getGreen(),color.getBlue()).getRGB());
				}
				if(x==56 && y==114){//низ
					current_image.setRGB(x,y,new Color(cs[xx*2+1][(yy+1)*2],color.getGreen(),color.getBlue()).getRGB());
				}
				if(x==114 && y==56){//право
					current_image.setRGB(x,y,new Color(cs[(xx+1)*2][yy*2+1],color.getGreen(),color.getBlue()).getRGB());
				}
				
				
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
