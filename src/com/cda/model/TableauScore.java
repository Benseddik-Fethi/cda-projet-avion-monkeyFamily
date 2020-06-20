package com.cda.model;

import javax.swing.*;
import java.util.ArrayList;

public class TableauScore extends Entite {
    public static ArrayList<String> score = new ArrayList<>();

    public TableauScore() {
        this.hauteur = 55;
        this.largeur = 50;
        this.xPos = 500;
        this.yPos = 20;
        this.strImage = "/images/score-0.png";
        this.icoMissile = new ImageIcon(getClass().getResource(this.strImage));
        this.imgMissile = this.icoMissile.getImage();
        initHashMap();
    }

    private void initHashMap() {
        score.add("/images/score-0.png");
        score.add("/images/score-1.png");
        score.add("/images/score-2.png");
        score.add("/images/score-3.png");
        score.add("/images/score-4.png");
        score.add("/images/score-5.png");
        score.add("/images/score-6.png");
        score.add("/images/score-7.png");
        score.add("/images/score-8.png");
        score.add("/images/score-9.png");
    }
}
