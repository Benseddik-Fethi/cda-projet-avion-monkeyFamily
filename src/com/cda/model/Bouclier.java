package com.cda.model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bouclier extends Entite {
	protected static ImageIcon ii;
	protected static Image i;
	public static boolean actif = false;
	public static int NbreBouclier = 4;

	public Bouclier() {
		this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
		this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
		this.largeur = 160;
		this.hauteur = 160;
		this.dY = Constantes.VITESSE_VAISSEAU;
		this.icoMissile = new ImageIcon(getClass().getResource("/images/bouclier.png"));
		this.imgMissile = icoMissile.getImage();
	}

	public void initBouclier(Graphics g) {
		if (actif && NbreBouclier > 0) {
			Bouclier.gestionBouclier();
			g.drawImage(imgMissile, TableauDeBord.vaisseau.xPos - 30, TableauDeBord.vaisseau.yPos - 30, 160, 160, null);
		}
	}

	public static void gestionBouclier() {
		String vieUtilisé = "";
		if (NbreBouclier == 3) {
			ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(vieUtilisé));
			Image imgMissile = icoMissile.getImage();
			TableauDeBord.bouclier3.setImgMissile(imgMissile);
		}
		if (NbreBouclier == 2) {
			ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(vieUtilisé));
			Image imgMissile = icoMissile.getImage();
			TableauDeBord.bouclier2.setImgMissile(imgMissile);
		}
		if (NbreBouclier == 1) {
			ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(vieUtilisé));
			Image imgMissile = icoMissile.getImage();
			TableauDeBord.bouclier1.setImgMissile(imgMissile);
		}
	}

	public static void setNbreBouclier(int nbreBouclier) {
		NbreBouclier = nbreBouclier;
	}
}