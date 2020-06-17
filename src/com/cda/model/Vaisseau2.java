package com.cda.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Vaisseau2 implements Runnable {
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private String strImage;
	private ImageIcon icoVaisseau;
	private Image imgVaisseau;
	private static final int VITESSE = 20;

	public Vaisseau2(int x, int y, String strImage) {
		this.largeur = 10;
		this.hauteur = 10;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.icoVaisseau = new ImageIcon(getClass().getResource(this.strImage));
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

	public void monte() {
		this.y -= VITESSE;
	}

	public void descend() {
		this.y += VITESSE;
	}

	public void droite() {
		this.x += VITESSE;
	}

	public void gauche() {
		this.x -= VITESSE;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
