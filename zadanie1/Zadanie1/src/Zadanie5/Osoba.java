package Zadanie5;

public class Osoba {
    private String imie;
    private Integer wiek;

    public Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return imie + " (" + wiek + " lat)";
    }
}
