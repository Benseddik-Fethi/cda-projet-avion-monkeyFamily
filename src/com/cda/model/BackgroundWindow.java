package com.cda.model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundWindow extends JPanel {
	private final int HAUTEUR = 400;
	public int yFond;
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;

	public BackgroundWindow(MaFenetre vMaFenetre) {
		this.yFond = 400;
		setBounds(vMaFenetre.getX(), vMaFenetre.getY(), vMaFenetre.getWidth(), vMaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource("/images/fond.jpg"));
		this.imgBandeFond = this.icoBandeFond.getImage();
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();

	}

	private void deplacementFond(Graphics g) {
		if (yFond == MaFenetre.FENETRE_HEIGHT) {
			yFond = 400;
		}
		g.drawImage(this.imgBandeFond, 0, this.yFond, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR * 2, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR * 3, null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		deplacementFond(g);
	}
}