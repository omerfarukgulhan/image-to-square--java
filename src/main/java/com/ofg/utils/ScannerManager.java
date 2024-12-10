package com.ofg.utils;

import java.util.Scanner;

public class ScannerManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getImagePath() {
        System.out.print("Enter the absolute path of the image you want to copy: ");
        return scanner.nextLine();
    }

    public static String getSquareColor() {
        System.out.print("Enter the square color: ");
        return scanner.nextLine();
    }
}
