package com.cda.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cda.model.Vaisseau;

public class EcouteurClavier implements KeyListener {
	int positionX = Vaisseau.x;
	int positionY = Vaisseau.y;
	public static final String img1 = "/images/avion-top.png";
	public static final String img2 = "/images/avion-left.png";
	public static final String img3 = "/images/avion-right.png";
	Vaisseau vVaisseau;

	public EcouteurClavier(Vaisseau vVaisseau) {
		this.vVaisseau = vVaisseau;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			int positionDown = (int) (positionY < 650 ? positionY += 20 : positionY);
			Vaisseau.y = positionDown;
			break;
		case KeyEvent.VK_UP:
			int positionUp = (int) (positionY > 20 ? positionY -= 20 : positionY);
			Vaisseau.y = positionUp;
			break;
		case KeyEvent.VK_RIGHT:
			int positionRight = (int) (positionX < 550 ? positionX += 20 : (positionX = -50));
			vVaisseau.chargerImag(img3);
			Vaisseau.x = positionRight;
			break;
		case KeyEvent.VK_LEFT:
			int positionLeft = (int) (positionX > -50 ? positionX -= 20 : (positionX = 550));
			vVaisseau.chargerImag(img2);
			Vaisseau.x = positionLeft;
			break;
		}
		vVaisseau.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		vVaisseau.chargerImag(img1);
	}
}
