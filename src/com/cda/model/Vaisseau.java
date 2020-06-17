package com.cda.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Vaisseau {
	public static final String img1 = "/images/avion-top.png";
	public static int dX = 0;
	public static int dY = 0;
	private int largeur;
	private int hauteur;
	private int x;
	private int y;

	private String strImage;
	private ImageIcon icoVaisseau;
	private Image imgVaisseau;

	public Vaisseau(int x, int y, String strImage) {
		this.largeur = 10;
		this.hauteur = 10;
		this.x = x;
		this.y = y;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
			this.x = this.x + dX;
			this.icoVaisseau = new ImageIcon(getClass().getResource("/images/avion-right.png"));
			this.imgVaisseau = this.icoVaisseau.getImage();

		} else if (dX < 0) {
			this.x = this.x + dX;
			this.icoVaisseau = new ImageIcon(getClass().getResource("/images/avion-left.png"));
			this.imgVaisseau = this.icoVaisseau.getImage();
		} else {
			this.icoVaisseau = new ImageIcon(getClass().getResource("/images/avion-top.png"));
			this.imgVaisseau = this.icoVaisseau.getImage();
		}
		return this.getX();
	}

	public int deplacementVaisseauVertical() {
		if (dY > 0) {
			this.y = this.y + dY;

		} else if (dY < 0) {
			this.y = this.y + dY;
		}

		return this.getY();
	}
}
