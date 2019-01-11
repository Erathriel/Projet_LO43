package Modele;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class PorteModele extends MurModele {
    private boolean verrouiller;

    // Constructeur
    public PorteModele(Image image, CaseModele maCase, boolean verrouiller) {
        super(image, maCase);
        this.verrouiller=verrouiller;
    }

    // Getters et Setters
    public boolean isVerrouiller() {
        return verrouiller;
    }

    public void setVerrouiller() {
        /*Ouverture de la porte est change son image en fonction de la position de la case qui la contient */
        this.verrouiller = false;
        this.getMaCase().setPassable(true);
        try {
            File nomImage;
            Image img ;
            if (this.getMaCase().getCoordX() == 2 && this.getMaCase().getCoordY()==4) {
                nomImage = new File("img/porteo1.jpg");
                 img = ImageIO.read(nomImage.getAbsoluteFile());
                this.setImage(img);
            }
            else if(this.getMaCase().getCoordX() == 2 && this.getMaCase().getCoordY()==0){
                nomImage = new File("img/porteo2.jpg");
                img = ImageIO.read(nomImage.getAbsoluteFile());
                this.setImage(img);
            }
            else if(this.getMaCase().getCoordX() == 0 && this.getMaCase().getCoordY()==2){
                nomImage = new File("img/porteo3.jpg");
                img = ImageIO.read(nomImage.getAbsoluteFile());
                this.setImage(img);
            }
            else if(this.getMaCase().getCoordX() == 4 && this.getMaCase().getCoordY()==2){
                nomImage = new File("img/porteo4.jpg");
                img = ImageIO.read(nomImage.getAbsoluteFile());
                this.setImage(img);
            }
        }
        catch(Exception e){
            System.out.println("Error reading ouverture porte");
        }
    }

    @Override
    public String toString() {
        return "PorteModele{" +
                "verrouiller=" + verrouiller +
                '}';
    }
}
