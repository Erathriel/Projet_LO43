import Controleur.*;
import Modele.*;
import Vue.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
        //MenuFen fen = new MenuFen();
        //MenuControlleur mControl = new MenuControlleur(fen);
        PartieModele mPartie=new PartieModele();
        GameFen g= new GameFen(mPartie);
        PartieControlleur control=new PartieControlleur(mPartie,g);
        mPartie.creationPersoObjM();
        control.jeu();
    }
}
