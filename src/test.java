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
        vPartie.parcoursMap("maps/mapTest.txt");
    }
}
