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
    private CaseModele[][] cases;

    public PlateauPanel(PlateauModele pm) {
        super();
        this.plateau = pm;
        this.map = new char[25][25];
        this.cases=map();
        this.updateListeTuile();

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
                        casesTuile[i][j]=cases[i][j+(compteur*5)];
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
                        casesTuile[i][j]=cases[i+5][j+((compteur%5)*5)];
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
                        casesTuile[i][j]=cases[i+10][j+((compteur%5)*5)];
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
                        casesTuile[i][j]=cases[i+15][j+((compteur%5)*5)];
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
                        casesTuile[i][j]=cases[i+20][j+((compteur%5)*5)];
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

    public void updateListeTuile(){
        this.plateau.setCompTuile(listeTuile(this.cases));
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

    public CaseModele[][] map(){
        CaseModele[][] cases = new CaseModele[25][25];
        ElemCaseModele elemMap;
        File nomImage;
        Image img;
        if (isEmpty(this.map)){
            this.map = parcoursMap("maps/mapTest3.txt");
        }
        for (int i=0; i<25; i++){
            for (int j=0; j<25; j++){
                try {

                    switch (this.map[i][j])
                    {
                        case '1':
                            nomImage = new File("img/mur1.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap = new MurModele(img, cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '2':
                            nomImage = new File("img/sol1.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap =new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '3':
                            nomImage = new File("img/coin1.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '4':
                            nomImage = new File("img/portef1.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new PorteModele(img,cases[i][j],true);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '5' :
                            nomImage = new File("img/coin2.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '6' :
                            nomImage = new File("img/coin3.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '7' :
                            nomImage = new File("img/coin4.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '8' :
                            nomImage = new File("img/mur2.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '9' :
                            nomImage = new File("img/mur3.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case '0' :
                            nomImage = new File("img/mur4.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new SolModele(img,cases[i][j]);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'a':
                            nomImage = new File("img/portef2.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new PorteModele(img,cases[i][j],true);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'b':
                            nomImage = new File("img/portef3.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new PorteModele(img,cases[i][j],true);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'c':
                            nomImage = new File("img/portef4.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, false);
                            elemMap=new PorteModele(img,cases[i][j],true);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'd':
                            nomImage = new File("img/porteo1.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap=new PorteModele(img,cases[i][j],false);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'e':
                            nomImage = new File("img/porteo2.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap=new PorteModele(img,cases[i][j],false);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'f':
                            nomImage = new File("img/porteo3.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap=new PorteModele(img,cases[i][j],false);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        case 'g':
                            nomImage = new File("img/porteo4.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            cases[i][j]= new CaseModele(null, i, j, true);
                            elemMap=new PorteModele(img,cases[i][j],false);
                            cases[i][j].getCompElemCase().add(elemMap);
                            break;
                        default:
                            System.out.println("Error : afficheMapGraphique() ");
                            break;
                    }
                }catch (Exception e){
                    System.out.println("EROROROROROROROR");
                }

            }
        }
        return cases;
    }

    // Affichage graphique de la map
    public void afficheMapGraphique(Graphics g) throws IOException {

            for (int i=0; i<25; i++){
                for (int j=0; j<25; j++){
                        for(int k=0;k<this.cases[i][j].getCompElemCase().size();k++){
                        g.drawImage(this.cases[i][j].getCompElemCase().get(k).getImage(), j * 35, i * 35, null);
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

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }
}
