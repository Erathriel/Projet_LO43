package Vue;

import Modele.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PlateauPanel extends JPanel {
    private PlateauModele plateau;

    public PlateauPanel(PlateauModele pm) {
        super();
        plateau = pm;
        /*JPanel jtest = new JPanel();
        jtest.setOpaque(false);
        jtest.setSize(100,100);
        File nomImage = new File("img/mur.png");
        Image img = Toolkit.getDefaultToolkit().getImage(nomImage.getAbsolutePath());
        JLabel image = new JLabel(new ImageIcon(nomImage.getAbsolutePath()));
        this.setLayout(new BorderLayout());
        this.add(image,BorderLayout.CENTER);*/
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
        char[][] map = new char[25][25];
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
                    if (j == map.length){
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
            /*for (int k=0; k<80; k++){
                for (int l = 0; l<80; l++){
                    if (l == 79){
                        System.out.println(map[k][l]);
                    }
                    else{
                        System.out.print(map[k][l]+" ");
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

    public ArrayList<TuileModele> listeTuile(CaseModele[][] cases){
        final int NBTUILE = 25;
        ArrayList<TuileModele> tuilePlateau = new ArrayList<TuileModele>();
        int compteur = 0;
        while(compteur<NBTUILE){
            CaseModele[][] casesTuile = new CaseModele[5][5];
            tuilePlateau.add(new TuileModele(compteur,plateau));
            if (compteur<5){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        //casesTuile[i][j]=cases[i+(compteur*5)][j];
                        casesTuile[i][j]= new CaseModele(cases[i+(compteur*5)][j]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(i));
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if (compteur>=5 && compteur<10){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        //casesTuile[i][j]=cases[i+((compteur%5)*5)][j+5];
                        casesTuile[i][j]= new CaseModele(cases[i+((compteur%5)*5)][j+5]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(i));
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if(compteur >= 10 && compteur < 15){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        //casesTuile[i][j]=cases[i+((compteur%5)*5)][j+10];
                        casesTuile[i][j]=new CaseModele(cases[i+((compteur%5)*5)][j+10]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(i));
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if (compteur >=15 && compteur < 20){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        //casesTuile[i][j]=cases[i+((compteur%5)*5)][j+15];
                        casesTuile[i][j]=new CaseModele(cases[i+((compteur%5)*5)][j+15]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(i));
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if (compteur >= 20){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        //casesTuile[i][j]=cases[i+((compteur%5)*5)][j+20];
                        casesTuile[i][j]=new CaseModele(cases[i+((compteur%5)*5)][j+20]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(i));
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else{
                System.out.println("Error : listeTuile() ");
            }
            compteur++;
        }
        return tuilePlateau;
    }

    public void afficheMapGraphique(Graphics g) throws IOException {
        CaseModele[][] cases = new CaseModele[80][80];
        //ElemCaseModele[][] elemMap = new ElemCaseModele[80][80];
        ElemCaseModele elemMap;
        ArrayList<ElemCaseModele> listeElemDeCase;
        File nomImage;
        Image img;
            char [][] map = parcoursMap("maps/mapTest2.txt");
            for (int i=0; i<25; i++){
                for (int j=0; j<25; j++){
                    switch (map[i][j])
                    {
                        case '1':
                            nomImage = new File("img/mur.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]= new MurModele(img, null); // A modifier pour maCase
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap = new MurModele(img, cases[i][j]);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '2':
                            nomImage = new File("img/sol1.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]=new SolModele(img,null);
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap =new SolModele(img,cases[i][j]);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '3':
                            nomImage = new File("img/sol2.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]=new SolModele(img,null);
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap=new SolModele(img,cases[i][j]);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '4':
                            nomImage = new File("img/porte.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]=new PorteModele(img,null,true);
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new PorteModele(img,cases[i][j],true);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }
                }
            }
            // DEBUG : listeTuile()
            plateau.setCompTuile(listeTuile(cases));
            for (int i=0; i < 25; i++){
                TuileModele tuileTest = plateau.getCompTuile().get(i);
                CaseModele[][] test;
                test=tuileTest.getCompCase();
                System.out.println("----------------- tuile : " + i +" -------------");
                for (int j=0;j<5;j++){
                    for (int k=0;k<5;k++){
                        System.out.print(" | " + test[i][j].getCoordX()+" , " + test[i][j].getCoordY() + " | ");
                    }
                }
            }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            afficheMapGraphique(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "PlateauPanel{}";
    }
}
