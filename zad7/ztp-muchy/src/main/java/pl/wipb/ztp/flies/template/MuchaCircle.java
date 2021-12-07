package pl.wipb.ztp.flies.template;

import java.awt.*;

class MuchaCircle extends Mucha {

	private Double angle = randomIntFromInterval(1D,30D);;

	private void randomizeVelocity(){

		Double vx = Math.cos(Math.toRadians(angle)) * super.vx - Math.sin(Math.toRadians(angle)) * super.vy;
		Double vy = Math.sin(Math.toRadians(angle)) * super.vx + Math.cos(Math.toRadians(angle)) * super.vy;

		super.vx = vx;
		super.vy = vy;
	}

	private Double randomIntFromInterval(Double min, Double max) { // min and max included
		return Math.floor(Math.random() * (max - min + 1) + min);
	}

	public Color getColor(){
		return Color.red;
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
}