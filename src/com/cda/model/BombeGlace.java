package com.cda.model;

import com.cda.utils.Tools;

import javax.swing.*;

public class BombeGlace extends Entite {

    public BombeGlace() {
        this.largeur = Constantes.LARGEUR_MISSILE;
        this.hauteur = Constantes.HAUTEUR_MISSILE;
        this.xPos = Tools.genererInt(0, 550);
        this.yPos = Constantes.POSITION_DEPART;
        this.dY = Constantes.VITESSE_CHUTE_GLACE;
        this.strImage = Constantes.MISSILE_GLACE;
        this.icoMissile = new ImageIcon(getClass().getResource(super.strImage));
        this.imgMissile = this.icoMissile.getImage();
    }
}
