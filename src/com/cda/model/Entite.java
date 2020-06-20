package com.cda.model;

import com.cda.utils.Tools;

import javax.swing.*;
import java.awt.*;


public abstract class Entite {

    protected int vitesse;
    protected int largeur;
    protected int hauteur;
    protected int xPos;
    protected int yPos;
    protected int onfireXPos;
    protected int onfireYPos;
    protected int dY;
    protected int dX;
    protected String strImage;
    protected String missileDetruit;
    protected String strOnFire;
    protected ImageIcon icoOnFire;
    protected Image imgOnFire;
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


    public Image getImgVaisseau() {
        return imgVaisseau;
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

    public void setdX(int dX) {
        this.dX = dX;
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


    public Rectangle getBounds() {
        return new Rectangle(this.getxPos(), this.getyPos(), this.getLargeur() - 5, this.getHauteur() - 5);
    }

    public Rectangle getBoundsVaisseau() {
        return new Rectangle(this.getxPos(), this.getyPos(), this.getLargeur() - 20, this.getHauteur() - 10);
    }

    public int deplacementMissile() {
        if (this.getyPos() < 820 && !(this instanceof BombeZigZag)) {
            if (this instanceof Mine) {
                this.setyPos(this.yPos + Tools.genererInt(-1, 1));
                this.setxPos(this.xPos + Tools.genererInt(-1, 2));
            }
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