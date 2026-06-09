class ConsoleTicketPrinter implements TicketPrinter {
    @Override
    public void cetakTiket(Transaksi trx) {
        System.out.println("\n          E-TICKET JAVA EXPRESS       ");
        System.out.println("ID Transaksi  : " + trx.getIdTransaksi());
        System.out.println("Nama Penumpang: " + trx.getPenumpang().getNama());
        System.out.println("NIK           : " + trx.getPenumpang().getNik());
        System.out.println("Kereta        : " + trx.getKereta().getNama() + " (" + trx.getKereta().getRute() + ")");
        System.out.println("Jumlah Tiket  : " + trx.getJumlahTiket());
        System.out.println("Status        : LUNAS & TERKONFIRMASI");
    }
}