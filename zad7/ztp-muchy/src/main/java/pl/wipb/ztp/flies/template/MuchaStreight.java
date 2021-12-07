package pl.wipb.ztp.flies.template;

import java.awt.*;

class MuchaStreight extends Mucha {

	public void move() {
		super.x += super.vx;
		super.y += super.vy;
		if(super.x<0) { super.x = -super.x; super.vx = -super.vx; }
		if(super.x>1) { super.x = 2-super.x;super.vx = -super.vx; }
		if(super.y<0) { super.y = -super.y; super.vy = -super.vy; }
		if(super.y>1) { super.y = 2-super.y;super.vy = -super.vy; }
	}

	public Color getColor(){
		return Color.green;
	}
}