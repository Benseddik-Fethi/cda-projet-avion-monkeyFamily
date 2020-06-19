package com.cda.model;

import com.cda.utils.Tools;

import javax.swing.*;

public class Vie extends Entite{


    public Vie() {
        this.largeur = 50;
        this.hauteur = 50;
        this.xPos = 20;
        this.yPos = 30;
        this.strImage = Constantes.IMAGE_VIE;
        this.icoMissile = new ImageIcon(getClass().getResource(super.strImage));
        this.imgMissile = this.icoMissile.getImage();
    }
}
