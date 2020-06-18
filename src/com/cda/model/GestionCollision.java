package com.cda.model;

import java.awt.*;
import java.util.ArrayList;

public abstract class GestionCollision {

    public static void collissionArray(Entite vVaisseau, ArrayList<Entite> listMissile) {
        for (Entite entite : listMissile) {
            collision(entite, vVaisseau);
        }
    }

    public static void collision(Entite vMissile, Entite vVaisseau) {
        Rectangle rect1 = vMissile.getBounds();
        Rectangle rect2 = vVaisseau.getBounds();
        if (rect2.intersects(rect1)) {
            if (vVaisseau instanceof TirVaisseau) {
                vMissile.detruit = true;
                vVaisseau.detruit = true;

            } else {
                vMissile.detruit = true;
            }

        }

    }
}
