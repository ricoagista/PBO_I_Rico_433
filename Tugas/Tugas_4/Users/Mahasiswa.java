package Praktikum.Users;

import Praktikum.Actions.MhsAction;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Mahasiswa extends User implements MhsAction{

    public Mahasiswa() {
        super("rico", "rico");
    }
    static Scanner Input = new Scanner(System.in);

    ArrayList<LostItem> lostItems = new ArrayList<>();
    public void ReportItem(){
        try{
            System.out.println("Formulir Pelaporan Barang Hilang");
            System.out.print("Masukan Nama Barang      : ");
            String NamaBarang = Input.nextLine();
            System.out.print("Masukan Deskripsi Barang : ");
            String DeskripsiBarang = Input.nextLine();
            System.out.print("Masukan Lokasi Barang    : ");
            String LokasiBarang = Input.nextLine();
            lostItems.add(new LostItem(NamaBarang,DeskripsiBarang,LokasiBarang));
            System.out.println("Terima Kasih Sudah Melaporkan Barang Hilang");

        }catch(Exception e){
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.WARNING, "Anda memasukan Input yang Salah", e);
        }
    }

    public void ViewReportItem(){
        for (LostItem lostItem : lostItems) {
            System.out.println("Barang Yang Hilang");
            System.out.println("1. ID Barang : " + lostItem.getIdLostitem());
            System.out.println("2. Nama Barang : " + lostItem.getBarangHilang());
            System.out.println("3. Deskripsi Barang : " + lostItem.getDeskripsiHilang());
            System.out.println("4. Lokasi Barang : " + lostItem.getLokasiBarang());
        }
    }

    @Override
    public boolean Login(String UsernameInput,String PasswordInput){
        if(this.getUsername().equals(UsernameInput) && this.getPassword().equals(PasswordInput)){
            return true;
        }
        return false;
    }
    @Override
    public void DisplayAppMenu(){
        System.out.println("Pilihan Menu Mahasiswa");
        System.out.println("1. Laporkan Barang Hilang");
        System.out.println("2. Lihat Barang Hilang");
        System.out.println("3. Exit");
        System.out.print("\nInput: ");
    }
}