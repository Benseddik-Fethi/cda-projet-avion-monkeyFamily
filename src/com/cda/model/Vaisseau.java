package com.cda.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Vaisseau extends JPanel {
	BufferedImage img;
	public static final String img1 = "/avion-top.png";
	public static int x = 250;
	public static int y = 650;

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