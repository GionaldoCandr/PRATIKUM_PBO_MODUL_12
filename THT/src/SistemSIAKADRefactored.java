import java.util.*;

public class SistemSIAKADRefactored {
    public static void main(String[] args) {
        
        DatabaseRepository dbBaru = new CloudNoSQLDatabase(); 
        ValidatorKRS validator = new ValidatorKRS();
        CetakPDFService cetakPdf = new CetakPDFService();
        
        SistemKRSManager krsManager = new SistemKRSManager(dbBaru, validator, cetakPdf);

        Mahasiswa mhs1 = new Mahasiswa("10522001", "Budi Santoso", new UktBidikmisi());

        List<MataKuliah> pilihanBudi = new ArrayList<>();
        pilihanBudi.add(new KuliahTeori("CS101", "Pemrograman Dasar", 3));
        pilihanBudi.add(new KuliahMBKM("MBKM01", "Magang Merdeka TechCompany", 20));

        krsManager.prosesKRS(mhs1, pilihanBudi);
    }
}