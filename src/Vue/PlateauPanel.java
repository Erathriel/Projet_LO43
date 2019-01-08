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
    private char[][] map;

    public PlateauPanel(PlateauModele pm) {
        super();
        plateau = pm;
        //TEST
        map = new char[25][25];
    }

    // affichage de la map en console
    public void affichageMapConsole(String name){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            //byte[] buffer = new byte[8];
            int buffer;
            String ligne="";
            while((buffer = fis.read()) != -1){
                ligne= ligne + (char) buffer;
            }
            System.out.println(ligne);
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parcours du fichier texte representant la map
    public char[][] parcoursMap(String name){
        //char[][] map = new char[25][25];
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
                if (buffer != 32 && buffer != 10 && i<this.map.length){
                    if (j == this.map.length){
                        i++;
                        j=0;
                        this.map[i][j]=(char)buffer;
                    }
                    else{
                        this.map[i][j]=(char)buffer;
                        j++;
                    }
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

    // Création des tuiles de la map
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
                        casesTuile[i][j]= new CaseModele(cases[i+(compteur*5)][j]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(compteur));
                        casesTuile[i][j].setCoordX(i);
                        casesTuile[i][j].setCoordY(j);
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if (compteur>=5 && compteur<10){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        casesTuile[i][j]= new CaseModele(cases[i+((compteur%5)*5)][j+5]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(compteur));
                        casesTuile[i][j].setCoordX(i);
                        casesTuile[i][j].setCoordY(j);
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if(compteur >= 10 && compteur < 15){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        casesTuile[i][j]=new CaseModele(cases[i+((compteur%5)*5)][j+10]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(compteur));
                        casesTuile[i][j].setCoordX(i);
                        casesTuile[i][j].setCoordY(j);
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if (compteur >=15 && compteur < 20){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        casesTuile[i][j]=new CaseModele(cases[i+((compteur%5)*5)][j+15]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(compteur));
                        casesTuile[i][j].setCoordX(i);
                        casesTuile[i][j].setCoordY(j);
                    }
                }
                tuilePlateau.get(compteur).setCompCase(casesTuile);
            }
            else if (compteur >= 20){
                for (int i=0; i < 5; i++){
                    for (int j=0; j < 5; j++){
                        casesTuile[i][j]=new CaseModele(cases[i+((compteur%5)*5)][j+20]);
                        casesTuile[i][j].setMaTuile(tuilePlateau.get(compteur));
                        casesTuile[i][j].setCoordX(i);
                        casesTuile[i][j].setCoordY(j);
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

    // verifie si le tableau est vide
    public boolean isEmpty(char[][] map){
        for (int i=0; i<25;i++){
            for (int j=0; j<25;j++){
                if (map[i][j] != '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    // TEST
    /*public char[][] changeMap(){
        this.map[0][0]='2';
        this.map[1][1]='2';
        return this.map;
    }*/

    // Affichage graphique de la map
    public void afficheMapGraphique(Graphics g) throws IOException {
        CaseModele[][] cases = new CaseModele[25][25];
        ElemCaseModele elemMap;
        File nomImage;
        Image img;
        if (isEmpty(this.map)){
            this.map = parcoursMap("maps/mapTest2.txt");
        }
            for (int i=0; i<25; i++){
                for (int j=0; j<25; j++){
                    switch (this.map[i][j])
                    {
                        case '1':
                            nomImage = new File("img/mur.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]= new MurModele(img, null); // A modifier pour maCase
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap = new MurModele(img, cases[i][j]);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            //g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '2':
                            nomImage = new File("img/sol1.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]=new SolModele(img,null);
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap =new SolModele(img,cases[i][j]);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            //g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '3':
                            nomImage = new File("img/sol2.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]=new SolModele(img,null);
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap=new SolModele(img,cases[i][j]);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            //g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '4':
                            nomImage = new File("img/porte.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            //elemMap[i][j]=new PorteModele(img,null,true);
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new PorteModele(img,cases[i][j],true);
                            //g.drawImage(elemMap[i][j].getImage(),j*20,i*20,null);
                            //g.drawImage(elemMap.getImage(),j*20,i*20,null);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        default:
                            System.out.println("Error : afficheMapGraphique() ");
                            break;
                    }
                }
            }
            for (int i=0; i<25; i++){
                for (int j=0; j<25; j++){
                    g.drawImage(cases[i][j].getCompElemCase().get(0).getImage(),j*20,i*20,null);
                }
            }
            this.plateau.setCompTuile(listeTuile(cases));
            // DEBUG : listeTuile()
            /*for (int i=0; i < 25; i++){
                TuileModele tuileTest = plateau.getCompTuile().get(i);
                CaseModele[][] test;
                test=tuileTest.getCompCase();
                System.out.println("----------------- tuile : " + i +" -------------");
                for (int j=0;j<5;j++){
                    for (int k=0;k<5;k++){
                        System.out.print(" | " + test[j][k].getCoordX()+" , " + test[j][k].getCoordY() + " | ");
                    }
                }
                System.out.println(" ");
            }*/
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

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }
}
