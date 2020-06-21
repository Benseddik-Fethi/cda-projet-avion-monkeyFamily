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
	protected static int VITESSE_DEFILEMENT_FOND = 8;

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
	protected final static int FENETRE_HEIGHT = 900;

	/**
	 * Utilis� dans les classes BackgroundWindow, MaFenetre dans le package
	 * com.cda.listener.
	 *
	 * @param <b>IMAGE_HEIGHT</b> permet de param�trer la hauteur du background,
	 *                            utilis� pour le d�filement vertical.
	 */
	protected final static int IMAGE_HEIGHT = 900;

	/**
	 * @param <b>IMAGES</b>
	 */
	// Utilis� dans les classes Vaisseau, MaFenetre dans le package
	// com.cda.listener.
	protected static final String AVION_TOP = "/images/avion-top-def.png";

	// Utilis� dans les classes Vaisseau, MaFenetre dans le package
	// com.cda.listener.
	protected static final String AVION_VAISSEAU_DETRUIT = "/images/avion-top.png";

	// Utilis� dans la classe Vaisseau dans le package com.cda.listener.
	protected static final String AVION_LEFT = "/images/avion-left.png";

	// Utilis� dans la classe Vaisseau dans le package com.cda.listener.
	protected static final String AVION_RIGHT = "/images/avion-right.png";

	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String FOND = "/images/fond.png";

	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String FOND_INTRO = "/images/fond-intro.png";

	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String FOND_FIN = "/images/fond-fin.png";

	/* ========Constante Avion======== */
	public static final int HAUTEUR_AVION = 100;
	public static final int LARGEUR_AVION = 100;
	public static final int POSITIONX_DEPART_AVION = 250;
	public static final int POSITIONY_DEPART_AVION = 750;

	/*-----------------Constante Missile/Mines---------*/
	protected static final int LARGEUR_MISSILE = 50;
	protected static final int HAUTEUR_MISSILE = 50;
	protected static final int POSITION_DEPART = -100;

	/* ============Constante Missile Feu========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_FEU = "/images/Bombe-Feu.png";
	protected static final int VITESSE_CHUTE_FEU = 4;

	/* ============Constante Missile Glace========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_GLACE = "/images/Bombe-Glace.png";
	protected static final int VITESSE_CHUTE_GLACE = 2;

	/* ============Constante Missile Normal========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_NORMAL = "/images/Bombe-Normal.png";
	protected static final int VITESSE_CHUTE_NORMAL = 3;

	/* ============Constante Missile ZigZag========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_ZIGZAG = "/images/Bombe-ZigZag.png";
	protected static final int VITESSE_CHUTE_ZIGZAG = 1;

	/* ============Constante Mines========== */
	// Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MINES = "/images/mine.png";
	protected static final int VITESSE_CHUTE_MINES = 1;

	/* =======Constante Tableau Missile======== */
	protected static int NOMBRE_MISSILE_INIT = 5;
	protected static final ArrayList<Entite> MES_MISSILES = new ArrayList<>();

	/* ==============Constante Missile Avion===== */
	public static final int HAUTEUR_MISSILE_AVION = 60;
	public static final int LARGEUR_MISSILE_AVION = 50;
	public static final int LARGEUR_MISSILE_SECONDAIRE_AVION = 50;
	protected static final String IMAGE_MISSILE_AVION = "/images/tir-avion.png";
	protected static final String IMAGE_MISSILE_TIR_ON_FIRE = "/images/tir-on-fire.png";
	public static final int DELTA_MISSILE = 45;
	public static final int DELTA_MISSILE_SECONDAIRE = 45;
	protected static final int NOMBRE_MISSILE_TIR_INIT = 5;
	public static final ArrayList<Entite> MES_TIR_MISSILE = new ArrayList<>();

	/* ==========Vie====================== */
	protected static final int NBREDEVIE = 3;
	protected static final String IMAGE_VIE = "/images/avion-icone.png";
	protected static final String IMAGE_ICONE_VIES = "/images/vie-icone.png";

	/* =============imageBouton======= */
	protected static final String BOUTON = "/images/bouton.png";
	protected static final String BOUTON_HOVER = "/images/bouton-survol.png";
	protected static final String BOUTON_REJOUER = "/images/bout-rejouer.png";
	protected static final String BOUTON_REJOUER_HOVER = "/images/bout-rejouer-survol.png";
	protected static final String BOUTON_SCORES = "/images/bout-scores.png";
	protected static final String BOUTON_SCORES_HOVER = "/images/bout-scores-survol.png";
	protected static final String BOUTON_QUITTER = "/images/bout-quitter.png";
	protected static final String BOUTON_QUITTER_HOVER = "/images/bout-quitter-survol.png";

	/* ===========LOGO============ */
	protected static final String LOGO = "/images/logo.png";

	/*========Image Fond=====*/
	protected static final String IMAGE_FOND_SCORE = "/images/fond-scores.png";
}
