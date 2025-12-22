## 🧩 Penjelasan File

### 🔸 Main.java

Berfungsi sebagai **entry point** aplikasi.  
Menampilkan menu utama dan mengatur alur navigasi program.

### 🔸 Database.java

Berfungsi sebagai penyimpanan data sementara (in-memory).

- Menyimpan data pelanggan
- Menyimpan data ekspedisi

### 🔸 DataPelanggan.java

Class model untuk data pelanggan.

- Menyimpan informasi pelanggan
- Digunakan oleh class `Pelanggan`

### 🔸 Pelanggan.java

Mengelola seluruh proses CRUD data pelanggan:

- Tambah pelanggan
- Tampilkan pelanggan
- Edit pelanggan
- Hapus pelanggan

### 🔸 DataEkspedisi.java

Class model untuk data pengiriman barang.

- Menyimpan detail ekspedisi
- Terhubung dengan data pelanggan melalui ID

### 🔸 Ekspedisi.java

Mengelola data ekspedisi:

- Tambah data pengiriman
- Edit & hapus data
- Pencarian data
- Tracking berdasarkan nomor resi

---

## 🛠 Utility

- **AsciiArt.java**  
  Menampilkan judul aplikasi dalam bentuk ASCII art.

- **Color.java**  
  Menyediakan warna teks untuk output console.

- **Labels.java**  
  Menyimpan teks pesan (info, error, sukses).

- **TitlePrinter.java**  
  Menampilkan judul dan header program.

- **ResiGenerator.java**  
  Membuat nomor resi secara otomatis dan unik.

---

## ▶️ Cara Menjalankan Program

1. Pastikan Java sudah terinstall
2. Compile seluruh file `.java`
3. Jalankan file `Main.java`
4. Gunakan menu yang tersedia

---

## 👤 Author

**Bilqis Mufida, Trye Tintian Runga, Muhammad 'Attar Syaafi**

---

## 📌 Catatan

Proyek ini masih menggunakan penyimpanan data sementara (tanpa database).
Dapat dikembangkan lebih lanjut ke aplikasi GUI atau berbasis web.
