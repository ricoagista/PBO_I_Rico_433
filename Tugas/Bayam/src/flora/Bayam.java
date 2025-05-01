package flora;

public class Bayam extends Tanaman {
    private String nama;
    private String jenis;

    public Bayam() {
        this.nama = "Bayam Hijau";
        this.jenis = "Sayuran Daun";
    }

    public Bayam(String nama, String jenis) {
        this.nama = nama;
        this.jenis = jenis;
    }

    @Override
    public void deskripsi() {
        System.out.println("Ini adalah Bayam.");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
    }
}
