package com.cda.model;

import com.cda.utils.Tools;

import javax.swing.*;

public class BombeZigZag extends Entite {
    public BombeZigZag() {

        this.largeur = Constantes.LARGEUR_MISSILE;
        this.hauteur = Constantes.HAUTEUR_MISSILE;
        this.xPos = Tools.genererInt(80, 520);
        this.yPos = Constantes.POSITION_DEPART;
        this.dY = Constantes.VITESSE_CHUTE_ZIGZAG;
        this.strImage = Constantes.MISSILE_ZIGZAG;
        this.icoMissile = new ImageIcon(getClass().getResource(super.strImage));
        this.imgMissile = this.icoMissile.getImage();
    }

    public  void choixImage(boolean vChoix){
        if(this.mur){
            this.icoMissile = new ImageIcon(getClass().getResource(Constantes.MISSILE_ZIGZAG_DROITE));
            this.imgMissile = this.icoMissile.getImage();
        }else {
            this.icoMissile = new ImageIcon(getClass().getResource(Constantes.MISSILE_ZIGZAG_GAUCHE));
            this.imgMissile = this.icoMissile.getImage();
        }

    }
}
