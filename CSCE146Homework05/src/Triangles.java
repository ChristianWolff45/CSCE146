//Written by Christian Wolff
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Triangles extends Canvas{
	public int count = 0;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Colorful triangles");
		frame.setSize(800,800);
		Triangles sp = new Triangles();
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 
	public void paint(Graphics g) {
		int[] xPoints = {this.getSize().height/2, 0, this.getSize().height};
		int[] yPoints = {0, this.getSize().height, this.getSize().height};
		g.fillPolygon(xPoints, yPoints, 3);//draws the first upright triangle
		drawCarpet(0,0,this.getSize().height,g, 0);//calls recursive function to draw upside down triangles
	}

	//creates fractal drawing of upside down triangles
	public void drawCarpet(int x, int y, int height, Graphics g, int CountColor) {
		int sub = (height+2)/4;//splits the frame into fourths, add 2 to height to round the integer
		int[] xPoints = {sub+x, sub*3+x, sub*2+x};
		int[] yPoints = {sub*2+y, sub*2+y, height+y};
		g.setColor(selectColor(CountColor));
		g.fillPolygon(xPoints, yPoints, 3);
		if(sub >= 4) {
			drawCarpet(x+sub,y, sub*2,g, CountColor+1);
			drawCarpet(x,y+sub*2, sub*2,g, CountColor+1);
			drawCarpet(x+sub*2,y+sub*2, sub*2,g, CountColor+1);
		}
	}

	// changes the color of triangles for fun
	private Color selectColor(int i) {
		i = (i %3);
		switch(i){
			case 0:
				return Color.RED;
			case 1:
				return Color.BLUE;
			case 2:
				return Color.WHITE;
		}
		return Color.BLACK;
	}
}
