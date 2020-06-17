package com.cda.model;

import javax.swing.JFrame;

import com.cda.listener.EcouteurVaisseau;

public class MaFenetre extends JFrame {
	public static TableauDeBord vBackgroundWindow;

	public MaFenetre() {
		setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Test");
		setResizable(false);
//		Toolkit kit = Toolkit.getDefaultToolkit();
//		Image img = kit.getImage("c:/logo.gif");
//		setIconImage(img);
		vBackgroundWindow = new TableauDeBord(this);
		this.getContentPane().add(vBackgroundWindow);
		this.addKeyListener(new EcouteurVaisseau());
		setVisible(true);
	}
}