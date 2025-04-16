public class mahasiswa extends User {
    public mahasiswa() {
        super("rico", "433");
    }

    @Override
    public boolean login(String inputNama, String inputNIM) {
        return super.login(inputNama, inputNIM);
    }

    public boolean ProccesLogin(String inputName, String inputNIM) {
        if (login(inputName, inputNIM)) {
            displayInfo();
            return true;
        } else {
            System.out.println("Gagal login");
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Login berhasil");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getPassword());
    }
}