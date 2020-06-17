package com.cda.model;

import com.cda.listener.EcouteurVaisseau;
import com.cda.utils.Tools;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BackgroundWindow extends JPanel {
    public static Vaisseau vaisseau;
    public int yFond;
    public Entite vMissileFeu;
    public Entite vMissileGlace;
    public Entite vMissileNormal;
    public Entite vMissileZigZag;
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    private boolean init = true;

    public BackgroundWindow(MaFenetre vMaFenetre) {
        this.yFond = 400;
        setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
        this.imgBandeFond = this.icoBandeFond.getImage();
        vaisseau = new Vaisseau(250, 650, Constantes.AVION_TOP);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new EcouteurVaisseau());
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    public void initMissile() {
        if (init) {
            vMissileFeu = new MissileFeu();
            vMissileGlace = new MissileGlace();
            vMissileNormal = new MissileNormal();
            vMissileZigZag = new MissileZigZag();
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

        if(!vMissileFeu.detruit) {
            g.drawImage(vMissileFeu.getImgMissile(), vMissileFeu.getxPos(), vMissileFeu.deplacementMissile(), vMissileFeu.hauteur, vMissileFeu.largeur, null);
        }else {
            vMissileFeu = missileDetruit();
        }
        if(!vMissileGlace.detruit) {
            g.drawImage(vMissileGlace.getImgMissile(), vMissileGlace.getxPos(), vMissileGlace.deplacementMissile(), vMissileGlace.hauteur, vMissileGlace.largeur, null);
        }else {
            vMissileGlace = missileDetruit();
        }
        if(!vMissileNormal.detruit) {
            g.drawImage(vMissileNormal.getImgMissile(), vMissileNormal.getxPos(), vMissileNormal.deplacementMissile(), vMissileNormal.hauteur, vMissileNormal.largeur, null);
        }else {
            vMissileNormal = missileDetruit();
        }
        g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
                vaisseau.deplacementVaisseauVertical(), 90, 90, null);

      /*  if (vMissileFeu1.getyPos() < 820) {
            g.drawImage(vMissileFeu1.getImgMissile(), vMissileFeu1.getxPos(), vMissileFeu1.deplacementMissile(),vMissileFeu1.hauteur,vMissileFeu1.largeur, null);
            g.drawImage(vMissileFeu2.getImgMissile(), vMissileFeu2.getxPos(), vMissileFeu2.deplacementMissile(),vMissileFeu2.hauteur,vMissileFeu2.largeur, null);
            g.drawImage(vMissileFeu3.getImgMissile(), vMissileFeu3.getxPos(), vMissileFeu3.deplacementMissile(),vMissileFeu3.hauteur,vMissileFeu3.largeur, null);

        } else if (vMissileFeu1.getyPos() > 700) {
            vMissileFeu1.setyPos(0);
            vMissileFeu1.setxPos(Tools.genererInt(70, 500));
        }*/
    }

    public Entite missileDetruit(){
        Entite sortie = null;
        ArrayList <Entite> missiles = new ArrayList<>();
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

        if(vMissileFeu.detruit || vMissileGlace.detruit || vMissileNormal.detruit){
            sortie = missiles.get(Tools.genererInt(0, missiles.size()));
        }

        return sortie;
    }

}