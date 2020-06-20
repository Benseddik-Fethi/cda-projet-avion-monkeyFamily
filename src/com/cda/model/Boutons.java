package com.cda.model;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Boutons extends JPanel {
	ImageIcon icoBouton;
	Image imgBouton;
	ImageIcon icoHover;
	Image imgHover;

	public Boutons(String pNomImage, String pNomHover, Function test) {
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(200, 350, 200, 50);
		this.icoBouton = new ImageIcon(getClass().getResource(pNomImage));
		this.imgBouton = this.icoBouton.getImage();
		this.icoBouton = new ImageIcon(getClass().getResource(pNomHover));
		this.imgBouton = this.icoBouton.getImage();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoBouton = new ImageIcon(getClass().getResource(pNomHover));
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoBouton = new ImageIcon(getClass().getResource(pNomImage));
				repaint();
			}
		});

	}
}
