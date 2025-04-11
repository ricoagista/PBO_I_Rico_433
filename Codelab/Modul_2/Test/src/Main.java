class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) {
        System.out.println(this.nama + " menyerang " + target.getNama());
    }
}

class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan pedang!");
        int damage = 20;
        int kesehatanTargetSaatIni = target.getKesehatan();
        target.setKesehatan(kesehatanTargetSaatIni - damage);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan sihir!");
        int damage = 15;
        int kesehatanTargetSaatIni = target.getKesehatan();
        target.setKesehatan(kesehatanTargetSaatIni - damage);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

public class Main {
    public static void main(String[] args) {
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());
        System.out.println();

        System.out.println(brimstone.getNama() + " menyerang " + viper.getNama() + " menggunakan pedang!");
        brimstone.serang(viper);
        System.out.println();

        System.out.println(viper.getNama() + " menyerang " + brimstone.getNama() + " menggunakan sihir!");
        viper.serang(brimstone);

        System.out.println("\nProcess finished with exit code 0");
    }
}