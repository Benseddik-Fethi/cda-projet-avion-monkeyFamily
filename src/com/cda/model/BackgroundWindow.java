package com.cda.model;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

<<<<<<< HEAD
public class BackgroundWindow extends JPanel {
    public static Vaisseau vaisseau;
    public static boolean finDuJeu = false;
    public int yFond;
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    private boolean init = true;

    public BackgroundWindow(MaFenetre vMaFenetre) {
        this.yFond = 400;
        setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
        this.imgBandeFond = this.icoBandeFond.getImage();
        vaisseau = new Vaisseau(250, 650, Constantes.AVION_TOP);
=======
import javax.swing.ImageIcon;
import javax.swing.JPanel;
>>>>>>> ff81b82196c046b023c990a29e00ae4d9bc23bdd

import com.cda.listener.EcouteurVaisseau;
import com.cda.listener.EcouteurVaisseauSouris;
import com.cda.utils.Tools;

<<<<<<< HEAD
    public void initMissile() {
        if (init) {
            for (int i = 0; i <Constantes.NOMBRE_MISSILE_INIT ; i++) {
                Constantes.mesMissile.add(missileDetruit());
            }
            init = false;
        }
    }
=======
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
>>>>>>> ff81b82196c046b023c990a29e00ae4d9bc23bdd

	public BackgroundWindow(MaFenetre vMaFenetre) {
		// Pour jouer à la souris
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(Constantes.AVION_TOP);
		Cursor perso = toolkit.createCustomCursor(image, new Point(0, 0), "perso");
		this.setCursor(perso);
		this.yFond = 400;
		setSize(vMaFenetre.getWidth(), vMaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
		this.imgBandeFond = this.icoBandeFond.getImage();
		vaisseau = new Vaisseau(250, 650, Constantes.AVION_TOP);

<<<<<<< HEAD
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        deplacementFond(g);
        initMissile();
        ArrayList<Entite> missileDetruit = new ArrayList<>();
        for (Entite monMissile : Constantes.mesMissile) {
            if (!monMissile.detruit) {
                g.drawImage(monMissile.getImgMissile(), monMissile.getxPos(), monMissile.deplacementMissile(), monMissile.hauteur, monMissile.largeur, null);
            } else {
               missileDetruit.add(monMissile);
            }
            //monMissile = missileDetruit();
        }
        Constantes.mesMissile.removeAll(missileDetruit);
        for (int i = 0; i < missileDetruit.size() ; i++) {
            Constantes.mesMissile.add(missileDetruit());
        }
        g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
                vaisseau.deplacementVaisseauVertical(), 90, 90, null);

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
=======
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

		if (!vMissileFeu.detruit) {
			g.drawImage(vMissileFeu.getImgMissile(), vMissileFeu.getxPos(), vMissileFeu.deplacementMissile(),
					vMissileFeu.hauteur, vMissileFeu.largeur, null);
		} else {
			vMissileFeu = missileDetruit();
		}
		if (!vMissileGlace.detruit) {
			g.drawImage(vMissileGlace.getImgMissile(), vMissileGlace.getxPos(), vMissileGlace.deplacementMissile(),
					vMissileGlace.hauteur, vMissileGlace.largeur, null);
		} else {
			vMissileGlace = missileDetruit();
		}
		if (!vMissileNormal.detruit) {
			g.drawImage(vMissileNormal.getImgMissile(), vMissileNormal.getxPos(), vMissileNormal.deplacementMissile(),
					vMissileNormal.hauteur, vMissileNormal.largeur, null);
		} else {
			vMissileNormal = missileDetruit();
		}
		g.drawImage(vaisseau.getImgVaisseau(), vaisseau.deplacementVaisseauHorizontal(),
				vaisseau.deplacementVaisseauVertical(), 90, 90, null);
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

		if (vMissileFeu.detruit || vMissileGlace.detruit || vMissileNormal.detruit) {
			sortie = missiles.get(Tools.genererInt(0, missiles.size()));
		}
		return sortie;
	}

>>>>>>> ff81b82196c046b023c990a29e00ae4d9bc23bdd
}