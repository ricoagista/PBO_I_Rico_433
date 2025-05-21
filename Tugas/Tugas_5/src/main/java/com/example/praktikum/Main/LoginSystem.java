package com.example.praktikum.Main;

import com.example.praktikum.Model.Item;
import com.example.praktikum.Organization.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Admin admin = new Admin("admin", "admin");
        admin.addUser(admin);
        Mahasiswa mahasiswa = new Mahasiswa("rico", "rico");
        mahasiswa.addUser(mahasiswa);
        int choice = 0;
        while (true) {
            try {
            MenuApp();
            choice = input.nextInt();
            input.nextLine();
            if (choice == 3) {
                System.out.println("\nTerima kasih!");
                break;
            }     
            LogicProgram(choice,admin,mahasiswa);
        } catch (InputMismatchException e) {
                System.out.println("\nHanya angka!\n");
                input.nextLine();
            }
           
        }
        
    }

    private static void LogicProgram(int choice,Admin admin,Mahasiswa mahasiswa) throws InputMismatchException {
        switch (choice) {
            case 1 -> admin.Login();
            case 2-> mahasiswa.Login();
            default -> System.out.println("Pilihan tidak valid!");
        }
        
    }

    private static void MenuApp(){
        System.out.println("\nMenu login:\n ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Logout");
        System.out.print("===> ");
    }
    
}
