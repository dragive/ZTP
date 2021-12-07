package pl.wipb.ztp.flies.strategy;


import java.awt.*;

public class MuchaStreightStrategy extends MuchaBaseStrategy{
    public MuchaStreightStrategy(Mucha mucha){
        this.mucha = mucha;
    }

    @Override
    protected void move() {
        mucha.x += mucha.vx;
        mucha.y += mucha.vy;
        if(mucha.x<0) { mucha.x = -mucha.x; mucha.vx = -mucha.vx; }
        if(mucha.x>1) { mucha.x = 2-mucha.x;mucha.vx = -mucha.vx; }
        if(mucha.y<0) { mucha.y = -mucha.y; mucha.vy = -mucha.vy; }
        if(mucha.y>1) { mucha.y = 2-mucha.y;mucha.vy = -mucha.vy; }
    }
    public Color getColor(){
        return Color.green;
    }
}
