import java.util.*;

class SistemKRSManager {
    private DatabaseRepository db;
    private ValidatorKRS validator;
    private CetakPDFService pdfService;

    public SistemKRSManager(DatabaseRepository db, ValidatorKRS validator, CetakPDFService pdfService) {
        this.db = db;
        this.validator = validator;
        this.pdfService = pdfService;
    }

    public void prosesKRS(Mahasiswa mhs, List<MataKuliah> pilihanMatkul) {
        List<MataKuliah> matkulValid = new ArrayList<>();
        int totalSks = 0;

        for (MataKuliah mk : pilihanMatkul) {
            if (validator.validasiPrasyarat(mhs.getId(), mk)) {
                matkulValid.add(mk);
                totalSks += mk.getSks();
            }
        }

        double tagihan = mhs.getSkemaUKT().hitungTarif(totalSks);
        System.out.println("Total Tagihan UKT: Rp " + tagihan);

        db.simpanKRS(mhs.getId(), matkulValid);
        
        pdfService.cetakDraf(mhs.getId());
    }
}
