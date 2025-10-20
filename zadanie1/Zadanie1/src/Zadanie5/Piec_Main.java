package Zadanie5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Piec_Main {
    public static void main(String[] args) {
        List<Osoba> list = new ArrayList<>();
        list.add(new Osoba("Kasia", 22));
        list.add(new Osoba("Marek", 30));
        list.add(new Osoba("Zosia", 18));
        list.add(new Osoba("Adam", 25));
        System.out.println("przed sortowaniem");
        for (Osoba i : list) {

            System.out.println(i);
        }
        Collections.sort(list, Comparator.comparingInt(Osoba::getWiek));

        System.out.println("\npo sortowaniu (wiek):");
        for (Osoba i : list) {
            System.out.println(i);
        }
    }
}
