package Zadanie3;//zadanie 3
import java.util.*;


public class Trzy_Main {
    public static void main(String[] args) {
        Map<Integer, String > hashmap = new HashMap<>();
        Map<Integer, String> treemap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hashmap");

        while (true){
            System.out.println("klucz: ");
            String inputKey = scanner.next();
            if (inputKey.equalsIgnoreCase("q")) break;
            try {
                int key = Integer.parseInt(inputKey);
                System.out.println("wartosc");
                String val = scanner.next();
                hashmap.put(key,val);
            }catch (NumberFormatException e){
                System.out.println("zla wartosc\n" + e);
            }
        }

        System.out.println("treemap");
        while (true){
            System.out.println("klucz: ");
            String inputKey = scanner.next();
            if (inputKey.equalsIgnoreCase("q")) break;
            try {
                int key = Integer.parseInt(inputKey);
                System.out.println("wartosc");
                String val = scanner.next();
                treemap.put(key,val);
            }catch (NumberFormatException e){
                System.out.println("zla wartosc\n" + e);
            }
        }

        System.out.println("Hashmap\n nie zachowuje kolejnosc");
        System.out.println(hashmap);
        System.out.println("Treemap\nsortuje wedlug kluczy");
        System.out.println(treemap);
    }
};