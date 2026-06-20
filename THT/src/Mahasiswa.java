class Mahasiswa {
    private String id;
    private String nama;
    private SkemaUKT skemaUKT;

    public Mahasiswa(String id, String nama, SkemaUKT skemaUKT) {
        this.id = id; this.nama = nama; this.skemaUKT = skemaUKT;
    }
    public String getId() { return id; }
    public SkemaUKT getSkemaUKT() { return skemaUKT; }
}