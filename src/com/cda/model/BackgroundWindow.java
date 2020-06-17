package com.cda.model;

import com.cda.listener.EcouteurVaisseau2;
import com.cda.utils.Tools;
import javax.swing.*;
import java.awt.*;

public class BackgroundWindow extends JPanel {

    private final int HAUTEUR = 400;
    private final int DISTANCE_MISSILES = 300;
    public int yFond;
    public static Vaisseau2 vaisseau;
    public MissileFeu vMissileFeu1;
    public MissileFeu vMissileFeu2;
    public MissileFeu vMissileFeu3;
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    private int dYMissile;
    private int yMissile;


	public BackgroundWindow(MaFenetre vMaFenetre) {
		this.yFond = 400;
		setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource("/images/fond.jpg"));
		this.imgBandeFond = this.icoBandeFond.getImage();
		vaisseau = new Vaisseau2(250, 650, "/images/avion-top.png");
		this.dYMissile = 0;
		this.yMissile = 100;
		this.vMissileFeu1 = new MissileFeu(300, Tools.genererInt(-150, -10),"/images/missile-feu.png");
		this.vMissileFeu2 = new MissileFeu(80, Tools.genererInt(-150, -10),"/images/missile-feu.png");
		this.vMissileFeu3 = new MissileFeu(400, Tools.genererInt(-150, -10),"/images/missile-feu.png");
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new EcouteurVaisseau2());
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}

	public void deplacementMissile(Graphics g) {
		/*
		 * this.vMissileFeu1.setY(this.vMissileFeu1.getY() + 1);
		 * this.vMissileFeu2.setY(this.vMissileFeu2.getY() + 1);
		 * this.vMissileFeu3.setY(this.vMissileFeu3.getY() + 1);
		 */
		/*
		 * if (this.vMissileFeu1.getY() == 810 ) {
		 * this.vMissileFeu1.setY(Tools.genererInt(-150, -10));
		 * this.vMissileFeu1.setX(Tools.genererInt(10, 500)); }
		 * if(this.vMissileFeu2.getY()==810){
		 * this.vMissileFeu2.setY(Tools.genererInt(-150, -10));
		 * this.vMissileFeu2.setX(Tools.genererInt(10, 500)); } if
		 * (this.vMissileFeu3.getY()==810){
		 * this.vMissileFeu3.setY(Tools.genererInt(-150, -10));
		 * this.vMissileFeu3.setX(Tools.genererInt(10, 500)); }
		 */
		g.drawImage(this.vMissileFeu1.getImgMissile(), this.vMissileFeu1.getX(), this.vMissileFeu1.getY(), null);
		g.drawImage(this.vMissileFeu2.getImgMissile(), this.vMissileFeu2.getX(), this.vMissileFeu2.getY(), null);
		g.drawImage(this.vMissileFeu3.getImgMissile(), this.vMissileFeu3.getX(), this.vMissileFeu3.getY(), null);

	}

	// Methode pour animation du fond d'ecran
	private void deplacementFond(Graphics g) {
		if (yFond == MaFenetre.FENETRE_HEIGHT) {
			yFond = 400;
		}
		g.drawImage(this.imgBandeFond, 0, this.yFond, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR * 2, null);
		g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR * 3, null);
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		deplacementFond(g);
		deplacementMissile(g);
		g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
				vaisseau.deplacementVaisseauVertical(), 90, 90, null);
	}
}