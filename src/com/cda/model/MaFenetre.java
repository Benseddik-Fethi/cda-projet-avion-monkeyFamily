package com.cda.model;

import com.cda.listener.EcouteurVaisseau;

import javax.swing.*;
import java.awt.*;

public class MaFenetre extends JFrame {
    public static final String ACCUEIL_PANEL = "ACCUEIL_PANEL";
    public static final String PARTIE_PANEL = "PARTIE_PANEL";
    public static final String FIN_PANEL = "FIN_PANEL";
    public static final String SCORE_PANEL = "SCORE_PANEL";
    public static Son monSon;
    public static Son monSonTir;
    public static Son monSonIntro;
    public static TableauDeBord vBackgroundWindow;
    public static Accueil vAccueil;
    public static PanelFin vPanelFin;
    public static PanelScore vPanelScore;
    protected final CardLayout cardLayout = new CardLayout();
    private final Container contentPane;

    public MaFenetre() {
        vAccueil = new Accueil(this);
        vPanelFin = new PanelFin(this);
        this.setSize(600, 900);
        this.setDefaultCloseOperation(3);
        this.setTitle("Monkey Squad");
        this.setResizable(false);
        this.setLocationRelativeTo((Component) null);
        vBackgroundWindow = new TableauDeBord(this);
        this.addKeyListener(new EcouteurVaisseau());
        this.setIconImage((new ImageIcon(this.getClass().getResource("/images/test-icon.png"))).getImage());
        this.setLayout(this.cardLayout);
        this.contentPane = this.getContentPane();
        this.contentPane.add(vAccueil, "ACCUEIL_PANEL");
        this.contentPane.add(vPanelFin, "FIN_PANEL");
        this.contentPane.add(vBackgroundWindow, "PARTIE_PANEL");
        monSon = new Son("/music.wav");
        monSonIntro = new Son("/intro.wav");
        monSonTir = new Son("/tir.wav");
        monSonIntro.startMusique();
        this.setVisible(true);
    }

    public void lancerPartiePanel() {
        this.cardLayout.show(this.contentPane, "PARTIE_PANEL");
        vBackgroundWindow.go();
        vBackgroundWindow.requestFocus(true);
    }

    public void finPartie() {
        this.cardLayout.show(this.contentPane, "FIN_PANEL");
    }

    public void rejouer() {
        this.cardLayout.show(this.contentPane, "PARTIE_PANEL");
        vBackgroundWindow.repaint();
        vBackgroundWindow.requestFocus(true);
    }

    public void afficheScore() {
        vPanelScore = new PanelScore(this);
        this.contentPane.add(vPanelScore, "SCORE_PANEL");
        this.cardLayout.show(this.contentPane, "SCORE_PANEL");
    }
}