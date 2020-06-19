package com.cda.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Accueil extends JPanel {
    ImageIcon logoTeam = new ImageIcon(getClass().getResource(Constantes.LOGO));
    Image imgLogo = logoTeam.getImage();
	public static String nomJoueur2 = "";
	protected JTextField nomJoueur = new JTextField();
	ImageIcon lancer = new ImageIcon("/images/bout.png");
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	ImageIcon icoMissile = new ImageIcon(getClass().getResource(Constantes.BOUTON));
	Image imgMissile = icoMissile.getImage();

	public Accueil(final MaFenetre cdaFenetre) {
		this.setLayout(null);

		JPanel lancerPartie = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgMissile, 0, 0, 200, 50, null);
			}
		};
		lancerPartie.setOpaque(false);
		JTextField nomJoueur = new JTextField();
		nomJoueur.setOpaque(false);
		nomJoueur.setHorizontalAlignment(JTextField.CENTER);
		nomJoueur.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		Font font = new Font("impact", Font.BOLD, 40);
		nomJoueur.setBounds(200, 300, 200, 50);
		nomJoueur.setFont(font);
		lancerPartie.setBounds(200, 425, 200, 50);
		this.add(lancerPartie);
		this.add(nomJoueur);
		setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
		this.imgBandeFond = this.icoBandeFond.getImage();
		nomJoueur2 = this.nomJoueur.getText();

		lancerPartie.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				cdaFenetre.lancerPartiePanel();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				icoMissile = new ImageIcon(getClass().getResource(Constantes.BOUTON_HOVER));
				imgMissile = icoMissile.getImage();
				lancerPartie.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				icoMissile = new ImageIcon(getClass().getResource(Constantes.BOUTON));
				imgMissile = icoMissile.getImage();
				lancerPartie.repaint();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
        g.drawImage(imgLogo, 150, 500,300,333,null);

	}
}
