package com.cda.listener;

import com.cda.model.BackgroundWindow;
import com.cda.model.MaFenetre;
import com.cda.model.Vaisseau;

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
                MaFenetre.vBackgroundWindow.vaisseau.descend();
                break;
            case KeyEvent.VK_UP:
               MaFenetre.vBackgroundWindow.vaisseau.monte();
                break;
            case KeyEvent.VK_RIGHT:
                MaFenetre.vBackgroundWindow.vaisseau.droite();
                break;
            case KeyEvent.VK_LEFT:
                MaFenetre.vBackgroundWindow.vaisseau.gauche();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
