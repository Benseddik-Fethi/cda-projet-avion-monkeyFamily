package com.cda.model;

import javax.swing.*;
import java.awt.*;

public class Ombre extends Entite {

	public Ombre() {
		this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
		this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
		this.largeur = 42;
		this.hauteur = 45;
		this.dY = Constantes.VITESSE_VAISSEAU;
		this.icoMissile = new ImageIcon(getClass().getResource("/images/ombre-avion.png"));
		this.imgMissile = icoMissile.getImage();
	}

	public void initOmbre(Graphics g) {
		g.drawImage(imgMissile, TableauDeBord.vaisseau.xPos - 80, TableauDeBord.vaisseau.yPos, 42, 45, null);
	}
}