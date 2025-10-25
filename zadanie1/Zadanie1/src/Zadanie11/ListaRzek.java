package Zadanie11;

import java.util.*;


public class ListaRzek {
    //treesety rzek w danych jezykach
    private Set<Rzeka> rzekiPL;
    private Set<Rzeka> rzekiDE;
    private Set<Rzeka> rzekiCZ;

    //konstryktor ktory za pomoca komparatora okresla sportowanie rzek
    public ListaRzek(){
        Comparator<Rzeka> cmpPL = Comparator.comparing(Rzeka::getPLnazwa);
        Comparator<Rzeka> cmpDE = Comparator.comparing(Rzeka::getDEnazwa);
        Comparator<Rzeka> cmpCZ = Comparator.comparing(Rzeka::getCZnazwa);
        rzekiPL = new TreeSet<>(cmpPL);
        rzekiDE = new TreeSet<>(cmpDE);
        rzekiCZ = new TreeSet<>(cmpCZ);
    }
    //dodanie nowej rzeki do treeseta
    public void dodajRzeke(Rzeka r){
        rzekiPL.add(r);
        rzekiDE.add(r);
        rzekiCZ.add(r);
    }
    public enum Jezyk{
        PL,
        DE,
        CZ
    }
    public void wyswietl(Jezyk jezyk){
        //wybor jezyka
        Set<Rzeka> zbior;
        switch (jezyk){
            case PL -> zbior = rzekiPL;
            case DE -> zbior = rzekiDE;
            case CZ -> zbior = rzekiCZ;
            default -> zbior = rzekiPL;
        }
        //pobranie kazdej nazwy rzeki z zadanego jezyka
        for (Rzeka r : zbior) {
            String nazwa = switch (jezyk) {
                case PL -> r.getPLnazwa();
                case DE -> r.getDEnazwa();
                case CZ -> r.getCZnazwa();
            };
            System.out.println("Rzeka: " + nazwa + "\nprzebieg: " + r.getPunktyrzeki()+ "\nwpływa do: " + (r.getWplywa() == null ? "brak" : r.getWplywa()));
        }
    }

    public List<Rzeka> dorzecze(String nazwa) {
        List<Rzeka> wynik = new ArrayList<>();
        Set<String> szukane = new HashSet<>(Arrays.asList(nazwa));

        for (int i = 0; i < wynik.size() + 1; i++) {
            for (Rzeka r : rzekiPL) {
                if (r.getWplywa() != null && szukane.contains(r.getWplywa())
                        && !szukane.contains(r.getPLnazwa())) {
                    wynik.add(r);
                    szukane.add(r.getPLnazwa());
                }
            }
        }

        return wynik;
    }
}
