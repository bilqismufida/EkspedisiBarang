
import java.util.ArrayList;

public class Database {

    public static ArrayList<DataPelanggan> dataPelanggan = new ArrayList<>();
    public static ArrayList<DataEkspedisi> dataEkspedisi = new ArrayList<>();

    public static int getNextPelangganId() {
        int maxId = 0;
        for (DataPelanggan dp : dataPelanggan) {
            if (dp.id > maxId) {
                maxId = dp.id;
            }
        }
        return maxId + 1;
    }

    // static {
    //     // Menambahkan data pelanggan awal (dummy data)
    //     dataPelanggan.add(new DataPelanggan(1, "Andi", "Jalan Merdeka No. 12", 81234567, "andi@email.com"));
    //     dataPelanggan.add(new DataPelanggan(2, "Budi", "Jalan Raya No. 8", 81298765, "budi@email.com"));
    //     dataPelanggan.add(new DataPelanggan(3, "Cici", "Jalan Sudirman No. 5", 81256789, "cici@email.com"));
    // }
}
