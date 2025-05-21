package com.example.praktikum.Organization;

import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

import com.example.praktikum.Actions.AdminAction;
import com.example.praktikum.Model.ExceptionCustom;
import com.example.praktikum.Model.Item;

public class Admin extends User implements AdminAction {
    static Scanner Input = new Scanner(System.in);

    public Admin(String Username, String Password) {
        super(Username, Password);
    }

    @Override
    public void DisplayAppMenu() {
        System.out.println("==========Admin=========");
        System.out.println("1. Atur barang");
        System.out.println("2. Atur user");
        System.out.println("3. Exit");
        System.out.println("=======================");
        System.out.print("Pilih ===> ");
    }

    @Override
    public void Login() {
        int Condition = 3;
        while (Condition > 0) {
            String UsernameInput, PasswordInput;
            System.out.print("Masukan Username Admin :");
            UsernameInput = Input.nextLine();
            System.out.print("Masukan Password Admin : ");
            PasswordInput = Input.nextLine();
            boolean valid = inputCheck(UsernameInput, PasswordInput);
            if (valid) {
                loggedAdmin();
                break;
            }
            Condition--;
            System.out.println("\nPercobaan Anda Tersisa : " + Condition + "\n");
        }
    }

    boolean inputCheck(String UsernameInput, String PasswordInput) {
        boolean val = false;
        for (User user : Userlist) {
            if (user instanceof Admin) {
                if (user.getUsername().equals(UsernameInput) && user.getPassword().equals(PasswordInput)) {
                    val = true;
                    System.out.println("Selamat Datang Admin!!!.");
                } else {
                    val = false;
                    System.out.println("Password Salah.");
                }
            }
        }
        return val;
    }

    public void loggedAdmin() {
        int Choice;
        while (true) {
            DisplayAppMenu();
            try {
                Choice = Input.nextInt();
                Input.nextLine();
                HandleLoogedAdmin(Choice);
                if (Choice == 3)
                    return;
            } catch (InputMismatchException e) {
                System.out.println("Hanya angka!");
                Input.nextLine();
            }
        }
    }

    private void HandleLoogedAdmin(int Choice) {
        switch (Choice) {
            case 1 -> ManageItems();
            case 2 -> ManageUsers();
            default -> System.out.println("Pilihan tidak valid!");
        }
    }

    private void MenuManageItems() {
        System.out.println("==========Admin=========");
        System.out.println("1. Tampilkan barang");
        System.out.println("2. Atur status barang");
        System.out.println("3. Kembali");
        System.out.print("===> ");
    }

    public void ManageItems() {
        int Choice;
        while (true) {
            try {
                MenuManageItems();
                Choice = Input.nextInt();
                Input.nextLine();
                HandleManageItem(Choice);
                if (Choice == 3) {
                    break;
                }
                
            } catch (ExceptionCustom e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("\nHanya angka!\n");
                Input.nextLine();
            }

        }

    }

    private void HandleManageItem(int Choice) throws ExceptionCustom{
        switch (Choice) {
            case 1 -> ShowItem();
            case 2 -> setStatusItem();
            default -> System.out.println("Pilihan tidak valid!");
        }
    }

    private void ShowItem() throws ExceptionCustom{
        if (Item.Itemlist.isEmpty()) {
            throw new ExceptionCustom("\nBarang kosong!\n");
        }
        Item.Itemlist.forEach(System.out::println);
    }

    private void setStatusItem() {
        Item.Itemlist.forEach(System.out::println);
        System.out.print("\nMasukan Indeks Barang : ");
        try {
            int Indeks = Input.nextInt();
            Input.nextLine();
            Indeks-=1;
            if (Indeks >= 0 && Indeks < Item.Itemlist.size()) {
                Item.Itemlist.get(Indeks).setStatus("Claimed");
                System.out.println("\nItem Berhasil Di Update!!!\n");
            } else {
                System.out.println("Tidak valid!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Hanya angka!");
            Input.nextLine();
        }

    }

    public void ManageUsers() {
        int Choice;
        while (true) {
        try {
        ManageUsersMenu();
        Choice  = Input.nextInt();
        Input.nextLine();
        if (Choice == 3) {
            break;
        }    
        HandleManageUsersMenu(Choice);
        } catch (InputMismatchException e) {
            System.out.println("Hanya angka!");
            Input.nextLine();
        }
        }
    }

    private void ManageUsersMenu(){
        System.out.println("==========Admin=========");
        System.out.println("1. Tambah mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.println("3. Kembali");
        System.out.print("===> ");
    }

    private void HandleManageUsersMenu(int Choice) throws InputMismatchException{
        switch (Choice) {
            case 1 -> AddMahasiswa();
            case 2 -> RemoveMahasiswa();        
            default -> System.out.println("\nTidak valid!\n");
        }
    }

    private void AddMahasiswa(){
        System.out.println("\n==========Tambah Mahasiswa=========");
        System.out.print("Masukan Nama Mahasiswa Baru : ");
        String Username = Input.nextLine();
        System.out.print("Masukan NIM Mahasiswa Baru : ");
        String NIM = Input.nextLine();
        Mahasiswa addMahasiswa = new Mahasiswa(Username, NIM);
        addMahasiswa.addUser(addMahasiswa);
        System.out.println("\nMahasiswa Berhasil Di tambahkan!!\n");
    }
    private void RemoveMahasiswa(){
        boolean removed = false;
        Userlist.stream().filter(e -> e instanceof Mahasiswa)
        .forEach(System.out::println);
        System.out.println("\n==========Hapus Mahasiswa=========");
        System.out.print("Masukan Nim Mahasiswa : ");
        String NIM = Input.nextLine();

        ListIterator<User> Iterator = Userlist.listIterator();
        while (Iterator.hasNext()) {
            User user = Iterator.next();

            if (user instanceof Mahasiswa) {
                if (user.getPassword().equalsIgnoreCase(NIM) ) {
                    Iterator.remove();
                    removed = true;
                    System.out.println("Mahasiswa Dengan NIM : " + NIM + "Berhasil di hapus!!");
                }
            }
        }
        if (!removed) {
            System.out.println("Mahasiswa dengan Nim : " + NIM + "Tidak Ditemukan\n");
        }
    
        
    }

}
