package Algorithm;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorTest {

	private int colorDef = 3;

	private double pixelKoef = 0.24;

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

	/////////////////////////////////
	public boolean compareColors(Color[] colors1, Color[] colors2) {
		int size = 0;
		for (int i = 0; i < colors2.length; i++) {
			if (compareOneColor(colors1[i], colors2[i])) {
				size++;
			}
		}

		//System.out.println(size + "/" + colors2.length * pixelKoef + "(" + colors2.length + ")");

		if (size > colors2.length * pixelKoef) {
			return true;
		}

		return false;
	}

	private boolean compareOneColor(Color color1, Color color2) {
		boolean rig = true;

		if (Math.abs(color1.getRed() - color2.getRed()) > colorDef) {
			rig = false;
		}
		if (Math.abs(color1.getGreen() - color2.getGreen()) > colorDef) {
			rig = false;
		}
		if (Math.abs(color1.getBlue() - color2.getBlue()) > colorDef) {
			rig = false;
		}
		return rig;
	}
	///////////////////////////////////

	public Color[] getColorsByX(BufferedImage image, int x) {
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
	}

	////////////////////////
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
	public Color[] getTopColors(BufferedImage image) {
		Color[] colors = new Color[image.getWidth()];
		for (int i = 0; i < image.getWidth(); i++) {
			colors[i] = getOneColor(image.getRGB(i, 0));
		}
		return colors;
	}

	public Color[] getRightColors(BufferedImage image) {
		Color[] colors = new Color[image.getWidth()];
		for (int i = 0; i < image.getWidth(); i++) {
			colors[i] = getOneColor(image.getRGB(image.getWidth() - 1, i));
		}
		return colors;
	}

	public Color[] getBottomColors(BufferedImage image) {
		Color[] colors = new Color[image.getHeight()];
		for (int i = 0; i < image.getHeight(); i++) {
			colors[i] = getOneColor(image.getRGB(i, image.getHeight() - 1));
		}
		return colors;
	}

	public Color[] getLeftColors(BufferedImage image) {
		Color[] colors = new Color[image.getWidth()];
		for (int i = 0; i < image.getWidth(); i++) {
			colors[i] = getOneColor(image.getRGB(0, i));
		}
		return colors;
	}
	////////////////////////////////////////////

	private Color getOneColor(int rgb) {
		int r = (rgb & 0x00ff0000) >> 16;
		int g = (rgb & 0x0000ff00) >> 8;
		int b = rgb & 0x000000ff;
		return new Color(r, g, b);
	}
///////////////
	public int getColorDef() {
		return colorDef;
	}

	public void setColorDef(int colorDef) {
		this.colorDef = colorDef;
	}

	public double getPixelKoef() {
		return pixelKoef;
	}

	public void setPixelKoef(double pixelKoef) {
		this.pixelKoef = pixelKoef;
	}
	
	////////////////////
	

}
