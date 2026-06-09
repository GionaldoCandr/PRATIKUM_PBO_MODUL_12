import java.util.*;
interface KeretaRepository {
    List<Kereta> ambilSemuaKereta();
    Kereta cariBerdasarkanKode(String kode);
}