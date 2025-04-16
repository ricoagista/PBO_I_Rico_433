public class admin extends User {
    public admin() {
        super("admin", "admin");
    }

    @Override
    public boolean login(String namaInput, String passwordInput) {
        return super.login(namaInput, passwordInput);
    }

    public boolean proccesLogin(String nama1, String password1) {
        if (login(nama1, password1)) {
            displayInfo();
            return true;
        } else {
            System.out.println("Login gagal");
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Login berhasil");
        System.out.println("Nama: " + getNama());
        System.out.println("Password: " + getPassword());
    }
}