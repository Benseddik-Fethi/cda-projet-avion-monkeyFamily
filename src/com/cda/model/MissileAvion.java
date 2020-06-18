package com.cda.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MissileAvion extends Entite {
    protected boolean initialisationMissile = false;
    protected int compteurTir = Constantes.NOMBRE_MISSILE_TIR_INIT;
    protected static ArrayList<Entite> missileTirDetruit = new ArrayList<>();

    public MissileAvion() {
        this.xPos = Constantes.POSITIONX_DEPART_AVION / 2;
        this.yPos = Constantes.POSITIONY_DEPART_AVION - Constantes.HAUTEUR_MISSILE;
        this.largeur = Constantes.LARGEUR_MISSILE_AVION;
        this.hauteur = Constantes.HAUTEUR_MISSILE_AVION;
        this.dY = Constantes.DELTA_MISSILE;
        this.strImage = Constantes.IMAGE_MISSILE_AVION;
        this.icoMissile = new ImageIcon(getClass().getResource(Constantes.IMAGE_MISSILE_AVION));
        super.imgMissile = this.icoMissile.getImage();
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

    public void initMissileTir() {
        if (initialisationMissile) {
            for (int i = 0; i < Constantes.NOMBRE_MISSILE_TIR_INIT; i++) {
                Constantes.MES_MISSILES.add(missileAvionDetruit());
            }
            initialisationMissile = true;
        }
    }

    public static Entite missileAvionDetruit() {
        return new MissileAvion();
    }

    public static void rechargementTirmissile(Graphics g){

        for (Entite monMissileTir : Constantes.MES_TIR_MISSILE) {
            if (!monMissileTir.detruit) {
                g.drawImage(monMissileTir.getImgMissile(), monMissileTir.getxPos(), monMissileTir.deplacementTirMissile(), monMissileTir.hauteur, monMissileTir.largeur, null);
            } else {
                missileTirDetruit.add(monMissileTir);
            }
        }
        Constantes.MES_MISSILES.removeAll(missileTirDetruit);
        for (int i = 0; i < missileTirDetruit.size(); i++) {
            Constantes.MES_MISSILES.add(missileAvionDetruit());
        }
    }

}
