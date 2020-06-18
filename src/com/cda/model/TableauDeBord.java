package com.cda.model;

import com.cda.emu.EnumMissile;
import com.cda.listener.EcouteurVaisseau;
import com.cda.listener.EcouteurVaisseauSouris;
import com.cda.utils.Tools;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableauDeBord extends JPanel {
    public static Vaisseau vaisseau;
    public static boolean finDuJeu = false;
    public int PosyFond;
    public TirVaisseau missileAvion = new TirVaisseau();
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    private boolean init = true;

    public TableauDeBord(MaFenetre vMaFenetre) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(Constantes.AVION_TOP);
        Cursor perso = toolkit.createCustomCursor(image, new Point(0, 0), "perso");
        this.setCursor(perso);
        this.PosyFond = 400;
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
            PosyFond = 400;
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
        //TirVaisseau.initMissile();
        //TirVaisseau.tirMissileMultiple(g);
        GestionCollision.collissionArray(vaisseau, Constantes.MES_MISSILES);
        GestionCollision.collissionArray(missileAvion, Constantes.MES_MISSILES);
        rechargementmissile(g);
        missileAvion.tirMissileVaisseau(g);

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
        } else {
            sortie = new BombeNormal();
        }
        return sortie;
    }

    public void rechargementmissile(Graphics g) {
        ArrayList<Entite> missileDetruit = new ArrayList<>();
        for (Entite monMissile : Constantes.MES_MISSILES) {
            if (!monMissile.detruit) {
                g.drawImage(monMissile.getImgMissile(), monMissile.getxPos(), monMissile.deplacementMissile(), monMissile.hauteur, monMissile.largeur, null);
            } else {
                missileDetruit.add(monMissile);
            }
        }
        Constantes.MES_MISSILES.removeAll(missileDetruit);
        for (int i = 0; i < missileDetruit.size(); i++) {
            Constantes.MES_MISSILES.add(missileDetruit());
        }
    }
}