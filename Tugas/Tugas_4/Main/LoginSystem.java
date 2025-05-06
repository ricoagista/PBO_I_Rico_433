package Modul_4_.Main;

import Modul_4_.Organiztion.*;
import java.util.Scanner;

public class LoginSystem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = 0;
        while (true) {
            MenuApp();
            choice = input.nextInt();
            input.nextLine();
            LogicProgram(choice);
            if (choice == 3) {
                System.out.println("Terima kasih sudah berkunjung");
                break;
            }
        }

    }

    private static void MenuApp(){
        System.out.println("\nWelcome\n ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("\nInput: ");

    }

    private static void LogicProgram(int choice){
        if(choice == 1) {
            LoginAdmin();
        }else if (choice == 2) {
            LoginMahasiswa();
        }
    }

    private static void LoginMahasiswa(){
        int Percobaan = 3;
        boolean Logged = false;
        while (Percobaan > 0) {

            System.out.print("\nMasukkan Username Mahasiswa : ");
            String Username = input.nextLine();
            System.out.print("Masukkan Password Mahasiswa : ");
            String Password = input.nextLine();
            if (new Modul_4_.Organiztion.Mahasiswa().Login(Username,Password)) {
                System.out.println("\nSelamat Anda Berhasil Login!!!\n");
                logintoMahasiswa();
                Logged = true;
            }
            Percobaan--;
            if (Logged != true) {
                System.out.println("Maaf Password yang Anda masukkan salah");
                System.out.println("Silakan Masukkan Password : " + Percobaan + " X");
            }else{
                break;
            }
        }
    }

    private static void LoginAdmin(){
        int Percobaan = 3;
        boolean Logged = false;
        while (Percobaan > 0) {
            System.out.print("\nMasukkan Username Admin : ");
            String Username = input.nextLine();
            System.out.print("Masukkan Password Admin : ");
            String Password = input.nextLine();
            if (new Modul_4_.Organiztion.Admin().Login(Username, Password)) {
                System.out.println("\nSelamat Anda Berhasil Login!!!\n");
                logintoAdmin();
                Logged = true;
            }
            Percobaan--;
            if (Logged != true) {
                System.out.println("Maaf Password yang Anda masukkan salah");
                System.out.println("Silakan Masukkan Password : " + Percobaan + " X");
            }else{
                break;
            }
        }

    }

    private static void logintoMahasiswa(){
        int Choice;
        Mahasiswa mahasiswa = new Modul_4_.Organiztion.Mahasiswa();
        while (true) {
            mahasiswa.DisplayAppMenu();
            Choice = input.nextInt();
            if (Choice == 3) {
                break;
            }
            switch (Choice) {
                case 1:
                    mahasiswa.ReportItem();
                    break;
                case 2:
                    mahasiswa.ViewReportItem();
                    break;

                default:
                    System.out.println("Pilihan Anda tidak valid");
                    break;
            }

        }
    }
    private static void logintoAdmin(){

        int Choice;
        Admin admin = new Modul_4_.Organiztion.Admin();

        while (true) {
            admin.DisplayAppMenu();
            Choice = input.nextInt();
            if (Choice == 3) {
                break;
            }
            switch (Choice) {
                case 1:
                    admin.ManageItems();
                    break;
                case 2:
                    admin.ManageUsers();
                    break;

                default:
                    System.out.println("Pilihan Anda tidak valid");
                    break;
            }

        }
    }

}