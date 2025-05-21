package com.example.praktikum.Organization;
import java.util.ArrayList;

public abstract class User {
    
    private String Username;
    private String Password;
    protected static ArrayList<User> Userlist = new ArrayList<>();

    public User(String username,String password) {
        Username = username;
        Password = password;
    }

    public void addUser(User user){
        Userlist.add(user);
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public abstract void Login();
    public abstract void DisplayAppMenu();

    @Override
    public String toString(){
        return 
        "========Data User==========\n"
        +"Akses     : " + this.getClass().getSimpleName() + "\n"
        +"Username  : " + this.Username + "\n"
        + "Password : " + this.Password + "\n";

    }
}
