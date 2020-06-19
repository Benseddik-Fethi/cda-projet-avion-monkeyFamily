package com.cda.model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bouclier extends Entite {
	ImageIcon ii;
	Image i;

	public Bouclier() {
		this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
		this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
		this.largeur = 160;
		this.hauteur = 160;
		this.dY = Constantes.DELTA_MISSILE_SECONDAIRE;
		ii = new ImageIcon(getClass().getResource("/images/bouclier.png"));
		i = ii.getImage();
	}

	public void initBouclier(Graphics g) {
		if (this.tirMissile) {
			System.out.println("bouclier");
			g.drawImage(i, this.xPos, this.yPos, 160, 160, null);
		}
	}
}