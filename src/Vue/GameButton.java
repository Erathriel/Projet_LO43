package Vue;

import Controleur.PartieControlleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameButton extends JButton implements ActionListener {
    private PartieControlleur control;
    private int actionJoueur;
    GameButton(PartieControlleur control, int actionJoueur,String nom){
        super(nom);
        this.control=control;
        this.actionJoueur=actionJoueur;
        this.setPreferredSize(new Dimension(125,25));
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        control.setActionJoueur(actionJoueur);
    }
}
