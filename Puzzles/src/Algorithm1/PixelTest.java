package Algorithm1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Controller.Cube;

public class PixelTest {

	
	public void compareOnePixel(List<Cube> cubes){
		List<Cube> cubic=new ArrayList<>(cubes);
		int index;
		while(cubic.isEmpty()){
			index=0;
			for(int i=cubic.size();i>0;i--){
				if(cubic.get(i)!=null){
					
					
					
					
				}
			}
			cubic.remove(index);
		}
		
		
	}
	
	public Cube findFirst(List<Cube> cubes) {
		boolean find = true;
		Cube cube=null;
		List<Cube> cc=new ArrayList<>();
		//int index = -1;
		//if(find){
		for (int i = 0; i < cubes.size(); i++) {
			if (compareWithAll(cubes, cubes.get(i))) {
				cc.add(cubes.get(i));
				//index++;
				break;
			}
		//}
		//find= false;
		}
		//Cube cube = null;
		/*if(index!=-1){
			cube = cc.get(index);}
		//cc.remove(index);
		if(index>0)
			index--;*/
		for(int i=0;i<cc.size();i++){
		
			System.out.println(cc.get(i).getCorrect_X()+"/"+cc.get(i).getCorrect_Y());
		
		}
		return cube;
	}

	private void verify(){
		
	}
	
	private boolean compareWithAll(List<Cube> cubes, Cube cube) {
		boolean a = false;
		List<Cube> cubc=new ArrayList<>();
		cube.setCurrent_orient(1);
		for (int i = 0; i < cubes.size(); i++) {
			int []b = compareImagess(cube.getImage(), cubes.get(i).getImage());
			if (b[0] == 1 && b[1] == 4)
				a = true;
		}
		//System.out.println(a + "(" + cube.getCurrent_X() + "|" + cube.getCurrent_Y() + ")");

		return a;
	}
	
	private void change(Cube cube, Cube cube1) {
		int xx = cube.getCurrent_X();
		int yy = cube.getCurrent_Y();

		cube.setCurrent_X(cube1.getCurrent_X());
		cube.setCurrent_Y(cube1.getCurrent_Y());

		cube1.setCurrent_X(xx);
		cube1.setCurrent_Y(yy);
	}
	
	private int[] compareImagess(BufferedImage image, BufferedImage image1){
		int[] arr=new int[2];
		if (topSide(image, image1)){
			arr[0]= 1;
		}else{
			arr[0]= 0;
		}
		if (leftSide(image, image1)){
			arr[1]= 4;
		}else{
			arr[1]= 0;
		}
		return arr;
	}
	
	
	public int compareImages(BufferedImage image, BufferedImage image1) {
		if (topSide(image, image1))
			return 1;
		if (rightSide(image, image1))
			return 2;
		if (boottomSide(image, image1))
			return 3;
		if (leftSide(image, image1))
			return 4;

		return 0;
	}
	
	public boolean compareColors(Color colors1, Color colors2) {
	
		if (compareOneColor(colors1, colors2)) {
		return true;
		}
		return false;
	}

	private boolean compareOneColor(Color color1, Color color2) {
		boolean rig = true;

		if (color1.getRed() == color2.getRed())  {
			rig = false;
		}
		if (color1.getGreen() == color2.getGreen()) {
			rig = false;
		}
		if (color1.getBlue() == color2.getBlue()) {
			rig = false;
		}
		return rig;
	}
	

	/*public Color[] getColorsByX(BufferedImage image, int x) {
		Color[] colors = new Color[image.getHeight()];
		for (int i = 0; i < image.getHeight(); i++) {
			colors[i] = getOneColor(image.getRGB(x, i));
		}
		return colors;
	}

	public Color[] getColorsByY(BufferedImage image, int y) {
		Color[] colors = new Color[image.getWidth()];
		for (int i = 0; i < image.getWidth(); i++) {
			colors[i] = getOneColor(image.getRGB(i, y));
		}
		return colors;
	}*/

	
	private boolean rightSide(BufferedImage image, BufferedImage image1) {
		return compareColors(getRightColors(image), getLeftColors(image1));

	}

	private boolean topSide(BufferedImage image, BufferedImage image1) {

		return compareColors(getTopColors(image), getBottomColors(image1));

	}

	private boolean leftSide(BufferedImage image, BufferedImage image1) {
		
		return compareColors(getLeftColors(image), getRightColors(image1));

	}

	private boolean boottomSide(BufferedImage image, BufferedImage image1) {

		return compareColors(getBottomColors(image), getTopColors(image1));

	}
	////////////////////////////////////////////

	////////////////////////////////////////////
	public Color getTopColors(BufferedImage image) {
		Color color = getOneColor(image.getRGB(56,0));
		return color;
	}

	public Color getRightColors(BufferedImage image) {
		Color color = getOneColor(image.getRGB(114,56));
		return color;
	}

	public Color getBottomColors(BufferedImage image) {
		Color color = getOneColor(image.getRGB(56,114));
		return color;
	}

	public Color getLeftColors(BufferedImage image) {
		Color color = getOneColor(image.getRGB(0,56));
		return color;
	}

	private Color getOneColor(int rgb) {
		int r = (rgb & 0x00ff0000) >> 16;
		int g = (rgb & 0x0000ff00) >> 8;
		int b = rgb & 0x000000ff;
		return new Color(r, g, b);
	}
}
