package Modele;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ObjetModele extends CarteModele{
    private String nom;
    private int emplacement;

    // Constructeur
    public ObjetModele(ImageIcon imgI,BufferedImage img, String intitule, String nom, int emplacement) {
        super(intitule,img,imgI);
        this.nom=nom;
        this.emplacement=emplacement;
    }

    // Getters et Setters
    public int getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(int emplacement) {
        this.emplacement = emplacement;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "ObjetModele{" +
                "nom='" + nom + '\'' +
                ", emplacement=" + emplacement +
                '}';
    }
}
