package com.cda.listener;

import com.cda.model.MaFenetre;
import com.cda.model.Vaisseau;
import com.cda.model.Vaisseau2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteurVaisseau2 implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                Vaisseau2.dY = 2;

                break;
            case KeyEvent.VK_UP:
                Vaisseau2.dY = -2;
                break;
            case KeyEvent.VK_RIGHT:

                Vaisseau2.dX = 2;
               // MaFenetre.vBackgroundWindow.vaisseau.droite();
                break;
            case KeyEvent.VK_LEFT:
                Vaisseau2.dX = -2;
               // MaFenetre.vBackgroundWindow.vaisseau.gauche();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                Vaisseau2.dY = 0;
                break;
            case KeyEvent.VK_UP:
                Vaisseau2.dY = 0;
             break;
            case KeyEvent.VK_RIGHT:
                Vaisseau2.dX = 0;
                break;
            case KeyEvent.VK_LEFT:
                Vaisseau2.dX = 0;
                break;
        }
    }
}
