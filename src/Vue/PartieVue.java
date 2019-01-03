package Vue;

import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PartieVue extends JFrame {
    private PartieModele mpartie;
    //private JLabel labelTest;
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
        /*this.labelTest = new JLabel();
        labelTest.setBorder(null);
        labelTest.setOpaque(false);*/
        this.plateau = new PlateauPanel();
        plateau.setBorder(null);
        plateau.setOpaque(false);
    }

    // Creation de la fenetre avec l'ajout des different componsant
    public void creerFenetre(){
        /*JPanel panTest = new JPanel();
        panTest.add(labelTest);
        panTest.setOpaque(false);
        this.setContentPane(panTest);*/
        plateau.setPreferredSize(new Dimension(10,10));
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
