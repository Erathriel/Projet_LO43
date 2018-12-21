package Vue;

import Modele.*;

import javax.swing.*;
import java.io.*;

public class PartieVue extends JFrame {
    private PartieModele mpartie;
    private JLabel labelTest;

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
        this.labelTest = new JLabel();
        labelTest.setBorder(null);
        labelTest.setOpaque(false);
    }

    // Creation de la fenetre avec l'ajout des different componsant
    public void creerFenetre(){
        JPanel panTest = new JPanel();
        panTest.add(labelTest);
        panTest.setOpaque(false);
        this.setContentPane(panTest);
    }

    public void affichageMapConsole(String name){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        //String map = "maps\\mapTest.txt";
        //System.out.println(map);
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            //byte[] buffer = new byte[8];
            int buffer;
            String ligne="";
            while((buffer = fis.read()) != -1){
                //System.out.println((char) buffer);
                ligne= ligne + (char) buffer;
            }
            System.out.println(ligne);
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode d'affichage renvoie String
    /*public String affichageMapConsole(String name){
        String ligne="";
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        //String map = "maps\\mapTest.txt";
        //System.out.println(map);
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            //byte[] buffer = new byte[8];
            int buffer;
            while((buffer = fis.read()) != -1){
                //System.out.println((char) buffer);
                ligne= ligne + (char) buffer;
            }
            System.out.println(ligne);
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ligne;
    }*/

    public void affichageMapGraphique(String name){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        //String map = "maps\\mapTest.txt";
        //System.out.println(map);
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            //byte[] buffer = new byte[8];
            int buffer;
            String ligne = null;
            while((buffer = fis.read()) != -1){
                //System.out.println((char) buffer);
                ligne= ligne + (char) buffer;
            }
            System.out.println(ligne);
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters et Setters
    public PartieModele getPartie() {
        return mpartie;
    }

    public void setPartie(PartieModele partie) {
        this.mpartie = partie;
    }

    public JLabel getLabelTest() {
        return labelTest;
    }

    public void setLabelTest(JLabel labelTest) {
        this.labelTest = labelTest;
    }
}
