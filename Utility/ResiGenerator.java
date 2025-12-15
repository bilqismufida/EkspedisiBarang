package Utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ResiGenerator {

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOM_LENGTH = 4;

    public static String generateResi(String jenisLayanan) {
        // 1. Service code (REG / EXP / etc)
        String serviceCode = jenisLayanan
                .substring(0, Math.min(3, jenisLayanan.length()))
                .toUpperCase();

        // 2. Current date (YYYYMMDD)
        String date = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 3. Random alphanumeric
        String randomPart = generateRandomString(RANDOM_LENGTH);

        // 4. Combine
        return serviceCode + "-" + date + "-" + randomPart;
    }

    private static String generateRandomString(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(CHAR_POOL.charAt(rand.nextInt(CHAR_POOL.length())));
        }

        return sb.toString();
    }
}
