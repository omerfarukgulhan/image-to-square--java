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
            File originalFile = FileManager.checkIfFileExists(imagePath);
            String fileExtension = FileManager.getFileExtension(originalFile);
            String fileNameWithoutExtension = originalFile.getName().replace("." + fileExtension, "");
            String newImageName = fileNameWithoutExtension + "-squared." + fileExtension;
            File newFolder = FileManager.createFolderToSaveImage();
            File newFile = new File(newFolder, newImageName + fileExtension);
            FileManager.checkIfFileExists(newFile);
            ImageManager.saveImage(originalFile, newFile);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}