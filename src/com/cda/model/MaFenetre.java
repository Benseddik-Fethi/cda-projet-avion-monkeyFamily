package com.cda.model;

import javax.swing.JFrame;

import com.cda.listener.EcouteurClavier;

public class MaFenetre extends JFrame {
	public MaFenetre() {
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Test");
		setResizable(false);
//		BackgroundWindow vBackgroundWindow = new BackgroundWindow(this);
//		this.getContentPane().add(vBackgroundWindow);
		Vaisseau vVaisseau = new Vaisseau();
		this.getContentPane().add(vVaisseau);
		this.addKeyListener(new EcouteurClavier(vVaisseau));
		setVisible(true);
	}
}
