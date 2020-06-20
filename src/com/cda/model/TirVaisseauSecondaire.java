package com.cda.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TirVaisseauSecondaire extends Entite {
    protected static boolean initialisationMissile = false;
    protected static ArrayList<Entite> missileTirDetruit = new ArrayList<>();
    protected int compteurTir = Constantes.NOMBRE_MISSILE_TIR_INIT;

    public TirVaisseauSecondaire() {
        this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
        this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
        this.largeur = Constantes.LARGEUR_MISSILE_SECONDAIRE_AVION;
        this.hauteur = Constantes.HAUTEUR_MISSILE_AVION;
        this.dY = Constantes.DELTA_MISSILE_SECONDAIRE;
        this.strOnFire = Constantes.IMAGE_MISSILE_TIR_ON_FIRE;
        this.icoOnFire = new ImageIcon(getClass().getResource(Constantes.IMAGE_MISSILE_TIR_ON_FIRE));
        super.imgOnFire = this.icoOnFire.getImage();
    }

    public static void tirMissileMultiple(Graphics g) {
        for (Entite monMissile : Constantes.MES_TIR_MISSILE) {
            if (!monMissile.detruit) {
                g.drawImage(monMissile.getImgMissile(), monMissile.xPos, monMissile.deplacementTirMissile(),
                        monMissile.hauteur, monMissile.largeur, null);
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
        return new TirVaisseauSecondaire();
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
            g.drawImage(this.imgOnFire, this.xPos, this.deplacementTirMissile() + 50,
                    Constantes.LARGEUR_MISSILE_SECONDAIRE_AVION, Constantes.HAUTEUR_MISSILE_AVION, null);
        }
    }
}