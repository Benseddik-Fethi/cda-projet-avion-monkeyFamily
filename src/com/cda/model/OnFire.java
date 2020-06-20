package com.cda.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OnFire extends Entite {
    protected static boolean initialisationMissile = false;
    protected static ArrayList<Entite> missileTirDetruit = new ArrayList<>();
    protected int compteurTir = Constantes.NOMBRE_MISSILE_TIR_INIT;
    public Image i;

    public OnFire() {
        this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
        this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
        this.largeur = Constantes.LARGEUR_MISSILE_SECONDAIRE_AVION;
        this.hauteur = Constantes.HAUTEUR_MISSILE_AVION;
        this.dY = Constantes.DELTA_MISSILE_SECONDAIRE;
        ImageIcon ii = new ImageIcon(getClass().getResource("/images/trainee-avion.png"));
        i = ii.getImage();
    }

    public static Entite missileDetruit() {
        return new OnFire();
    }

    public static void initMissile() {
        if (initialisationMissile) {
            for (int i = 0; i < Constantes.NOMBRE_MISSILE_TIR_INIT; i++) {
                Constantes.MES_TIR_MISSILE.add(missileDetruit());
            }
            initialisationMissile = false;
        }
    }

    public int deplacementTirMissile() {
        if (this.tirMissile) {
            if (this.yPos > 900) {
                this.yPos = this.yPos;
                System.out.println("secondaire ok ");
            } else {
                this.tirMissile = false;
            }
        }
        return yPos;
    }

    public void tirMissileVaisseau(Graphics g) {
        if (this.tirMissile) {
            g.drawImage(i, this.xPos + 160, this.yPos + 100 + 50, 29, 37, null);
        }
    }
}