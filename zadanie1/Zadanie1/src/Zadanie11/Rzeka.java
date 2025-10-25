package Zadanie11;

import java.util.List;

class Rzeka {
    private String PLnazwa;
    private String DEnazwa;
    private String CZnazwa;
    private String wplywa;
    private List<Punkt> punktyrzeki;

    public Rzeka(String PLnazwa,String DEnazwa, String CZnazwa, String wplywa, List<Punkt> punktyrzeki){
        this.PLnazwa = PLnazwa;
        this.DEnazwa = DEnazwa;
        this.CZnazwa = CZnazwa;
        this.wplywa = wplywa;
        this.punktyrzeki = punktyrzeki;
    }

    public String getPLnazwa(){ return PLnazwa;}
    public String getDEnazwa(){ return DEnazwa;}
    public String getCZnazwa(){ return CZnazwa;}
    public String getWplywa(){ return wplywa;}
    public List<Punkt> getPunktyrzeki() {return punktyrzeki;}

    @Override
    public String toString() {
        return String.format("Rzeka PL %s ,DE %s ,CZ %s \nwpływa do: %s",PLnazwa, DEnazwa, CZnazwa, (wplywa == null ? "brak" : wplywa));
    }
}
