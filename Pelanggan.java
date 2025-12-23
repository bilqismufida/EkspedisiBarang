
import Utility.Color;
import Utility.Labels;
import Utility.TitlePrinter;
import java.util.InputMismatchException;
import java.util.Scanner;

// =============================
//   CLASS CRUD PELANGGAN
// =============================
class Pelanggan {

    static Scanner input = new Scanner(System.in);

    // MENU CRUD
    public static void menuCrud() {
        int pilih;
        do {
            System.out.println("=== Menu Pelanggan ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Ubah Data");
            System.out.println("3. Pencarian Data");
            System.out.println("4. Sorting Data");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            System.out.println("======================");

            switch (pilih) {
                case 1:
                    tambahDataPelanggan();
                    break;
                case 2:
                    if (!Database.dataPelanggan.isEmpty()) {
                        pilihEditAtauHapus();
                    } else {
                        System.out.println(Labels.warning("Tidak ada data pelanggan"));
                    }
                    break;
                case 3:
                    cariDataPelanggan();
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

    // SIMPLE TABLE
    public static void tampilkanTableOnly() {
        printTableHeader();

        if (Database.dataPelanggan.isEmpty()) {
            System.out.println(
                    "|                TIDAK ADA DATA PELANGGAN                                                 |");
        } else {
            for (DataPelanggan p : Database.dataPelanggan) {
                printRow(p);
            }
        }

        printTableFooter();
    }

    // CREATE
    public static void tambahDataPelanggan() {
        System.out.println("\n=== TAMBAH DATA PELANGGAN ===");
        System.out.print("Nama Pelanggan: ");
        String nama = input.nextLine();
        System.out.print("Alamat: ");
        String alamat = input.nextLine();

        int telepon;
        while (true) {
            System.out.print("Nomor Telepon (cont. 08123): ");
            try {
                telepon = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(Labels.warning("Nomor telepon harus berupa angka!"));
                input.nextLine();
            }
        }

        System.out.print("Email: ");
        String email = input.next();

        System.out.println("=============================");

        int nextId = Database.getNextPelangganId();
        Database.dataPelanggan.add(new DataPelanggan(nextId, nama, alamat, telepon, email));
        System.out.println("\n" + Labels.success("Pelanggan berhasil ditambahkan!"));

        tampilkanTableOnly();
    }

    // READ — FULL TABLE
    public static void tampilkanDataPelanggan() {
        printTableHeader();

        if (Database.dataPelanggan.isEmpty()) {
            System.out.println(
                    "|                TIDAK ADA DATA PELANGGAN                                                 |");
        } else {
            for (DataPelanggan p : Database.dataPelanggan) {
                printRow(p);
            }
        }
        printTableFooter();

        menuCrud();
    }

    // SELECT
    public static void pilihEditAtauHapus() {
        tampilkanTableOnly();

        System.out.print("\nMasukkan ID Pelanggan: ");
        int id = input.nextInt();
        input.nextLine();

        DataPelanggan p = cariById(id);

        if (p == null) {
            System.out.println(Labels.id_not_found());
            return;
        }

        int pilih;
        do {
            System.out.println("\n=== Ubah Data Pelanggan ===");
            System.out.println("[ ID menu yang diedit: " + id + " ]");
            System.out.println("1. Edit Data");
            System.out.println("2. Hapus Data");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    editDataPelanggan(p);
                    break;
                case 2:
                    hapusDataPelanggan(p);
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

    //  UPDATE
    public static void editDataPelanggan(DataPelanggan p) {
        int pilih;
        do {
            System.out.println("========= Edit Menu =========");
            System.out.println("1. Nama");
            System.out.println("2. Alamat");
            System.out.println("3. No Telp");
            System.out.println("4. Email");
            System.out.println("0. Selesai");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama Baru: ");
                    p.nama = input.nextLine();
                    break;
                case 2:
                    System.out.print("Alamat Baru: ");
                    p.alamat = input.nextLine();
                    break;
                case 3:
                    while (true) {
                        try {
                            System.out.print("No Telp Baru: ");
                            p.telepon = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println(Labels.warning("Harus angka!"));
                            input.nextLine();
                        }
                    }
                    break;
                case 4:
                    System.out.print("Email Baru: ");
                    p.email = input.nextLine();
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
    public static void hapusDataPelanggan(DataPelanggan p) {
        System.out.print("Yakin hapus data ini? (y/n): ");
        String yn = input.nextLine();

        if (yn.equalsIgnoreCase("y")) {
            Database.dataPelanggan.remove(p);
            System.out.println(Labels.success("Data berhasil dihapus"));
            tampilkanTableOnly();
        } else {
            System.out.println(Labels.error("Penghapusan dibatalkan"));
        }
    }

    // SORTING
    public static void menuSorting() {
        int pilih;

        System.out.println("\n=== Sorting Data Pelanggan ===");
        System.out.println("1. Sorting berdasarkan ID");
        System.out.println("2. Sorting berdasarkan Nama (A-Z)");
        System.out.print("Pilih: ");
        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                sortById();
                break;
            case 2:
                sortByNama();
                break;
            default:
                System.out.println(Labels.opt_not_valid());
        }

        tampilkanTableOnly();
    }

    //SORT BY ID
    public static void sortById() {
        for (int i = 0; i < Database.dataPelanggan.size() - 1; i++) {
            for (int j = 0; j < Database.dataPelanggan.size() - i - 1; j++) {
                if (Database.dataPelanggan.get(j).id > Database.dataPelanggan.get(j + 1).id) {
                    DataPelanggan temp = Database.dataPelanggan.get(j);
                    Database.dataPelanggan.set(j, Database.dataPelanggan.get(j + 1));
                    Database.dataPelanggan.set(j + 1, temp);
                }
            }
        }
    }

    //SORT BY NAMA
    public static void sortByNama() {
        for (int i = 0; i < Database.dataPelanggan.size() - 1; i++) {
            for (int j = 0; j < Database.dataPelanggan.size() - i - 1; j++) {
                if (Database.dataPelanggan.get(j).nama
                        .compareToIgnoreCase(Database.dataPelanggan.get(j + 1).nama) > 0) {

                    DataPelanggan temp = Database.dataPelanggan.get(j);
                    Database.dataPelanggan.set(j, Database.dataPelanggan.get(j + 1));
                    Database.dataPelanggan.set(j + 1, temp);
                }
            }
        }
    }

    // SEARCH
    public static void cariDataPelanggan() {

        Scanner input = new Scanner(System.in);

        System.out.println("\n=== Pencarian Data Pelanggan ===");
        System.out.println("1. Pencarian Berdasarkan ID");
        System.out.println("2. Pencarian Berdasarkan Nama");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                System.out.print("Masukkan ID Pelanggan yang ingin dicari: ");
                int idPelanggan = input.nextInt();
                input.nextLine();
                DataPelanggan p = cariById(idPelanggan);
                printTableHeader();
                if (p != null) {
                    printRow(p);
                } else {
                    System.out.println(Labels.id_not_found());
                }
                printTableFooter();
                break;
            case 2:
                System.out.print("Masukkan Nama Pelanggan yang ingin dicari: ");
                String namaPelanggan = input.nextLine();
                DataPelanggan pByName = cariByNama(namaPelanggan);
                printTableHeader();
                if (pByName != null) {
                    printRow(pByName);
                } else {
                    System.out.println(Labels.data_not_found());
                }
                printTableFooter();
                break;
            default:
                System.out.println(Labels.opt_not_valid());
        }
    }

    public static DataPelanggan cariByNama(String nama) {
        for (DataPelanggan p : Database.dataPelanggan) {
            if (p.nama.toLowerCase().contains(nama.toLowerCase())) {
                return p;
            }

        }
        return null;

    }

    // SEARCH BY ID
    public static DataPelanggan cariById(int id) {
        for (DataPelanggan p : Database.dataPelanggan) {
            if (p.id == id) {
                return p;
            }

        }
        return null;
    }

    // TABEL UTILITY
    private static void printTableHeader() {
        TitlePrinter.print("Data Pelanggan", Color.CYAN);
        System.out
                .println("+----+----------------------+----------------------+---------------+----------------------+");
        System.out
                .println("| ID | Nama                 | Alamat               | No Telp       | Email                |");
        System.out
                .println("+----+----------------------+----------------------+---------------+----------------------+");
    }

    private static void printRow(DataPelanggan p) {
        System.out.printf("| %-2d | %-20s | %-20s | %-13d | %-20s |\n",
                p.id, p.nama, p.alamat, p.telepon, p.email);
    }

    private static void printTableFooter() {
        System.out
                .println("+-----------------------------------------------------------------------------------------+");
        TitlePrinter.print("~ ~ ~", Color.CYAN);
    }
}
