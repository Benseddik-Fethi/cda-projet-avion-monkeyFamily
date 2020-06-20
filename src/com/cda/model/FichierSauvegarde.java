package com.cda.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FichierSauvegarde {

    public static void fichier() {

        DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime vDate = LocalDateTime.now();
        String vDateFormater = vDate.format(vDateFormat);

        File vFichier = new File("C://temp/" + "sauvegarde-jeu.txt");
        if (vFichier.exists()) {
        } else {
            try {
                vFichier.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter vFileWriter = new FileWriter(vFichier, true)) {
            vFileWriter.append(vDateFormater).
                    append(" : ")
                    .append(Accueil.nomJoueur2)
                    .append(" ----> ")
                    .append(String.valueOf(GestionCollision.compteurGlobal))
                    .append("\n");
            vFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
