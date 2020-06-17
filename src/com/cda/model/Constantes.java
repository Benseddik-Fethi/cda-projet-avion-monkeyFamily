package com.cda.model;

import com.cda.utils.Tools;

import java.util.ArrayList;

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

/*========Constante Avion========*/
    protected static final int HAUTEUR_AVION = 50;
    protected static final int LARGEUR_AVION = 50;
    protected static final int POSITIONX_DEPART_AVION =250;
    protected static final int POSITIONY_DEPART_AVION =650;

    /*-----------------Constante Missile---------*/
    protected static final int LARGEUR_MISSILE = 50;
    protected static final int HAUTEUR_MISSILE = 50;
    protected static final int POSITION_DEPART = 0;


    /*============Constante Missile Feu==========*/
    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_FEU = "/images/missile-feu.png";
    protected static final int VITESSE_CHUTE_FEU = 3;

    /*============Constante Missile Glace==========*/
    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_GLACE = "/images/missile-glace.png";
    protected static final int VITESSE_CHUTE_GLACE = 2;

    /*============Constante Missile Normal==========*/
    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_NORMAL = "/images/missile-normal.png";
    protected static final int VITESSE_CHUTE_NORMAL = 2;

    /*============Constante Missile ZigZag==========*/
    // Utilis� dans la classe BackgroundWindow dans le package com.cda.listener.
    protected static final String MISSILE_ZIGZAG = "/images/missile-zigzag.png";
    protected static final String MISSILE_ZIGZAG_DROITE = "/images/missile-zigzag-droite.png";
    protected static final String MISSILE_ZIGZAG_GAUCHE = "/images/missile-zigzag-gauche.png";
    protected static final int VITESSE_CHUTE_ZIGZAG = 1;

    /*=======Constante Tableau Missile========*/
    protected static final int NOMBRE_MISSILE_INIT = 5;
    protected static final ArrayList<Entite> mesMissile = new ArrayList<>();


}
