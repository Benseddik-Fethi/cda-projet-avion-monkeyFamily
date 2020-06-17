package com.cda.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cda.model.Constantes;
import com.cda.model.TableauDeBord;
import com.cda.model.Vaisseau;

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
		}
	}
}
