package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    public static void sorter(int[] a, int fra, int til) {
        //metode for selection sort
        if (fra < til) {
            //stoppeverdien er fra < til
            int minste = fra;
            for (int i = fra; i < til; i++) {
                //finner indeksen til den minste for å sette den til fra plassen
                if (a[minste] > a[i]) {
                    minste = i;
                }
            }
            //bytter fra til å bli den minste verdien
            int temp = a[fra];
            a[fra] = a[minste];
            a[minste] = temp;

            //rekursjon, endrer fra til fra +1
            if (fra < til) {
                fra++;
                sorter(a, fra, til);
            }
        }
    }

    public static void quickSort(int[] array, int venstre, int hoyre) {

        //midtverdi
        int midt = (venstre + hoyre) / 2;
        //verdien til midten av arrayet
        int pivot = array[midt];

        int v = venstre;
        int h = hoyre;

        while (v <= h) {

            while (array[v] < pivot) {
                // finner indeksen som er høyere enn midtverdi
                v++;
            }

            while (array[h] > pivot) {
                // finner indeksen som er lavere enn midtverdi
                h--;
            }

            if (v <= h) {
                // bytter om verdiene
                int midlertidig = array[v];
                array[v] = array[h];
                array[h] = midlertidig;
                v++;
                h--;
            }
        }

        //rekursjon
        if (venstre < h) {
            quickSort(array, venstre, h);
        }
        if (hoyre > v) {
            quickSort(array, v, hoyre);
        }

    }

    //Denne tar inn char istedenfor String, samme konsept som over
    public static void quickSort(char[] array, int venstre, int hoyre) {

        int midt = (venstre + hoyre) / 2;
        int pivot = array[midt];

        int lav = venstre;
        int hoy = hoyre;

        while (lav <= hoy) {

            while (array[lav] < pivot) {

                lav++;
            }

            while (array[hoy] > pivot) {

                hoy--;
            }

            if (lav <= hoy) {

                char midlertidig = array[lav];
                array[lav] = array[hoy];
                array[hoy] = midlertidig;
                lav++;
                hoy--;
            }
        }

        if (venstre < hoy) {
            quickSort(array, venstre, hoy);
        }
        if (hoyre > lav) {
            quickSort(array, lav, hoyre);
        }

    }


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
            //bobler opp den største verdien
            if(a[i-1]>a[i]){
                int temp = a[i];
                a[i]=a[i-1];
                a[i-1] = temp;
            }

        }
        //etter at vi har bobla vil den største verdien ligge i det siste elementet i arrayen
        return a[a.length-1];

    }

    public static int ombyttinger(int[] a) {
        //throw new NotImplementedException();
        //dersom vi ikke får inn noe kastes en exception
        if(a.length <= 0){
            throw new NoSuchElementException("Arrayet kan ikke inneholde 0 tall");
        }

        //denne teller antall ombyttinger
        int antall_byttinger = 0;
        //looper igjennom for å telle inversjoner
        for(int i = 1; i < a.length; i++){
            //bruker samme konsept som i oppgaven over.
            //vi øker antall ombyttinger hver gang vi kommer inn i if setningen
            if(a[i-1]>a[i]){
                antall_byttinger++;
                int temp = a[i];
                a[i]=a[i-1];
                a[i-1] = temp;
            }

        }
        //returnerer antall iversjoner. vi ser på bytting av et par = 1 ombytting
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
            //vi trenger kun å sjekke med tallet foran for å se om alt er sortert
            int temp = a[i-1];
            int temp1 = a[i];
            //dersom det ikke er sortert kastes en exception
            if(temp>temp1){
                throw new IllegalStateException("Input arrayet er ikke sortert");
            }
            //dersom a[i] og a[i-1] er forskjellig vet vi at vi har fått inn et nytt unikt tall.
            //derfor øker vi antall
            else if(temp!=temp1){
                antall++;
            }

        }
        return antall;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //throw new NotImplementedException();
        //hjelpevariablen for å telle antall ulike
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
        if(a.length==0){
            return;
        }
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
            quickSort(a,0,a.length-1);
            return;
        }

        int left = 0;
        int right = a.length-1;
        //får oddetall på venstre side og partall på høyre side.
        // vi kan så sortere dem hver for seg
        while(left < right) {
            //dersom %2=0 vet vi at det er partall
            while (a[right] % 2 == 0) {
                right--;

            }
            //dersom %2!=0 så er det et oddetall
            while (a[left] % 2 != 0) {
                left++;

            }
            //bytter om verdiene for å få oddetall til venstre og partall til høyre
            if(left <= right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }

        }
        //bruker kvikksortering for å sortere partall og oddetall seperat.
        //kvikksort koden ligger øverst i dette dokumentet
        quickSort(a,0,right);
        quickSort(a,left,a.length-1);

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        //throw new NotImplementedException();

        //hvis vi ikke får inn noe så skal løkken avsluttes
        if(a.length == 0){
            return;
        }else {
            //vi tar vare på det siste tallet ettersom at dette blir glemt i
            //i = a.length -1. denne verdien skal være i a[0] uansett situasjon
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
        int antall_ganger = k%a.length;
        if(k<0){
            antall_ganger = k+a.length;
        }


        //bruker d samme som i oppgave 5 bare at vi gjør dette flere ganger
        // kommer ikke på noen bedre algoritme aakkurat nå. denne gir 16 sek(altfor lang tid og må endres)
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
        //throw new NotImplementedException();

        //splitter strengene vi får med "";
        //ABC blir til A,B,C
        String[] String_s = s.split("");
        String[] String_t = t.split("");

        //sluttordet sin lengde må være begge strengene sin lengde til sammen
        String[] flettet = new String[String_s.length + String_t.length];

        // hjelpevaribler
        // k brukes til å fylle flettet
        // j og i skal gå igjennom s og t
        int i =0; int j = 0; int k = 0;

        //denne gjøres til en av charene går tom for bokstaver
        // tar først en bokstav fra s så en fra t....
        while( i < String_s.length && j < String_t.length){
            flettet[k++] = String_s[i++];
            flettet[k++] = String_t[j++];
        }
        //kun en av disse while løkkene vil kjøre
        // den skal kunne legge til resten av bokstavene som er igjen fra enten s eller t
        while(i < String_s.length){
            flettet[k++] = String_s[i++];
        }
        while(j < String_t.length){
            flettet[k++] = String_t[j++];
        }

        // skriver ut flettet
        String ut ="";
        for(int l =0; l<flettet.length; l++){
            ut+=flettet[l];
        }

        return ut;
        }



    /// 7b)
    public static String flett(String... s) {
        //throw new NotImplementedException();
        if(s.length==0){
            return "";
        }
        // for å finne lengden til sluttordet må vi legge sammen alle
        //lengdene til s
        int lengde = 0;
        for (int i = 0; i < s.length; i++) {
            lengde = lengde + s[i].length();
        }
        char svar[] = new char[lengde];
        //k bestemmer hvor i svar bokstaven legges
        int k = 0;
        //i er posisjonen den skal hente bokstaven fra
        for(int i = 0; i<svar.length; i++){
            //j velger hvilket ord bokstaven skal hentes fra
            // feks s[1] vil være det andre ordet som vi fikk inn som parameter
            for (int j = 0; j < s.length; j++) {
                //dersom s[j],length() > i slår inn vet vi at ordet har en bokstav i charAt(i)
                //og kan hente den. hvis den ikke slår inn vil det si at ordet har gått tom for bokstaver
                if(s[j].length()>i){
                    svar[k]=s[j].charAt(i);
                    k++;
                }

            }

        }

        String ut = "";
        for(int i = 0; i < svar.length; i++){
            ut+=svar[i];
        }

        return ut;
        }


    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
       // throw new NotImplementedException();
        if (a.length == 0) {
            return a;
        }
        ArrayList<Integer> liste = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            liste.add(a[i]);
        }

        int b[] = a.clone();
        sorter(b,0,b.length);

        int[] kopi = new int[a.length];
        kopi[0] = liste.indexOf(b[0]);
        int storsteTall = b[a.length - 1] + 1;

        for (int i = 1; i < kopi.length; i++) {

            if (b[i] == b[i - 1]) {
                liste.set(liste.indexOf(b[i]), storsteTall);
                kopi[i] = liste.indexOf(b[i]);

            } else {
                kopi[i] = liste.indexOf(b[i]);
            }
        }
        return kopi;
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        //throw new NotImplementedException();

        int n = a.length;
        if (n < 3) {
            throw new NoSuchElementException("Må ha minst tre tall");
        }

        int[] sorter = {a[0],a[1],a[2]};
        int[] sortert = indekssortering(sorter);

        int m = sortert[0];
        int nm = sortert[1];
        int tm = sortert[2];

        int minstverdi = a[m];
        int nestminstsverdi = a[nm];
        int tredjminstverdi = a[tm];

        for (int i = 3; i < n; i++) {
            if (a[i] < tredjminstverdi) {
                if (a[i] < minstverdi) {
                    tm = nm;
                    tredjminstverdi = nestminstsverdi;

                    nm = m;
                    nestminstsverdi = minstverdi;

                    m = i;
                    minstverdi = a[m];

                } else if (a[i] < nestminstsverdi) {
                    tm = nm;
                    tredjminstverdi = nestminstsverdi;

                    nm = i;
                    nestminstsverdi = a[nm];
                } else {
                    tm = i;
                    tredjminstverdi = a[tm];
                }
            }

        }
        return new int[]{m, nm, tm};

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

        quickSort(char1,0,a.length()-1);
        quickSort(char2,0,b.length()-1);


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
        return false;//h
    }

}  // Oblig1
