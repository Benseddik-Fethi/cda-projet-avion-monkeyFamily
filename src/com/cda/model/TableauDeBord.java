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
    public int yFond;
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    private boolean init = true;
    public MissileAvion missileAvion = new MissileAvion();

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
            vMissile.detruit = true;
        } else {

        }
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

        collissionArray(vaisseau, Constantes.MES_MISSILES);
        collissionArray(missileAvion, Constantes.MES_MISSILES);
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

    public void rechargementmissile(Graphics g){
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