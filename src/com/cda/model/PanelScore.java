package com.cda.model;

import javax.swing.*;
import java.awt.*;

public class PanelScore extends JPanel {
    private final ImageIcon icoQuitter = new ImageIcon(getClass().getResource(Constantes.BOUTON));
    private final Image imgQuitter = icoQuitter.getImage();
    private final ImageIcon icoReprendre = new ImageIcon(getClass().getResource(Constantes.BOUTON));
    private final Image imgReprendre = icoReprendre.getImage();
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;

    public PanelScore() {
        this.setLayout(null);


    }
}
