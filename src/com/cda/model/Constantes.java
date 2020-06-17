package com.cda.model;

/**
 * Constantes du projet
 *
 */
public class Constantes {

	/**
	 * Utilisé dans la classe Ecouteur Vaisseau dans le package com.cda.listener.
	 *
	 * @param <b>VITESSE</b> permet de régler la vitesse du vaisseau en modifiant la
	 *                       valeur.
	 * 
	 */
	public static final int VITESSE_VAISSEAU = 5;

	/**
	 * Utilisé dans la classe Chrono dans le package com.cda.model.
	 *
	 * @param <b>VITESSE_DEFILEMENT_FOND</b> permet de régler la vitesse de
	 *                                       défilement du fond en modifiant la
	 *                                       valeur.
	 * 
	 */
	protected final static int VITESSE_DEFILEMENT_FOND = 5;

	/**
	 * Utilisé dans la classe MaFenetre dans le package com.cda.listener.
	 *
	 * @param <b>FENETRE_WIDTH</b> permet de paramétrer la largeur de la fenêtre de
	 *                             jeu.
	 * 
	 */
	protected final static int FENETRE_WIDTH = 600;

	/**
	 * Utilisé dans les classes MaFenetre, BackgroundWindow, MaFenetre dans le
	 * package com.cda.listener.
	 *
	 * @param <b>FENETRE_HEIGHT</b> permet de paramétrer la hauteur de la fenêtre de
	 *                              jeu.
	 * 
	 */
	protected final static int FENETRE_HEIGHT = 800;

	/**
	 * Utilisé dans les classes BackgroundWindow, MaFenetre dans le package
	 * com.cda.listener.
	 *
	 * @param <b>IMAGE_HEIGHT</b> permet de paramétrer la hauteur du background,
	 *                            utilisé pour le défilement vertical.
	 * 
	 */
	protected final static int IMAGE_HEIGHT = FENETRE_HEIGHT / 2;

	/**
	 * 
	 * @param <b>IMAGES</b>
	 * 
	 */
	// Utilisé dans les classes Vaisseau, MaFenetre dans le package
	// com.cda.listener.
	protected static final String AVION_TOP = "/images/avion-top.png";

	// Utilisé dans la classe Vaisseau dans le package com.cda.listener.
	protected static final String AVION_LEFT = "/images/avion-left.png";

	// Utilisé dans la classe Vaisseau dans le package com.cda.listener.
	protected static final String AVION_RIGHT = "/images/avion-right.png";

	// Utilisé dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String FOND = "/images/fond.png";

	// Utilisé dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_FEU = "/images/missile-feu.png";

	// Utilisé dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_GLACE = "/images/missile-glace.png";

	// Utilisé dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_NORMAL = "/images/missile-normal.png";

	// Utilisé dans la classe BackgroundWindow dans le package com.cda.listener.
	protected static final String MISSILE_ZIGZAG = "/images/missile-zigzag.png";
}
