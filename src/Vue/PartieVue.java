package Vue;

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

    // Init des attribut de la fenetre
    public void initAttribut(){
        /*this.labelTest = new JLabel("test");
        labelTest.setBorder(null);
        labelTest.setOpaque(false);*/
        this.plateau = new PlateauPanel();
        //plateau.setBackground(Color.blue);
        plateau.setBorder(null);
        plateau.setOpaque(false);
    }

    // Creation de la fenetre avec l'ajout des different componsant
    public void creerFenetre(){
        /*plateau.add(labelTest);
        plateau.setOpaque(false);*/
        this.setContentPane(plateau);
        //plateau.setPreferredSize(new Dimension(50,50));
    }


    // Getters et Setters
    public PartieModele getPartie() {
        return mpartie;
    }

    public void setPartie(PartieModele partie) {
        this.mpartie = partie;
    }

    /*public JLabel getLabelTest() {
        return labelTest;
    }

    public void setLabelTest(JLabel labelTest) {
        this.labelTest = labelTest;
    }*/
}
