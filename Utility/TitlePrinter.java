package Utility;

public class TitlePrinter {

    public static void print(String title, String color) {
        int WIDTH = 90;
        String cleanTitle = title.toUpperCase();
        String text = " " + cleanTitle + " ";

        int side = (WIDTH - text.length()) / 2;
        if (side < 0) side = 0;

        String line = "~".repeat(side);

        System.out.println(
            color + Color.BOLD +
            line + text + line +
            Color.RESET
        );
    }
    public static void printTableE(String title, String color) {
        int WIDTH = 135;
        String cleanTitle = title.toUpperCase();
        String text = " " + cleanTitle + " ";

        int side = (WIDTH - text.length()) / 2;
        if (side < 0) side = 0;

        String line = "~".repeat(side);

        System.out.println(
            color + Color.BOLD +
            line + text + line +
            Color.RESET
        );
    }

    public static void sub(String subtitle, String color) {
        System.out.println(
            color + ">> " + subtitle + Color.RESET
        );
    }

    
     public static void sampaiJumpa() {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("        TERIMA KASIH TELAH MENGGUNAKAN");
        System.out.println("            SISTEM EKSPEDISI BARANG");
        System.out.println("===============================================");
        System.out.println();
    }
}
