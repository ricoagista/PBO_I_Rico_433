public class User {
    private String nama, Password;

    User(String nama, String Password) {
        this.nama = nama;
        this.Password = Password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public boolean login(String InputNama, String InputPassword) {
        return (InputNama.equals(nama) && InputPassword.equals(Password));
    }

    public void displayInfo() {
        System.out.println("sukses .....");
    }
}