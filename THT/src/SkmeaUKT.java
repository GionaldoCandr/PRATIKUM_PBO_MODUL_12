// OCP dengan mengubah kode yang kebanyakan kondisi if else

interface SkemaUKT {
    double hitungTarif(int totalSks);
}

class UktReguler implements SkemaUKT {
    public double hitungTarif(int totalSks) { return 5000000 + (totalSks * 100000); }
}

class UktBidikmisi implements SkemaUKT {
    public double hitungTarif(int totalSks) { return 0; } // Gratis
}

class UktInternasional implements SkemaUKT {
    public double hitungTarif(int totalSks) { return 15000000 + (totalSks * 300000); }
}