package com.cda.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class GestionCollision {
<<<<<<< HEAD
    public static int score = 0;
=======
	public static int compteurGlobal = 0;
	protected static int compteur1 = 0;
	protected static int compteur2 = 0;
	protected static int compteur3 = 0;
	protected static int mine = 0;
	protected static int bombeFeu = 0;
	protected static int bombeGlace = 0;
	protected static int bombeZigZag = 0;

	public static void collissionArray(Entite vVaisseau, ArrayList<Entite> listMissile) {
		for (Entite entite : listMissile) {
			collision(entite, vVaisseau);
		}
	}

	public static void collision(Entite vMissile, Entite vVaisseau) {
		Rectangle rect1 = vMissile.getBounds();
		Rectangle rect2 = vVaisseau.getBoundsVaisseau();
		if (rect2.intersects(rect1)) {
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
					}
				} else if (vMissile instanceof BombeNormal) {
					compteurGlobal++;
					vMissile.detruit = true;
				} else if (vMissile instanceof BombeFeu) {
					bombeFeu++;
					if (bombeFeu > 5) {
						vMissile.detruit = true;
						bombeFeu = 0;
						compteurGlobal += 5;
					}
				} else if (vMissile instanceof BombeGlace) {
					bombeGlace++;
					if (bombeGlace > 10) {
						vMissile.detruit = true;
						bombeGlace = 0;
						compteurGlobal += 10;
					}
				} else if (vMissile instanceof BombeZigZag) {
					bombeZigZag++;
					if (bombeZigZag > 15) {
						vMissile.detruit = true;
						bombeZigZag = 0;
						compteurGlobal += 50;
					}
				} else {

				}
				System.out.println("tir réussi");
				if (compteurGlobal < 999999) {
					compteur();
				} else {
					compteurGlobal = 0;
				}
			} else if ((vVaisseau instanceof Vaisseau && vMissile instanceof BombeFeu)
					|| (vVaisseau instanceof Vaisseau && vMissile instanceof BombeGlace)
					|| (vVaisseau instanceof Vaisseau && vMissile instanceof BombeZigZag)
					|| (vVaisseau instanceof Vaisseau && vMissile instanceof BombeNormal)) {
				vMissile.detruit = true;
				System.out.println("touché par missile");
			} else {
				vMissile.detruit = true;
			}
		} else if (rect2.intersects(rect1) && vMissile instanceof Mine) {
			if (vVaisseau instanceof Vaisseau && vMissile instanceof Mine) {
				vMissile.detruit = true;
				vVaisseau.detruit = true;
				System.out.println("détruit par mine");
			}
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
>>>>>>> dev

		String test3 = TableauScore.score.get((compteurGlobal / 100) % 10);
		ImageIcon icoMissile3 = new ImageIcon(TableauScore.class.getResource(test3));
		Image imgMissile3 = icoMissile3.getImage();
		MaFenetre.vBackgroundWindow.score3.setImgMissile(imgMissile3);

<<<<<<< HEAD
    public static void collision(Entite vMissile, Entite vVaisseau) {
        Rectangle rect1 = vMissile.getBounds();
        Rectangle rect2 = vVaisseau.getBounds();
        if (rect2.intersects(rect1)) {
            if ((vVaisseau instanceof TirVaisseau && vMissile instanceof BombeFeu)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeGlace)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeZigZag)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeNormal)) {
                vMissile.detruit = true;
                vVaisseau.detruit = true;
                score += 5;
            }else if((vVaisseau instanceof Vaisseau && vMissile instanceof BombeFeu)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeGlace)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeZigZag)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeNormal)){
                vMissile.detruit = true;
                score -=5;
            } else {
                vMissile.detruit = true;
                score +=1;

            }
=======
		String test4 = TableauScore.score.get((compteurGlobal / 1000) % 10);
		ImageIcon icoMissile4 = new ImageIcon(TableauScore.class.getResource(test4));
		Image imgMissile4 = icoMissile4.getImage();
		MaFenetre.vBackgroundWindow.score4.setImgMissile(imgMissile4);

		String test5 = TableauScore.score.get((compteurGlobal / 10000) % 10);
		ImageIcon icoMissile5 = new ImageIcon(TableauScore.class.getResource(test5));
		Image imgMissile5 = icoMissile5.getImage();
		MaFenetre.vBackgroundWindow.score5.setImgMissile(imgMissile5);
>>>>>>> dev

		String test6 = TableauScore.score.get((compteurGlobal / 100000) % 10);
		ImageIcon icoMissile6 = new ImageIcon(TableauScore.class.getResource(test6));
		Image imgMissile6 = icoMissile6.getImage();
		MaFenetre.vBackgroundWindow.score6.setImgMissile(imgMissile6);
	}

	public static int getCompteurGlobal() {
		return compteurGlobal;
	}
}