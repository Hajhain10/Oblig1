package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
       // throw new NotImplementedException();
        if(a.length <= 0){
            throw new NoSuchElementException("Arrayet kan ikke inneholde 0 tall");
        }

        //looper igjennom for å endre plass
        for(int i = 1; i < a.length; i++){

            if(a[i-1]>a[i]){
                int temp = a[i];
                a[i]=a[i-1];
                a[i-1] = temp;
            }

        }
        return a[a.length-1];

    }

    public static int ombyttinger(int[] a) {
        //throw new NotImplementedException();
        if(a.length <= 0){
            throw new NoSuchElementException("Arrayet kan ikke inneholde 0 tall");
        }

        int antall_byttinger = 0;
        //looper igjennom for å telle inversjoner
        for(int i = 1; i < a.length; i++){

            if(a[i-1]>a[i]){
                antall_byttinger++;
                int temp = a[i];
                a[i]=a[i-1];
                a[i-1] = temp;
            }

        }
        //husk å fjerne denne
        System.out.println(Arrays.toString(a));
        //returnerer antall iversjoner. v ser på bytting av et par = 1 ombytting
        return antall_byttinger;

    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1