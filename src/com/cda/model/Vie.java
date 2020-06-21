package com.cda.model;

import javax.swing.ImageIcon;

public class Vie extends Entite {

	public Vie() {
		this.largeur = 50;
		this.hauteur = 50;
		this.xPos = 25;
		this.yPos = 22;
		this.strImage = Constantes.IMAGE_ICONE_VIES;
		this.icoMissile = new ImageIcon(getClass().getResource(super.strImage));
		this.imgMissile = this.icoMissile.getImage();
	}
}
