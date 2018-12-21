package Vue;

import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class PartieVue extends JFrame {
    private PartieModele mpartie;
    //private JLabel labelTest;
    private JPanel plateau;

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
        this.plateau = new JPanel();
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

    public char[][] parcoursMap(String name){
        char[][] map = new char[10][10];
        int i=0;
        int j=0;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            int buffer;
            String ligne="";
            while((buffer = fis.read()) != -1){
                if (buffer != 32 && i<10){
                    if (j == 10){
                        i++;
                        j=0;
                        map[i][j]=(char)buffer;
                    }
                    else{
                        map[i][j]=(char)buffer;
                        j++;
                    }
                }
            }
            /*for (int k=0; k<10; k++){
                for (int l = 0; l<10; l++){
                    System.out.println(map[k][l]);
                }
            }*/
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public void affichageMapGraphique(Graphics g){

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
