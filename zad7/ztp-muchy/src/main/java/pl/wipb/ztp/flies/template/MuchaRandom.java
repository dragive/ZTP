package pl.wipb.ztp.flies.template;

import java.awt.*;

class MuchaRandom extends Mucha {

	private void randomizeVelocity(){
		Double angle = randomIntFromInterval(-90D,90D);

		Double vx = Math.cos(Math.toRadians(angle)) * super.vx - Math.sin(Math.toRadians(angle)) * super.vy;
		Double vy = Math.sin(Math.toRadians(angle)) * super.vx + Math.cos(Math.toRadians(angle)) * super.vy;

		super.vx = vx;
		super.vy = vy;
	}

	private Double randomIntFromInterval(Double min, Double max) { // min and max included
		return Math.floor(Math.random() * (max - min + 1) + min);
	}

	public void move() {
		randomizeVelocity();
		super.x += super.vx;
		super.y += super.vy;
		if(super.x<0) { super.x = -super.x; super.vx = -super.vx; }
		if(super.x>1) { super.x = 2-super.x;super.vx = -super.vx; }
		if(super.y<0) { super.y = -super.y; super.vy = -super.vy; }
		if(super.y>1) { super.y = 2-super.y;super.vy = -super.vy; }

	}
	public Color getColor(){
		return Color.pink;
	}
}