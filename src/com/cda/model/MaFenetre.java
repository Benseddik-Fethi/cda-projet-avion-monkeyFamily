package com.cda.model;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.cda.listener.EcouteurVaisseau;

public class MaFenetre extends JFrame {
	protected final CardLayout cardLayout = new CardLayout();
	public static final String ACCUEIL_PANEL = "ACCUEIL_PANEL";
	public static final String PARTIE_PANEL = "PARTIE_PANEL";
	public static final String FIN_PANEL = "FIN_PANEL";
	public static TableauDeBord vBackgroundWindow;
	public static Accueil vAccueil;
	private Container contentPane;
	public static Son monSon;

	public MaFenetre() {
		vAccueil = new Accueil(this);
		setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("FlightFight");
		setResizable(false);
		setLocationRelativeTo(null);
		vBackgroundWindow = new TableauDeBord(this);
		this.addKeyListener(new EcouteurVaisseau());
		setIconImage(new ImageIcon(this.getClass().getResource("/images/test-icon.png")).getImage());
		this.setLayout(cardLayout);
		contentPane = this.getContentPane();
		contentPane.add(vAccueil, ACCUEIL_PANEL);
		contentPane.add(vBackgroundWindow, PARTIE_PANEL);
		monSon = new Son("/1-welcome.wav");
		this.setVisible(true);
	}

	public void lancerPartiePanel() {
		cardLayout.show(contentPane, PARTIE_PANEL);
		vBackgroundWindow.go();
		vBackgroundWindow.requestFocus(true);
	}

	public void finDePArtie() {
		cardLayout.show(contentPane, ACCUEIL_PANEL);
	}
}