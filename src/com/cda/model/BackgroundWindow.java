package com.cda.model;
import com.cda.listener.EcouteurVaisseau2;
import com.cda.utils.Tools;

import javax.swing.*;
import java.awt.*;

public class BackgroundWindow extends JPanel {

    public static Vaisseau2 vaisseau;
    private final int HAUTEUR = 400;
    public int yFond;
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    public static MissileFeu vMissileFeu;


    public BackgroundWindow(MaFenetre vMaFenetre) {
        this.yFond = 400;
        setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource("/images/fond.jpg"));
        this.imgBandeFond = this.icoBandeFond.getImage();
        vaisseau = new Vaisseau2(250, 650, "/images/avion-top.png");
        vMissileFeu = new MissileFeu(300,0,"/images/missile-feu.png");
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new EcouteurVaisseau2());
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
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
        g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
                vaisseau.deplacementVaisseauVertical(), 90, 90, null);
        if(vMissileFeu.getY() < 700) {
			g.drawImage(vMissileFeu.getImgMissile(), vMissileFeu.getX(), vMissileFeu.deplacementMissileFeu(), null);
		}else if(vMissileFeu.getY() > 700){
        	vMissileFeu.setY(0);
        	vMissileFeu.setX(Tools.genererInt(70, 500));
		}
    }
}