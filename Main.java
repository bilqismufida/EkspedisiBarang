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
                    Pelanggan.tampilkanDataPelanggan();
                    break;
                case 2: 
                    Ekspedisi.tampilkanDataEkspedisi();
                    break;
                case 0:
                    TitlePrinter.sampaiJumpa();
                    System.exit(0);
                default: System.out.println(Labels.opt_not_valid());
            }
        } while (pilih != 0);
    }
}
