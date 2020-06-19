package com.cda.model;

public class Chrono implements Runnable {

    @Override
    public void run() {
        while (!TableauDeBord.finDuJeu) {
           // MaFenetre.vBackgroundWindow.PosyFond++;
            MaFenetre.vBackgroundWindow.repaint();
            System.out.println(GestionCollision.score);
            try {
                Thread.sleep(Constantes.VITESSE_DEFILEMENT_FOND);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
