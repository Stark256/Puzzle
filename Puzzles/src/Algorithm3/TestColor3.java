package Algorithm3;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TestColor3 {
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

		if (color1.getRed() != color2.getRed())  {
			rig = false;
		}
		/*if (color1.getGreen() != color2.getGreen()) {
			rig = false;
		}
		if (color1.getBlue() != color2.getBlue()) {
			rig = false;
		}*/
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
	//	System.out.println("r="+r+"/g="+g+"/b="+b);
		return new Color(r, g, b);
	}
}
