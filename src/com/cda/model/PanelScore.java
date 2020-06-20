package com.cda.model;

import javax.swing.*;
import java.awt.*;

public class PanelScore extends JPanel {
    private ImageIcon icoQuitter = new ImageIcon(getClass().getResource(Constantes.BOUTON));
    private Image imgQuitter = icoQuitter.getImage();
    private ImageIcon icoReprendre = new ImageIcon(getClass().getResource(Constantes.BOUTON));
    private Image imgReprendre = icoReprendre.getImage();
    private ImageIcon icoBandeFond;
    private Image imgBandeFond;

    public PanelScore() {
        this.setLayout(null);



    }
}
