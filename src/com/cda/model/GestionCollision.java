package com.cda.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class GestionCollision {
    public static int compteurGlobal = 0;
    protected static int mine = 0;
    protected static int bombeFeu = 0;
    protected static int bombeGlace = 0;
    protected static int bombeZigZag = 0;
    protected static int vie = 3;

    public static void collissionArray(Entite vVaisseau, ArrayList<Entite> listMissile) {
        for (Entite entite : listMissile) {
            collision(entite, vVaisseau);
        }
    }

    public static void collision(Entite vMissile, Entite vVaisseau) {
        Rectangle rect1 = vMissile.getBounds();
        Rectangle rect2 = vVaisseau.getBoundsVaisseau();
        if (rect2.intersects(rect1) && !Bouclier.actif) {
            if ((vVaisseau instanceof TirVaisseau && vMissile instanceof BombeFeu)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeGlace)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeZigZag)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeNormal)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof Mine)) {
                if (vMissile instanceof Mine) {
                    mine++;
                    if (mine > 20) {
                        vMissile.detruit = true;
                        mine = 0;
                        compteurGlobal += 100;
                        gestionPoint();
                    }
                } else if (vMissile instanceof BombeNormal) {
                    compteurGlobal++;
                    vMissile.detruit = true;
                    gestionPoint();
                } else if (vMissile instanceof BombeFeu) {
                    bombeFeu++;
                    if (bombeFeu > 5) {
                        vMissile.detruit = true;
                        bombeFeu = 0;
                        compteurGlobal += 5;
                        gestionPoint();
                    }
                } else if (vMissile instanceof BombeGlace) {
                    bombeGlace++;
                    if (bombeGlace > 10) {
                        vMissile.detruit = true;
                        bombeGlace = 0;
                        compteurGlobal += 10;
                        gestionPoint();
                    }
                } else {
                    bombeZigZag++;
                    if (bombeZigZag > 15) {

                        vMissile.detruit = true;
                        bombeZigZag = 0;
                        compteurGlobal += 50;
                        gestionPoint();
                    }
                }
                System.out.println("tir réussi");

            } else if ((vVaisseau instanceof Vaisseau && vMissile instanceof BombeFeu)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeGlace)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeZigZag)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeNormal)) {
                vMissile.detruit = true;
                vie--;
                gestionVie();
                System.out.println("touché par missile");

            } else if (vMissile instanceof Mine && !Bouclier.actif) {
                vMissile.detruit = true;
                vVaisseau.detruit = true;
                vie--;
                gestionVie();
                System.out.println("détruit par mine");

            } else {
                System.out.println("détruit par bouclier");
                vMissile.detruit = true;
            }
        }
    }

    public static void gestionVie() {
        String vieUtilise = "";
        if (vie == 2) {
            ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(vieUtilise));
            Image imgMissile = icoMissile.getImage();
            MaFenetre.vBackgroundWindow.vie3.setImgMissile(imgMissile);
        }
        if (vie == 1) {
            ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(vieUtilise));
            Image imgMissile = icoMissile.getImage();
            MaFenetre.vBackgroundWindow.vie2.setImgMissile(imgMissile);
        }
        if (vie == 0) {
            ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(vieUtilise));
            Image imgMissile = icoMissile.getImage();
            MaFenetre.vBackgroundWindow.vie1.setImgMissile(imgMissile);
        }
        if (vie < 0) {
            TableauDeBord.finDuJeu = true;
            FichierSauvegarde.fichier();
            System.out.println("partie fini");
        }

    }

    public static void gestionPoint() {
        if (compteurGlobal < 999999) {
            compteur();
        } else {
            compteurGlobal = 0;
        }
    }

    public static void compteur() {
        compteurGlobal++;
        String test = TableauScore.score.get(compteurGlobal % 10);
        ImageIcon icoMissile = new ImageIcon(TableauScore.class.getResource(test));
        Image imgMissile = icoMissile.getImage();
        MaFenetre.vBackgroundWindow.score.setImgMissile(imgMissile);

        String test2 = TableauScore.score.get((compteurGlobal / 10) % 10);
        ImageIcon icoMissile2 = new ImageIcon(TableauScore.class.getResource(test2));
        Image imgMissile2 = icoMissile2.getImage();
        MaFenetre.vBackgroundWindow.score2.setImgMissile(imgMissile2);


        String test3 = TableauScore.score.get((compteurGlobal / 100) % 10);
        ImageIcon icoMissile3 = new ImageIcon(TableauScore.class.getResource(test3));
        Image imgMissile3 = icoMissile3.getImage();
        MaFenetre.vBackgroundWindow.score3.setImgMissile(imgMissile3);


        String test4 = TableauScore.score.get((compteurGlobal / 1000) % 10);
        ImageIcon icoMissile4 = new ImageIcon(TableauScore.class.getResource(test4));
        Image imgMissile4 = icoMissile4.getImage();
        MaFenetre.vBackgroundWindow.score4.setImgMissile(imgMissile4);

        String test5 = TableauScore.score.get((compteurGlobal / 10000) % 10);
        ImageIcon icoMissile5 = new ImageIcon(TableauScore.class.getResource(test5));
        Image imgMissile5 = icoMissile5.getImage();
        MaFenetre.vBackgroundWindow.score5.setImgMissile(imgMissile5);

        String test6 = TableauScore.score.get((compteurGlobal / 100000) % 10);
        ImageIcon icoMissile6 = new ImageIcon(TableauScore.class.getResource(test6));
        Image imgMissile6 = icoMissile6.getImage();
        MaFenetre.vBackgroundWindow.score6.setImgMissile(imgMissile6);
    }

}