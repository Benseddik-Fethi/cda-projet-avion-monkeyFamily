package com.cda.model;

/**
 * Constantes du projet
 */
public class Constantes {

    /**
     * Utilis� dans la classe Ecouteur Vaisseau dans le package com.cda.listener.
     *
     * @param <b>VITESSE</b> permet de r�gler la vitesse du vaisseau en modifiant la
     * valeur.
     */
    public static final int VITESSE_VAISSEAU = 5;

    /**
     * Utilis� dans la classe Chrono dans le package com.cda.model.
     *
     * @param <b>VITESSE_DEFILEMENT_FOND</b> permet de r�gler la vitesse de
     * d�filement du fond en modifiant la
     * valeur.
     */
    protected final static int VITESSE_DEFILEMENT_FOND = 5;

    /**
     * Utilis� dans la classe MaFenetre dans le package com.cda.listener.
     *
     * @param <b>FENETRE_WIDTH</b> permet de param�trer la largeur de la fen�tre de
     * jeu.
     */
    protected final static int FENETRE_WIDTH = 600;

    /**
     * Utilis� dans les classes MaFenetre, BackgroundWindow, MaFenetre dans le
     * package com.cda.listener.
     *
     * @param <b>FENETRE_HEIGHT</b> permet de param�trer la hauteur de la fen�tre de
     * jeu.
     */
    protected final static int FENETRE_HEIGHT = 800;

    /**
     * Utilis� dans les classes BackgroundWindow, MaFenetre dans le package
     * com.cda.listener.
     *
     * @param <b>IMAGE_HEIGHT</b> permet de param�trer la hauteur du background,
     * utilis� pour le d�filement vertical.
     */
    protected final static int IMAGE_HEIGHT = FENETRE_HEIGHT / 2;

    /**
     * @param <b>IMAGES</b>
     */
    // Utilis� dans les classes Vaisseau, MaFenetre dans le package
    // com.cda.listener.
    protected static final String AVION_TOP = "/images/avion-top.png";

    // Utilis� dans la classe Vaisseau dans le package com.cda.listener.
    protected static final String AVION_LEFT = "/images/avion-left.png";

    // Utilis� dans la classe Vaisseau dans le package com.cda.listener.
    protected static final String AVION_RIGHT = "/images/avion-right.png";

    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String FOND = "/images/fond.jpg";

    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_FEU = "/images/missile-feu.png";

    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_GLACE = "/images/missile-glace.png";

    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_NORMAL = "/images/missile-normal.png";

    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_ZIGZAG = "/images/missile-zigzag.png";
}
