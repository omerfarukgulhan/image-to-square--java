package com.ofg.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageManager {
    public static void addBarsToImage(File originalFile, File newFile, String squareColor) throws Exception {
        BufferedImage originalImage = loadImage(originalFile);
        int maxDimension = calculateMaxDimension(originalImage);
        BufferedImage squaredImage = createSquaredImage(originalImage, maxDimension, parseColor(squareColor));
        saveSquaredImage(squaredImage, newFile);
    }

    private static BufferedImage loadImage(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        if (image == null) {
            throw new IllegalArgumentException("Invalid image file: " + file.getAbsolutePath());
        }
        return image;
    }

    private static int calculateMaxDimension(BufferedImage image) {
        return Math.max(image.getWidth(), image.getHeight());
    }

    private static BufferedImage createSquaredImage(BufferedImage originalImage, int maxDimension, Color backgroundColor) {
        BufferedImage squaredImage = new BufferedImage(maxDimension, maxDimension, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = squaredImage.createGraphics();

        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, maxDimension, maxDimension);

        int x = (maxDimension - originalImage.getWidth()) / 2;
        int y = (maxDimension - originalImage.getHeight()) / 2;
        g2d.drawImage(originalImage, x, y, null);
        g2d.dispose();

        return squaredImage;
    }

    private static Color parseColor(String squareColor) {
        try {
            return Color.decode(squareColor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid color format. Please use hex format, e.g., #FFFFFF.");
        }
    }

    private static void saveSquaredImage(BufferedImage squaredImage, File newFile) throws IOException {
        String formatName = FileManager.getFileExtension(newFile).substring(1).toLowerCase();
        if (!ImageIO.write(squaredImage, formatName, newFile)) {
            throw new RuntimeException("Failed to save the squared image. Unsupported format: " + formatName);
        }
    }
}
