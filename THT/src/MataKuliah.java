// ISP PRINSIPLE
// mecah jadi interface yang kebanyakan jadi lebih sepesifik

interface MataKuliah {
    String getKode();
    String getNama();
    int getSks();
}

interface MataKuliahPraktikum extends MataKuliah {
    void alokasiAsistenLab();
    void cekPeralatanPraktikum();
}