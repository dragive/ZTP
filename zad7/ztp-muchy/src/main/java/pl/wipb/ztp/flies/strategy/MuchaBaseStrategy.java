package pl.wipb.ztp.flies.strategy;

public abstract class MuchaBaseStrategy {
    protected Mucha mucha;

    public Mucha getMucha() {
        return mucha;
    }

    public void setMucha(Mucha mucha) {
        this.mucha = mucha;
    }

    protected abstract void move();
}
