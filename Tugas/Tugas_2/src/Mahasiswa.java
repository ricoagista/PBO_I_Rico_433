class Mahasiswa {
    private final String validNama = "rico";
    private final String validNIM = "123";

    public boolean login(String nama, String nim) {
        return nama.equalsIgnoreCase(validNama) && nim.equals(validNIM);
    }

    public void displayInfo() {
        System.out.println("Login berhasil!");
        System.out.println("Nama: " + validNama);
        System.out.println("NIM: " + validNIM);
    }
}