package com.cda.model;

import javax.swing.*;
import java.awt.*;

public class PanelScore extends JPanel {
    private final ImageIcon icoBandeFond;
    private final Image imgBandeFond;

    public PanelScore(final MaFenetre cdaFenetre) {
        this.setLayout(null);
        setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.IMAGE_FOND_SCORE));
        this.imgBandeFond = this.icoBandeFond.getImage();



    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
    }
}
