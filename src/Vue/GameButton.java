package Vue;

import Controleur.PartieControlleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameButton extends JButton {
    private int actionJoueur;
    GameButton(int actionJoueur,String nom){
        super(nom);
        this.actionJoueur=actionJoueur;
        this.setPreferredSize(new Dimension(125,25));
    }


    /*@Override
    public void actionPerformed(ActionEvent e) {
        control.setActionJoueur(actionJoueur);
    }*/
}
