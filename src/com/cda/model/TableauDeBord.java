package com.cda.model;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
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
		vaisseau = new Vaisseau();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new EcouteurVaisseau());
		this.addMouseListener(new EcouteurVaisseauSouris());
		this.addMouseMotionListener(new EcouteurVaisseauSouris());
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}

	public static void collissionArray(Entite vVaisseau, ArrayList<Entite> listMissile) {
		for (Entite entite : listMissile) {
			collision(entite, vVaisseau);
		}
	}

	public static void collision(Entite vMissile, Entite vVaisseau) {
		Rectangle rect1 = vMissile.getBounds();
		Rectangle rect2 = vVaisseau.getBounds();
		if (rect2.intersects(rect1)) {
			System.out.println("BOOM!!!!");
		} else {

		}
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
		collissionArray(vaisseau, Constantes.mesMissile);
		ArrayList<Entite> missileDetruit = new ArrayList<>();
		for (Entite monMissile : Constantes.mesMissile) {
			if (!monMissile.detruit) {
				g.drawImage(monMissile.getImgMissile(), monMissile.getxPos(), monMissile.deplacementMissile(),
						monMissile.hauteur, monMissile.largeur, null);
			} else {
				missileDetruit.add(monMissile);
			}
			// monMissile = missileDetruit();
		}
		Constantes.mesMissile.removeAll(missileDetruit);
		for (int i = 0; i < missileDetruit.size(); i++) {
			Constantes.mesMissile.add(missileDetruit());
		}
		g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
				vaisseau.deplacementVaisseauVertical(), vaisseau.hauteur, vaisseau.largeur, null);

	}

	public Entite missileDetruit() {
		Entite sortie = null;
		int choixMissile = Tools.genererInt(0, EnumMissile.values().length);
		EnumMissile monMissile = EnumMissile.values()[choixMissile];
		if (monMissile == EnumMissile.FEU) {
			sortie = new MissileFeu();
		} else if (monMissile == EnumMissile.GLACE) {
			sortie = new MissileGlace();
		} else if (monMissile == EnumMissile.ZIGZAG) {
			sortie = new MissileZigZag();
		} else {
			sortie = new MissileNormal();
		}
		return sortie;
	}
}