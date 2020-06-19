package com.cda.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
class Accueil extends JPanel {
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;
    public Accueil(final MaFenetre cdaFenetre) {

        JButton lancerPartie = new JButton();
        lancerPartie.setText("lancer une partie");
        this.add(lancerPartie);
        setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.FOND));
        this.imgBandeFond = this.icoBandeFond.getImage();

        lancerPartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cdaFenetre.lancerPartiePanel();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
    }
}

