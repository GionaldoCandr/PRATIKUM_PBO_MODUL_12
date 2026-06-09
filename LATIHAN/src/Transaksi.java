public class Transaksi {
    private String idTransaksi;
    private Penumpang penumpang;
    private Kereta kereta;
    private int jumlahTiket;

    public Transaksi(String idTransaksi, Penumpang penumpang, Kereta kereta, int jumlahTiket) {
        this.idTransaksi = idTransaksi;
        this.penumpang = penumpang;
        this.kereta = kereta;
        this.jumlahTiket = jumlahTiket;
    }

    public String getIdTransaksi() { return idTransaksi; }
    public Penumpang getPenumpang() { return penumpang; }
    public Kereta getKereta() { return kereta; }
    public int getJumlahTiket() { return jumlahTiket; }
    
}
