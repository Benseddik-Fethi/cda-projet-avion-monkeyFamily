package com.cda.model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Boutons extends JPanel {
	ImageIcon icoBouton;
	Image imgBouton;

	public Boutons(String pNomImage) {
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(200, 50);
		this.icoBouton = new ImageIcon(getClass().getResource(pNomImage));
		this.imgBouton = this.icoBouton.getImage();
	}

	public ImageIcon getIcoBouton() {
		return icoBouton;
	}

	public void setIcoBouton(ImageIcon icoBouton) {
		this.icoBouton = icoBouton;
	}

	public Image getImgBouton() {
		return imgBouton;
	}

	public void setImgBouton(Image imgBouton) {
		this.imgBouton = imgBouton;
	}
}
