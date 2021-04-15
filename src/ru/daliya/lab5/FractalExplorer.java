package ru.daliya.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ICC_ProfileRGB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {

	private int screenSize;
	private JImageDisplay display;
	private FractalGenerator fractalGenerator;
	private Rectangle2D.Double range;

	public FractalExplorer(int screenSize) {
		this.screenSize = screenSize;
		display = new JImageDisplay(screenSize, screenSize);
		fractalGenerator = new Mandelbrot();
		range = new Rectangle2D.Double();
		fractalGenerator.getInitialRange(range);
	}

	public static void main(String[] args) {
		FractalExplorer fractalExplorer = new FractalExplorer(500);
		fractalExplorer.createAndShowGUI();
	}

	public void createAndShowGUI() {
		// Создаем окно
		JFrame frame = new JFrame("Фракталы");
		frame.setSize(screenSize, screenSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Добавляем дисплей
		frame.getContentPane().add(display, BorderLayout.CENTER);

		// Добавляем кнопку
		Button reset = new Button("reset");
		reset.setSize(50, 30);
		reset.addActionListener(new JButtonClick());
		reset.setVisible(true);

		frame.getContentPane().add(reset, BorderLayout.SOUTH);

		// Раскрываем окно
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);

		// Добавляем слушателя на клики мыши по окну
		frame.addMouseListener(new JMouseAdapter());

		display.clearImage();

		drawFractal();
	}

	private void drawFractal() {
		for (int x = 0; x < screenSize; x++) {
			for (int y = 0; y < screenSize; y++) {
				double xCoord = fractalGenerator.getCoord(range.x, range.x + range.width, screenSize, x);
				double yCoord = fractalGenerator.getCoord(range.y, range.y + range.height, screenSize, y);

				int iterations = fractalGenerator.numIterations(xCoord, yCoord);

				int rgbColor = 0;

				if (iterations != -1) {
					float hue = 0.7f + (float) iterations / 200f;
					rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
				}

				display.drawPixel(x, y, rgbColor);
			}
		}

		display.repaint();
	}

	private class JMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			display.drawPixel(e.getX(), e.getY(), ICC_ProfileRGB.icSigGreenColorantTag);
			double x = fractalGenerator.getCoord(range.x, range.x + range.width, screenSize, e.getX());
			double y = fractalGenerator.getCoord(range.y, range.y + range.height, screenSize, e.getY());
			fractalGenerator.recenterAndZoomRange(range, x, y, 0.5);
			display.repaint();
			drawFractal();
		}
	}

	private class JButtonClick implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fractalGenerator.getInitialRange(range);
			drawFractal();
		}
	}

}



