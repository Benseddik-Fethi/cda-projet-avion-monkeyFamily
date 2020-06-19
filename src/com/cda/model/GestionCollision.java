package com.cda.model;

import java.awt.*;
import java.util.ArrayList;

public abstract class GestionCollision {
    public static int score = 0;

    public static void collissionArray(Entite vVaisseau, ArrayList<Entite> listMissile) {
        for (Entite entite : listMissile) {
            collision(entite, vVaisseau);
        }
    }

    public static void collision(Entite vMissile, Entite vVaisseau) {
        Rectangle rect1 = vMissile.getBounds();
        Rectangle rect2 = vVaisseau.getBounds();
        if (rect2.intersects(rect1)) {
            if ((vVaisseau instanceof TirVaisseau && vMissile instanceof BombeFeu)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeGlace)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeZigZag)
                    || (vVaisseau instanceof TirVaisseau && vMissile instanceof BombeNormal)) {
                vMissile.detruit = true;
                vVaisseau.detruit = true;
                score += 5;
            }else if((vVaisseau instanceof Vaisseau && vMissile instanceof BombeFeu)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeGlace)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeZigZag)
                    || (vVaisseau instanceof Vaisseau && vMissile instanceof BombeNormal)){
                vMissile.detruit = true;
                score -=5;
            } else {
                vMissile.detruit = true;
                score +=1;

            }

        }

    }
}
