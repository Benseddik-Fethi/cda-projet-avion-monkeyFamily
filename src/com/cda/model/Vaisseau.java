package com.cda.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Vaisseau extends JPanel {
    public static final String img1 = "/images/avion-top.png";
    public static int x = 0;
    public static int y = 0;
    BufferedImage img;

    public Vaisseau() {
        chargerImag(img1);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, x, y, 100, 100, this);
    }

    public void chargerImag(String vImg) {
        try {
            img = ImageIO.read(Vaisseau.class.getResource(vImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}