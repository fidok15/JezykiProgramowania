package Zadanie11;

import java.util.Arrays;

public class Jedynaste_Main {
    public static void main(String[] args){
        ListaRzek lista = new ListaRzek();

        Rzeka odra = new Rzeka("Odra","Oder","Odra", null, Arrays.asList(new Punkt(32.3 ,88.3), new Punkt (53.3, 57.5)));
        Rzeka wisla = new Rzeka("Wisła", "Weichsel", "Visla", null, Arrays.asList(new Punkt(62.3 ,28.3), new Punkt (83.3, 17.5)));
        Rzeka san = new Rzeka("San", "San", "San", "Wisła", Arrays.asList(new Punkt(92.3 ,48.3), new Punkt (33.3, 27.5)));
        Rzeka warta = new Rzeka("Warta", "Warthe", "Varta", "Odra", Arrays.asList(new Punkt(42.3 ,98.3), new Punkt (63.3, 77.5)));

        lista.dodajRzeke(odra);
        lista.dodajRzeke(wisla);
        lista.dodajRzeke(san);
        lista.dodajRzeke(warta);

        System.out.println("Polska lista\n");
        lista.wyswietl(ListaRzek.Jezyk.PL);
        System.out.println("\n");
        System.out.println("Niemiecka lista\n");
        lista.wyswietl(ListaRzek.Jezyk.DE);
        System.out.println("\n");
        System.out.println("Czeska lista\n");
        lista.wyswietl(ListaRzek.Jezyk.CZ);
        System.out.println("\n");

        System.out.println("Dorzecze wisly");
        lista.dorzecze("Wisła").forEach(r -> System.out.println(r.getPLnazwa()));


    }

}
