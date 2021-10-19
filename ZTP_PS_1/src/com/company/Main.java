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
        System.out.println("dodaanie do bazy przez polaczenie 1.: ");
        for(int i =0; i<10;i++){
            p1.set(i,(char)(i+'a'));
        }

        System.out.println("Sprawdzenie co kryje się przy użyciu innego połączenia z innej bazy");
        //sprawdzenie co sie kryje przy uzyciu innego polaczenia z innej bazy
        for(int i =0; i<10;i++){
            System.out.print(p3.get(i));
        }

        //zmiana danych przy jeszcze nowo utworzonym polączeniu
        System.out.println("Zmiana danych przy jeszcze nowo utworzonym połaczeniu: ");
        IPolaczenie polTestowe1 = Baza.getPolaczenie();
        for(int i = 5; i<10;i++)
        {
            polTestowe1.set(i,(char)('1'+i-2));
        }


        //wypisanie danych jeszcze nowo utworzonym polączeniu
System.out.println("Wypisanie danych na jeszcze nowo utworzonym połączeniu z innej bazy");
        IPolaczenie polTestowe2 = Baza.getPolaczenie();
        for(int i = 0; i<10;i++)
        {
            System.out.print(polTestowe1.get(i));
        }










    }


}
