package Draw;
import java.awt.Color;
import java.awt.Graphics2D;

import Frame.Panel;

public class Background {

	public Color color;
	
	
	public Background() {
		color = new Color(50,50,50);
	}

	public void draw(Graphics2D graphic){
		graphic.setColor(color);
		graphic.fillRect(0, 0, Panel.WIDTH, Panel.HEIGHT);
	}
}
