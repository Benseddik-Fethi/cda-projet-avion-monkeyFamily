package com.cda.model;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.cda.listener.EcouteurVaisseau;

public class MaFenetre extends JFrame {
	public static Son monSon;
	public static Son monSonTir;
	public static Son monSonIntro;
	protected final CardLayout cardLayout = new CardLayout();
	public static final String ACCUEIL_PANEL = "ACCUEIL_PANEL";
	public static final String PARTIE_PANEL = "PARTIE_PANEL";
	public static final String FIN_PANEL = "FIN_PANEL";
	public static final String SCORE_PANEL = "SCORE_PANEL";
	private final Container contentPane;
	public static TableauDeBord vBackgroundWindow;
	public static Accueil vAccueil;
	public static PanelFin vPanelFin;
	public static PanelScore vPanelScore;

	public MaFenetre() {
		vAccueil = new Accueil(this);
		vPanelFin = new PanelFin(this);

		setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Monkey Squad");
		setResizable(false);
		setLocationRelativeTo(null);
		vBackgroundWindow = new TableauDeBord(this);
		this.addKeyListener(new EcouteurVaisseau());
		setIconImage(new ImageIcon(this.getClass().getResource("/images/test-icon.png")).getImage());
		this.setLayout(cardLayout);
		contentPane = this.getContentPane();
		contentPane.add(vAccueil, ACCUEIL_PANEL);
		contentPane.add(vPanelFin, FIN_PANEL);
		contentPane.add(vBackgroundWindow, PARTIE_PANEL);

		monSon = new Son("/audio/music.wav");
		monSonIntro = new Son("/audio/intro.wav");
		monSonTir = new Son("/audio/tir.wav");
		MaFenetre.monSonIntro.startMusique();
		this.setVisible(true);
	}

	public void lancerPartiePanel() {
		cardLayout.show(contentPane, PARTIE_PANEL);
		vBackgroundWindow.go();
		vBackgroundWindow.requestFocus(true);
	}

	public void finPartie() {
		cardLayout.show(contentPane, FIN_PANEL);
	}

	public void rejouer() {
		cardLayout.show(contentPane, PARTIE_PANEL);
		vBackgroundWindow.repaint();
		vBackgroundWindow.requestFocus(true);
	}
	public void afficheScore(){
		vPanelScore = new PanelScore(this);
		contentPane.add(vPanelScore, SCORE_PANEL);
		cardLayout.show(contentPane, SCORE_PANEL);
	}
}