package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CarteEtudianteModele extends CarteModele {
    private int malchance;

    // Constructeur
    public CarteEtudianteModele(ImageIcon imgI,BufferedImage img, String intitule, int malchance) {
        super(intitule,img,imgI);
        this.malchance = malchance;
    }

    // Methodes
    public void apparition(CaseModele c,int exp){// Fonction qui fait appraitre les nouveaux étudiants sur la case ou la carte est pioché
        try {
            String tab2[]={"CS","HUMA",null};
            String tab5[]={"CS","TM",null};
            String tab6[]={"HUMA",null,null};
            String tab7[]={"TM","HUMA",null};
            File etuSimplef = new File("img/etucshuma.png");
            Image etuSimple=ImageIO.read(etuSimplef.getAbsoluteFile());
            etuSimplef= new File("img/etucstm.png");
            Image etuCsTm=ImageIO.read(etuSimplef.getAbsoluteFile());
            etuSimplef= new File("img/etuhumatm.png");
            Image etuHumaTm=ImageIO.read(etuSimplef.getAbsoluteFile());
            etuSimplef= new File("img/elevenegligeant.png");
            Image etuHuma=ImageIO.read(etuSimplef.getAbsoluteFile());
            //on va dans le if correspondant a la difficulté de la carte
            //et on fait apparaître en fonction de l'experience
            if (this.malchance == 1) {
                for (int i = 0; i < (exp / 25) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuSimple, c, 3, 2, "etudiant à l'heure", true, 2, tab2, 2));
                }
            } else if (this.malchance == 2) {

                for (int i = 0; i < (exp / 25) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuCsTm, c, 1, 3, "etudiant en manque de TM CS", true, 4, tab5, 2));
                }
            } else if (this.malchance == 3) {
                for (int i = 0; i < (exp / 25) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuCsTm, c, 1, 3, "etudiant en manque de TM CS", true, 2, tab5, 2));
                }
                for (int i = 0; i < (exp / 50) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuHuma, c, 5, 1, "etudiant en manque d'HUMA", true, 10,  tab6, 6));
                }
            } else if (this.malchance == 4) {
                for (int i = 0; i < (exp / 25) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuSimple, c, 3, 2, "etudiant à l'heure", true, 2, tab2, 2));
                }
                for (int i = 0; i < (exp / 50) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuCsTm, c, 1, 3, "etudiant en manque de TM CS", true, 4,tab5, 2));
                }
                for (int i = 0; i < (exp / 75) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuHumaTm, c, 5, 1, "etudiant en manque de TM HUMA", true, 4, tab7, 8));
                }
            } else if (this.malchance == 5) {
                c.getCompElemCase().add(new EtudiantModele(etuHuma, c, 8, 1, "etudiant négligeant envers les HUMA", true, 10,  tab6, 20));
            } else if (this.malchance == 6) {
                for (int i = 0; i < (exp / 25) + 1; i++) {

                    c.getCompElemCase().add(new EtudiantModele(etuSimple, c, 3, 2, "etudiant à l'heure", true, 2, tab2, 2));
                }
                for (int i = 0; i < (exp / 50) + 1; i++) {
                    c.getCompElemCase().add(new EtudiantModele(etuCsTm, c, 1, 3, "etudiant en manque de TM CS", true, 4, tab5, 4));
                }
                for (int i = 0; i < (exp / 75) + 1; i++) {
                    c.getCompElemCase().add(new EtudiantModele(etuHumaTm, c, 5, 1, "etudiant en manque de TM HUMA", true, 4, tab7, 8));
                }

                c.getCompElemCase().add(new EtudiantModele(etuHuma, c, 8, 1, "etudiant négligeant envers les HUMA", true, 10,  tab6, 20));

            }
        }
        catch(Exception e){
            System.out.println("Error reading file Carte Etu");
        }
    }
    

    @Override
    public String toString() {
        return "CarteEtudianteModele{" +
                "malchance=" + malchance +
                '}';
    }
}
