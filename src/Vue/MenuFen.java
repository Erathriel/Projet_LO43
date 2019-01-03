package Vue;

import Controleur.PartieControlleur;
import Modele.PartieModele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuFen extends JFrame {
    MenuFen(){
        super();
        PartieControlleur control=new PartieControlleur(new PartieModele(),null);
        this.setTitle("Menu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuPanel menuPanel = new MenuPanel(control);
        this.setVisible(true);
        this.add(menuPanel);
        control.jeu();
    }
    public static void main(String args[]){
        MenuFen fen = new MenuFen();
    }
}
