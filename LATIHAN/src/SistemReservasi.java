import java.util.*;

public class SistemReservasi {
    private final KeretaRepository repository;

    public SistemReservasi(KeretaRepository repository) {
        this.repository = repository;
    }

    public List<Kereta> dapatkanJadwalKereta() {
        return repository.ambilSemuaKereta();
    }

    // Sekarang menerima objek Penumpang, dan mengembalikan objek Transaksi
    public Transaksi pesanTiket(String kode, Penumpang penumpang, int jumlahTiket) 
            throws RuteTidakDitemukanException, TiketHabisException {
        
        System.out.println("\n[SISTEM] Memproses reservasi Anda...");

        // 1. Cari Kereta via Repository
        Kereta keretaPilihan = repository.cariBerdasarkanKode(kode);
        if (keretaPilihan == null) {
            throw new RuteTidakDitemukanException("Penolakan Sistem: Rute dengan kode '" + kode + "' tidak terdaftar di jadwal kami.");
        }

        // 2. Validasi Kapasitas Kursi
        if (jumlahTiket > keretaPilihan.getSisaKursi()) {
            throw new TiketHabisException("Penolakan Sistem: Jumlah pemesanan melebihi kapasitas yang tersedia.", 
                                          keretaPilihan.getNama(), 
                                          keretaPilihan.getSisaKursi());
        }

        // 3. Proses Berhasil
        keretaPilihan.kurangiKursi(jumlahTiket);
        String idTransaksi = "TRX-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        
        // Return Objek Transaksi baru
        return new Transaksi(idTransaksi, penumpang, keretaPilihan, jumlahTiket);
    }
}