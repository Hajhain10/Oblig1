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
       // throw new NotImplementedException();
        if(a.length==0){
            return 0;
        }
        //Starter på 1 siden d første tallet alltid vil være unikt
        int antall = 1;
        //går igjennom arrayet som vi har
        for(int i = 1; i< a.length; i++){

            int temp = a[i-1];
            int temp1 = a[i];
            if(temp>temp1){
                throw new IllegalStateException("Input arrayet er ikke sortert");
            }
            else if(temp!=temp1){
                System.out.println(temp + " " + temp1);
                antall++;
            }

        }
        return antall;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //throw new NotImplementedException();
        int unike = 0;

        for(int i= 0; i < a.length; i++){
            int pluss = 0;
            for(int j = 0; j < a.length; j++) {
                pluss = j;
                if (a[i] == a[j]) {
                    break;
                }
            }
            if(i == pluss){
                unike++;
            }
        }
        return unike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        //throw new NotImplementedException();
        char siste = a[a.length-1];
        for(int i = a.length-1; i>0; i--){
            a[i]=a[i-1];

        }
        a[0] = siste;


    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        //throw new NotImplementedException();
        int antall_ganger = k;
        if(k<0){
            antall_ganger = k+a.length;
        }

        for (int antall = 0; antall < antall_ganger; antall++) {

            char temp = a[a.length-1];
            for (int i = a.length-1; i > 0; i--) {

                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
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
