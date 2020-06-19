package com.cda.model;

import com.cda.listener.EcouteurVaisseau;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.*;

public class MaFenetre extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    public static final String ACCUEIL_PANEL = "ACCUEIL_PANEL";
    public static final String PARTIE_PANEL = "PARTIE_PANEL";
    private Container contentPane;
    public static TableauDeBord vBackgroundWindow;


    public MaFenetre() {
        setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("FlightFight");
        setResizable(false);
        setLocationRelativeTo(null);
        vBackgroundWindow = new TableauDeBord(this);
        this.addKeyListener(new EcouteurVaisseau());
        this.setLayout(cardLayout);
        contentPane = this.getContentPane();
        contentPane.add(new Accueil(this), ACCUEIL_PANEL);
        this.getContentPane().add(vBackgroundWindow,PARTIE_PANEL);
        this.setVisible(true);
        setIconImage(new ImageIcon(this.getClass().getResource("/images/test-icon.png")).getImage());
        setVisible(true);
    }

    public void lancerPartiePanel() {
        cardLayout.show(contentPane, PARTIE_PANEL);
        vBackgroundWindow.go();
    }
}