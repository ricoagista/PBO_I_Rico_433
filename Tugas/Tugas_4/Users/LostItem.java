package Praktikum.Users;

public class LostItem {
    private int idLostitem;
    private String BarangHilang;
    private String DeskripsiHilang;
    private String LokasiBarang;
    public LostItem(String barangHilang, String deskripsiHilang, String lokasiBarang) {
        idLostitem = (int)(Math.random()*101);
        BarangHilang = barangHilang;
        DeskripsiHilang = deskripsiHilang;
        LokasiBarang = lokasiBarang;
    }
    public int getIdLostitem() {
        return idLostitem;
    }
    public String getBarangHilang() {
        return BarangHilang;
    }
    public String getDeskripsiHilang() {
        return DeskripsiHilang;
    }
    public String getLokasiBarang() {
        return LokasiBarang;
    }

    

}
