package pl.wipb.ztp.flies.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class Mucha {
	
	private final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy

	private MuchaBaseStrategy muchaStrategy;

	public Mucha() {
		muchaStrategy = new MuchaRandomStrategy(this);
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	
	public void move() {
		muchaStrategy.move();
	}
}