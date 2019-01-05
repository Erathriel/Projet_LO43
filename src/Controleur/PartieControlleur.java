package Controleur;

import Vue.*;
import Modele.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

public class PartieControlleur implements KeyListener, MouseListener {
    private PartieModele mPartie;
    private PartieVue vPartie;
    private boolean victoire;
    private boolean defaite;
    private int actionJoueur;
    private ProfModele joueurEnAction;

    // Constructeur
    public PartieControlleur(PartieModele mPartie, PartieVue vPartie) {
        this.mPartie = mPartie;
        this.vPartie = vPartie;
        this.victoire=false;
        this.defaite=false;
        this.actionJoueur=0;
    }

    public void jeu() {
        this.mPartie.getListePerso().add(new ProfModele(null, null, 50, 3, "Prof Math", true, 0));
        while(!victoire && !defaite ){
            for (PersonnageModele p:this.mPartie.getListePerso()) {
                p.setJouable(true);
            }
            for (PersonnageModele p : this.mPartie.getListePerso()) {
                if (p.isJouable()) {
                    if (p instanceof EtudiantModele) {
                        p.tourDeJeu();
                    } else if (p instanceof ProfModele) {
                        joueurEnAction = ((ProfModele) p);
                        while (p.getPa() > 0) {
                            switch (actionJoueur) {
                                case 1:
                                    ((ProfModele) p).choixOutilEtZone();
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 2:
                                    ((ProfModele) p).fouiller(this.mPartie.getPileCarte());
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 3:
                                    p.deplacement();
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 4:
                                    ((ProfModele) p).choixPorte();
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 5:
                                    ((ProfModele) p).choixModifInventaire();
                                    this.actionJoueur = 0;
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 6:
                                    ((ProfModele) p).activerObjectif();
                                    this.actionJoueur = 0;
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 7:
                                    ((ProfModele) p).capaciteActive();
                                    this.actionJoueur = 0;
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                case 8:
                                    ((ProfModele) p).capacitePassive();
                                    this.actionJoueur = 0;
                                    this.vPartie.getGamefen().repaintInfo(joueurEnAction);
                                    break;
                                default:
                                    System.out.println(p.getPa());
                                    break;
                            }
                        }
                    }
                    p.setJouable(false);
                    this.actualisationTuile();
                }
            }
        }
    }
    public void actualisationTuile(){
        for (TuileModele t : this.mPartie.getPlateau().getCompTuile()) {
            t.setPersOnTuile();
            t.setTuileAccessible();
        }
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
    public int getActionJoueur(){return this.actionJoueur;}
    public void setActionJoueur(int actionJoueur){this.actionJoueur=actionJoueur;}
    public ProfModele getJoueurEnAction(){return this.joueurEnAction;}
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
