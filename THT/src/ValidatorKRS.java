class ValidatorKRS {
    public boolean validasiPrasyarat(String idMahasiswa, MataKuliah mk) {
        System.out.println("Memvalidasi prasyarat matkul " + mk.getNama() + "...");
        return true; 
    }
}

class CetakPDFService {
    public void cetakDraf(String idMahasiswa) {
        System.out.println("Mencetak draf KRS PDF dengan format kop surat terbaru untuk " + idMahasiswa);
    }
}
