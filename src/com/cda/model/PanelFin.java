package com.cda.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFin extends JPanel {
	Boutons boutonQuitter;
	Boutons boutonRejouer;
	Boutons boutonScores;

	private final ImageIcon icoBandeFond;
	private final Image imgBandeFond;

	private ImageIcon icoBoutonTemp;
	private Image icoImageTemp;

	public PanelFin(final MaFenetre cdaFenetre) {

		boutonQuitter = new Boutons(Constantes.BOUTON_QUITTER);
		boutonRejouer = new Boutons(Constantes.BOUTON_REJOUER);
		boutonScores = new Boutons(Constantes.BOUTON_SCORES);

		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND_TEST));
		this.imgBandeFond = this.icoBandeFond.getImage();

		boutonQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoBoutonTemp = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER_HOVER));
				boutonQuitter.setImgBouton(icoBoutonTemp.getImage());
				boutonQuitter.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoBoutonTemp = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER));
				boutonQuitter.setImgBouton(icoBoutonTemp.getImage());
				boutonQuitter.repaint();
			}
		});

		this.add(boutonQuitter);
		this.add(boutonRejouer);
		this.add(boutonScores);

		setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
	}
}
