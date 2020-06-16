package com.cda.model;

import javax.swing.*;

public class MaFenetre extends JFrame {
    public static final  String FOND_ECRAN = "null";

    public MaFenetre() {
        setSize(600, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Test");
        setVisible(true);
        setResizable(false);

    }
}
