public class Penumpang {
    private String nik;
    private String nama;

    public Penumpang(String nik, String nama) {
        if (nik.length() != 16 || !nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException("Penolakan Sistem: NIK harus terdiri dari TEPAT 16 digit angka tanpa huruf/simbol!");
        }
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() { return nik; }
    public String getNama() { return nama; }
    
}
