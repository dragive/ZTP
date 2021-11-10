package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Baza extends AbstractListModel {
    private ArrayList<Data> ar = new ArrayList<>();

    public int getSize() {
        return ar.size();
    }

    public Object getElementAt(int index) {
        return ar.get(index);
    }

    public void add(Data tab){
        ar.add(tab);
        fireIntervalAdded(ar,ar.size(), ar.size());
    }

    public void remove(int idx){
        ar.remove(ar.get(idx));
        fireIntervalRemoved(ar,ar.size(), ar.size());
    }
}
