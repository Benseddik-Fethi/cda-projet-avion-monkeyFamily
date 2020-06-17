package com.cda.model;

import javax.swing.JFrame;

import com.cda.listener.EcouteurVaisseau;

public class MaFenetre extends JFrame {
	public static BackgroundWindow vBackgroundWindow;

	public MaFenetre() {
		setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Test");
		setResizable(false);
		vBackgroundWindow = new BackgroundWindow(this);
		new Vaisseau(240, 600, Constantes.AVION_TOP);
		this.getContentPane().add(vBackgroundWindow);
		this.addKeyListener(new EcouteurVaisseau());
		setVisible(true);
	}
}