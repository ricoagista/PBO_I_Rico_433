import flora.Tanaman;
import flora.Bayam;

public class Flora {
    public static void main(String[] args) {
        Tanaman tanaman1 = new Tanaman();
        Tanaman tanaman2 = new Bayam();

        tanaman1.deskripsi(); // Output dari Tanaman
        System.out.println("-----");
        tanaman2.deskripsi(); // Output dari Bayam (polymorphism)
    }
}
