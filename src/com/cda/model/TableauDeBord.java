package com.cda.model;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.cda.listener.EcouteurVaisseau;
import com.cda.listener.EcouteurVaisseauSouris;
import com.cda.utils.Tools;

public class TableauDeBord extends JPanel {
	public static Vaisseau vaisseau;
	public static boolean finDuJeu = false;
	public int yFond;
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	private boolean init = true;

	public TableauDeBord(MaFenetre vMaFenetre) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(Constantes.AVION_TOP);
		Cursor perso = toolkit.createCustomCursor(image, new Point(0, 0), "perso");
		this.setCursor(perso);
		this.yFond = 400;
		setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
		this.imgBandeFond = this.icoBandeFond.getImage();
		vaisseau = new Vaisseau(250, 650, Constantes.AVION_TOP);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new EcouteurVaisseau());
		this.addMouseListener(new EcouteurVaisseauSouris());
		this.addMouseMotionListener(new EcouteurVaisseauSouris());
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}

	public void initMissile() {
		if (init) {
			for (int i = 0; i < Constantes.NOMBRE_MISSILE_INIT; i++) {
				Constantes.mesMissile.add(missileDetruit());
			}
			init = false;
		}
	}

	// Methode pour animation du fond d'ecran
	private void deplacementFond(Graphics g) {
		if (yFond == Constantes.FENETRE_HEIGHT) {
			yFond = 400;
		}
		g.drawImage(this.imgBandeFond, 0, this.yFond, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - Constantes.IMAGE_HEIGHT, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - Constantes.IMAGE_HEIGHT * 2, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - Constantes.IMAGE_HEIGHT * 3, null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		deplacementFond(g);
		initMissile();
		ArrayList<Entite> missileDetruit = new ArrayList<>();
		for (Entite monMissile : Constantes.mesMissile) {
			if (!monMissile.detruit) {
				g.drawImage(monMissile.getImgMissile(), monMissile.getxPos(), monMissile.deplacementMissile(),
						monMissile.hauteur, monMissile.largeur, null);
			} else {
				missileDetruit.add(monMissile);
			}
		}
		Constantes.mesMissile.removeAll(missileDetruit);
		for (int i = 0; i < missileDetruit.size(); i++) {
			Constantes.mesMissile.add(missileDetruit());
		}
		g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
				vaisseau.deplacementVaisseauVertical(), 150, 150, null);
		TableauDeBord.collision(TableauDeBord.vaisseau, Constantes.mesMissile.get(0));
	}

	public Entite missileDetruit() {
		Entite sortie = null;
		ArrayList<Entite> missiles = new ArrayList<>();
		missiles.add(new MissileGlace());
		missiles.add(new MissileFeu());
		missiles.add(new MissileNormal());
		missiles.add(new MissileZigZag());
		missiles.add(new MissileGlace());
		missiles.add(new MissileFeu());
		missiles.add(new MissileNormal());
		missiles.add(new MissileZigZag());
		missiles.add(new MissileGlace());
		missiles.add(new MissileFeu());
		missiles.add(new MissileNormal());
		missiles.add(new MissileZigZag());

		return missiles.get(Tools.genererInt(0, missiles.size()));
	}

	public static boolean collision(Entite pAvion, Entite pMissile) {

		Point pMA = new Point(pMissile.getxPos(), pMissile.getyPos());
		Point pMB = new Point(pMissile.getxPos() + pMissile.getLargeur(), pMissile.getyPos());
		Point pMC = new Point(pMissile.getxPos() + pMissile.getLargeur(), pMissile.getyPos() + pMissile.getHauteur());
		Point pMD = new Point(pMissile.getxPos(), pMissile.getyPos() + pMissile.getHauteur());

		Point pAA = new Point(pAvion.getxPos(), pAvion.getyPos());
		Point pAB = new Point(pAvion.getxPos() + pAvion.getLargeur(), pAvion.getyPos());
		Point pAC = new Point(pAvion.getxPos() + pAvion.getLargeur(), pAvion.getyPos() + pAvion.getHauteur());
		Point pAD = new Point(pAvion.getxPos(), pAvion.getyPos() + pAvion.getHauteur());

		return (pMC.getX() > pAA.getX() && pMC.getX() < pAB.getX() && pMC.getY() > pAA.getY()
				&& pAA.getY() < pAD.getY());

//		Point missA = new Point(pMissile.getxPos(), pMissile.getyPos());
//		Point missB = new Point(pMissile.getxPos() + pMissile.getLargeur(), pMissile.getyPos());
//		Point missC = new Point(pMissile.getxPos() + pMissile.getLargeur(), pMissile.getyPos() + pMissile.getHauteur());
//		Point missD = new Point(pMissile.getxPos(), pMissile.getyPos() + pMissile.getHauteur());
//
//		Point avionA = new Point(pAvion.getxPos(), pAvion.getyPos());
//		Point avionB = new Point(pAvion.getxPos() + pAvion.getLargeur(), pAvion.getyPos());
//		Point avionC = new Point(pAvion.getxPos() + pAvion.getLargeur(), pAvion.getyPos() + pAvion.getHauteur());
//		Point aD = new Point(pAvion.getxPos(), pAvion.getyPos() + pAvion.getHauteur());
//
//		return (missC.getX() < avionB.getX() && missC.getX() > avionA.getX() && missC.getY() > avionA.getY()
//				&& missC.getY() < aD.getY())
//				|| (missD.getX() < avionB.getX() && missD.getX() > avionA.getX() && missD.getY() > avionA.getY()
//						&& missD.getY() < aD.getY());

	}

	public static boolean collisionArray(Entite unVaisseau, ArrayList<Entite> tabMissiles) {
		for (Entite leMissile : tabMissiles) {
			if (collision(leMissile, unVaisseau)) {
				System.out.println("test");
			}
		}
		return finDuJeu;
	}

}