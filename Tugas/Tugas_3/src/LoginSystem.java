import java.util.Scanner;
public class LoginSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Admin ");
        System.out.println("2. Mahasiswa ");
        System.out.println("Pilih menu login ");
        int pilihan = input.nextInt();
        boolean suksesLogin = false;
        input.nextLine();

        switch (pilihan){
            case 1:
                admin Admin = new admin();

                Admin.setNama("admin");
                Admin.setPassword("admin");

                while (!suksesLogin) {
                    System.out.print("masukkan nama : ");
                    String nama = input.nextLine().trim();
                    System.out.print("masukkan password anda: ");
                    String pass = input.nextLine().trim();
                    suksesLogin = Admin.proccesLogin(nama, pass);
                }
                break;
            case 2:
                mahasiswa Mahasiswa = new mahasiswa();

                Mahasiswa.setNama("rico");
                Mahasiswa.setPassword("rico");

                while(!suksesLogin){
                    System.out.print("masukkan nama mahasiswa: ");
                    String inputNama = input.nextLine();
                    System.out.print("Mauskkan NIM anda: ");
                    String InputNIM = input.nextLine();
                    suksesLogin = Mahasiswa.ProccesLoigin(inputNama, InputNIM);
                }
                break;
            default:
                System.out.println("pilihan tidak valid");
        }
    }

    static class admin extends User {
        public admin(){
            super(" ", "");
        }
        @Override
        public boolean login(String namaInput, String passwordInput){
            return super.login(namaInput, passwordInput);
        }
        public boolean proccesLogin(String nama1, String password1){
            if(login(nama1, password1)){
                displayInfo();
                return true;
            }else{
                System.out.println("loigin gagal");
                return  false;
            }
        }
        @Override
        public void displayInfo(){
            System.out.println("Login berhasil");
            System.out.println("Nama: " + getNama());
            System.out.println("Password: " + getPassword());

        }
    }
    static class mahasiswa extends User {
        mahasiswa() {
            super("", "");
        }
        @Override
        public boolean login (String inputNama, String InputnNIM){
            return super.login(inputNama, InputnNIM);
        }

        public boolean ProccesLoigin(String inputName, String inputNIM){
            if(login(inputName, inputNIM)){
                displayInfo();
                return true;
            }else{
                System.out.println("gagak login ");
                return false;
            }
        }
        @Override
        public void displayInfo (){
            System.out.println("Login berhasil");
            System.out.println("Nama : " + getNama());
            System.out.println("NIM: " + getPassword());
        }
    }
}