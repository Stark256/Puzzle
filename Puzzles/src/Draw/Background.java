package Draw;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Frame.Panel;

public class Background {

	public Color color;
	
	
	public Background() {
		color = new Color(50,50,50);
	}

	public void update(){
		
	}
	
	public void draw(Graphics2D graphic){
		graphic.setColor(color);
		graphic.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
		
	//	graphic.setColor(new Color(70,70,70));
	//	graphic.fillRect(20, 20, Panel.WIDTH, Panel.WIDTH);
		
	//	graphic.fillRect(20, Panel.WIDTH, Panel.WIDTH-40, (Panel.WIDTH-40)/4);
		
		/*try {
			graphic.drawImage(ImageIO.read(new File("src/img/car.jpg")), 20, 20, null);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		
		//graphic.setColor(new Color(150,20,20));
		/*graphic.setColor(new Color(50,50,50));
		graphic.setStroke(new BasicStroke(3));
		graphic.drawLine(((Panel.WIDTH-40)/4)+20, 20, ((Panel.WIDTH-40)/4)+20, Panel.WIDTH-20);
		graphic.drawLine(((Panel.WIDTH-40)/4)*2+20, 20, ((Panel.WIDTH-40)/4)*2+20, Panel.WIDTH-20);
		graphic.drawLine(((Panel.WIDTH-40)/4)*3+20, 20, ((Panel.WIDTH-40)/4)*3+20, Panel.WIDTH-20);
		
		graphic.drawLine(20, ((Panel.WIDTH-40)/4)+20, Panel.WIDTH-20, ((Panel.WIDTH-40)/4)+20);
		graphic.drawLine(20, ((Panel.WIDTH-40)/4)*2+20, Panel.WIDTH-20, ((Panel.WIDTH-40)/4)*2+20);
		graphic.drawLine(20, ((Panel.WIDTH-40)/4)*3+20, Panel.WIDTH-20, ((Panel.WIDTH-40)/4)*3+20);*/
	
		
		
		//graphic.drawLine((Panel.WIDTH-40)/4+20, Panel.WIDTH, (Panel.WIDTH-40)/4+20, Panel.WIDTH+(Panel.WIDTH-40)/4);
		//graphic.drawLine(((Panel.WIDTH-40)/4)*2+20, Panel.WIDTH, ((Panel.WIDTH-40)/4)*2+20, Panel.WIDTH+(Panel.WIDTH-40)/4);
		//graphic.drawLine(((Panel.WIDTH-40)/4)*3+20, Panel.WIDTH, ((Panel.WIDTH-40)/4)*3+20, Panel.WIDTH+(Panel.WIDTH-40)/4);
		//(Panel.WIDTH-40)/4+20
		
	}
	
}
