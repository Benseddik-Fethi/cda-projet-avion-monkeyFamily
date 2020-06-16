package com.cda.listener;

import com.cda.model.Vaisseau;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteurClavier implements KeyListener {
    public Vaisseau vVaisseau;

    public EcouteurClavier(Vaisseau vVaisseau) {
        this.vVaisseau = vVaisseau;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:

                System.out.println("Bas");
                break;
            case KeyEvent.VK_UP:

                System.out.println("Haut");
                break;
            case KeyEvent.VK_RIGHT:

                System.out.println("Droite");
                break;
            case KeyEvent.VK_LEFT:

                System.out.println("Gauche");
                break;

        }

        vVaisseau.repaint();

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
