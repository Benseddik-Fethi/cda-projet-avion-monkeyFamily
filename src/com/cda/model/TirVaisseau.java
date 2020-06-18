package com.cda.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TirVaisseau extends Entite {
    protected static boolean initialisationMissile = false;
    protected static ArrayList<Entite> missileTirDetruit = new ArrayList<>();
    protected int compteurTir = Constantes.NOMBRE_MISSILE_TIR_INIT;

    public TirVaisseau() {
        this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
        this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
        this.largeur = Constantes.LARGEUR_MISSILE_AVION;
        this.hauteur = Constantes.HAUTEUR_MISSILE_AVION;
        this.dY = Constantes.DELTA_MISSILE;
        this.strImage = Constantes.IMAGE_MISSILE_AVION;
        this.icoMissile = new ImageIcon(getClass().getResource(Constantes.IMAGE_MISSILE_AVION));
        super.imgMissile = this.icoMissile.getImage();
    }

    public static void tirMissileMultiple(Graphics g) {
        for (Entite monMissile : Constantes.MES_TIR_MISSILE) {
            if (!monMissile.detruit) {
                g.drawImage(monMissile.getImgMissile(), monMissile.xPos, monMissile.deplacementTirMissile(), monMissile.hauteur, monMissile.largeur, null);
            } else {
                missileTirDetruit.add(monMissile);
                monMissile.detruit = true;
            }
        }
        Constantes.MES_TIR_MISSILE.removeAll(missileTirDetruit);
        for (int i = 0; i < missileTirDetruit.size(); i++) {
            Constantes.MES_TIR_MISSILE.add(missileDetruit());
        }
    }

    public static Entite missileDetruit() {
        return new TirVaisseau();
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
            if (this.yPos > 0) {
                this.yPos = this.yPos - Constantes.DELTA_MISSILE;
            } else {
                this.tirMissile = false;
            }
        }
        return yPos;
    }

    public void tirMissileVaisseau(Graphics g) {
        if (this.tirMissile) {
            g.drawImage(this.imgMissile, this.xPos, this.deplacementTirMissile(), Constantes.HAUTEUR_MISSILE_AVION, Constantes.LARGEUR_MISSILE_AVION, null);
        }
    }
}