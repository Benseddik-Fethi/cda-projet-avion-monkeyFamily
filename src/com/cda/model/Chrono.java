package com.cda.model;

public class Chrono implements Runnable {
	private final int PAUSE = 1;

	@Override
	public void run() {
		while (true) {
			MaFenetre.vBackgroundWindow.yFond++;
			MaFenetre.vBackgroundWindow.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
