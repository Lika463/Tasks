package ru.daliya.lab6;

import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends javax.swing.JComponent {
    private final BufferedImage bufferedImage;

    public JImageDisplay(int width, int height) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
    }

    public void clearImage() {

        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                drawPixel(x, y, 0);
            }
        }


    }

    void drawPixel(int x, int y, int rgbColor) {
        bufferedImage.setRGB(x, y, rgbColor);
    }

}
