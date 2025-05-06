package Modul_4_.Organiztion;

public abstract class User {
    
    private String Username;
    private String Password;

    

    public User(String username,String password) {
        Username = username;
        Password = password;
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

    
    public abstract boolean Login(String Username,String Password);
    public abstract void DisplayAppMenu();
}
