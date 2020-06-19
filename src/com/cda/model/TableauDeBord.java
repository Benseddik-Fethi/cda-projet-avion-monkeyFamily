package com.cda.model;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.cda.emu.EnumMissile;
import com.cda.listener.EcouteurVaisseau;
import com.cda.listener.EcouteurVaisseauSouris;
import com.cda.utils.Tools;

public class TableauDeBord extends JPanel {
	public static Vaisseau vaisseau;
	public static boolean finDuJeu = false;
	public int PosyFond;
	public Bouclier bouclier = new Bouclier();
	public TirVaisseau missileAvion = new TirVaisseau();
	public TirVaisseauSecondaire tirSecondaireAvion = new TirVaisseauSecondaire();
//	public Test traineeAvion = new Test();
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	private ImageIcon icoNuage;
	private Image imgNuage;
	private boolean init = true;
	public TableauScore score = new TableauScore();
	public TableauScore score2 = new TableauScore();
	public TableauScore score3 = new TableauScore();
	public TableauScore score4 = new TableauScore();
	public TableauScore score5 = new TableauScore();
	public TableauScore score6 = new TableauScore();

	public TableauDeBord(MaFenetre vMaFenetre) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(Constantes.AVION_TOP);
		Cursor perso = toolkit.createCustomCursor(image, new Point(0, 0), "perso");
		this.setCursor(perso);
		this.PosyFond = 0;
		setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
		this.imgBandeFond = this.icoBandeFond.getImage();
		vaisseau = new Vaisseau();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new EcouteurVaisseau());
		this.addMouseListener(new EcouteurVaisseauSouris());
		this.addMouseMotionListener(new EcouteurVaisseauSouris());

		Thread chronoEcran = new Thread(new Chrono()); // sortir thread et créer méthode pour lancer le jeu après le
														// menu
		chronoEcran.start();

	}

	public void initMissile() {
		if (init) {
			for (int i = 0; i < Constantes.NOMBRE_MISSILE_INIT; i++) {
				Constantes.MES_MISSILES.add(missileDetruit());
			}
			init = false;
		}
	}

	// Methode pour animation du fond d'ecran
	private void deplacementFond(Graphics g) {
		if (PosyFond == Constantes.FENETRE_HEIGHT) {
			PosyFond = 0;
		}
		g.drawImage(this.imgBandeFond, 0, this.PosyFond, null);
		g.drawImage(this.imgBandeFond, 0, this.PosyFond - Constantes.IMAGE_HEIGHT, null);
		g.drawImage(this.imgBandeFond, 0, this.PosyFond - Constantes.IMAGE_HEIGHT * 2, null);
		g.drawImage(this.imgBandeFond, 0, this.PosyFond - Constantes.IMAGE_HEIGHT * 3, null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		deplacementFond(g);
		initMissile();
		GestionCollision.collissionArray(vaisseau, Constantes.MES_MISSILES);
		GestionCollision.collissionArray(missileAvion, Constantes.MES_MISSILES);
		rechargementmissile(g);
		bouclier.initBouclier(g);
		missileAvion.tirMissileVaisseau(g);
		tirSecondaireAvion.tirMissileVaisseau(g);
		// traineeAvion.tirMissileVaisseau(g);
		g.drawImage(score.getImgMissile(), score.xPos + 20, score.yPos, null);
		g.drawImage(score2.getImgMissile(), score.xPos - 15, score.yPos, null);
		g.drawImage(score3.getImgMissile(), score.xPos - 50, score.yPos, null);
		g.drawImage(score4.getImgMissile(), score.xPos - 85, score.yPos, null);
		g.drawImage(score5.getImgMissile(), score.xPos - 120, score.yPos, null);
		g.drawImage(score6.getImgMissile(), score.xPos - 155, score.yPos, null);
		g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
				vaisseau.deplacementVaisseauVertical(), vaisseau.hauteur, vaisseau.largeur, null);

	}

	public Entite missileDetruit() {
		Entite sortie = null;
		int choixMissile = Tools.genererInt(0, EnumMissile.values().length);
		EnumMissile monMissile = EnumMissile.values()[choixMissile];
		if (monMissile == EnumMissile.FEU) {
			sortie = new BombeFeu();
		} else if (monMissile == EnumMissile.GLACE) {
			sortie = new BombeGlace();
		} else if (monMissile == EnumMissile.ZIGZAG) {
			sortie = new BombeZigZag();
		} else if (monMissile == EnumMissile.MINES) {
			sortie = new Mine();
		} else {
			sortie = new BombeNormal();
		}
		return sortie;
	}

	public void rechargementmissile(Graphics g) {
		ArrayList<Entite> missileDetruit = new ArrayList<>();
		for (Entite monMissile : Constantes.MES_MISSILES) {
			if (!monMissile.detruit) {
				g.drawImage(monMissile.getImgMissile(), monMissile.getxPos(), monMissile.deplacementMissile(),
						monMissile.hauteur, monMissile.largeur, null);
			} else {
				missileDetruit.add(monMissile);
			}
		}
		Constantes.MES_MISSILES.removeAll(missileDetruit);
		for (int i = 0; i < missileDetruit.size(); i++) {
			Constantes.MES_MISSILES.add(missileDetruit());
		}
	}

	public static void difficulte() {
		if (GestionCollision.getCompteurGlobal() > 1000) {
			Constantes.setNOMBRE_MISSILE_INIT(Constantes.getNOMBRE_MISSILE_INIT() * 2);
		} else if (GestionCollision.getCompteurGlobal() > 10000) {
			Constantes.setNOMBRE_MISSILE_INIT(Constantes.getNOMBRE_MISSILE_INIT() * 5);

		}
	}
}