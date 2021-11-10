package com.company;

public class PropData implements Data{
    private int size;
    private RealData tab;

    public PropData(int size) {
        this.size = size;
    }

    @Override
    public int get(int idx) {
        if (tab==null) return 0;
        return tab.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if (tab == null) tab = new RealData(this.size);
        tab.set(idx, value);
    }

    @Override
    public int size() {
        return this.size;
    }
}
