package com.cda.listener;

import com.cda.model.Bouclier;
import com.cda.model.Constantes;
import com.cda.model.MaFenetre;
import com.cda.model.TableauDeBord;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EcouteurVaisseau implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_NUMPAD0:

                //bouclier();
                break;
            case KeyEvent.VK_DOWN:
                TableauDeBord.vaisseau.setdY(Constantes.VITESSE_VAISSEAU);
                TableauDeBord.bouclier.setdY(Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_UP:
                TableauDeBord.vaisseau.setdY(-Constantes.VITESSE_VAISSEAU);
                TableauDeBord.bouclier.setdY(-Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_RIGHT:
                TableauDeBord.vaisseau.setdX(Constantes.VITESSE_VAISSEAU);
                TableauDeBord.bouclier.setdX(Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_LEFT:
                TableauDeBord.vaisseau.setdX(-Constantes.VITESSE_VAISSEAU);
                TableauDeBord.bouclier.setdX(-Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_SPACE:
                if (!MaFenetre.vBackgroundWindow.missileAvion.isTirMissile()) {
                    tirDouble();
                    tirSecondaire();
                    break;
                }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_NUMPAD0:
                //bouclier();
                break;
            case KeyEvent.VK_DOWN:
                TableauDeBord.vaisseau.setdY(Constantes.VITESSE_VAISSEAU);
//			traineeAvion();
                break;
            case KeyEvent.VK_UP:
                // traineeAvion();
                TableauDeBord.vaisseau.setdY(-Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_RIGHT:
                // traineeAvion();
                TableauDeBord.vaisseau.setdX(Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_LEFT:
                // traineeAvion();
                TableauDeBord.vaisseau.setdX(-Constantes.VITESSE_VAISSEAU);
                break;
            case KeyEvent.VK_SPACE:
                if (!MaFenetre.vBackgroundWindow.missileAvion.isTirMissile()) {
                    tirDouble();
                    tirSecondaire();
                    break;
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_NUMPAD0:
                Bouclier.actif = true;
                Bouclier.NbreBouclier--;
                //bouclier();
                break;
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
                if (!MaFenetre.vBackgroundWindow.missileAvion.isTirMissile()) {
                    tirDouble();

                    break;

                }
        }
    }

    public void tirDouble() {
        MaFenetre.vBackgroundWindow.missileAvion.setTirMissile(true);
        MaFenetre.vBackgroundWindow.missileAvion
                .setyPos((TableauDeBord.vaisseau.getyPos() - 50) - Constantes.HAUTEUR_MISSILE_AVION);
        MaFenetre.vBackgroundWindow.missileAvion
                .setxPos((TableauDeBord.vaisseau.getxPos() - 75) + Constantes.LARGEUR_AVION);
    }

    public void tirSecondaire() {
        MaFenetre.vBackgroundWindow.tirSecondaireAvion.setTirMissile(true);
        MaFenetre.vBackgroundWindow.tirSecondaireAvion
                .setyPos((TableauDeBord.vaisseau.getyPos() - 50) - Constantes.HAUTEUR_MISSILE_AVION);
        MaFenetre.vBackgroundWindow.tirSecondaireAvion
                .setxPos((TableauDeBord.vaisseau.getxPos() - 75) + Constantes.LARGEUR_AVION);
    }

    public void bouclier() {
        System.out.println("bouclier");
        TableauDeBord.bouclier.setTirMissile(true);
        TableauDeBord.bouclier.setyPos((TableauDeBord.vaisseau.getyPos() - 100));
        TableauDeBord.bouclier.setxPos((TableauDeBord.vaisseau.getxPos()));
    }

//	public void traineeAvion() {
//		MaFenetre.vBackgroundWindow.traineeAvion.setTirMissile(true);
//		MaFenetre.vBackgroundWindow.traineeAvion
//				.setyPos((TableauDeBord.vaisseau.getyPos()) - Constantes.HAUTEUR_MISSILE_AVION);
//		MaFenetre.vBackgroundWindow.tirSecondaireAvion
//				.setxPos((TableauDeBord.vaisseau.getxPos()) + Constantes.LARGEUR_AVION);
//	}
}
