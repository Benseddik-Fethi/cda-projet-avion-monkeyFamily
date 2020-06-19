package com.cda.model;

import javax.swing.*;
import java.awt.*;

public class Bouclier extends Entite {
    protected static ImageIcon ii;
    protected static Image i;
    public static boolean actif = false;

    public Bouclier() {
        this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
        this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
        this.largeur = 160;
        this.hauteur = 160;
        this.dY = Constantes.VITESSE_VAISSEAU;
        ii = new ImageIcon(getClass().getResource("/images/bouclier.png"));
        i = ii.getImage();
    }

    public void initBouclier(Graphics g) {
        if (actif) {
            System.out.println("bouclier");
            g.drawImage(i, TableauDeBord.vaisseau.xPos - 30, TableauDeBord.vaisseau.yPos - 30, 160, 160, null);
        }
    }

}