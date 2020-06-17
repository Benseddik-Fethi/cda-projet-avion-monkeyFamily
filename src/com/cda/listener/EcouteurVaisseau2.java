package com.cda.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.cda.model.MaFenetre;

public class EcouteurVaisseau2 implements KeyListener, MouseListener {
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
//		switch (e.getKeyCode()) {
//		case KeyEvent.VK_DOWN:
//			MaFenetre.vBackgroundWindow.vaisseau.descend();
//			break;
//		case KeyEvent.VK_UP:
//			MaFenetre.vBackgroundWindow.vaisseau.monte();
//			break;
//		case KeyEvent.VK_RIGHT:
//			MaFenetre.vBackgroundWindow.vaisseau.droite();
//			break;
//		case KeyEvent.VK_LEFT:
//			MaFenetre.vBackgroundWindow.vaisseau.gauche();
//			break;
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		MaFenetre.vBackgroundWindow.vaisseau.setX(e.getX());
		MaFenetre.vBackgroundWindow.vaisseau.setY(e.getY());
		MaFenetre.vBackgroundWindow.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
