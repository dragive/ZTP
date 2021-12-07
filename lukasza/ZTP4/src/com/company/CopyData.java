package com.company;

public class CopyData implements Data {
    private Data origin;
    private Data copy;

    public CopyData(Data origin) {
        this.origin = origin;
        this.copy = new RealData(origin.size());
    }

    @Override
    public int get(int idx) {
        return origin != null ? origin.get(idx) : copy.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if (origin != null){
            for (int i = 0; i < origin.size(); i++) {
                copy.set(i, origin.get(i));
            }
            origin =null;
        }
        copy.set(idx, value);
    }

    @Override
    public int size() {
        return copy.size();
    }
}
