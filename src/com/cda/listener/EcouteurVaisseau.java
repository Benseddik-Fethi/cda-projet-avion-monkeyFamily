package com.cda.listener;

import com.cda.model.Constantes;
import com.cda.model.MaFenetre;
import com.cda.model.TableauDeBord;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteurVaisseau implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                TableauDeBord.vaisseau.setdY(Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_UP:
                TableauDeBord.vaisseau.setdY(-Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_RIGHT:
                TableauDeBord.vaisseau.setdX(Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_LEFT:
                TableauDeBord.vaisseau.setdX(-Constantes.VITESSE_VAISSEAU);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                TableauDeBord.vaisseau.setdY(0);
                break;
            case KeyEvent.VK_UP:
                TableauDeBord.vaisseau.setdY(0);
                break;
            case KeyEvent.VK_RIGHT:
                TableauDeBord.vaisseau.setdX(0);
                break;
            case KeyEvent.VK_LEFT:
                TableauDeBord.vaisseau.setdX(0);
                break;
            case KeyEvent.VK_SPACE:
                if(!MaFenetre.vBackgroundWindow.missileAvion.isTirMissile()){
                    MaFenetre.vBackgroundWindow.missileAvion.setyPos(TableauDeBord.vaisseau.getyPos() - Constantes.HAUTEUR_MISSILE_AVION);
                    MaFenetre.vBackgroundWindow.missileAvion.setxPos(TableauDeBord.vaisseau.getxPos() + Constantes.LARGEUR_AVION/2-1);
                    MaFenetre.vBackgroundWindow.missileAvion.setTirMissile(true);
                    break;

                }
        }
    }
}
