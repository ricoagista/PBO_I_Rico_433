package com.example.praktikum.Model;

import java.util.ArrayList;

public class Item {
    private int idLostitem;
    private int Indeks;
    private String BarangHilang;
    private String DeskripsiHilang;
    private String LokasiBarang;
    private String Status;

    public static ArrayList<Item> Itemlist = new ArrayList<>();

    public Item(String barangHilang, String deskripsiHilang, String lokasiBarang) {
        idLostitem = (int)(Math.random()*101);
        Indeks = Itemlist.size() + 1;
        BarangHilang = barangHilang;
        DeskripsiHilang = deskripsiHilang;
        LokasiBarang = lokasiBarang;
        Status = "Reported";
    }

    public void AddItem(Item item){
        Itemlist.add(item);
    }
    
    public int getIndeks() {
        return Indeks;
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
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    
    @Override
    public String toString(){
        return 
        "===============Data Barang================\n"
        + "Id Barang    : " + this.idLostitem + "\n"
        + "Indeks Barang: " + this.Indeks + "\n"
        + "Nama Barang  : " + this.BarangHilang + "\n"
        + "Deskripsi    : " + this.DeskripsiHilang + "\n"
        + "Lokasi       : " + this.LokasiBarang + "\n"
        + "Status Barang: " + this.Status + "\n"
        +"=========================================="
        + "\n";
    }

    

}
