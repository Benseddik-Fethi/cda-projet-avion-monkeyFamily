package com.cda.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.cda.model.Constantes;
import com.cda.model.MaFenetre;
import com.cda.model.Vaisseau;

public class EcouteurVaisseauSouris implements MouseListener, MouseMotionListener {
	int sX = -1, sY = -1;
	boolean dragSouris = false;
	int curX = -1, curY = -1;
	Vaisseau vVaisseau = new Vaisseau(Vaisseau.getX(), Vaisseau.getY(), Constantes.AVION_TOP);

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		vVaisseau.setX(p.x);
		vVaisseau.setY(p.y);
		if (dragSouris) {
			MaFenetre.vBackgroundWindow.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point point = e.getPoint();
		sX = point.x; // si x en cours inférieur a sX changer image vers right.

//		vVaisseau.setX(sX);
		sY = point.y;
//		vVaisseau.setY(sY);
		dragSouris = true;
		vVaisseau.deplacementVaisseauHorizontal();
		vVaisseau.deplacementVaisseauVertical();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragSouris = false;
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
