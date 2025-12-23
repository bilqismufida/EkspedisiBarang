
import Utility.Color;
import Utility.Labels;
import Utility.ResiGenerator;
import Utility.TitlePrinter;
import java.util.InputMismatchException;
import java.util.Scanner;

// =============================
//   CLASS CRUD EKSPEDISI
// =============================
class Ekspedisi {

    static Scanner input = new Scanner(System.in);
    static int nextId = 1;

    // READ — FULL TABLE
    public static void tampilkanDataEkspedisi() {

        printTableHeader();

        if (Database.dataEkspedisi.isEmpty()) {
            System.out.println(
                    "|                TIDAK ADA DATA EKSPEDISI                                                                                            |");
            printTableFooter();
        } else {
            for (DataEkspedisi p : Database.dataEkspedisi) {
                printRow(p);
            }
            printTableFooter();
        }
        if (Database.dataPelanggan.isEmpty()) {
            System.out.println("");
            System.out.println(Labels.error("Tidak ada data pelanggan"));
            System.out.println("Diharap mengisi data pelanggan sebelum membuat data ekspedisi");
        } else {
            menuCrud();
        }

    }

    // SIMPLE TABLE
    public static void tampilkanTableOnly() {
        printTableHeader();

        if (Database.dataEkspedisi.isEmpty()) {
            System.out.println(
                    "|                TIDAK ADA DATA EKSPEDISI                                                                                            |");
        } else {
            for (DataEkspedisi p : Database.dataEkspedisi) {
                printRow(p);
            }
        }

        printTableFooter();
    }

    // CREATE
    public static void tambahDataEkspedisi() {
        tampilkanTableOnly();
        int opsi;
        String jenis_layanan = "";

        TitlePrinter.sub("Tambah Data Ekspedisi", Color.YELLOW);
        Pelanggan.tampilkanTableOnly();
        System.out.print("Pilih ID Pelanggan: ");
        int id_pelanggan = input.nextInt();
        input.nextLine();

        DataPelanggan p = cariByIdPelanggan(id_pelanggan);

        if (p == null) {
            System.out.println(Labels.id_not_found());
            return;
        }

        System.out.print("Alamat Pengirim: " + p.alamat);
        String alamat_pengirim = p.alamat;

        System.out.print("\nAlamat Penerima: ");
        String alamat_penerima = input.nextLine();

        System.out.println("\nDeskripsi Barang (Max. 20 karakter): ");
        String deskripsi_barang = input.nextLine();
        if (deskripsi_barang.length() > 20) {
            System.out.println("[!] Deskripsi terlalu panjang, dipotong otomatis.");
            deskripsi_barang = deskripsi_barang.substring(0, 20);
        }

        do {
            System.out.println("\nPilih Jenis Layanan:");
            System.out.println("[1] REG | [2] EXP | [3] ECO");
            System.out.print("Pilih: ");
            opsi = input.nextInt();
            input.nextLine(); // Clear the buffer

            switch (opsi) {
                case 1:
                    jenis_layanan = "REG";
                    break;
                case 2:
                    jenis_layanan = "EXP";
                    break;
                case 3:
                    jenis_layanan = "ECO";
                    break;
                default:
                    System.out.println(Labels.warning("Tolong pilih opsi yang sesuai!"));
                    break;
            }
        } while (jenis_layanan.equals(""));

        String no_resi = ResiGenerator.generateResi(jenis_layanan);
        System.out.println("Nomor Resi otomatis: " + no_resi);

        String status_ekspedisi = "Sedang Dikemas";

        System.out.println("=============================");

        Database.dataEkspedisi.add(new DataEkspedisi(nextId++, id_pelanggan, alamat_pengirim, alamat_penerima,
                deskripsi_barang, jenis_layanan, no_resi, status_ekspedisi));
        System.out.println(Labels.success("EKSPEDISI berhasil ditambahkan!"));

        tampilkanTableOnly();
    }

