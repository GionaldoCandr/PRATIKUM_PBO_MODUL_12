interface hitungDenda {
    double hitung(int hari);

}

interface cetakInfo{
    void cetak();
}


class standardDenda implements hitungDenda {
    @Override
    public double hitung(int hari) {
        return hari * 2000;
    }
}d

class dendaDenda implements hitungDenda {
    @Override
    public double hitung(int hari) {
        return hari * 5000;
    }
}

class textCetakInfo implements cetakInfo {
    @Override
     public void cetak(double totalDenda) {
        System.out.println("Denda yang harus dibayar: " + hitungDenda);
     }
    
    }

class tabelCetakInfo implements cetakInfo {
    @Override
    public void cetak(double totalDenda) {
        System.out.println("|Denda yang harus dibayar|");
        System.out.println("|" + totalDenda + "|");
    }
}
public class katalogBuku {
    public Book cariJudulBuku(String judul) {
        return new Book(judul);
    }
}

public class LibraryMenager {
    private hitungDenda hitungDenda;
    private cetakInfo cetakInfo;
    private katalogBuku katalog;

    public LibraryMeanger(hitungDenda hitungDenda, cetakInfo cetakInfo, katalogBuku katalog) {
        this.hitungDenda = hitungDenda;
        this.cetakInfo = cetakInfo;
        this.katalog = katalog;
    }

    public void prosesPeminjaman(Member member, String judulBuku){
        Book buku = katalog.cariJudulBuku(judulBuku);
      //  blablablablabl

    }


    public void (member, int hariTerlambat) {
        // blabalbalbalbla
    }

    

    



    
}
