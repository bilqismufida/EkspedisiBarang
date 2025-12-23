
class Database {
    static DataPelanggan[] dataPelanggan = new DataPelanggan[100];
    static DataEkspedisi[] dataEkspedisi = new DataEkspedisi[100];

    static int jumlahPelanggan = 0;
    static int jumlahEkspedisi = 0;

    static int getNextPelangganId() {
        return jumlahPelanggan + 1;
    }

   

}