    public static void pilihEditAtauHapusEkspedisi() {
        tampilkanTableOnly();

        System.out.print("\nMasukkan ID Ekspedisi: ");
        int id = input.nextInt();
        input.nextLine();

        DataEkspedisi e = cariById(id);

        if (e == null) {
            System.out.println(Labels.id_not_found());
            return;
        }

        int pilih;
        do {
            System.out.println("\n=== Ubah Data Ekspedisi ===");
            System.out.println("1. Edit Data");
            System.out.println("2. Hapus Data");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    editDataEkspedisi(e);
                    break;
                case 2:
                    hapusDataEkspedisi(e);
                    pilih = 0;
                    break;
                case 0:
                    TitlePrinter.sub("Kembali", Color.YELLOW);
                    break;
                default:
                    System.out.println(Labels.opt_not_valid());
            }
        } while (pilih != 0);
    }

    // UPDATE
    public static void editDataEkspedisi(DataEkspedisi e) {
        int pilih, opsi;
        String jenis_layanan = "";

        do {
            TitlePrinter.sub("Edit Data Ekspedisi", Color.YELLOW);

            System.out.println("1. ID Pelanggan");
            System.out.println("2. Alamat Pengirim");
            System.out.println("3. Alamat Penerima");
            System.out.println("4. Deskripsi Barang");
            System.out.println("5. Nomor Resi");
            System.out.println("6. Status");
            System.out.println("0. Selesai");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    Pelanggan.tampilkanTableOnly();
                    System.out.print("ID Pelanggan Baru: ");
                    int idP = input.nextInt();
                    input.nextLine();

                    if (cariByIdPelanggan(idP) == null) {
                        System.out.println(Labels.id_not_found());
                    } else {
                        e.id_pelanggan = idP;
                    }
                    break;

                case 2:
                    System.out.print("Alamat Pengirim Baru: ");
                    e.alamat_pengirim = input.nextLine();
                    break;

                case 3:
                    System.out.print("Alamat Penerima Baru: ");
                    e.alamat_penerima = input.nextLine();
                    break;

                case 4:
                    System.out.print("Deskripsi Barang Baru: ");
                    e.deskripsi_barang = input.nextLine();
                    break;

                case 5:
                    do {
                        System.out.println("[1] REG | [2] EXP | [3] ECO");
                        System.out.print("Pilih: ");
                        opsi = input.nextInt();
                        input.nextLine();

                        switch (opsi) {
                            case 1:
                                jenis_layanan = "REG";
                                break;
                            case 2:
                                jenis_layanan = "EXP";
                                break;
                            case 3:
                                jenis_layanan = "ECO";
                                break;
                            default:
                                System.out.println(Labels.warning("Pilihan tidak valid"));
                        }
                    } while (jenis_layanan.equals(""));

                    e.no_resi = ResiGenerator.generateResi(jenis_layanan);
                    break;

                case 6:
                    System.out.println("[1] Selesai | [2] Sedang dikirim | [3] Sedang dikemas");
                    System.out.print("Pilih: ");
                    opsi = input.nextInt();
                    input.nextLine();

                    if (opsi == 1) {
                        e.status_ekspedisi = "Selesai";
                    } else if (opsi == 2) {
                        e.status_ekspedisi = "Sedang dikirim";
                    } else if (opsi == 3) {
                        e.status_ekspedisi = "Sedang dikemas";
                    } else {
                        System.out.println(Labels.opt_not_valid());
                    }
                    break;

                case 0:
                    System.out.println(Labels.success("Perubahan disimpan"));
                    break;
                default:
                    System.out.println(Labels.opt_not_valid());
            }
        } while (pilih != 0);

        tampilkanTableOnly();
    }

    // DELETE
    public static void hapusDataEkspedisi(DataEkspedisi e) {
        System.out.print("Yakin hapus data ini? (y/n): ");
        String yn = input.nextLine();

        if (yn.equalsIgnoreCase("y")) {
            Database.dataEkspedisi.remove(e);
            System.out.println(Labels.success("Data Ekspedisi berhasil dihapus"));
            tampilkanTableOnly();
        } else {
            System.out.println(Labels.error("Penghapusan dibatalkan"));
        }
    }

    public static void menuSorting() {
        int pilih;

        System.out.println("\n=== Sorting Data Ekspedisi ===");
        System.out.println("1. Sorting berdasarkan ID Ekspedisi");
        System.out.println("2. Sorting berdasarkan Status");
        System.out.print("Pilih: ");
        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                sortByIdEkspedisi();
                break;
            case 2:
                sortByStatus();
                break;
            default:
                System.out.println(Labels.opt_not_valid());
        }

        tampilkanTableOnly();
    }

    public static void sortByIdEkspedisi() {
        for (int i = 0; i < Database.dataEkspedisi.size() - 1; i++) {
            for (int j = 0; j < Database.dataEkspedisi.size() - i - 1; j++) {
                if (Database.dataEkspedisi.get(j).id_layanan
                        > Database.dataEkspedisi.get(j + 1).id_layanan) {

                    DataEkspedisi temp = Database.dataEkspedisi.get(j);
                    Database.dataEkspedisi.set(j, Database.dataEkspedisi.get(j + 1));
                    Database.dataEkspedisi.set(j + 1, temp);
                }
            }
        }
    }

    public static void sortByStatus() {
        for (int i = 0; i < Database.dataEkspedisi.size() - 1; i++) {
            for (int j = 0; j < Database.dataEkspedisi.size() - i - 1; j++) {
                if (Database.dataEkspedisi.get(j).status_ekspedisi
                        .compareToIgnoreCase(Database.dataEkspedisi.get(j + 1).status_ekspedisi) > 0) {

                    DataEkspedisi temp = Database.dataEkspedisi.get(j);
                    Database.dataEkspedisi.set(j, Database.dataEkspedisi.get(j + 1));
                    Database.dataEkspedisi.set(j + 1, temp);
                }
            }
        }
    }

    // MENU CRUD
    public static void menuCrud() {
        int pilih;

        do {
            System.out.println("====== Menu Ekspedisi ======");
            System.out.println("1. Tambah Data");
            System.out.println("2. Edit / Hapus Data");
            System.out.println("3. Pencarian Data Ekspedisi");
            System.out.println("4. Sorting Data Ekspedisi");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            System.out.println("============================");

            switch (pilih) {
                case 1:
                    tambahDataEkspedisi();
                    break;
                case 2:
                    if (!Database.dataEkspedisi.isEmpty()) {
                        pilihEditAtauHapusEkspedisi();
                    } else {
                        System.out.println(Labels.warning("Tidak ada data ekspedisi"));
                    }
                    break;
                case 3:
                    cariDataEkspedisi();
                    break;
                case 4:
                    menuSorting();
                    break;
                case 0:
                    TitlePrinter.sub("Kembali", Color.YELLOW);
                    break;
                default:
                    System.out.println(Labels.opt_not_valid());
            }
        } while (pilih != 0);
    }

    // SEARCH BY ID Ekspedisi
    public static DataEkspedisi cariById(int id) {
        for (DataEkspedisi e : Database.dataEkspedisi) {
            if (e.id_layanan == id) {
                return e;
            }
        }
        return null;
    }

    // SEARCH BY ID Pelanggan
    public static DataPelanggan cariByIdPelanggan(int id) {
        for (DataPelanggan p : Database.dataPelanggan) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    // TABEL UTILITY
    public static void cariDataEkspedisi() {
        System.out.println("\n=== Pencarian Data Ekspedisi ===");
        System.out.println("1. Pencarian Berdasarkan Jenis Layanan");
        System.out.println("2. Pencarian Berdasarkan Status Ekspedisi");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                System.out.print("Masukkan Jenis Layanan yang ingin dicari (REG/EXP): ");
                String jenisLayanan = input.nextLine();
                tampilkanEkspedisiBerdasarkanLayanan(jenisLayanan);
                break;

            case 2:
                System.out.println(
                        "Masukkan Status Ekspedisi yang ingin dicari:");
                System.out.println(
                        "[1]Selesai | [2]Sedang dikirim | [3]Sedang dikemas");
                System.out.print(
                        "Pilih: ");
                int opsi = input.nextInt();
                String statusEkspedisi = "";
                switch (opsi) {
                    case 1:
                        statusEkspedisi = "Selesai";
                        break;
                    case 2:
                        statusEkspedisi = "Sedang dikirim";
                        break;
                    case 3:
                        statusEkspedisi = "Sedang dikemas";
                        break;
                    default:
                        try {
                            System.out.println(Labels.warning("Tolong pilih opsi yang sesuai!"));
                        } catch (InputMismatchException e) {
                            System.out.println(Labels.warning("Tolong pilih opsi yang sesuai!"));
                        }
                }
                tampilkanEkspedisiBerdasarkanStatus(statusEkspedisi);
                break;

            default:
                System.out.println(Labels.opt_not_valid());
                break;
        }
    }

    // Tampilkan Ekspedisi Berdasarkan Jenis Layanan
    public static void tampilkanEkspedisiBerdasarkanLayanan(String jenisLayanan) {
        printTableHeader();

        boolean found = false;
        for (DataEkspedisi e : Database.dataEkspedisi) {
            if (e.jenis_layanan.equalsIgnoreCase(jenisLayanan)) {
                printRow(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println(Labels.data_not_found());
        }

        printTableFooter();
    }

    // Tampilkan Ekspedisi Berdasarkan Status Ekspedisi
    public static void tampilkanEkspedisiBerdasarkanStatus(String statusEkspedisi) {
        printTableHeader();

        boolean found = false;
        for (DataEkspedisi e : Database.dataEkspedisi) {
            if (e.status_ekspedisi.equalsIgnoreCase(statusEkspedisi)) {
                printRow(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println(Labels.data_not_found());
        }

        printTableFooter();
    }

    // TABEL UTILITY
    private static void printTableHeader() {
        System.out.println("\n");
        TitlePrinter.printTableE("Data Ekspedisi", Color.CYAN);
        System.out.println(
                "+----+------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.println(
                "| ID | ID Plggn   | Alamat Pengirim      | Alamat Penerima      | Deskripsi Barang     | No Resi              | Status               |");
        System.out.println(
                "+----+------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
    }

    private static void printRow(DataEkspedisi e) {
        System.out.printf(
                "| %-2d | %-10d | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                e.id_layanan,
                e.id_pelanggan,
                e.alamat_pengirim,
                e.alamat_penerima,
                e.deskripsi_barang,
                e.no_resi,
                e.status_ekspedisi);
    }

    private static void printTableFooter() {
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");
        TitlePrinter.printTableE("~ ~~~ ~", Color.CYAN);
    }
}
