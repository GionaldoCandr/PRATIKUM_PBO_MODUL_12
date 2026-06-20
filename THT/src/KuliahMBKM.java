class KuliahMBKM implements MataKuliah {
    private String kode, nama;
    private int sksKonversi;

    public KuliahMBKM(String kode, String nama, int sksKonversi) {
        this.kode = kode; this.nama = nama; this.sksKonversi = sksKonversi;
    }
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sksKonversi; }
}
