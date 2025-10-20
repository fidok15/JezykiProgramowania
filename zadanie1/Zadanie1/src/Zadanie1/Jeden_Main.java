package Zadanie1;//zadanie 1
import java.util.*;

public class Jeden_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Float> hashSet = new HashSet<>();
        TreeSet<Float> treeSet = new TreeSet<>();

        System.out.println("Podaj liczby do hashseta");
        while(scanner.hasNextFloat()){
            float num = scanner.nextFloat();
            hashSet.add(num);
        }

        System.out.println("Podaj liczby do treeseta");
        while(scanner.hasNextFloat()){
            float num2 = scanner.nextFloat();
            treeSet.add(num2);
        }
        System.out.println("Hashset\nbrak sortowania,kolejnosci");
        System.out.println(hashSet);

        System.out.println("Treeset posortowany");
        System.out.println(treeSet);
    }
}