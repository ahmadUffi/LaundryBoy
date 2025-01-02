package com.tubes;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MissionUtil {
    private static final Scanner scanner = new Scanner(System.in); // Satu instance Scanner

    // ==== Fungsi intInput baru ====
    public static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // public static int getIntInput() {
    //     while (true) {
    //         String input = scanner.nextLine().trim(); // Membaca input sebagai string
    //         try {
    //             // Memastikan input adalah angka
    //             if (input.matches("\\d+")) { // Hanya menerima digit
    //                 return Integer.parseInt(input);
    //             } else {
    //                 System.out.println("Input tidak valid. Silakan masukkan angka.");
    //             }
    //         } catch (NumberFormatException e) {
    //             System.out.println("Input tidak valid. Silakan masukkan angka.");
    //         }
    //     }
    // }
    
    public static double getDoubleInput() {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka desimal.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // ==== Fungsi StringInput baru ====
    public static String getStringInput() {
        while (true) {
            String input = scanner.nextLine().trim(); // Menghapus spasi di awal dan akhir
            if (input.isEmpty()) { // Mengecek apakah input kosong
                System.out.println("Input tidak boleh kosong. Silakan masukkan teks yang valid.");
            } else if (input.matches("\\d+")) { // Mengecek apakah input hanya berupa angka
                System.out.println("Input tidak valid. Silakan masukkan teks tanpa angka.");
            } else {
                return input;
            }
        }
    }
    
    // public static String getStringInput() {
    //     return scanner.nextLine();
    // }

    // public static String moneyFormat(double price) {
    //     return NumberFormat.getInstance().format(price);
    // }

    // ==== Fungsi moneyFormat baru ====
    public static String moneyFormat(double price) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String formattedPrice = currencyFormatter.format(price);
        
        return formattedPrice.replace("Rp", "IDR ").replace(",00", ".00");
    }

    

    // Optional: Method to clear the console (not universally supported)
    public static void clearConsole() {
        // This is a simple way to simulate clearing the console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

















public static String getStringNoHpBisnisInput() {
    return scanner.nextLine();
}
}