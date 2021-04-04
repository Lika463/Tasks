package ru.daliya.lab4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends javax.swing.JComponent {
    private BufferedImage image;

    public JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        super.setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void clearImage() {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                drawPixel(x, y, 0);
            }
        }
    }

    void drawPixel(int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }

}
