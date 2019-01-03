package Controleur;

import Vue.*;
import Modele.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class PartieControlleur implements KeyListener, MouseListener {
    private PartieModele mPartie;
    private PartieVue vPartie;

    // Constructeur
    public PartieControlleur(PartieModele mPartie, PartieVue vPartie) {
        this.mPartie = mPartie;
        this.vPartie = vPartie;
    }

    // Getters et Setters
    public PartieModele getmPartie() {
        return mPartie;
    }

    public void setmPartie(PartieModele mPartie) {
        this.mPartie = mPartie;
    }

    public PartieVue getvPartie() {
        return vPartie;
    }

    public void setvPartie(PartieVue vPartie) {
        this.vPartie = vPartie;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
