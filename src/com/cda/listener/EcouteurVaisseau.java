package com.cda.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cda.model.Constantes;
import com.cda.model.Vaisseau;

public class EcouteurVaisseau implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			Vaisseau.dY = Constantes.VITESSE_VAISSEAU;
			break;
		case KeyEvent.VK_UP:
			Vaisseau.dY = -Constantes.VITESSE_VAISSEAU;
			break;
		case KeyEvent.VK_RIGHT:
			Vaisseau.dX = Constantes.VITESSE_VAISSEAU;
			break;
		case KeyEvent.VK_LEFT:
			Vaisseau.dX = -Constantes.VITESSE_VAISSEAU;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			Vaisseau.dY = 0;
			break;
		case KeyEvent.VK_UP:
			Vaisseau.dY = 0;
			break;
		case KeyEvent.VK_RIGHT:
			Vaisseau.dX = 0;
			break;
		case KeyEvent.VK_LEFT:
			Vaisseau.dX = 0;
			break;
		}
	}
}