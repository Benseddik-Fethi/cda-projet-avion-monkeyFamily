package com.cda.model;

import javax.swing.ImageIcon;

import com.cda.utils.Tools;

public class Mine extends Entite {
	public Mine() {
		this.largeur = Constantes.LARGEUR_MISSILE;
		this.hauteur = Constantes.HAUTEUR_MISSILE;
		this.xPos = Tools.genererInt(0, 550);
		this.yPos = Constantes.POSITION_DEPART;
		this.dY = Constantes.VITESSE_CHUTE_MINES;
		this.strImage = Constantes.MINES;
		this.icoMissile = new ImageIcon(getClass().getResource(super.strImage));
		this.imgMissile = this.icoMissile.getImage();
	}
}
