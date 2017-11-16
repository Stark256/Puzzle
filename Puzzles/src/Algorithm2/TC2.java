package Algorithm2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import Controller.Cube;

public class TC2 {
	private int colorDef = 15;

	private double pixelKoef = 0.9;
	

	private boolean compareOneColor(Color color1, Color color2) {
		boolean rig = true;

		if (color1.getRed() != color2.getRed()) {
			rig = false;
		}
		if (color1.getGreen() != color2.getGreen()) {
			rig = false;
		}
		if (color1.getBlue() != color2.getBlue()) {
			rig = false;
		}
		return rig;
	}

	/*private boolean compareOneColor(Color color1, Color color2) {
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
	}*/

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
		Color[] colors = new Color[image.getHeight()];
		for (int i = 0; i < image.getHeight(); i++) {
			colors[i] = getOneColor(image.getRGB(image.getHeight() - 1, i));
		}
		return colors;
	}

	public Color[] getBottomColors(BufferedImage image) {
		Color[] colors = new Color[image.getWidth()];
		for (int i = 0; i < image.getWidth(); i++) {
			colors[i] = getOneColor(image.getRGB(i, image.getWidth() - 1));
		}
		return colors;
	}

	public Color[] getLeftColors(BufferedImage image) {
		Color[] colors = new Color[image.getHeight()];
		for (int i = 0; i < image.getHeight(); i++) {
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
	
	
	///////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////

	public void boost(Cube cube, List<Cube> rCubes, List<Cube> bCubes) {
	    Color[] leftcolors;
	    Color[] bottomcolors;
	    for (int i = 0; i < rCubes.size(); i++) {
	      if (i == 0) {
	    	  leftcolors=boostUp(getRightColors(cube.getImage()), getLeftColors(rCubes.get(i).getImage()));
	      } else {
	    	  leftcolors=boostDown(getRightColors(cube.getImage()), getLeftColors(rCubes.get(i).getImage()));
	      }
	      boostImage(rCubes.get(i).getImage(),leftcolors,4);
	      
	    }
	    for (int i = 0; i < bCubes.size(); i++) {
	      if (i == 0) {
	    	  bottomcolors=boostUp(getBottomColors(cube.getImage()), getTopColors(bCubes.get(i).getImage()));
	      } else {
	    	  bottomcolors=boostDown(getBottomColors(cube.getImage()), getTopColors(bCubes.get(i).getImage()));
	      }
	      boostImage(bCubes.get(i).getImage(),bottomcolors,1);
	    }

	  }

	  private void boostImage(BufferedImage image, Color[] colors, int side) {
	    if (side == 1) {
	      for (int i = 0; i < colors.length; i++) {
	        image.setRGB(i, 0, colors[i].getRGB());
	      }
	    }
	    if (side == 4) {
	      for (int i = 0; i < colors.length; i++) {
	        image.setRGB(0, i, colors[i].getRGB());
	      }
	    }
	  }

	  private Color[] boostUp(Color[] colors1, Color[] colors2) {
	    for (int i = 0; i < colors2.length; i++) {
	     colors2[i]=compareOneResult(colors1[i], colors2[i], true);
	    }
	    return colors2;
	  }

	  private Color[] boostDown(Color[] colors1, Color[] colors2) {
	    for (int i = 0; i < colors2.length; i++) {
	    	 colors2[i]= compareOneResult(colors1[i], colors2[i], false);
	    }
	    return colors2;
	  }

	  private Color compareOneResult(Color color1, Color color2, boolean isBoost) {
	    int r = color1.getRed() - color2.getRed();
	    int g = color1.getGreen() - color2.getGreen();
	    int b = color1.getBlue() - color2.getBlue();

	       	if(isBoost){
	    		color2 = new Color(color1.getRed() , color1.getGreen() , color1.getBlue() );
	    	}else{
	    		//((-1)*r)
	    		int rd=(color2.getRed() + (r*(-1)));
	    		int gd=(color2.getGreen() + (g*(-1)));
	    		int bd=(color2.getBlue() + (b*(-1)));
	    		if(rd>0 && rd<255){
	    			r=r*(-1);
	    		}else{
	    			r=0;
	    		}
	    		if(gd>0 && gd<255){
	    			g=g*(-1);
	    		}else{
	    			g=0;
	    		}
	    		if(bd>0 && bd<255){
	    			b=b*(-1);
	    		}else{
	    			b=0;
	    		}
	    		color2 = new Color(color2.getRed() + r, color2.getGreen() +  g, color2.getBlue() + b);
	    	}

	    return color2;

	  }



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
	  
}
