package com.cda.model;

public class Chrono implements Runnable {
    protected static int timerBouclier = 0;
    protected static int timerDifficult = 0;
    protected static int ajoutBombe = 0;

    @Override
    public void run() {
        while (!TableauDeBord.finDuJeu) {
            MaFenetre.vBackgroundWindow.PosyFond++;
            timerBouclier++;
            timerDifficult++;
            if (timerBouclier == 1000) {
                Bouclier.actif = false;
            }

            MaFenetre.vBackgroundWindow.repaint();
            try {
                Thread.sleep(Constantes.VITESSE_DEFILEMENT_FOND);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
