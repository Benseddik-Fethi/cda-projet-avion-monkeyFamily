package com.cda.model;


import javax.swing.*;

import java.awt.*;

public class MissileFeu {
    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private int dY = 3;
    private String strImage = "/images/missile-feu.png";
    private ImageIcon icoMissile;
    private Image imgMissile;

    public static int vitesse = 3;

    public MissileFeu(int x, int y, String strImage) {
        this.largeur = 50;
        this.hauteur = 70;
        this.x = x;
        this.y = y;
        this.strImage = strImage;
        this.icoMissile = new ImageIcon(getClass().getResource(strImage));
        this.imgMissile = this.icoMissile.getImage();


    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImgMissile() {
        return imgMissile;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStrImage(String strImage) {
        this.strImage = strImage;
    }

    public void setIcoMissile(ImageIcon icoMissile) {
        this.icoMissile = icoMissile;
    }

    public void setImgMissile(Image imgMissile) {
        this.imgMissile = imgMissile;
    }


    public static void setVitesse(int vitesse) {
        MissileFeu.vitesse = vitesse;
    }


    public int deplacementMissileFeu() {
        if (this.getY() < 700) {
            this.y = this.y + dY;
        }

        return this.getY();
    }
}
