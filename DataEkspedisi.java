public class DataEkspedisi {
    int id_layanan, id_pelanggan, telepon;
    String alamat_pengirim, alamat_penerima, deskripsi_barang, no_resi;
// ID_Layanan	id_pelanggan	Alamat Pengirim	alamat_penerima	deskripsi_barang	jenis_layanan	status_pengiriman	nomor_resi
    public DataEkspedisi(int id_layanan, int id_pelanggan, String alamat_pengirim, String alamat_penerima, String deskripsi_barang, String no_resi) {
        this.id_layanan = id_layanan;
        this.id_pelanggan = id_pelanggan;
        this.alamat_pengirim = alamat_pengirim;
        this.alamat_penerima = alamat_penerima;
        this.deskripsi_barang = deskripsi_barang;
        this.no_resi = no_resi;
    }
}