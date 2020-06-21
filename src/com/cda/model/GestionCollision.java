package com.cda.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.cda.program.Program;

public abstract class GestionCollision extends JPanel {
	public static int compteurGlobal = 0;
	protected static int mine = 0;
	protected static int bombeFeu = 0;
	protected static int bombeGlace = 0;
	protected static int bombeZigZag = 0;
	public static int vie = 3;

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

			} else if ((vVaisseau instanceof Vaisseau && vMissile instanceof BombeFeu)
					|| (vVaisseau instanceof Vaisseau && vMissile instanceof BombeGlace)
					|| (vVaisseau instanceof Vaisseau && vMissile instanceof BombeZigZag)
					|| (vVaisseau instanceof Vaisseau && vMissile instanceof BombeNormal)) {
				vMissile.detruit = true;
				vie--;
				gestionVie();

			} else if (vMissile instanceof Mine && !Bouclier.actif) {
				vMissile.detruit = true;
				vVaisseau.detruit = true;
				vie--;
				gestionVie();
			} else {
				vMissile.detruit = true;
			}
		}
	}

	public static void gestionVie() {
		String vieUtilise = "";
		if(vie == 3){
			vieUtilise = Constantes.IMAGE_ICONE_VIES;
		}
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
			MaFenetre.monSon.stopMusique();
			MaFenetre.monSonTir.stopMusique();
			MaFenetre.monSonIntro.startMusique();
			FichierSauvegarde.fichier();
			Chrono.pause = true;
			Program.vMaFenetre.finPartie();
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

	public static void scoreReinit() {
		Chrono.pause = false;
		Bouclier.setNbreBouclier(4);
		MaFenetre.monSonIntro.stopMusique();
		MaFenetre.monSon.startMusique();
		MaFenetre.vBackgroundWindow.vaisseau.setxPos(Constantes.POSITIONX_DEPART_AVION);
		MaFenetre.vBackgroundWindow.vaisseau.setyPos(Constantes.POSITIONY_DEPART_AVION);
		GestionCollision.setCompteurGlobal(0);
		GestionCollision.setVie(3);
		ImageIcon icoMissile = new ImageIcon("/images/score-0.png");
		Image imgMissile = icoMissile.getImage();
		MaFenetre.vBackgroundWindow.score.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.score2.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.score3.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.score4.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.score5.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.score6.setImgMissile(imgMissile);
		icoMissile = new ImageIcon(TableauScore.class.getResource(Constantes.IMAGE_ICONE_VIES));
		imgMissile = icoMissile.getImage();
		MaFenetre.vBackgroundWindow.vie1.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.vie2.setImgMissile(imgMissile);
		MaFenetre.vBackgroundWindow.vie3.setImgMissile(imgMissile);
		icoMissile = new ImageIcon(TableauScore.class.getResource("/images/bouclier.png"));
		imgMissile = icoMissile.getImage();
		TableauDeBord.bouclier1.setImgMissile(imgMissile);
		TableauDeBord.bouclier2.setImgMissile(imgMissile);
		TableauDeBord.bouclier3.setImgMissile(imgMissile);

	}

	public static void setCompteurGlobal(int compteurGlobal) {
		GestionCollision.compteurGlobal = compteurGlobal;
	}

	public static void setVie(int vie) {
		GestionCollision.vie = vie;
	}
}