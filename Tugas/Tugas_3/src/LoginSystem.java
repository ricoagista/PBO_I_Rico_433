import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Admin ");
        System.out.println("2. Mahasiswa ");
        System.out.println("Pilih menu login ");
        int pilihan = input.nextInt();
        boolean suksesLogin = false;
        input.nextLine();

        switch (pilihan) {
            case 1:
                admin Admin = new admin();

                Admin.setNama("admin");
                Admin.setPassword("admin");

                while (!suksesLogin) {
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine().trim();
                    System.out.print("Masukkan password anda: ");
                    String pass = input.nextLine().trim();
                    suksesLogin = Admin.proccesLogin(nama, pass);
                }
                break;
            case 2:
                mahasiswa Mahasiswa = new mahasiswa();

                Mahasiswa.setNama("rico");
                Mahasiswa.setPassword("rico");

                while (!suksesLogin) {
                    System.out.print("Masukkan nama mahasiswa: ");
                    String inputNama = input.nextLine();
                    System.out.print("Masukkan NIM anda: ");
                    String inputNIM = input.nextLine();
                    suksesLogin = Mahasiswa.ProccesLogin(inputNama, inputNIM);
                }
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }
}