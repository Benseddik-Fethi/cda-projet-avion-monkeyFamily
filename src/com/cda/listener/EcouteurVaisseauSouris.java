package com.cda.listener;

import com.cda.model.MaFenetre;
import com.cda.model.TableauDeBord;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EcouteurVaisseauSouris implements MouseListener, MouseMotionListener {
    int sX = -1, sY = -1;
    boolean dragSouris = false;
    int curX = -1, curY = -1;

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = e.getPoint();
        TableauDeBord.vaisseau.setxPos(p.x);
        TableauDeBord.vaisseau.setyPos(p.y);
//		traineeAvion();
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
        TableauDeBord.vaisseau.deplacementVaisseauHorizontal();
        TableauDeBord.vaisseau.deplacementVaisseauVertical();
//		traineeAvion();
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
//
//	public void traineeAvion() {
//		MaFenetre.vBackgroundWindow.traineeAvion.setTirMissile(true);
//		MaFenetre.vBackgroundWindow.traineeAvion
//				.setyPos((TableauDeBord.vaisseau.getyPos()) - Constantes.HAUTEUR_MISSILE_AVION);
//		MaFenetre.vBackgroundWindow.tirSecondaireAvion
//				.setxPos((TableauDeBord.vaisseau.getxPos()) + Constantes.LARGEUR_AVION);
//	}

}
