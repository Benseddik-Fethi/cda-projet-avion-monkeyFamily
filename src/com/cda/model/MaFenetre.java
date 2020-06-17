package com.cda.model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.cda.listener.EcouteurVaisseau;

public class MaFenetre extends JFrame {
	public static TableauDeBord vBackgroundWindow;

	public MaFenetre() {
		setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("FlightFight");
		setResizable(false);
		vBackgroundWindow = new TableauDeBord(this);
		this.getContentPane().add(vBackgroundWindow);
		this.addKeyListener(new EcouteurVaisseau());
		setIconImage(new ImageIcon(this.getClass().getResource("/images/test-icon.png")).getImage());
		setVisible(true);
	}
}