package com.cda.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cda.model.Vaisseau;

public class EcouteurVaisseau implements KeyListener {
	private static final int VITESSE = 5;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			Vaisseau.dY = VITESSE;
			break;
		case KeyEvent.VK_UP:
			Vaisseau.dY = -VITESSE;
			break;
		case KeyEvent.VK_RIGHT:
			Vaisseau.dX = VITESSE;
			break;
		case KeyEvent.VK_LEFT:
			Vaisseau.dX = -VITESSE;
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
