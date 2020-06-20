package com.cda.model;

public class Chrono implements Runnable {
	protected static int timerBouclier = 0;
	protected static int timerDifficult = 0;
	protected static int ajoutBombe = 0;
	public static boolean pause = false;

	@Override
	public void run() {
		while (!TableauDeBord.finDuJeu) {
			if (!pause) {
				MaFenetre.vBackgroundWindow.PosyFond++;
				MaFenetre.vBackgroundWindow.repaint();
				System.out.println(Accueil.nomJoueur2);
				timerBouclier++;
				timerDifficult++;
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