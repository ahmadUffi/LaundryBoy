package com.tubes;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MissionUtil {
    private static final Scanner scanner = new Scanner(System.in); // Satu instance Scanner

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

    public static String getStringInput() {
        return scanner.nextLine();
    }

    public static String moneyFormat(double price) {
        return NumberFormat.getInstance().format(price);
    }

    // Optional: Method to clear the console (not universally supported)
    public static void clearConsole() {
        // This is a simple way to simulate clearing the console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
