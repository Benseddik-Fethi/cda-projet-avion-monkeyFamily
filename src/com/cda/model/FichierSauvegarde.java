package com.cda.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class FichierSauvegarde {

	private static Properties vPropriete = System.getProperties();
	private static String vUserDir = vPropriete.getProperty("user.dir");
	private static DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private static LocalDateTime vDate = LocalDateTime.now();
	private static String vDateFormater = vDate.format(vDateFormat);
	private static File vFichier = new File("sauvegarde-jeu.txt");
	protected static TreeMap<Integer, String> tableauScore = new TreeMap<>(Collections.reverseOrder());

	public static void fichier() {

		if (vFichier.exists()) {
		} else {
			try {
				vFichier.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter vFileWriter = new FileWriter(vFichier, true)) {
			vFileWriter.append(Accueil.nomJoueur2).append(" ").append(String.valueOf(GestionCollision.compteurGlobal)).append(" ")
					.append(vDateFormater).append("\n");
			vFileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void recupererScore() {
		BufferedReader lecteurAvecBuffer = null;
		String ligne = "";

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(vFichier));
		} catch (FileNotFoundException var6) {
		}

		while(true) {
			try {
				if ((ligne = lecteurAvecBuffer.readLine()) == null) {
					break;
				}
			} catch (IOException var7) {
				var7.printStackTrace();
			}

			String[] ligneSplit = ligne.split(" ");
			int score = Integer.parseInt(ligneSplit[1]);
			String nom = ligneSplit[0] + " " + ligneSplit[2];
			tableauScore.put(score, nom);
		}


		try {
			lecteurAvecBuffer.close();
		} catch (IOException var5) {
			var5.printStackTrace();
		}

	}

	public static void trier() {
		Set set2 = tableauScore.entrySet();
		Iterator iterator2 = set2.iterator();
		System.out.println("Après le tri: ");

		for (int i = 0; i < set2.size() && i < 10; ++i) {
			Entry me2 = (Entry) iterator2.next();
			System.out.print(me2.getKey() + " ");
			System.out.println(me2.getValue());
		}
	}
}
