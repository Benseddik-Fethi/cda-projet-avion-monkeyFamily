package com.cda.model;

<<<<<<< HEAD
=======
import javax.swing.ImageIcon;
import javax.swing.JFrame;

>>>>>>> dev
import com.cda.listener.EcouteurVaisseau;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MaFenetre extends JFrame {
    public static TableauDeBord vBackgroundWindow;

<<<<<<< HEAD
    public MaFenetre() {
        setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Test");
        setResizable(false);
        vBackgroundWindow = new TableauDeBord(this);
        this.getContentPane().add(vBackgroundWindow);
        this.addKeyListener(new EcouteurVaisseau());
        setVisible(true);
    }
=======
	public MaFenetre() {
		setSize(Constantes.FENETRE_WIDTH, Constantes.FENETRE_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("FlightFight");
		setResizable(false);
		setLocationRelativeTo(null);
		vBackgroundWindow = new TableauDeBord(this);
		this.getContentPane().add(vBackgroundWindow);
		this.addKeyListener(new EcouteurVaisseau());
		setIconImage(new ImageIcon(this.getClass().getResource("/images/test-icon.png")).getImage());
		setVisible(true);
	}
>>>>>>> dev
}