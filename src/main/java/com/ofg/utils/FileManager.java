package com.ofg.utils;

import java.io.File;

public class FileManager {
    public static File checkIfFileExists(String imagePath) {
        File originalFile = new File(imagePath);
        if (!originalFile.exists()) {
            throw new RuntimeException("The file does not exist at the specified path.");
        }
        return originalFile;
    }

    public static void checkIfFileExists(File newFile) {
        if (newFile.exists()) {
            throw new RuntimeException("The file with this name already exists in the target folder.");
        }
    }

    public static String getFileExtension(File originalFile) {
        String fileName = originalFile.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex <= 0) {
            throw new RuntimeException("The file does not have a extension.");
        }
        return fileName.substring(dotIndex);
    }

    public static File createFolderToSaveImage() {
        String parentDirectory = new File("").getAbsolutePath();
        File newFolder = new File(parentDirectory, "images/output");
        if (!newFolder.exists()) {
            newFolder.mkdirs();
        }
        return newFolder;
    }
}
