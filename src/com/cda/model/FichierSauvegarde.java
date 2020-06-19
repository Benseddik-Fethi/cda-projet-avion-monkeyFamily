package com.cda.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class FichierSauvegarde {



    public static void fichier()  {
        Properties vPropriete = System.getProperties();
        String vNomSession = vPropriete.getProperty("user.name");
        String vUserDir = vPropriete.getProperty("user.dir");
        DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime vDate = LocalDateTime.now();
        String vDateFormater = vDate.format(vDateFormat);

        File vFichier = new File("C://temp/" + vDateFormater + ".txt");
        if (vFichier.exists()) {
            System.out.println("le fichier existe ");
        } else {
            System.out.println("le fichier n'existe pas !");
            try {
                vFichier.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter vFileWriter = new FileWriter(vFichier, true);
            vFileWriter.append(Accueil.nomJoueur2 + " " + GestionCollision.compteurGlobal +"\n"); // ma session pc ne contient que mon prenom.
            vFileWriter.flush();
            vFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
