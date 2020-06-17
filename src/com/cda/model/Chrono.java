package com.cda.model;

public class Chrono implements Runnable {

    @Override
    public void run() {
        while (!BackgroundWindow.finDuJeu) {
            MaFenetre.vBackgroundWindow.yFond++;
            MaFenetre.vBackgroundWindow.repaint();
            try {
                Thread.sleep(Constantes.VITESSE_DEFILEMENT_FOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
