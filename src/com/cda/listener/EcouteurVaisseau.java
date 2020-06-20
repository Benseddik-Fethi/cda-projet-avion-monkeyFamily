package com.cda.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cda.model.Bouclier;
import com.cda.model.Chrono;
import com.cda.model.Constantes;
import com.cda.model.MaFenetre;
import com.cda.model.TableauDeBord;

public class EcouteurVaisseau implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_NUMPAD1:
			Chrono.pause = true;
			break;
		case KeyEvent.VK_NUMPAD2:
			Chrono.pause = false;
			break;
		case KeyEvent.VK_NUMPAD0:
			// bouclier();
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
		case KeyEvent.VK_NUMPAD1:
			Chrono.pause = true;
			break;
		case KeyEvent.VK_NUMPAD2:
			Chrono.pause = false;
			break;
		case KeyEvent.VK_NUMPAD0:
			// bouclier();
			break;
		case KeyEvent.VK_DOWN:
			TableauDeBord.vaisseau.setdY(Constantes.VITESSE_VAISSEAU);
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
				MaFenetre.monSonTir.startMusique();
				tirDouble();
				tirSecondaire();
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_NUMPAD1:
			Chrono.pause = true;
			break;
		case KeyEvent.VK_NUMPAD2:
			Chrono.pause = false;
			break;
		case KeyEvent.VK_NUMPAD0:
			Bouclier.actif = true;
			Bouclier.NbreBouclier--;
			// bouclier();
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
			MaFenetre.monSonTir.stopMusique();
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
}
