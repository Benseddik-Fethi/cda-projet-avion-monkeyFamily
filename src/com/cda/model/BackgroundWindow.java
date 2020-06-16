package com.cda.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundWindow extends JPanel {
	BufferedImage img;

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
