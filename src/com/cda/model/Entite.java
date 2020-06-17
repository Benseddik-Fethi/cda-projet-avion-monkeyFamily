package com.cda.model;

import javax.swing.*;
import java.awt.*;

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
    protected boolean detruit;
    protected boolean mur = false;

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

    public int deplacementMissile() {
        if (this.getyPos() < 820 && !(this instanceof MissileZigZag)) {
            this.yPos = this.yPos + this.dY;
        } else if (this.getyPos() < 820 && (this instanceof MissileZigZag) && mur) {
            this.yPos = this.yPos + this.dY;
            this.xPos = this.xPos - 1;

            if (this.xPos == -5) {
                mur = false;
            }
        } else if (this.getyPos() < 820 && (this instanceof MissileZigZag) && !mur) {
            this.yPos = this.yPos + this.dY;
            this.xPos = this.xPos + 1;
            if (this.xPos == 560) {
                mur = true;
            }
        } else {
            this.detruit = true;
        }
        return this.getyPos();
    }

    public boolean missileDetruit(Entite vEntite) {
        if (this.yPos < vEntite.getyPos() + vEntite.getHauteur()
                && this.yPos + this.hauteur > vEntite.getyPos()
                && this.xPos + this.hauteur > vEntite.getxPos()
                && this.xPos < vEntite.getxPos() + vEntite.getLargeur()) {
            return true;
        } else {
            return false;
        }

    }
}