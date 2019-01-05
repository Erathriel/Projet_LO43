package Modele;

import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class CarteModele {
    private String intitule;
    private BufferedImage img;
    private ImageIcon imgI;
    // Constructeur
    public CarteModele(String intitule,BufferedImage img,ImageIcon imgI) {
        this.intitule = intitule;
        this.img=img;
        this.imgI=imgI;
    }

    // Getters et Setters
    public String getIntitule() {
        return intitule;
    }
    public BufferedImage getImg(){return this.img;}
    public ImageIcon getImgIcon(){return this.imgI;}
    @Override
    public String toString() {
        return "CarteModele{" +
                "intitule='" + intitule + '\'' +
                '}';
    }
}
