package com.cda.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundWindow extends JPanel {
    BufferedImage img;
    public static final String img1 = "/imgs/pacOuvert.png";

    public BackgroundWindow(MaFenetre vMaFenetre) {
        setBounds(vMaFenetre.getX(), vMaFenetre.getY(), vMaFenetre.getWidth(), vMaFenetre.getHeight());
        setBackground(Color.green);
        setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    public void chargerImag(String vImg) {
        try {
            img = ImageIO.read(BackgroundWindow.class.getResource(vImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
