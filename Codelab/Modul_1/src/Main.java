import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input dari pengguna
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelaminInput = scanner.nextLine();

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();

        // Menutup Scanner
        scanner.close();

        // Menghitung umur
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        // Menentukan jenis kelamin
        String jenisKelamin;
        if (jenisKelaminInput.equalsIgnoreCase("L")) {
            jenisKelamin = "Laki-laki";
        } else if (jenisKelaminInput.equalsIgnoreCase("P")) {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "Jenis kelamin tidak valid";
        }

        // Menampilkan data diri
        System.out.println("\nData Diri:");
        System.out.println("Nama           : " + nama);
        System.out.println("Jenis Kelamin  : " + jenisKelamin);
        System.out.println("Umur           : " + umur + " tahun");
    }
}