package com.cda.model;

public class Chrono implements Runnable {
<<<<<<< HEAD
	private final int PAUSE = 3;

=======
>>>>>>> ab81536dd91d85010da2182891f5fe35d413f0a5
	@Override
	public void run() {
		while (true) {
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
