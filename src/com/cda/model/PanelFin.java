package com.cda.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFin extends JPanel {
	private final ImageIcon icoQuitter = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER));
	private final Image imgQuitter = icoQuitter.getImage();
	private final ImageIcon icoRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER));
	private final Image imgRejouer = icoRejouer.getImage();
	private final ImageIcon icoScores = new ImageIcon(getClass().getResource(Constantes.BOUTON_SCORES));
	private final Image imgScores = icoScores.getImage();
	private ImageIcon icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));;
	private Image imgBandeFond = icoBandeFond.getImage();

	public PanelFin() {
		this.setLayout(null);
		JPanel lancerPartie = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgMissile, 0, 0, 200, 50, null);
			}
		};
		lancerPartie.setOpaque(false);
		lancerPartie.setBounds(200, 350, 200, 50);
		this.add(lancerPartie);
		setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
		this.imgBandeFond = this.icoBandeFond.getImage();

		lancerPartie.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				nomJoueur2 = nomJoueur.getText().trim();
				if (nomJoueur2.length() != 0) {
					cdaFenetre.lancerPartiePanel();
					MaFenetre.monSon.musiqueFondStart();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoBouton = new ImageIcon(getClass().getResource(Constantes.BOUTON_HOVER));
				imgMissile = icoBouton.getImage();
				lancerPartie.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoBouton = new ImageIcon(getClass().getResource(Constantes.BOUTON));
				imgMissile = icoBouton.getImage();
				lancerPartie.repaint();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
		g.drawImage(imgLogo, 150, 500, 300, 333, null);

	}

}
