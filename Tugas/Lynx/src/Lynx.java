package karnivora;

public class Lynx extends Hewan implements Karnivora {

    public Lynx(String nama, int umur) {
        super(nama, umur);
    }

    @Override
    public void suara() {
        System.out.println(nama + " mengeluarkan suara: Grrrrr!");
    }

    @Override
    public void berburu() {
        System.out.println(nama + " sedang berburu kelinci di hutan.");
    }

    @Override
    public void makanDaging() {
        System.out.println(nama + " memakan hasil buruannya.");
    }

    // Method tambahan opsional
    public void lariCepat() {
        System.out.println(nama + " bisa berlari dengan cepat saat mengejar mangsa.");
    }

    public static void main(String[] args) {
        Lynx lynx1 = new Lynx("Lynxy", 4);
        lynx1.info();
        lynx1.suara();
        lynx1.berburu();
        lynx1.makanDaging();
        lynx1.lariCepat();
    }
}
