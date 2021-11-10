package com.company;

public class RealData implements Data {

    public int[] tab;
    public RealData(int size) {
        this.tab=new int[size];
    }

    @Override
    public int get(int idx) {
        return tab[idx];
    }

    @Override
    public void set(int idx, int value) {
        tab[idx]=value;
    }

    @Override
    public int size() {
        return tab.length;
    }
}
