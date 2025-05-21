package com.example.praktikum.Organization;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.example.praktikum.Actions.MhsAction;
import com.example.praktikum.Model.ExceptionCustom;
import com.example.praktikum.Model.Item;

public class Mahasiswa extends User implements MhsAction{
    
    public Mahasiswa(String Username,String Password) {
        super(Username, Password);
    }
    static Scanner Input = new Scanner(System.in);
    
    @Override
    public void ReportItem(){
        System.out.println("=========Formulir Barang Hilang========================");
        System.out.print("Masukan Nama Barang      : ");
        String NamaBarang = Input.nextLine();
        System.out.print("Masukan Deskripsi Barang : ");
        String DeskripsiBarang = Input.nextLine();
        System.out.print("Masukan Lokasi Barang    : ");
        String LokasiBarang = Input.nextLine();
        Item.Itemlist.add(new Item(NamaBarang, DeskripsiBarang, LokasiBarang));
        System.out.println("Terima Kasih Sudah Melaporkan barang yang ada temukan");
    }

    @Override
    public void ViewReportItem(){
        try {
            Item.Itemlist.stream()
            .filter(e-> "Reported".equals(e.getStatus()))
            .collect(Collectors.toList());

            if (Item.Itemlist.isEmpty()) {
                throw new ExceptionCustom("Tidak Ada reported Item");
            }
            Item.Itemlist.forEach(System.out::println);

        } catch (ExceptionCustom e) {
            System.out.println("Masalah yang terjadi : " + e.getMessage());
        }
        
    }

    @Override
    public void Login() {
        int Condition = 3;
        while (Condition > 0) {
            String UsernameInput, PasswordInput;
            System.out.print("Masukan Username Mahasiswa :");
            UsernameInput = Input.nextLine();
            System.out.print("Masukan NIM Mahassiwa      : ");
            PasswordInput = Input.nextLine();
            boolean valid = inputCheck(UsernameInput, PasswordInput);
            if (valid) {
                loggedMahasiswa();
                break;
            }
            Condition--;
            System.out.println("\nPercobaan Anda Tersisa : " + Condition + "\n");
        }
    }

    boolean inputCheck(String UsernameInput, String PasswordInput) {
        boolean val = false;
        for (User user : Userlist) {
            if (user instanceof Mahasiswa) {
                if (user.getUsername().equals(UsernameInput) && user.getPassword().equals(PasswordInput)) {
                    val = true;
                    System.out.println("Selamat Datang " + this.getUsername() + "!!!");
                } else {
                    val = false;
                    System.out.println("Password Salah.");
                }
            }
        }
        return val;
    }

    @Override
    public void DisplayAppMenu(){
        System.out.println("==========Menu=========");
        System.out.println("1. Laporkan barang");
        System.out.println("2. LIhat laporan barang");
        System.out.println("3. Exit");
        System.out.print("===> ");
    }

    private void loggedMahasiswa(){
        int Choice;
        while (true) {
        try {
        DisplayAppMenu();
        Choice = Input.nextInt();
        Input.nextLine();
        HandleLoogedMhs(Choice);
        if (Choice == 3) {
            break;
        }
        } catch (InputMismatchException e) {
            System.out.println("\nChoice Only a Number!!!\n");
            Input.nextLine();
        }    
            
        }
    }

    private void HandleLoogedMhs(int Choice) throws InputMismatchException{
        switch (Choice) {
            case 1 -> ReportItem();
            case 2 -> ViewReportItem();
            default -> System.out.println("\nChoice is Not Valid!!\n");
        }
    }

    

    
}