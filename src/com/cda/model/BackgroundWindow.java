package com.cda.model;

import com.cda.listener.EcouteurVaisseau2;

import javax.swing.*;
import java.awt.*;


public class BackgroundWindow extends JPanel {

    private final int HAUTEUR = 400;
    public int yFond;
    public Vaisseau2 vaisseau;
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;


    public BackgroundWindow(MaFenetre vMaFenetre) {
        this.yFond = 400;
        setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource("/images/fond.jpg"));
        this.imgBandeFond = this.icoBandeFond.getImage();
        this.vaisseau = new Vaisseau2(250, 650, "/images/avion-top.png");
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new EcouteurVaisseau2());
        // a voir une fois projet fini fond d'ecran animé.
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }


    public void setVaisseau(Vaisseau2 vaisseau) {
        this.vaisseau = vaisseau;
    }

    //Methode pour animation du fond d'ecran
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
       /* g.drawImage(this.imgBandeFond, 0, this.yFond, null);
        g.drawImage(this.imgBandeFond, 0, this.yFond - this.HAUTEUR, null);*/
        deplacementFond(g);
        g.drawImage(this.vaisseau.getImgVaisseau(), this.vaisseau.getX(), this.vaisseau.getY(), 100, 100, null);
    }
}

