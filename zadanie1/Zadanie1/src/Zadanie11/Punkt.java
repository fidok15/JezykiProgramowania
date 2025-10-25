package Zadanie11;

class Punkt {

    private double lat;
    private double lon;

    public Punkt(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() { return lat;}
    public double getLon() { return lon;}

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", lat,lon);
    }
}
