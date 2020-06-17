package com.cda.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Vaisseau {
	public static int dX = 0;
	public static int dY = 0;
	private int largeur;
	private int hauteur;
	private static int x;
	private static int y;

	private String strImage;
	private ImageIcon icoVaisseau;
	private Image imgVaisseau;

	public Vaisseau(int x, int y, String strImage) {
		this.largeur = 10;
		this.hauteur = 10;
		Vaisseau.x = x;
		Vaisseau.y = y;
		this.strImage = strImage;
		this.icoVaisseau = new ImageIcon(getClass().getResource(strImage));
		this.imgVaisseau = this.icoVaisseau.getImage();

	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public static int getX() {
		return x;
	}

	public void setX(int x) {
		Vaisseau.x = x;
	}

	public static int getY() {
		return y;
	}

	public void setY(int y) {
		Vaisseau.y = y;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

	public ImageIcon getIcoVaisseau() {
		return icoVaisseau;
	}

	public void setIcoVaisseau(ImageIcon icoVaisseau) {
		this.icoVaisseau = icoVaisseau;
	}

	public Image getImgVaisseau() {
		return imgVaisseau;
	}

	public void setImgVaisseau(Image imgVaisseau) {
		this.imgVaisseau = imgVaisseau;
	}

	public int deplacementVaisseauHorizontal() {
		if (dX > 0) {
			if (x < 500) {
				Vaisseau.x = Vaisseau.x + dX;
				this.icoVaisseau = new ImageIcon(getClass().getResource(Constantes.AVION_RIGHT));
				this.imgVaisseau = this.icoVaisseau.getImage();
			}
		} else if (dX < 0) {
			if (x > 0) {
				Vaisseau.x = Vaisseau.x + dX;
				this.icoVaisseau = new ImageIcon(getClass().getResource(Constantes.AVION_LEFT));
				this.imgVaisseau = this.icoVaisseau.getImage();
			}
		} else {
			this.icoVaisseau = new ImageIcon(getClass().getResource(Constantes.AVION_TOP));
			this.imgVaisseau = this.icoVaisseau.getImage();
		}
		return Vaisseau.getX();
	}

	public int deplacementVaisseauVertical() {
		if (dY > 0) {
			if (y < 680) {
				Vaisseau.y = Vaisseau.y + dY;
			}
		} else if (dY < 0) {
			if (y > 20) {
				Vaisseau.y = Vaisseau.y + dY;
			}
		}
		return Vaisseau.getY();
	}
}
