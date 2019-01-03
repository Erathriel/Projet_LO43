import Controleur.PartieControlleur;
import Modele.*;
import Vue.PartieVue;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class test {

    public static void main(String[] args) {
        PartieModele mPartie = new PartieModele();
        PartieVue vPartie = new PartieVue(mPartie);
        PartieControlleur cPartie = new PartieControlleur(mPartie,vPartie);
        //affichageMapConsole("maps\\mapTest.txt"); // windows
        //vPartie.affichageMapConsole("maps/mapTest.txt"); // linux
        //vPartie.parcoursMap("maps/mapTest.txt");

        /*PlateauModele plateau = new PlateauModele(9);
        CaseModele caseTuile1[][]= new CaseModele[5][5];
        CaseModele caseTuile2[][]= new CaseModele[5][5];
        CaseModele caseTuile3[][]= new CaseModele[5][5];
        CaseModele caseTuile4[][]= new CaseModele[5][5];
        CaseModele caseTuile5[][]= new CaseModele[5][5];
        CaseModele caseTuile6[][]= new CaseModele[5][5];
        CaseModele caseTuile7[][]= new CaseModele[5][5];
        CaseModele caseTuile8[][]= new CaseModele[5][5];
        CaseModele caseTuile9[][]= new CaseModele[5][5];
        plateau.getCompTuile().add(new TuileModele(1,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(2,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(3,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(4,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(5,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(6,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(7,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(8,25,null,null,plateau));
        plateau.getCompTuile().add(new TuileModele(9,25,null,null,plateau));
        caseTuile1[0][0]= new CaseModele(plateau.getCompTuile().get(0),0,0,false);
        caseTuile1[1][0]= new CaseModele(plateau.getCompTuile().get(0),1,0,false);
        caseTuile1[2][0]= new CaseModele(plateau.getCompTuile().get(0),2,0,false);
        caseTuile1[3][0]= new CaseModele(plateau.getCompTuile().get(0),3,0,false);
        caseTuile1[4][0]= new CaseModele(plateau.getCompTuile().get(0),4,0,false);
        caseTuile1[0][1]= new CaseModele(plateau.getCompTuile().get(0),0,1,false);
        caseTuile1[0][2]= new CaseModele(plateau.getCompTuile().get(0),0,2,false);
        caseTuile1[0][3]= new CaseModele(plateau.getCompTuile().get(0),0,3,false);
        caseTuile1[0][4]= new CaseModele(plateau.getCompTuile().get(0),0,4,false);
        caseTuile1[1][4]= new CaseModele(plateau.getCompTuile().get(0),1,4,false);
        caseTuile1[2][4]= new CaseModele(plateau.getCompTuile().get(0),2,4,false);
        caseTuile1[3][4]= new CaseModele(plateau.getCompTuile().get(0),3,4,false);
        caseTuile1[4][4]= new CaseModele(plateau.getCompTuile().get(0),4,4,false);
        caseTuile1[4][1]= new CaseModele(plateau.getCompTuile().get(0),4,1,false);
        caseTuile1[4][2]= new CaseModele(plateau.getCompTuile().get(0),4,2,false);
        caseTuile1[4][3]= new CaseModele(plateau.getCompTuile().get(0),4,3,false);
        caseTuile1[1][1]= new CaseModele(plateau.getCompTuile().get(0),1,1,true);
        caseTuile1[1][2]= new CaseModele(plateau.getCompTuile().get(0),1,2,true);
        caseTuile1[1][3]= new CaseModele(plateau.getCompTuile().get(0),1,3,true);
        caseTuile1[2][1]= new CaseModele(plateau.getCompTuile().get(0),2,1,true);
        caseTuile1[2][2]= new CaseModele(plateau.getCompTuile().get(0),2,2,true);
        caseTuile1[2][3]= new CaseModele(plateau.getCompTuile().get(0),2,3,true);
        caseTuile1[3][1]= new CaseModele(plateau.getCompTuile().get(0),3,1,true);
        caseTuile1[3][2]= new CaseModele(plateau.getCompTuile().get(0),3,2,true);
        caseTuile1[3][3]= new CaseModele(plateau.getCompTuile().get(0),3,3,true);
        plateau.getCompTuile().get(0).setCompCase(caseTuile1);
        caseTuile2[0][0]= new CaseModele(plateau.getCompTuile().get(1),0,0,false);
        caseTuile2[1][0]= new CaseModele(plateau.getCompTuile().get(1),1,0,false);
        caseTuile2[2][0]= new CaseModele(plateau.getCompTuile().get(1),2,0,false);
        caseTuile2[3][0]= new CaseModele(plateau.getCompTuile().get(1),3,0,false);
        caseTuile2[4][0]= new CaseModele(plateau.getCompTuile().get(1),4,0,false);
        caseTuile2[0][1]= new CaseModele(plateau.getCompTuile().get(1),0,1,false);
        caseTuile2[0][2]= new CaseModele(plateau.getCompTuile().get(1),0,2,false);
        caseTuile2[0][3]= new CaseModele(plateau.getCompTuile().get(1),0,3,false);
        caseTuile2[0][4]= new CaseModele(plateau.getCompTuile().get(1),0,4,false);
        caseTuile2[1][4]= new CaseModele(plateau.getCompTuile().get(1),1,4,false);
        caseTuile2[2][4]= new CaseModele(plateau.getCompTuile().get(1),2,4,false);
        caseTuile2[3][4]= new CaseModele(plateau.getCompTuile().get(1),3,4,false);
        caseTuile2[4][4]= new CaseModele(plateau.getCompTuile().get(1),4,4,false);
        caseTuile2[4][1]= new CaseModele(plateau.getCompTuile().get(1),4,1,false);
        caseTuile2[4][2]= new CaseModele(plateau.getCompTuile().get(1),4,2,false);
        caseTuile2[4][3]= new CaseModele(plateau.getCompTuile().get(1),4,3,false);
        caseTuile2[1][1]= new CaseModele(plateau.getCompTuile().get(1),1,1,true);
        caseTuile2[1][2]= new CaseModele(plateau.getCompTuile().get(1),1,2,true);
        caseTuile2[1][3]= new CaseModele(plateau.getCompTuile().get(1),1,3,true);
        caseTuile2[2][1]= new CaseModele(plateau.getCompTuile().get(1),2,1,true);
        caseTuile2[2][2]= new CaseModele(plateau.getCompTuile().get(1),2,2,true);
        caseTuile2[2][3]= new CaseModele(plateau.getCompTuile().get(1),2,3,true);
        caseTuile2[3][1]= new CaseModele(plateau.getCompTuile().get(1),3,1,true);
        caseTuile2[3][2]= new CaseModele(plateau.getCompTuile().get(1),3,2,true);
        caseTuile2[3][3]= new CaseModele(plateau.getCompTuile().get(1),3,3,true);
        plateau.getCompTuile().get(1).setCompCase(caseTuile2);
        caseTuile3[0][0]= new CaseModele(plateau.getCompTuile().get(2),0,0,false);
        caseTuile3[1][0]= new CaseModele(plateau.getCompTuile().get(2),1,0,false);
        caseTuile3[2][0]= new CaseModele(plateau.getCompTuile().get(2),2,0,false);
        caseTuile3[3][0]= new CaseModele(plateau.getCompTuile().get(2),3,0,false);
        caseTuile3[4][0]= new CaseModele(plateau.getCompTuile().get(2),4,0,false);
        caseTuile3[0][1]= new CaseModele(plateau.getCompTuile().get(2),0,1,false);
        caseTuile3[0][2]= new CaseModele(plateau.getCompTuile().get(2),0,2,false);
        caseTuile3[0][3]= new CaseModele(plateau.getCompTuile().get(2),0,3,false);
        caseTuile3[0][4]= new CaseModele(plateau.getCompTuile().get(2),0,4,false);
        caseTuile3[1][4]= new CaseModele(plateau.getCompTuile().get(2),1,4,false);
        caseTuile3[2][4]= new CaseModele(plateau.getCompTuile().get(2),2,4,false);
        caseTuile3[3][4]= new CaseModele(plateau.getCompTuile().get(2),3,4,false);
        caseTuile3[4][4]= new CaseModele(plateau.getCompTuile().get(2),4,4,false);
        caseTuile3[4][1]= new CaseModele(plateau.getCompTuile().get(2),4,1,false);
        caseTuile3[4][2]= new CaseModele(plateau.getCompTuile().get(2),4,2,false);
        caseTuile3[4][3]= new CaseModele(plateau.getCompTuile().get(2),4,3,false);
        caseTuile3[1][1]= new CaseModele(plateau.getCompTuile().get(2),1,1,true);
        caseTuile3[1][2]= new CaseModele(plateau.getCompTuile().get(2),1,2,true);
        caseTuile3[1][3]= new CaseModele(plateau.getCompTuile().get(2),1,3,true);
        caseTuile3[2][1]= new CaseModele(plateau.getCompTuile().get(2),2,1,true);
        caseTuile3[2][2]= new CaseModele(plateau.getCompTuile().get(2),2,2,true);
        caseTuile3[2][3]= new CaseModele(plateau.getCompTuile().get(2),2,3,true);
        caseTuile3[3][1]= new CaseModele(plateau.getCompTuile().get(2),3,1,true);
        caseTuile3[3][2]= new CaseModele(plateau.getCompTuile().get(2),3,2,true);
        caseTuile3[3][3]= new CaseModele(plateau.getCompTuile().get(2),3,3,true);
        plateau.getCompTuile().get(2).setCompCase(caseTuile3);
        caseTuile4[0][0]= new CaseModele(plateau.getCompTuile().get(3),0,0,false);
        caseTuile4[1][0]= new CaseModele(plateau.getCompTuile().get(3),1,0,false);
        caseTuile4[2][0]= new CaseModele(plateau.getCompTuile().get(3),2,0,false);
        caseTuile4[3][0]= new CaseModele(plateau.getCompTuile().get(3),3,0,false);
        caseTuile4[4][0]= new CaseModele(plateau.getCompTuile().get(3),4,0,false);
        caseTuile4[0][1]= new CaseModele(plateau.getCompTuile().get(3),0,1,false);
        caseTuile4[0][2]= new CaseModele(plateau.getCompTuile().get(3),0,2,false);
        caseTuile4[0][3]= new CaseModele(plateau.getCompTuile().get(3),0,3,false);
        caseTuile4[0][4]= new CaseModele(plateau.getCompTuile().get(3),0,4,false);
        caseTuile4[1][4]= new CaseModele(plateau.getCompTuile().get(3),1,4,false);
        caseTuile4[2][4]= new CaseModele(plateau.getCompTuile().get(3),2,4,false);
        caseTuile4[3][4]= new CaseModele(plateau.getCompTuile().get(3),3,4,false);
        caseTuile4[4][4]= new CaseModele(plateau.getCompTuile().get(3),4,4,false);
        caseTuile4[4][1]= new CaseModele(plateau.getCompTuile().get(3),4,1,false);
        caseTuile4[4][2]= new CaseModele(plateau.getCompTuile().get(3),4,2,false);
        caseTuile4[4][3]= new CaseModele(plateau.getCompTuile().get(3),4,3,false);
        caseTuile4[1][1]= new CaseModele(plateau.getCompTuile().get(3),1,1,true);
        caseTuile4[1][2]= new CaseModele(plateau.getCompTuile().get(3),1,2,true);
        caseTuile4[1][3]= new CaseModele(plateau.getCompTuile().get(3),1,3,true);
        caseTuile4[2][1]= new CaseModele(plateau.getCompTuile().get(3),2,1,true);
        caseTuile4[2][2]= new CaseModele(plateau.getCompTuile().get(3),2,2,true);
        caseTuile4[2][3]= new CaseModele(plateau.getCompTuile().get(3),2,3,true);
        caseTuile4[3][1]= new CaseModele(plateau.getCompTuile().get(3),3,1,true);
        caseTuile4[3][2]= new CaseModele(plateau.getCompTuile().get(3),3,2,true);
        caseTuile4[3][3]= new CaseModele(plateau.getCompTuile().get(3),3,3,true);
        plateau.getCompTuile().get(3).setCompCase(caseTuile4);
        caseTuile5[0][0]= new CaseModele(plateau.getCompTuile().get(4),0,0,false);
        caseTuile5[1][0]= new CaseModele(plateau.getCompTuile().get(4),1,0,false);
        caseTuile5[2][0]= new CaseModele(plateau.getCompTuile().get(4),2,0,false);
        caseTuile5[3][0]= new CaseModele(plateau.getCompTuile().get(4),3,0,false);
        caseTuile5[4][0]= new CaseModele(plateau.getCompTuile().get(4),4,0,false);
        caseTuile5[0][1]= new CaseModele(plateau.getCompTuile().get(4),0,1,false);
        caseTuile5[0][2]= new CaseModele(plateau.getCompTuile().get(4),0,2,false);
        caseTuile5[0][3]= new CaseModele(plateau.getCompTuile().get(4),0,3,false);
        caseTuile5[0][4]= new CaseModele(plateau.getCompTuile().get(4),0,4,false);
        caseTuile5[1][4]= new CaseModele(plateau.getCompTuile().get(4),1,4,false);
        caseTuile5[2][4]= new CaseModele(plateau.getCompTuile().get(4),2,4,false);
        caseTuile5[3][4]= new CaseModele(plateau.getCompTuile().get(4),3,4,false);
        caseTuile5[4][4]= new CaseModele(plateau.getCompTuile().get(4),4,4,false);
        caseTuile5[4][1]= new CaseModele(plateau.getCompTuile().get(4),4,1,false);
        caseTuile5[4][2]= new CaseModele(plateau.getCompTuile().get(4),4,2,false);
        caseTuile5[4][3]= new CaseModele(plateau.getCompTuile().get(4),4,3,false);
        caseTuile5[1][1]= new CaseModele(plateau.getCompTuile().get(4),1,1,true);
        caseTuile5[1][2]= new CaseModele(plateau.getCompTuile().get(4),1,2,true);
        caseTuile5[1][3]= new CaseModele(plateau.getCompTuile().get(4),1,3,true);
        caseTuile5[2][1]= new CaseModele(plateau.getCompTuile().get(4),2,1,true);
        caseTuile5[2][2]= new CaseModele(plateau.getCompTuile().get(4),2,2,true);
        caseTuile5[2][3]= new CaseModele(plateau.getCompTuile().get(4),2,3,true);
        caseTuile5[3][1]= new CaseModele(plateau.getCompTuile().get(4),3,1,true);
        caseTuile5[3][2]= new CaseModele(plateau.getCompTuile().get(4),3,2,true);
        caseTuile5[3][3]= new CaseModele(plateau.getCompTuile().get(4),3,3,true);
        plateau.getCompTuile().get(4).setCompCase(caseTuile5);
        caseTuile6[0][0]= new CaseModele(plateau.getCompTuile().get(5),0,0,false);
        caseTuile6[1][0]= new CaseModele(plateau.getCompTuile().get(5),1,0,false);
        caseTuile6[2][0]= new CaseModele(plateau.getCompTuile().get(5),2,0,true);
        caseTuile6[3][0]= new CaseModele(plateau.getCompTuile().get(5),3,0,false);
        caseTuile6[4][0]= new CaseModele(plateau.getCompTuile().get(5),4,0,false);
        caseTuile6[0][1]= new CaseModele(plateau.getCompTuile().get(5),0,1,false);
        caseTuile6[0][2]= new CaseModele(plateau.getCompTuile().get(5),0,2,false);
        caseTuile6[0][3]= new CaseModele(plateau.getCompTuile().get(5),0,3,false);
        caseTuile6[0][4]= new CaseModele(plateau.getCompTuile().get(5),0,4,false);
        caseTuile6[1][4]= new CaseModele(plateau.getCompTuile().get(5),1,4,false);
        caseTuile6[2][4]= new CaseModele(plateau.getCompTuile().get(5),2,4,false);
        caseTuile6[3][4]= new CaseModele(plateau.getCompTuile().get(5),3,4,false);
        caseTuile6[4][4]= new CaseModele(plateau.getCompTuile().get(5),4,4,false);
        caseTuile6[4][1]= new CaseModele(plateau.getCompTuile().get(5),4,1,false);
        caseTuile6[4][2]= new CaseModele(plateau.getCompTuile().get(5),4,2,false);
        caseTuile6[4][3]= new CaseModele(plateau.getCompTuile().get(5),4,3,false);
        caseTuile6[1][1]= new CaseModele(plateau.getCompTuile().get(5),1,1,true);
        caseTuile6[1][2]= new CaseModele(plateau.getCompTuile().get(5),1,2,true);
        caseTuile6[1][3]= new CaseModele(plateau.getCompTuile().get(5),1,3,true);
        caseTuile6[2][1]= new CaseModele(plateau.getCompTuile().get(5),2,1,true);
        caseTuile6[2][2]= new CaseModele(plateau.getCompTuile().get(5),2,2,true);
        caseTuile6[2][3]= new CaseModele(plateau.getCompTuile().get(5),2,3,true);
        caseTuile6[3][1]= new CaseModele(plateau.getCompTuile().get(5),3,1,true);
        caseTuile6[3][2]= new CaseModele(plateau.getCompTuile().get(5),3,2,true);
        caseTuile6[3][3]= new CaseModele(plateau.getCompTuile().get(5),3,3,true);
        plateau.getCompTuile().get(5).setCompCase(caseTuile6);
        caseTuile7[0][0]= new CaseModele(plateau.getCompTuile().get(6),0,0,false);
        caseTuile7[1][0]= new CaseModele(plateau.getCompTuile().get(6),1,0,false);
        caseTuile7[2][0]= new CaseModele(plateau.getCompTuile().get(6),2,0,false);
        caseTuile7[3][0]= new CaseModele(plateau.getCompTuile().get(6),3,0,false);
        caseTuile7[4][0]= new CaseModele(plateau.getCompTuile().get(6),4,0,false);
        caseTuile7[0][1]= new CaseModele(plateau.getCompTuile().get(6),0,1,false);
        caseTuile7[0][2]= new CaseModele(plateau.getCompTuile().get(6),0,2,false);
        caseTuile7[0][3]= new CaseModele(plateau.getCompTuile().get(6),0,3,false);
        caseTuile7[0][4]= new CaseModele(plateau.getCompTuile().get(6),0,4,false);
        caseTuile7[1][4]= new CaseModele(plateau.getCompTuile().get(6),1,4,false);
        caseTuile7[2][4]= new CaseModele(plateau.getCompTuile().get(6),2,4,false);
        caseTuile7[3][4]= new CaseModele(plateau.getCompTuile().get(6),3,4,false);
        caseTuile7[4][4]= new CaseModele(plateau.getCompTuile().get(6),4,4,false);
        caseTuile7[4][1]= new CaseModele(plateau.getCompTuile().get(6),4,1,false);
        caseTuile7[4][2]= new CaseModele(plateau.getCompTuile().get(6),4,2,false);
        caseTuile7[4][3]= new CaseModele(plateau.getCompTuile().get(6),4,3,false);
        caseTuile7[1][1]= new CaseModele(plateau.getCompTuile().get(6),1,1,true);
        caseTuile7[1][2]= new CaseModele(plateau.getCompTuile().get(6),1,2,true);
        caseTuile7[1][3]= new CaseModele(plateau.getCompTuile().get(6),1,3,true);
        caseTuile7[2][1]= new CaseModele(plateau.getCompTuile().get(6),2,1,true);
        caseTuile7[2][2]= new CaseModele(plateau.getCompTuile().get(6),2,2,true);
        caseTuile7[2][3]= new CaseModele(plateau.getCompTuile().get(6),2,3,true);
        caseTuile7[3][1]= new CaseModele(plateau.getCompTuile().get(6),3,1,true);
        caseTuile7[3][2]= new CaseModele(plateau.getCompTuile().get(6),3,2,true);
        caseTuile7[3][3]= new CaseModele(plateau.getCompTuile().get(6),3,3,true);
        plateau.getCompTuile().get(6).setCompCase(caseTuile7);
        caseTuile8[0][0]= new CaseModele(plateau.getCompTuile().get(7),0,0,false);
        caseTuile8[1][0]= new CaseModele(plateau.getCompTuile().get(7),1,0,false);
        caseTuile8[2][0]= new CaseModele(plateau.getCompTuile().get(7),2,0,true);
        caseTuile8[3][0]= new CaseModele(plateau.getCompTuile().get(7),3,0,false);
        caseTuile8[4][0]= new CaseModele(plateau.getCompTuile().get(7),4,0,false);
        caseTuile8[0][1]= new CaseModele(plateau.getCompTuile().get(7),0,1,false);
        caseTuile8[0][2]= new CaseModele(plateau.getCompTuile().get(7),0,2,false);
        caseTuile8[0][3]= new CaseModele(plateau.getCompTuile().get(7),0,3,false);
        caseTuile8[0][4]= new CaseModele(plateau.getCompTuile().get(7),0,4,false);
        caseTuile8[1][4]= new CaseModele(plateau.getCompTuile().get(7),1,4,false);
        caseTuile8[2][4]= new CaseModele(plateau.getCompTuile().get(7),2,4,false);
        caseTuile8[3][4]= new CaseModele(plateau.getCompTuile().get(7),3,4,false);
        caseTuile8[4][4]= new CaseModele(plateau.getCompTuile().get(7),4,4,false);
        caseTuile8[4][1]= new CaseModele(plateau.getCompTuile().get(7),4,1,false);
        caseTuile8[4][2]= new CaseModele(plateau.getCompTuile().get(7),4,2,false);
        caseTuile8[4][3]= new CaseModele(plateau.getCompTuile().get(7),4,3,false);
        caseTuile8[1][1]= new CaseModele(plateau.getCompTuile().get(7),1,1,true);
        caseTuile8[1][2]= new CaseModele(plateau.getCompTuile().get(7),1,2,true);
        caseTuile8[1][3]= new CaseModele(plateau.getCompTuile().get(7),1,3,true);
        caseTuile8[2][1]= new CaseModele(plateau.getCompTuile().get(7),2,1,true);
        caseTuile8[2][2]= new CaseModele(plateau.getCompTuile().get(7),2,2,true);
        caseTuile8[2][3]= new CaseModele(plateau.getCompTuile().get(7),2,3,true);
        caseTuile8[3][1]= new CaseModele(plateau.getCompTuile().get(7),3,1,true);
        caseTuile8[3][2]= new CaseModele(plateau.getCompTuile().get(7),3,2,true);
        caseTuile8[3][3]= new CaseModele(plateau.getCompTuile().get(7),3,3,true);
        plateau.getCompTuile().get(7).setCompCase(caseTuile8);
        caseTuile9[0][0]= new CaseModele(plateau.getCompTuile().get(8),0,0,false);
        caseTuile9[1][0]= new CaseModele(plateau.getCompTuile().get(8),1,0,false);
        caseTuile9[2][0]= new CaseModele(plateau.getCompTuile().get(8),2,0,true);
        caseTuile9[3][0]= new CaseModele(plateau.getCompTuile().get(8),3,0,false);
        caseTuile9[4][0]= new CaseModele(plateau.getCompTuile().get(8),4,0,false);
        caseTuile9[0][1]= new CaseModele(plateau.getCompTuile().get(8),0,1,false);
        caseTuile9[0][2]= new CaseModele(plateau.getCompTuile().get(8),0,2,true);
        caseTuile9[0][3]= new CaseModele(plateau.getCompTuile().get(8),0,3,false);
        caseTuile9[0][4]= new CaseModele(plateau.getCompTuile().get(8),0,4,false);
        caseTuile9[1][4]= new CaseModele(plateau.getCompTuile().get(8),1,4,false);
        caseTuile9[2][4]= new CaseModele(plateau.getCompTuile().get(8),2,4,false);
        caseTuile9[3][4]= new CaseModele(plateau.getCompTuile().get(8),3,4,false);
        caseTuile9[4][4]= new CaseModele(plateau.getCompTuile().get(8),4,4,false);
        caseTuile9[4][1]= new CaseModele(plateau.getCompTuile().get(8),4,1,false);
        caseTuile9[4][2]= new CaseModele(plateau.getCompTuile().get(8),4,2,false);
        caseTuile9[4][3]= new CaseModele(plateau.getCompTuile().get(8),4,3,false);
        caseTuile9[1][1]= new CaseModele(plateau.getCompTuile().get(8),1,1,true);
        caseTuile9[1][2]= new CaseModele(plateau.getCompTuile().get(8),1,2,true);
        caseTuile9[1][3]= new CaseModele(plateau.getCompTuile().get(8),1,3,true);
        caseTuile9[2][1]= new CaseModele(plateau.getCompTuile().get(8),2,1,true);
        caseTuile9[2][2]= new CaseModele(plateau.getCompTuile().get(8),2,2,true);
        caseTuile9[2][3]= new CaseModele(plateau.getCompTuile().get(8),2,3,true);
        caseTuile9[3][1]= new CaseModele(plateau.getCompTuile().get(8),3,1,true);
        caseTuile9[3][2]= new CaseModele(plateau.getCompTuile().get(8),3,2,true);
        caseTuile9[3][3]= new CaseModele(plateau.getCompTuile().get(8),3,3,true);
        plateau.getCompTuile().get(8).setCompCase(caseTuile9);
        plateau.getCompTuile().get(8).setTuileAccessible();
        ProfModele p=new ProfModele(null,caseTuile8[2][2],100,3,"Jean Pierre",true,0);
        caseTuile8[2][2].getCompElemCase().add(p);
        /*p.deplacement();
        p.deplacement();*/
        /*String tab[]={"CS","HUMA"};
        EtudiantModele e = new EtudiantModele(null,caseTuile9[2][2],10,2,"etudiant simple",true,5,tab,2);
        // caseTuile9[2][2].getCompElemCase().add(e);
        PorteModele p1= new PorteModele(null,caseTuile8[2][0],true);
        PorteModele p2= new PorteModele(null,caseTuile8[0][2],true);
        PorteModele p3= new PorteModele(null,caseTuile8[4][2],true);
        caseTuile8[2][0].getCompElemCase().add(p1);
        caseTuile8[0][2].getCompElemCase().add(p2);
        caseTuile8[4][2].getCompElemCase().add(p3);
        for (TuileModele t : plateau.getCompTuile()) {
            t.porteSurTuile();
            t.setPersOnTuile();
            System.out.println(t.tuileContainProf());
            System.out.println(t.tuileContainEtu());
            System.out.println(t.getId());
            t.setTuileAccessible();
        }
        OutilValidationModele o1=new OutilValidationModele("canif","Canif de la muerte",0,0,5,4,3,tab,3);
        OutilValidationModele o2=new OutilValidationModele("canif","Canif de la muerte 2",0,1,5,4,3,tab,3);
        OutilValidationModele o3=new OutilValidationModele("canif","Canif de la muerte 3",0,1,5,4,3,tab,3);
        CleModele c1= new CleModele("cle","cle",3);
        System.out.println(p.getPv());
        p.getInventaire().getContenuInventaire().add(o1);
        p.getInventaire().getContenuInventaire().add(o2);
        p.getInventaire().getContenuInventaire().add(o3);
        p.getInventaire().getContenuInventaire().add(c1);
        plateau.getCompTuile().get(7).getCompCase()[4][2].getCompElemCase().add(new PorteModele(null,plateau.getCompTuile().get(6).getCompCase()[4][2],true));
        plateau.getCompTuile().get(6).getCompCase()[4][2].getCompElemCase().add(new PorteModele(null,plateau.getCompTuile().get(6).getCompCase()[4][2],true));
        //e.tourDeJeu();
        p.choixOutilEtZone();
        //p.deplacement();
        p.choixModifInventaire();
        System.out.println(p.getMaCase().getMaTuile().getId());
        p.choixPorte();
        for (TuileModele t : plateau.getCompTuile()) {
            t.porteSurTuile();
            t.setPersOnTuile();
            t.setTuileAccessible();
        }
        System.out.println(p.getMaCase().getMaTuile().getId());
        p.deplacement();
        System.out.println(p.getMaCase().getMaTuile().getId());
        System.out.println(p.getMaCase().getMaTuile().getCompCase()[4][2].getPassable());
        p.deplacement();
        System.out.println(p.getMaCase().getMaTuile().getId());
        System.out.println(p.getPv());
        /*for (TuileModele t : plateau.getCompTuile()) {
            t.setPersOnTuile();
            System.out.println(t.tuileContainProf());
            System.out.println(t.tuileContainEtu());
            System.out.println(t.getId());
            t.setTuileAccessible(plateau.getCompTuile());
        }
        System.out.println(e.getMaCase().getMaTuile().getId());*/
    }
}
