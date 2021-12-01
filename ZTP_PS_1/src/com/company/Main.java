package com.company;


import com.company.Interfaces.IPolaczenie;
import com.company.classes.Baza;

public class Main {

    public static void main(String[] args) {

        IPolaczenie p1 = Baza.getPolaczenie();

        IPolaczenie p2 = Baza.getPolaczenie();
        IPolaczenie p3 = Baza.getPolaczenie();

        IPolaczenie p4 = Baza.getPolaczenie();

        System.out.println("Wypisanie referencji: \n");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);


        /*
        Spradzenie czy pobieranie danych działa
         */

        //dodaanie do bazy przez polaczenie 1
        System.out.println("\nDodanie do bazy przez polaczenie 1. wartości: \n");
        for(int i =0; i<10;i++){
            p1.set(i,(char)(i+'a'));
            System.out.println("  wartość: "+((char)(i+'a'))+"   pod indeksem: "+i);
        }
        System.out.println("\n\n");

        System.out.print("Sprawdzenie co kryje się przy użyciu innego połączenia z innej bazy:  ");
        //sprawdzenie co sie kryje przy uzyciu innego polaczenia z innej bazy
        for(int i =0; i<10;i++){
            System.out.print(p3.get(i));
        }
        System.out.println("\n");

        //zmiana danych przy jeszcze nowo utworzonym polączeniu
        System.out.println("Zmiana danych przy jeszcze nowo utworzonym połaczeniu  ");
        IPolaczenie polTestowe1 = Baza.getPolaczenie();
        for(int i = 5; i<10;i++)
        {
            polTestowe1.set(i,(char)('1'+i-2)); // wpisanie danych zmienionych
        }



        //wypisanie danych jeszcze nowo utworzonym polączeniu
    System.out.print("\nWypisanie danych na jeszcze nowo utworzonym połączeniu z innej bazy:  ");
        IPolaczenie polTestowe2 = Baza.getPolaczenie();
        for(int i = 0; i<10;i++)
        {
            System.out.print(polTestowe1.get(i));
        }
        System.out.println("\n\n");


    System.out.println("WNIOSKI: wyświetlając referencje można zaobserwować zmianę wartości i to, że co 3. pobrania instancji wartość jest taka sama. Dodatkowo po tworzeniu wykorzystywaniu połączeń nowoutworzonych można korzystać dalej z jedynej instancji Bazy.");







    }


}
