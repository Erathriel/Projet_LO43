package Vue;

import Controleur.PartieControlleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PartieVue extends JFrame {
    private PartieModele mpartie;
   // private JLabel labelTest;
    private PlateauPanel plateau;
    // Constructeur
    public PartieVue(PartieModele partie) {
        super();
        this.mpartie = partie;
        this.setTitle("Map");
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        initAttribut();
        creerFenetre();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Methodes

    // Init des attributs de la fenetre
    public void initAttribut(){
        this.plateau = new PlateauPanel(mpartie.getPlateau());
        plateau.setBorder(null);
        plateau.setOpaque(false);
    }

    // Creation de la fenetre avec l'ajout des different componsant
    public void creerFenetre(){
        this.setContentPane(plateau);
    }


    // Getters et Setters
    public PartieModele getPartie() {
        return mpartie;
    }

    public void setPartie(PartieModele partie) {
        this.mpartie = partie;
    }

    public PlateauPanel getPlateau() {
        return plateau;
    }

    public void setPlateau(PlateauPanel plateau) {
        this.plateau = plateau;
    }
}
