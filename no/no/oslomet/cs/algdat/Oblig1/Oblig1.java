package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
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

        //throw new NotImplementedException();
        int partall = 0;
        int oddetall = 0;
        //løkke for å sjekke om d kun r enten partall eller oddetall
        for(int i = 0; i<a.length; i++){
            if(a[i]%2==0){
                partall++;
            }else
                oddetall++;
        }
        //hvis det kun er en av delene så sorterer vi hele llsta
        if(oddetall == 0 || partall == 0){
           //todo fikse algoritme for å sortere
            return;
        }

        int left = 0;
        int right = a.length-1;
        //får oddetall på venstre side og partall på høyre side.
        // vi kan så sortere dem hver for seg
        while(left < right) {
            while (a[right] % 2 == 0) {
                right--;

            }
            while (a[left] % 2 != 0) {
                left++;

            }
            if(left <= right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
            //System.out.print(left + " " + right+"    ");

        }
        //vet ikke helt om vi bør bruke quicksort eller bare bruke selection sort
        // (quicksort) koden står i kompediet
        //todo fikse algoritme for å sortere

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        //throw new NotImplementedException();

        //hvis vi ikke får inn noe så skal løkken avsluttes
        if(a.length == 0){
            return;
        }else {
            //vi tar vare på det siste tallet ettersom at dette blir glemt i
            //i = a.lemngth -1. denne verdien skal være i a[0] uansett situasjon
            // derfor setter vi det til slutt.
            char siste = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];

            }
            a[0] = siste;

        }

    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        //throw new NotImplementedException();
        int antall_ganger = k;
        if(k<0){
            antall_ganger = k+a.length;
        }

        //bruker d samme som i oppgave 5 bare at vi gjør dette flere ganger
        // kommer ikke på noen bedre algoritme aakkurat nå. denne gir 16 sek(altfor lang tid og må endres)
        // todo ^ denne må kun være midlertilig
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
       // throw new NotImplementedException();

        // dersom a får inn en tom streng så vil a være i b.
        if(a.equals("")){
            return true;
        }
        // en mengde som ikke er tom(a) vil ikke være i en tom mengde(b).
        if(!a.equals("") && b.equals("")){
            return false;
        }
        // j = en hjelpevariabel
        int j = 0;
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);


        for (int i = 0; i < char2.length; i++){
            //dersom char[j]==char[i] vil den ene bokstaven være lik
            // vi fjerner denne bokstaven fra b slik at den ikke blit talt opp igjen/ flere ganger
            // i tillegg til dette går vi til neste bokstav i streng a med hjelpervariabelen j++
            if(char1[j]==char2[i]){
                j++;
                //dersom j == a.length() vil d si at alle bokstavene er funnnet i b
                //som medfører at a er inneholdt i b
                if(a.length() == j){
                    return true;
                }
            }

        }

        //standardverdien er false; hvis den er true kommer den ikke hit;
        return false;
    }

}  // Oblig1
