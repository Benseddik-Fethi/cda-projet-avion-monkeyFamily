package com.cda.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Entite {

	protected int vitesse;
	protected int largeur;
	protected int hauteur;
	protected int xPos;
	protected int yPos;
	protected int dY;
	protected int dX;
	protected String strImage;
	protected String missileDetruit;
	protected ImageIcon icoMissile;
	protected Image imgMissile;
	protected ImageIcon icoVaisseau;
	protected Image imgVaisseau;
	protected boolean detruit;
	protected boolean tirMissile;
	protected boolean mur = false;

	public boolean isTirMissile() {
		return tirMissile;
	}

	public void setTirMissile(boolean tirMissile) {
		this.tirMissile = tirMissile;
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

	public boolean isMur() {
		return mur;
	}

	public void setMur(boolean mur) {
		this.mur = mur;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
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

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getdY() {
		return dY;
	}

	public void setdY(int dY) {
		this.dY = dY;
	}

	public int getdX() {
		return dX;
	}

	public void setdX(int dX) {
		this.dX = dX;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

	public String getMissileDetruit() {
		return missileDetruit;
	}

	public void setMissileDetruit(String missileDetruit) {
		this.missileDetruit = missileDetruit;
	}

	public ImageIcon getIcoMissile() {
		return icoMissile;
	}

	public void setIcoMissile(ImageIcon icoMissile) {
		this.icoMissile = icoMissile;
	}

	public Image getImgMissile() {
		return imgMissile;
	}

	public void setImgMissile(Image imgMissile) {
		this.imgMissile = imgMissile;
	}

	public boolean isDetruit() {
		return detruit;
	}

	public void setDetruit(boolean detruit) {
		this.detruit = detruit;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.getxPos(), this.getyPos(), this.getLargeur() - 5, this.getHauteur() - 5);
	}

	public int deplacementMissile() {
		if (this.getyPos() < 820 && !(this instanceof BombeZigZag)) {
			this.setyPos(this.yPos + this.dY);
		} else if (this.getyPos() < 820 && (this instanceof BombeZigZag) && mur) {
			this.setyPos(this.yPos + this.dY);
			this.setxPos(this.xPos - 1);

			if (this.xPos == -5) {
				mur = false;
			}
		} else if (this.getyPos() < 820 && (this instanceof BombeZigZag) && !mur) {
			this.setyPos(this.yPos + this.dY);
			this.setxPos(this.xPos + 1);
			if (this.xPos == 560) {
				mur = true;
			}
		} else {
			this.detruit = true;
		}
		return this.getyPos();
	}

	public int deplacementTirMissile() {
		if (this.tirMissile) {
			if (this.yPos > 0) {
				this.yPos = this.yPos - Constantes.DELTA_MISSILE;
			} else {
				this.tirMissile = false;
			}
		}
		return yPos;
	}
}