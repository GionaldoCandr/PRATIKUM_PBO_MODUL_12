class KuliahTeori implements MataKuliah {
    private String kode, nama;
    private int sks;

    public KuliahTeori(String kode, String nama, int sks) {
        this.kode = kode; this.nama = nama; this.sks = sks;
    }
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sks; }
}