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
                //System.out.println("start boucle : i : "+i+"     j : "+j); DEBUG
                if (buffer != 32 && buffer != 10 && i<map.length){
                    //System.out.print((char)buffer); DEBUG
                    if (j == 10){
                        i++;
                        j=0;
                        map[i][j]=(char)buffer;
                        //System.out.println("passage cond i = 10"); DEBUG
                    }
                    else{
                        map[i][j]=(char)buffer;
                        j++;
                        //System.out.println("passage else"); DEBUG
                    }
                    //System.out.println("end boucle : i : "+i+"     j : "+j); DEBUG
                }
            }
            // DEBUG affiche le tableau map en console
            /*for (int k=0; k<10; k++){
                for (int l = 0; l<10; l++){
                    if (l == 9){
                        System.out.println(map[k][l]);
                    }
                    else{
                        System.out.print(map[k][l]);
                    }
                }
            }*/
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public void afficheMapGraphique(Graphics g){
        CaseModele[][] cases = new CaseModele[10][10];
        ElemCaseModele[][] elemMap = new ElemCaseModele[10][10];
        File nomImage;
        Image img;
        char [][] map = parcoursMap("maps/mapTest.txt");
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                switch (map[i][j])
                {
                    case 1:
                        nomImage = new File("img/mur.jpg");
                        img = Toolkit.getDefaultToolkit().getImage(nomImage.getAbsolutePath());
                        elemMap[i][j]= new MurModele(img, null); // A modifier pour maCase
                        g.drawImage(elemMap[i][j].getImage(),i*32,j*32,null);
                        break;
                    case 2:
                        nomImage = new File("img/sol1.jpg");
                        img = Toolkit.getDefaultToolkit().getImage(nomImage.getAbsolutePath());
                        elemMap[i][j]=new SolModele(null,null);
                        g.drawImage(elemMap[i][j].getImage(),i*32,j*32,null);
                        break;
                    case 3:
                        nomImage = new File("img/sol2.jpg");
                        img = Toolkit.getDefaultToolkit().getImage(nomImage.getAbsolutePath());
                        elemMap[i][j]=new SolModele(null,null);
                        g.drawImage(elemMap[i][j].getImage(),i*32,j*32,null);
                        break;
                    case 4:
                        nomImage = new File("img/porte.jpg");
                        img = Toolkit.getDefaultToolkit().getImage(nomImage.getAbsolutePath());
                        elemMap[i][j]=new PorteModele(null,null,true);
                        g.drawImage(elemMap[i][j].getImage(),i*32,j*32,null);
                        break;
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        afficheMapGraphique(g);
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
