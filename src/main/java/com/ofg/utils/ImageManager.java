package com.ofg.utils;

import java.io.*;

public class ImageManager {
    public static void saveImage(File originalFile, File newFile) {
        try (InputStream inputStream = new FileInputStream(originalFile);
             OutputStream outputStream = new FileOutputStream(newFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File saved successfully as: " + newFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}
