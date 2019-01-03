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

    // Constructeur
    public PartieControlleur(PartieModele mPartie, PartieVue vPartie) {
        this.mPartie = mPartie;
        this.vPartie = vPartie;
        this.victoire=true;
        this.defaite=false;
        this.actionJoueur=0;
    }

    public void jeu(){
        this.mPartie.getListePerso().add(new ProfModele(null,null,50,3,"Prof Math",true,0));
        for (PersonnageModele p: this.mPartie.getListePerso()) {
            if(p.isJouable()){
                if(p instanceof EtudiantModele)
                {
                    p.tourDeJeu();
                }
                else if( p instanceof ProfModele){

                    while(p.getPa()>0) {
                        switch (actionJoueur) {
                            case 1:
                                ((ProfModele) p).choixOutilEtZone();
                                this.actionJoueur = 0;
                                break;
                            case 2:
                                ((ProfModele) p).fouiller(this.mPartie.getPileCarte());
                                this.actionJoueur = 0;
                                break;
                            case 3:
                                p.deplacement();
                                this.actionJoueur = 0;
                                break;
                            case 4:
                                ((ProfModele) p).choixPorte();
                                this.actionJoueur = 0;
                                break;
                            case 5:
                                ((ProfModele) p).choixModifInventaire();
                                this.actionJoueur = 0;
                                break;
                            case 6:
                                ((ProfModele) p).activerObjectif();
                                this.actionJoueur = 0;
                                break;
                            case 7:
                                ((ProfModele) p).capaciteActive();
                                this.actionJoueur = 0;
                                break;
                            case 8:
                                ((ProfModele) p).capacitePassive();
                                this.actionJoueur = 0;
                                break;
                            case 9:
                                System.out.println("\n\n\nALLLLLLLLLLLLO");
                                p.setPa(p.getPa()-1);
                                this.actionJoueur = 0;
                                break;
                            default: System.out.println(p.getPa());break;
                        }
                    }
                }
                p.setJouable(false);
                for (TuileModele t: this.mPartie.getPlateau().getCompTuile()) {
                    t.setPersOnTuile();
                    t.setTuileAccessible();
                }
            }
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
