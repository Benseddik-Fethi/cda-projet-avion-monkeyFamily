package com.cda.model;

public class Chrono implements Runnable {

    public static boolean pause = false;
    protected static int timerBouclier = 0;

    @Override
    public void run() {
        while (!TableauDeBord.finDuJeu) {
            if (!pause) {
                MaFenetre.vBackgroundWindow.PosyFond++;
                MaFenetre.vBackgroundWindow.repaint();
                timerBouclier++;

                if (timerBouclier == 1000) {
                    Bouclier.actif = false;
                    timerBouclier = 0;
                }
            }
            try {
                Thread.sleep(Constantes.VITESSE_DEFILEMENT_FOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

