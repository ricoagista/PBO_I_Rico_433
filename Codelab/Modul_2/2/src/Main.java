public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank("202310370311129", "Maharani", 500000.0);
        RekeningBank rekening2 = new RekeningBank("202310370311307", "Amelia", 1000000.0);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(200000.0);
        rekening2.setorUang(500000.0);

        rekening1.tarikUang(800000.0);
        rekening2.tarikUang(300000.0);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}