import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String usernameAdminValid = "admin433";
        String passwordAdminValid = "password433";
        String namaMahasiswaValid = "rico";
        String nimMahasiswaValid = "433";

        while (true) {
            System.out.println("Pilih login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");
            int pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan username: ");
                String username = input.nextLine();
                System.out.print("Masukkan password: ");
                String password = input.nextLine();

                if (username.equals(usernameAdminValid) && password.equals(passwordAdminValid)) {
                    System.out.println("Login Admin berhasil!");
                    break;
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan Nama: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = input.nextLine();

                if (nama.equals(namaMahasiswaValid) && nim.equals(nimMahasiswaValid)) {
                    System.out.println("Login Mahasiswa berhasil!");
                    System.out.println("Nama: " + nama);
                    System.out.println("NIM: " + nim);
                    break;
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        input.close();
    }
}