package Praktikum.Users;

import Praktikum.Actions.AdminAction;

public class Admin extends User implements AdminAction{

    public Admin(){
        super("admin","admin");
    }

    public void ManageItems(){
        System.out.println("Coming Soon");
    }

    public void ManageUsers(){
        System.out.println("Coming Soon");
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
        System.out.println("Pilihan Menu Admin");
        System.out.println("1. Atur Barang");
        System.out.println("2. Atur User");
        System.out.println("3. Exit");
        System.out.print("\nInput: ");
    }
}