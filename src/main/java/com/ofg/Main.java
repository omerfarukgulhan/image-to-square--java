package com.ofg;

import com.ofg.utils.FileManager;
import com.ofg.utils.ImageManager;
import com.ofg.utils.ScannerManager;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String imagePath = ScannerManager.getImagePath();
            String squareColor = ScannerManager.getSquareColor();
            File originalFile = FileManager.getFileToSquare(imagePath);
            String fileExtension = FileManager.getFileExtension(originalFile);
            String newImageName = FileManager.getBaseFileName(originalFile) + "-squared" + "-" + squareColor;
            File outputFolder = FileManager.createFolderToSaveImage();
            File newFile = new File(outputFolder, newImageName + fileExtension);
            FileManager.checkIfFileExists(newFile);
            ImageManager.addBarsToImage(originalFile, newFile, squareColor);
            System.out.println("Image successfully squared and saved to: " + newFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}