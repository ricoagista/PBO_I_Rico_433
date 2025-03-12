class Monyet {
    static void memanjat() {
        System.out.println("Monyet sedang memanjat pohon dengan lincah.");
    }
    void mencariMakan() {
        System.out.println("Monyet berlari mencari makan di hutan.");
    }
    void bersuara() {
        System.out.println("Monyet mengeluarkan suara untuk berkomunikasi.");
    }
}

public class Main {
    public static void main(String[] args) {
        Monyet monkey = new Monyet();
        Monyet.memanjat();
        monkey.mencariMakan();
        monkey.bersuara();
    }
}