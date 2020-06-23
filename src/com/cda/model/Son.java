package com.cda.model;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Son {
	public Clip clip;
	InputStream urlMusique;
	InputStream bufferedIn;
	AudioInputStream monExplosion;
	FloatControl gainControl;

	public Son(String pSon) {
		try { // Tout dans le try permet de lire la musqiue du jeu en boucle.
			urlMusique = MaFenetre.class.getResourceAsStream(pSon);
			bufferedIn = new BufferedInputStream(urlMusique);
			monExplosion = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(monExplosion);
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void startMusique() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stopMusique() {
		clip.stop();
	}
}
