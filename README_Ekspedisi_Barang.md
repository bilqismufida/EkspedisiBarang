
SISTEM EKSPEDISI BARANG
======================

DESKRIPSI UMUM
--------------
Proyek Sistem Ekspedisi Barang adalah aplikasi Java berbasis console
yang digunakan untuk melakukan pendataan pelanggan dan layanan ekspedisi.
Sistem ini mendukung pengelolaan data pelanggan, data pengiriman barang,
pencarian data, manipulasi data (tambah, edit, hapus), serta pelacakan
status pengiriman menggunakan nomor resi.

Struktur proyek dibagi menjadi:
- Model Data
- Logic / Controller
- Penyimpanan Data (in-memory)
- Utility pendukung tampilan


DAFTAR FITUR
============

A. FITUR WAJIB
--------------

1. Pendataan Pelanggan
   - Nama pelanggan
   - Alamat pelanggan
   - Nomor telepon
   - Email pelanggan

   Fitur:
   - Tambah data pelanggan
   - Lihat data pelanggan
   - Edit data pelanggan
   - Hapus data pelanggan

2. Pendataan Layanan Ekspedisi
   - Alamat pengirim
   - Alamat penerima
   - Deskripsi barang
   - Jenis layanan pengiriman
   - Status ekspedisi
   - Nomor resi

   Fitur:
   - Tambah data ekspedisi
   - Lihat data ekspedisi
   - Edit data ekspedisi
   - Hapus data ekspedisi

3. Pencarian Data
   - Berdasarkan jenis layanan
   - Berdasarkan kata kunci tertentu

4. Informasi Jumlah Data
   - Jumlah pelanggan
   - Jumlah data ekspedisi/barang

5. Manipulasi Data
   - Edit dan hapus data pelanggan
   - Edit dan hapus data ekspedisi


B. FITUR TAMBAHAN
-----------------
6. Pelacakan Pengiriman
   - Tracking status pengiriman menggunakan nomor resi

7. Status Ekspedisi
   - Sedang dikemas
   - Sedang dikirim
   - Selesai
   - Status lainnya sesuai kebutuhan


ANALISIS FILE DAN KEGUNAAN
=========================

1. Main.java
------------
Fungsi:
- Entry point aplikasi
- Menampilkan menu utama
- Mengatur alur navigasi user

Relasi:
- Memanggil class Pelanggan
- Memanggil class Ekspedisi
- Menggunakan utility tampilan


2. Database.java
----------------
Fungsi:
- Menyimpan data sementara (in-memory)

Isi:
- List DataPelanggan
- List DataEkspedisi

Relasi:
- Digunakan oleh Pelanggan dan Ekspedisi
- Bertindak sebagai database sederhana


3. DataPelanggan.java
---------------------
Fungsi:
- Model data pelanggan

Atribut:
- id
- nama
- alamat
- telepon
- email

Relasi:
- Disimpan di Database
- Digunakan oleh Pelanggan
- ID dipakai di DataEkspedisi


4. Pelanggan.java
-----------------
Fungsi:
- Mengelola CRUD data pelanggan

Method utama:
- tampilkanDataPelanggan()
- tambahDataPelanggan()
- editDataPelanggan()
- hapusDataPelanggan()
- cariById()

Relasi:
- Mengakses Database.dataPelanggan
- Mengelola objek DataPelanggan


5. DataEkspedisi.java
---------------------
Fungsi:
- Model data ekspedisi

Atribut:
- id_layanan
- id_pelanggan
- alamat_pengirim
- alamat_penerima
- deskripsi_barang
- jenis_layanan
- status_ekspedisi
- no_resi

Relasi:
- Disimpan di Database
- Berelasi dengan DataPelanggan


6. Ekspedisi.java
-----------------
Fungsi:
- Mengelola CRUD data ekspedisi
- Pencarian dan tracking resi

Method utama:
- tampilkanDataEkspedisi()
- tambahDataEkspedisi()
- editDataEkspedisi()
- hapusDataEkspedisi()
- cariById()
- trackingResi()

Relasi:
- Mengakses Database.dataEkspedisi
- Menggunakan ResiGenerator
- Relasi dengan DataPelanggan


PACKAGE UTILITY
===============

1. AsciiArt.java
   - Menampilkan ASCII art judul aplikasi

2. Color.java
   - Menyediakan warna ANSI untuk console

3. Labels.java
   - Menyediakan pesan standar sistem

4. TitlePrinter.java
   - Menampilkan judul dan header tampilan

5. ResiGenerator.java
   - Membuat nomor resi otomatis dan unik


KESIMPULAN
==========
Proyek Sistem Ekspedisi Barang telah memenuhi seluruh sketsa fitur awal,
termasuk CRUD, pencarian data, tracking pengiriman, dan status ekspedisi.

Struktur kode sudah modular dan mudah dikembangkan lebih lanjut ke
database nyata atau aplikasi berbasis GUI/Web.


Author: Bilqis Mufida, Trye Tintian Runga, Muhammad 'Attar Syaafi