package com.cda.model;

import java.util.ArrayList;

/**
 * Constantes du projet
 */
public class Constantes {

	/**
	 * Utilis� dans la classe Ecouteur Vaisseau dans le package com.cda.listener.
	 *
	 * @param <b>VITESSE</b> permet de r�gler la vitesse du vaisseau en modifiant la
	 *                       valeur.
	 */
	public static final int VITESSE_VAISSEAU = 5;

	/**
	 * Utilis� dans la classe Chrono dans le package com.cda.model.
	 *
	 * @param <b>VITESSE_DEFILEMENT_FOND</b> permet de r�gler la vitesse de
	 *                                       d�filement du fond en modifiant la
	 *                                       valeur.
	 */
	protected final static int VITESSE_DEFILEMENT_FOND = 5;

	/**
	 * Utilis� dans la classe MaFenetre dans le package com.cda.listener.
	 *
	 * @param <b>FENETRE_WIDTH</b> permet de param�trer la largeur de la fen�tre de
	 *                             jeu.
	 */
	protected final static int FENETRE_WIDTH = 600;

	/**
	 * Utilis� dans les classes MaFenetre, BackgroundWindow, MaFenetre dans le
	 * package com.cda.listener.
	 *
	 * @param <b>FENETRE_HEIGHT</b> permet de param�trer la hauteur de la fen�tre de
	 *                              jeu.
	 */
	protected final static int FENETRE_HEIGHT = 800;

	/**
	 * Utilis� dans les classes BackgroundWindow, MaFenetre dans le package
	 * com.cda.listener.
	 *
	 * @param <b>IMAGE_HEIGHT</b> permet de param�trer la hauteur du background,
	 *                            utilis� pour le d�filement vertical.
	 */
	protected final static int IMAGE_HEIGHT = FENETRE_HEIGHT / 2;

	/**
	 * @param <b>IMAGES</b>
	 */
	// Utilis� dans les classes Vaisseau, MaFenetre dans le package
	// com.cda.listener.
	protected static final String AVION_TOP = "/images/avion-top.png";

	// Utilis� dans les classes Vaisseau, MaFenetre dans le package
	// com.cda.listener.
	protected static final String AVION_VAISSEAU_DETRUIT = "/images/avion-top.png";

	// Utilis� dans la classe Vaisseau dans le package com.cda.listener.
	protected static final String AVION_LEFT = "/images/avion-left.png";

	// Utilis� dans la classe Vaisseau dans le package com.cda.listener.
	protected static final String AVION_RIGHT = "/images/avion-right.png";

	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String FOND = "/images/fond-ecran.jpg";

	/* ========Constante Avion======== */
	public static final int HAUTEUR_AVION = 70;
	public static final int LARGEUR_AVION = 70;
	public static final int POSITIONX_DEPART_AVION = 250;
	public static final int POSITIONY_DEPART_AVION = 650;

	/*-----------------Constante Missile---------*/
	protected static final int LARGEUR_MISSILE = 50;
	protected static final int HAUTEUR_MISSILE = 50;
	protected static final int POSITION_DEPART = 0;

	/* ============Constante Missile Feu========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_FEU = "/images/Bombe-Feu.png";
	protected static final int VITESSE_CHUTE_FEU = 3;

	/* ============Constante Missile Glace========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_GLACE = "/images/Bombe-Glace.png";
	protected static final int VITESSE_CHUTE_GLACE = 2;

	/* ============Constante Missile Normal========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_NORMAL = "/images/Bombe-Normal.png";
	protected static final int VITESSE_CHUTE_NORMAL = 2;

	/* ============Constante Missile ZigZag========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.

	protected static final String MISSILE_ZIGZAG = "/images/Bombe-ZigZag.png";
	protected static final int VITESSE_CHUTE_ZIGZAG = 1;

	/* =======Constante Tableau Missile======== */
	protected static final int NOMBRE_MISSILE_INIT = 3;
	protected static final ArrayList<Entite> MES_MISSILES = new ArrayList<>();

	/* ==============Constante Missile Avion===== */
	public static final int HAUTEUR_MISSILE_AVION = 20;
	public static final int LARGEUR_MISSILE_AVION = 60;
	protected static final String IMAGE_MISSILE_AVION = "/images/tir-avion.png";
	public static final int DELTA_MISSILE = 4;
	protected static final int NOMBRE_MISSILE_TIR_INIT = 1;
	public static final ArrayList<Entite> MES_TIR_MISSILE = new ArrayList<>();
}
