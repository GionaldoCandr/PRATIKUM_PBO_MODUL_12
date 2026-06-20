// DIP sistem bergantung pada abstrak bukan class konkrit
import java.util.*;
interface DatabaseRepository {
    void simpanKRS(String idMahasiswa, List<MataKuliah> daftarMatkul);
}

class MySQLDatabase implements DatabaseRepository {
    public void simpanKRS(String idMahasiswa, List<MataKuliah> daftarMatkul) {
        System.out.println("[MySQL] Menyimpan " + daftarMatkul.size() + " matkul untuk " + idMahasiswa);
    }
}

class CloudNoSQLDatabase implements DatabaseRepository {
    public void simpanKRS(String idMahasiswa, List<MataKuliah> daftarMatkul) {
        System.out.println("[Cloud NoSQL] Menyimpan " + daftarMatkul.size() + " matkul untuk " + idMahasiswa + " secara asinkronus agar tidak down.");
    }
}