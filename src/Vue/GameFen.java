package Vue;

import Controleur.PartieControlleur;
import Modele.PartieModele;

import javax.swing.*;

public class GameFen extends JFrame {
    GameFen(PartieControlleur control){
        this.setTitle("Menu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePane gamePane=new GamePane(control);
        this.add(gamePane);
        this.setVisible(true);

    }
    public static void main(String Args[]){
        PartieModele mPartie=new PartieModele();
        PartieControlleur control=new PartieControlleur(mPartie,null);
        GameFen g= new GameFen(control);
    }
}
