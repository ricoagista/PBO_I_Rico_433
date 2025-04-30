import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        Buku novel = new Fiksi("Laskar Pelangi", "Andrea Hirata");
        Buku ensiklopedia = new NonFiksi("Ensiklopedia Sains", "Dr. Budi");

        novel.displayInfo();
        System.out.println();
        ensiklopedia.displayInfo();
        System.out.println();

        Anggota rico = new Anggota("Rico", "I433");
        Anggota shandika = new Anggota("Shandika", "I876");

        rico.pinjamBuku("Laskar Pelangi");
        shandika.pinjamBuku("Ensiklopedia Sains", 7);

        System.out.println();
        rico.kembalikanBuku("Laskar Pelangi");
    }
}
