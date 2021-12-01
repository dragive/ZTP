package com.company.classes;

import com.company.Interfaces.IPolaczenie;

import java.util.ArrayList;

public class Baza {
    private char[] tab = new char[100]; /* ... */

    private static Baza instance;

    /**
     * Statyczna metoda klasy Baza, stworzona w celu umożliwienia pobierania połączeń do bazy.
     */
    public static IPolaczenie getPolaczenie() {

        return Polaczenie.getInstance();

    }

    /**
     * Zablokowanie dostępu do konstruktora z poziomu innych klas
     */
    private Baza(){}

    /**
     * Statyczna metoda do pobierania instancji obiektu z Singletonu.
     * @return Obiekt klasy Baza
     */
    public static Baza getInstance(){
        if(instance==null){
            instance = new Baza();
        }
        return instance;
    }

    private static class Polaczenie implements IPolaczenie {

        private Baza baza; /* ... */

        private static ArrayList<IPolaczenie> instaces;

        /**
         * wskazanie na obecny, ostanio wykorzsytany indeks
         */
        private static Integer counter;

        /**
         * prywatny konstruktor. Jego rolę przejeła metoda getInstance
         */
        private Polaczenie(){
            baza = Baza.getInstance();
        }

        /**
         * zadeklarowanie ilości połączeń do wykorzystania z puli
         */
        private static Integer numberOfConnections = 3; // ilość połączeń w puli

        /**
         * Statyczna metoda pobierania instancji połączenia i zwrócenia jednego z puli. Wykorzystana została wczesna inicjalizacja.
         */
        public static IPolaczenie getInstance() {

            if(instaces==null){
                instaces = new ArrayList<IPolaczenie>();
                for( int i =0;i<numberOfConnections;i++) instaces.add(new Polaczenie());
                counter = instaces.size()-1; //ustawienie wartości o jeden mniejszej, by kolejna brana była wartość z indeksu zerowego listy
            }
            counter = (counter+1)%instaces.size();
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
