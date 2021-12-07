package pl.wipb.ztp.flies.strategy;


import java.awt.*;

public class MuchaRandomStrategy extends MuchaBaseStrategy{
    public MuchaRandomStrategy(Mucha mucha){
        this.mucha = mucha;
    }

    private void randomizeVelocity(){

        Double angle = randomIntFromInterval(-90D,90D);

        Double vx = Math.cos(Math.toRadians(angle)) * mucha.vx - Math.sin(Math.toRadians(angle)) * mucha.vy;
        Double vy = Math.sin(Math.toRadians(angle)) * mucha.vx + Math.cos(Math.toRadians(angle)) * mucha.vy;

        mucha.vx = vx;
        mucha.vy = vy;
    }

    private Double randomIntFromInterval(Double min, Double max) { // min and max included
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    @Override
    protected void move() {
        randomizeVelocity();
        mucha.x += mucha.vx;
        mucha.y += mucha.vy;
        if(mucha.x<0) { mucha.x = -mucha.x; mucha.vx = -mucha.vx; }
        if(mucha.x>1) { mucha.x = 2-mucha.x;mucha.vx = -mucha.vx; }
        if(mucha.y<0) { mucha.y = -mucha.y; mucha.vy = -mucha.vy; }
        if(mucha.y>1) { mucha.y = 2-mucha.y;mucha.vy = -mucha.vy; }
    }

    public Color getColor(){
        return Color.pink;
    }
}
