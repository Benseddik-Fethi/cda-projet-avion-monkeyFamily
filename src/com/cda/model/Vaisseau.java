package com.cda.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Vaisseau extends Entite {
	ImageIcon ii;
	Image i;

	public Vaisseau() {
		this.hauteur = Constantes.HAUTEUR_AVION;
		this.largeur = Constantes.LARGEUR_AVION;
		this.xPos = 250;
		this.yPos = 750;
		this.strImage = Constantes.AVION_TOP;
		this.icoVaisseau = new ImageIcon(getClass().getResource(strImage));
		this.imgVaisseau = this.icoVaisseau.getImage();
	}

	public int deplacementVaisseauHorizontal() {
		if (dX > 0 && this.getxPos() < 500) {
			this.xPos = this.xPos + dX;
			this.icoVaisseau = new ImageIcon(getClass().getResource(Constantes.AVION_RIGHT));
			this.imgVaisseau = this.icoVaisseau.getImage();
		} else if (dX < 0 && this.getxPos() > 0) {
			this.xPos = this.xPos + dX;
			this.icoVaisseau = new ImageIcon(getClass().getResource(Constantes.AVION_LEFT));
			this.imgVaisseau = this.icoVaisseau.getImage();
		} else {
			this.icoVaisseau = new ImageIcon(getClass().getResource(Constantes.AVION_TOP));
			this.imgVaisseau = this.icoVaisseau.getImage();
		}
		return this.getxPos();
	}

	public int deplacementVaisseauVertical() {
		if (dY > 0 && this.getyPos() < 680) {
			this.yPos = this.yPos + dY;
		} else if (dY < 0 && this.getyPos() > 15) {
			this.yPos = this.yPos + dY;
		}
		return this.getyPos();
	}
}