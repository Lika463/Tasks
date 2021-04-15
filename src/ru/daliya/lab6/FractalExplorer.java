package ru.daliya.lab6;

import ru.daliya.lab6.fractals.BurningShip;
import ru.daliya.lab6.fractals.Mandelbrot;
import ru.daliya.lab6.fractals.Tricorn;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.color.ICC_ProfileRGB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;

public class FractalExplorer {

    private final int screenSize;
    private final JImageDisplay display;
    private FractalGenerator fractalGenerator;
    private final Rectangle2D.Double range;
    private JFrame frame;
    private Button buttonReset;
    private Button buttonSaveImage;
    private JComboBox<FractalGenerator> comboBox;

    private int rowsRemaining;
    private boolean interfaceEnabled;

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
        // Кнопка сброса
        buttonReset = new Button("Reset");
        buttonReset.setSize(screenSize / 3, 50);
        buttonReset.addActionListener(new JButtonClick());
        buttonReset.setVisible(true);

        // Кнопка сохранения фрактала
        buttonSaveImage = new Button("Save Image");
        buttonSaveImage.setSize(screenSize / 3, 50);
        buttonSaveImage.addActionListener(new ButtonSaveClick());
        buttonSaveImage.setVisible(true);

        // Создание фракталов
        Mandelbrot MandelbrotFractal = new Mandelbrot();
        BurningShip BurningShipFractal = new BurningShip();
        Tricorn TricornFractal = new Tricorn();

        // Комбобокс выбора фракталов
        comboBox = new JComboBox<>();
        comboBox.addItem(MandelbrotFractal);
        comboBox.addItem(BurningShipFractal);
        comboBox.addItem(TricornFractal);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FractalGenerator newFractal = (FractalGenerator) comboBox.getSelectedItem();
                if (newFractal != null) {
                    fractalGenerator = newFractal;
                    newFractal.getInitialRange(range);
                    drawFractal();
                }
            }
        });

        // Панель вывода компонентов интерфейса
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Настройка размещения элементов интерфейса на форме
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(display)
                .addComponent(comboBox)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonReset)
                        .addComponent(buttonSaveImage))

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(comboBox)
                .addComponent(display)
                .addGroup(layout.createParallelGroup()
                        .addComponent(buttonReset)
                        .addComponent(buttonSaveImage)
                )
        );

        // Очищаем картинку
        display.clearImage();

        // Инициализация окна
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(screenSize, screenSize));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addMouseListener(new JMouseAdapter());

        // Рисуем фрактал
        this.drawFractal();
    }


    private class JMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            display.drawPixel(e.getX(), e.getY(), ICC_ProfileRGB.icSigGreenColorantTag);
            double x = FractalGenerator.getCoord(range.x, range.x + range.width, screenSize, e.getX());
            double y = FractalGenerator.getCoord(range.y, range.y + range.height, screenSize, e.getY());
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

    private class ButtonSaveClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser dialog = new JFileChooser();
			if (dialog.showSaveDialog(frame) != JFileChooser.APPROVE_OPTION) {
				return;
			}

			File file = dialog.getSelectedFile();
			FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
			dialog.setFileFilter(filter);
			dialog.setAcceptAllFileFilterUsed(false);
			try {
				javax.imageio.ImageIO.write(display.getBufferedImage(), "png", file);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(frame, "Возникли проблемы при сохранении картинки!" + exception.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
		}
    }

    private class FractalWorker extends SwingWorker<Object, Object>{
        int y;
        int[] colorArray;
        FractalWorker(int y){
            this.y = y;
        }
        @Override
        protected Object doInBackground() throws Exception {
            colorArray = new int[display.getWidth()];

            double xCoordinate, yCoordinate;
            int iterations;
            float hue;
            int rgbColor;
            for (int x = 0; x < display.getWidth(); x++){
                xCoordinate = fractalGenerator.getCoord(range.x, range.x + range.width, screenSize, x);
                yCoordinate = fractalGenerator.getCoord(range.y, range.y + range.height, screenSize, y);
                iterations = fractalGenerator.numIterations(xCoordinate, yCoordinate);
                if (iterations != -1) {
                    hue = 0.7f + (float) iterations / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                } else {
                    rgbColor = 0;
                }
                colorArray[x] = rgbColor;
            }
            return null;
        }

        @Override
        protected void done() {
            for (int x = 0; x < display.getWidth(); x++){
                display.drawPixel(x, y, colorArray[x]);
            }
            display.repaint(0, 0, y, display.getWidth(), 1);
            rowsRemaining--;
            if (rowsRemaining == 0){
                enableUI(true);
            }
        }
    }

    public void enableUI(boolean value){
        buttonSaveImage.setEnabled(value);
        buttonReset.setEnabled(value);
        comboBox.setEnabled(value);
        interfaceEnabled = value;
    }

    private void drawFractal(){
        rowsRemaining = display.getHeight();
        enableUI(false);
        for (int counter = 0; counter < display.getHeight(); counter+=4){
            FractalWorker worker1 = new FractalWorker(counter);
            FractalWorker worker2 = new FractalWorker(counter+1);
            FractalWorker worker3 = new FractalWorker(counter+2);
            FractalWorker worker4 = new FractalWorker(counter+3);
            worker1.execute();
            worker2.execute();
            worker3.execute();
            worker4.execute();
        }

    }
}



