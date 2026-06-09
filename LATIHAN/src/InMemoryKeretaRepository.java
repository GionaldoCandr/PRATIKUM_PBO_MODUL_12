import java.util.*;

class InMemoryKeretaRepository implements KeretaRepository {
    private List<Kereta> daftarKereta;

    public InMemoryKeretaRepository() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }

    @Override
    public List<Kereta> ambilSemuaKereta() {
        return daftarKereta;
    }

    @Override
    public Kereta cariBerdasarkanKode(String kode) {
        for (Kereta k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}

