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
import com.cda.program.Program;

class Accueil extends JPanel {
	public static String nomJoueur2;
	protected JTextField nomJoueur = new JTextField();
	private final ImageIcon icoBandeFond;
	private final Image imgBandeFond;
	private ImageIcon icoBouton = new ImageIcon(getClass().getResource(Constantes.BOUTON));
	private Image imgMissile = icoBouton.getImage();

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
		nomJoueur.setOpaque(false);
		nomJoueur.setHorizontalAlignment(JTextField.CENTER);
		nomJoueur.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		Font font = new Font("impact", Font.BOLD, 40);
		nomJoueur.setBounds(200, 280, 200, 50);
		nomJoueur.setFont(font);
		lancerPartie.setBounds(200, 350, 200, 50);
		this.add(lancerPartie);
		this.add(nomJoueur);
		setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
		this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND_INTRO));
		this.imgBandeFond = this.icoBandeFond.getImage();
		lancerPartie.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				nomJoueur2 = nomJoueur.getText().trim().replace(" ", "-");
				if (nomJoueur2.length() >3 && nomJoueur2.length()<6) {
					Program.vMaFenetre.lancerPartiePanel();
					MaFenetre.monSonIntro.stopMusique();
					MaFenetre.monSon.startMusique();
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
	}
}
