
import Utility.AsciiArt;
import Utility.Color;
import Utility.Labels;
import Utility.TitlePrinter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            AsciiArt.ekspedisi();
            TitlePrinter.print("Sistem Ekspedisi Barang", Color.GREEN);

            System.out.println("1. Kelola Data Pelanggan");
            System.out.println("2. Kelola Data Ekspedisi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilih = input.nextInt();
            input.nextLine();

            TitlePrinter.print("~ ~ ~", Color.GREEN);

            switch (pilih) {
                case 1:
                    // dataDummy();
                    Pelanggan.tampilkanDataPelanggan();
                    break;
                case 2:
                    Ekspedisi.tampilkanDataEkspedisi();
                    break;
                case 0:
                    TitlePrinter.sampaiJumpa();
                    System.exit(0);
                default:
                    System.out.println(Labels.opt_not_valid());
            }
        } while (pilih != 0);
    }

    // public static void dataDummy() {
    //     Database.dataPelanggan[0] = new DataPelanggan(1, "Andi", "Bandung", 8123456, "andi@gmail.com");
    //     Database.dataPelanggan[1] = new DataPelanggan(2, "Budi", "Jakarta", 8134567, "budi@gmail.com");
    //     Database.dataPelanggan[2] = new DataPelanggan(3, "Citra", "Surabaya", 8145678, "citra@gmail.com");
    //     Database.dataEkspedisi[0] = new DataEkspedisi(1, 3, "Bandung", "Jakarta",  "fragile", "REG", "REG-ABC1", "Sedang dikirim");
    //     Database.dataEkspedisi[1] = new DataEkspedisi(2, 3, "Jakarta", "Jakarta", "fragile","EXP", "EXP-ABC1", "Sedang dikirim");
    //     Database.dataEkspedisi[2] = new DataEkspedisi(3, 1, "Surabaya", "Jakarta", "fragile","ECO", "ECO-ABC1", "Sedang dikirim");

    //     Database.jumlahPelanggan = 3;
    //     Database.jumlahEkspedisi = 3;
    // }

}
