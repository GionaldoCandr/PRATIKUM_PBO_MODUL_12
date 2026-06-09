import java.util.*;
public class JavaExpressApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        KeretaRepository repo = new InMemoryKeretaRepository();
        TicketPrinter printer = new ConsoleTicketPrinter();
        // Service kini murni logic, urusan print diurus controller
        SistemReservasi service  = new SistemReservasi(repo);
        
        boolean isRunning = true;

        try {
            while (isRunning) {
                System.out.println("\n--- MENU UTAMA ---");
                System.out.println("1. Lihat Jadwal Kereta");
                System.out.println("2. Pesan Tiket");
                System.out.println("0. Keluar Aplikasi");
                System.out.print("Pilih menu > ");

                int pilihan = -1;
                try {
                    pilihan = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("\n[ERROR INPUT] Anda memasukkan huruf atau simbol. Harap masukkan angka menu!");
                    scanner.nextLine(); 
                    continue; 
                }

                switch (pilihan) {
                    case 1:
                        tampilkanJadwal(service.dapatkanJadwalKereta());
                        break;
                    case 2:
                        try {
                            System.out.println("\n--- FORM PEMESANAN TIKET ---");
                            System.out.print("Masukkan Kode Kereta : ");
                            String kode = scanner.nextLine();
                            System.out.print("Masukkan NIK (16 digit) : ");
                            String nik = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap  : ");
                            String nama = scanner.nextLine();
                            System.out.print("Masukkan Jumlah Tiket  : ");
                            int jumlah = scanner.nextInt();
                            scanner.nextLine();

                            // 1. Buat Objek Penumpang (Otomatis memvalidasi NIK di konstruktornya)
                            Penumpang penumpangBaru = new Penumpang(nik, nama);

                            // 2. Lakukan transaksi melalui service dan simpan hasilnya di Objek Transaksi
                            Transaksi hasilTransaksi = service.pesanTiket(kode, penumpangBaru, jumlah);

                            // 3. Lempar objek Transaksi ke Printer
                            printer.cetakTiket(hasilTransaksi);

                        } catch (InputMismatchException e) {
                            System.out.println("\n[ERROR INPUT] Jumlah tiket harus berupa ANGKA BULAT!");
                            scanner.nextLine();
                        } catch (DataPenumpangTidakValidException e) {
                            System.out.println("\n[VALIDASI GAGAL] " + e.getMessage());
                        } catch (RuteTidakDitemukanException e) {
                            System.out.println("\n[RUTE GAGAL] " + e.getMessage());
                        } catch (TiketHabisException e) {
                            System.out.println("\n[STOK GAGAL] " + e.getMessage());
                            System.out.println("-> Info   : Kereta " + e.getNamaKereta() + " saat ini hanya tersisa " + e.getSisaKursi() + " kursi.");
                        } catch (Exception e) {
                            System.out.println("\n[SYSTEM ERROR] Terjadi kesalahan fatal: " + e.getMessage());
                        }
                        break;

                    case 0:
                        isRunning = false;
                        break;

                    default:
                        System.out.println("\n[PERINGATAN] Menu tidak valid. Silakan pilih 1, 2, atau 0.");
                }
            }
        } finally {
            if (scanner != null) scanner.close();
            System.out.println(" [SYSTEM LOG] Blok penanganan akhir (finally) dieksekusi.");
            System.out.println(" Sesi JAVA EXPRESS telah ditutup. Memori telah dibersihkan.");
        }
    }

    private static void tampilkanJadwal(List<Kereta> daftarKereta) {
        System.out.println("                 JADWAL KERETA API AKTIF                 ");
        System.out.printf("| %-5s | %-15s | %-12s | %-10s |\n", "KODE", "NAMA KERETA", "RUTE", "SISA KURSI");
        System.out.println("---------------------------------------------------------");
        for (Kereta k : daftarKereta) {
            System.out.printf("| %-5s | %-15s | %-12s | %-10d |\n", k.getKode(), k.getNama(), k.getRute(), k.getSisaKursi());
        }
    }
}