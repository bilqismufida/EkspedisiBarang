package Utility;

public class Labels {
    private Labels() {}

    public static String bold(String msg) {
        return Color.ANSI_BOLD + msg + Color.ANSI_RESET_BOLD;
    }

    public static String warning(String msg) {
        return Color.ANSI_YELLOW + "[!] " + msg + Color.ANSI_RESET;
    }

    public static String success(String msg) {
        return Color.ANSI_GREEN + "[OK] " + msg + Color.ANSI_RESET;
    }

    public static String error(String msg) {
        return Color.ANSI_RED + "[X] " + msg + Color.ANSI_RESET;
    }

    public static String opt_not_valid() {
        return "\n" + Color.ANSI_RED + "[X] Opsi Tidak Valid" + Color.ANSI_RESET;
    }
    public static String id_not_found() {
        return "\n" + Color.ANSI_RED + "[X] ID tidak ditemukan" + Color.ANSI_RESET;
    }
    public static String data_not_found() {
        return "\n" + Color.ANSI_RED + "[X] Data tidak ditemukan" + Color.ANSI_RESET;
    }
}

