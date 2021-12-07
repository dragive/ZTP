package pl.wipb.ztp.flies.template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Mucha {
	
	protected final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy

	public Mucha() {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	
	abstract public void move();
	abstract Color getColor();
}