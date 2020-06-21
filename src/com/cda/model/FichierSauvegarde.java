package com.cda.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class FichierSauvegarde {

<<<<<<< HEAD
	private static Properties vPropriete = System.getProperties();
	private static String vUserDir = vPropriete.getProperty("user.dir");
	private static DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private static LocalDateTime vDate = LocalDateTime.now();
	private static String vDateFormater = vDate.format(vDateFormat);
	private static File vFichier = new File("c://temp//sauvegarde-jeu.txt");
	protected static TreeMap<Integer, String> tableauScore = new TreeMap<>(Collections.reverseOrder());

=======
>>>>>>> dev
	public static void fichier() {
		Properties vPropriete = System.getProperties();
		String vUserDir = vPropriete.getProperty("user.dir");
		DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime vDate = LocalDateTime.now();
		String vDateFormater = vDate.format(vDateFormat);


		File vFichier = new File("sauvegarde-jeu.txt");

		if (vFichier.exists()) {
		} else {
			try {
				vFichier.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter vFileWriter = new FileWriter(vFichier, true)) {
			vFileWriter.append(vDateFormater).append(" : ").append(Accueil.nomJoueur2).append(" ----> ")
					.append(String.valueOf(GestionCollision.compteurGlobal)).append("\n");
			vFileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD

	public static void recupererScore() {

		BufferedReader lecteurAvecBuffer = null;
		String ligne = "";
		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(vFichier));
		} catch (FileNotFoundException exc) {
		}
		while (true) {

			try {
				if ((ligne = lecteurAvecBuffer.readLine()) == null) break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] ligneSplit = ligne.split(" ");
			int score = Integer.parseInt(ligneSplit[1]);
			String nom = ligneSplit[0] + " " + ligneSplit[2];
			tableauScore.put(score, nom);
		}
		try {
			lecteurAvecBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

=======
>>>>>>> dev
}
