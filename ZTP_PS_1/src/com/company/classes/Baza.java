package com.company.classes;

import com.company.Interfaces.IPolaczenie;

import java.util.ArrayList;

public class Baza {
    private char[] tab ; /* ... */

    public static IPolaczenie getPolaczenie() {

        return Polaczenie.getInstance();

    }

    private Baza(){}

    private static class Polaczenie implements IPolaczenie {

        private Baza baza; /* ... */

        private static ArrayList<IPolaczenie> instaces;

        private static Integer counter;

        private Polaczenie(){}

        public static IPolaczenie getInstance() {



            if(instaces==null){
                instaces = new ArrayList<IPolaczenie>();
                instaces.add(new Polaczenie());
                instaces.add(new Polaczenie());
                instaces.add(new Polaczenie());
                counter = 2;
            }
            counter = (counter+1)%3;
            return instaces.get(counter);
        }

        public char get(int indeks) {

            return baza.tab[indeks];

        }

        public void set(int indeks, char c) {

            baza.tab[indeks] = c;

        }

        public int length() {

            return baza.tab.length;

        }

    }

}
