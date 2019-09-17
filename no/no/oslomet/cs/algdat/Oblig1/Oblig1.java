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
                //finner indeksen til den minste for a sette den til fra plassen
                if (a[minste] > a[i]) {
                    minste = i;
                }
            }
            //bytter fra til a bli den minste verdien
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
                // finner indeksen som er hoyere enn midtverdi
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
    //samme byttmetode som i hjelpemetoder i oblig1test
    //denne tar inn char istedenfor int
    private static void bytt(char[] a, int v, int h) {
        while (v < h) {
            char temp = a[v];
            a[v] = a[h];
            a[h] = temp;
            h--;
            v++;
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
        //looper igjennom for a endre plass
        for(int i = 1; i < a.length; i++){
            //bobler opp den storste verdien
            if(a[i-1]>a[i]){
                int temp = a[i];
                a[i]=a[i-1];
                a[i-1] = temp;
            }

        }
        //etter at vi har bobla vil den storste verdien ligge i det siste elementet i arrayen
        return a[a.length-1];

    }

    public static int ombyttinger(int[] a) {
        //throw new NotImplementedException();
        //dersom vi ikke far inn noe kastes en exception
        if(a.length <= 0){
            throw new NoSuchElementException("Arrayet kan ikke inneholde 0 tall");
        }

        //denne teller antall ombyttinger
        int antall_byttinger = 0;
        //looper igjennom for a telle inversjoner
        for(int i = 1; i < a.length; i++){
            //bruker samme konsept som i oppgaven over.
            //vi oker antall ombyttinger hver gang vi kommer inn i if setningen
            if(a[i-1]>a[i]){
                antall_byttinger++;
                int temp = a[i];
                a[i]=a[i-1];
                a[i-1] = temp;
            }

        }
        //returnerer antall iversjoner. vi ser pa bytting av et par = 1 ombytting
        return antall_byttinger;

    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
       // throw new NotImplementedException();
        if(a.length==0){
            return 0;
        }
        //Starter pa 1 siden d forste tallet alltid vil vaere unikt
        int antall = 1;
        //gar igjennom arrayet som vi har
        for(int i = 1; i< a.length; i++){
            //vi trenger kun a sjekke med tallet foran for a se om alt er sortert
            int temp = a[i-1];
            int temp1 = a[i];
            //dersom det ikke er sortert kastes en exception
            if(temp>temp1){
                throw new IllegalStateException("Input arrayet er ikke sortert");
            }
            //dersom a[i] og a[i-1] er forskjellig vet vi at vi har fatt inn et nytt unikt tall.
            //derfor oker vi antall
            else if(temp!=temp1){
                antall++;
            }

        }
        return antall;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //throw new NotImplementedException();
        //hjelpevariablen for a telle antall ulike
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
        //lokke for a sjekke om d kun r enten partall eller oddetall
        for(int i = 0; i<a.length; i++){
            if(a[i]%2==0){
                partall++;
            }else
                oddetall++;
        }
        //hvis det kun er en av delene sa sorterer vi hele llsta
        if(oddetall == 0 || partall == 0){
            quickSort(a,0,a.length-1);
            return;
        }

        int left = 0;
        int right = a.length-1;
        //far oddetall pa venstre side og partall pa hoyre side.
        // vi kan sa sortere dem hver for seg
        while(left < right) {
            //dersom %2=0 vet vi at det er partall
            while (a[right] % 2 == 0) {
                right--;

            }
            //dersom %2!=0 sa er det et oddetall
            while (a[left] % 2 != 0) {
                left++;

            }
            //bytter om verdiene for a fa oddetall til venstre og partall til hoyre
            if(left <= right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }

        }
        //bruker kvikksortering for a sortere partall og oddetall seperat.
        //kvikksort koden ligger overst i dette dokumentet
        quickSort(a,0,right);
        quickSort(a,left,a.length-1);

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        //throw new NotImplementedException();

        //hvis vi ikke far inn noe sa skal lokken avsluttes
        if(a.length == 0){
            return;
        }else {
            //vi tar vare pa det siste tallet ettersom at dette blir glemt i
            //i = a.length -1. denne verdien skal vaere i a[0] uansett situasjon
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
        //kan ikke operere med en tom mengde
        if(a.length == 0){
            return;
        }
        k = k%a.length;
        if(k<0){
            k = k+ a.length;
        }
        char[] kopi = new char[k];
        int j = a.length-k;
        for (int i = 0; i < k; i++) {
            kopi[i] = a[j];
            j++;
        }
        char temp;
        for (int i = a.length - 1; i > 0; i--) {
            if (i - k >= 0) {
                temp = a[i];
                a[i] = a[i - k];
                a[i - k] = temp;
            }
        }

        for(int i = 0; i < k; i++){
            a[i] = kopi[i];
        }
    }

    ///// Oppgave 7 ///////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        //throw new NotImplementedException();

        //splitter strengene vi faar med "";
        //ABC blir til A,B,C
        String[] String_s = s.split("");
        String[] String_t = t.split("");

        //sluttordet sin lengde ma vaere begge strengene sin lengde til sammen
        String[] flettet = new String[String_s.length + String_t.length];

        // hjelpevaribler
        // k brukes til a fylle flettet
        // j og i skal ga igjennom s og t
        int i =0; int j = 0; int k = 0;

        //denne gjores til en av charene gar tom for bokstaver
        // tar forst en bokstav fra s sa en fra t....
        while( i < String_s.length && j < String_t.length){
            flettet[k++] = String_s[i++];
            flettet[k++] = String_t[j++];
        }
        //kun en av disse while lokkene vil kjore
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
        // for a finne lengden til sluttordet ma vi legge sammen alle
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
            // feks s[1] vil vaere det andre ordet som vi fikk inn som parameter
            for (int j = 0; j < s.length; j++) {
                //dersom s[j],length() > i slar inn vet vi at ordet har en bokstav i charAt(i)
                //og kan hente den. hvis den ikke slar inn vil det si at ordet har gatt tom for bokstaver
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
        //dersom lengden er 0
        if (a.length == 0) {
            return a;
        }
        //endre array til arraylist ettersom at dette er enklere a jobbe med
        ArrayList<Integer> liste = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            liste.add(a[i]);
        }

        //vi skal finne indeksene i b. kan ikke bruke a siden den ikke skal endres (Oppgavetekst)
        int b[] = a.clone();
        //selection sort
        sorter(b,0,b.length);

        //lager en ny array som skal vaere indekstabellen
        int[] kopi = new int[a.length];
        kopi[0] = liste.indexOf(b[0]);
        //dersom vi har duplikate tall vi vi endre verdiene til tallet som er brukt
        int storsteTall = b[a.length - 1] + 1;

        for (int i = 1; i < kopi.length; i++) {
            //dersom vi finner d samme tallet endrer vi tallet som er brukt
            //slik at vi kan fa tallet som ikke er brukt. feks om vi har 5,1,0,5 vil vi fa
            // indeks 0 i forste omgang og indeks 4 i andre
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
        //sjekker at vi har tre tall minst
        int n = a.length;
        if (n < 3) {
            throw new NoSuchElementException("Ma ha minst tre tall");
        }
        //sorterer kun de tre forste tallene ved hjelp av oppgaven over
        int[] sorter = {a[0],a[1],a[2]};
        int[] sortert = indekssortering(sorter);

        //deklarer verdien til den minste, anest minste og tredj minste
        int m = sortert[0];
        int nm = sortert[1];
        int tm = sortert[2];

        int minstverdi = a[m];
        int nestminstsverdi = a[nm];
        int tredjminstverdi = a[tm];

        for (int i = 3; i < n; i++) {
            //dersom tallet er mindre enn tredj minste tallet vil denne vaere en av tre minste tallene
            if (a[i] < tredjminstverdi) {
                //dersom a[i] er minsre enn minsteverdi vil dette bli det minste tallet
                if (a[i] < minstverdi) {
                    tm = nm;
                    tredjminstverdi = nestminstsverdi;

                    nm = m;
                    nestminstsverdi = minstverdi;

                    m = i;
                    minstverdi = a[m];

                    //dersom den er storre enn minste verdi vil den bli nest minste verdi
                    //og nest minste verdi bli til den tredj minste.
                } else if (a[i] < nestminstsverdi) {
                    tm = nm;
                    tredjminstverdi = nestminstsverdi;

                    nm = i;
                    nestminstsverdi = a[nm];
                    //hvis ingen av de over treffer inn bytter vil det si at den er den tredjminste verdien
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
        // dersom a far inn en tom streng sa vil a vaere i b.
        if(a.equals("")){
            return true;
        }
        // en mengde som ikke er tom(a) vil ikke vaere i en tom mengde(b).
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
            //dersom char[j]==char[i] vil den ene bokstaven vaere lik
            // vi fjerner denne bokstaven fra b slik at den ikke blit talt opp igjen/ flere ganger
            // i tillegg til dette gar vi til neste bokstav i streng a med hjelpervariabelen j++
            if(char1[j]==char2[i]){
                j++;
                //dersom j == a.length() vil d si at alle bokstavene er funnnet i b
                //som medforer at a er inneholdt i b
                if(a.length() == j){
                    return true;
                }
            }

        }

        //standardverdien er false; hvis den er true kommer den ikke hit;
        return false;
    }

}  // Oblig1
