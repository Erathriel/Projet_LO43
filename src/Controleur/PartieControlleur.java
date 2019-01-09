package Controleur;

import Vue.*;
import Modele.*;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class PartieControlleur implements KeyListener, MouseListener, ActionListener {
    private PartieModele mPartie;
    private GameFen gameFen;
    private boolean victoire;
    private boolean defaite;
    private int actionJoueur;

    // Constructeur
    public PartieControlleur(PartieModele mPartie, GameFen gameFen) {
        this.mPartie = mPartie;
        this.gameFen = gameFen;
        this.victoire=false;
        this.defaite=false;
        this.actionJoueur=0;
    }

    public void jeu() {
        int exptot=0;
        for (TuileModele t:this.mPartie.getPlateau().getCompTuile()) {
            System.out.println("Tuile id : "+t.getId()
            );
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j <5 ; j++) {
                    System.out.print(" "+i+"  "+t.getCompCase()[i][j].getPassable()+" "+j+" ");
                }
                System.out.println("\n");
            }
        }
        while(!victoire && !defaite ){
            this.actualisationTuile();
            for (PersonnageModele p : this.mPartie.getListePerso()) {
                if (p.isJouable()) {
                    if (p instanceof EtudiantModele) {
                        p.tourDeJeu();
                        this.defaite=defaite();

                    } else if (p instanceof ProfModele) {
                        this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                        while (p.getPa() > 0) {
                            switch (actionJoueur) {
                                case 1:
                                    ((ProfModele) p).choixOutilEtZone();
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 2:
                                    ((ProfModele) p).fouiller(this.mPartie.getPileCarte());
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 3:
                                    p.deplacement();
                                    System.out.println(p.getMaCase().getMaTuile().getId());
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 4:
                                    ((ProfModele) p).choixPorte();
                                    this.actionJoueur = 0;
                                    this.actualisationTuile();
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 5:
                                    ((ProfModele) p).choixModifInventaire();
                                    this.actionJoueur = 0;
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 6:
                                    ((ProfModele) p).activerObjectif();
                                    this.actionJoueur = 0;
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 7:
                                    ((ProfModele) p).capaciteActive();
                                    this.actionJoueur = 0;
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 8:
                                    ((ProfModele) p).capacitePassive();
                                    this.actionJoueur = 0;
                                    this.gameFen.repaintInfo(mPartie.getJoueurEnAction());
                                    break;
                                case 9:
                                    p.passer();
                                    this.actionJoueur = 0;
                                    break;
                                default:
                                    break;
                            }
                            this.victoire=victoire();
                        }
                    }
                    p.setJouable(false);
                    this.actualisationTuile();
                }
            }
            exptot=0;
            for (PersonnageModele p: this.mPartie.getListePerso()) {
                p.setJouable(true);
                p.setPa(p.getNbPa());
                if(p instanceof ProfModele){
                    exptot+=((ProfModele) p).getExp();
                }
            }
            for(MachineCafeModele m:this.mPartie.getMachineCafeModele()){
                m.spawnDebutManche(this.mPartie.getPileCarte(),exptot);
            }
        }
        System.out.println("FIN");
    }
    public void actualisationTuile(){
        for (TuileModele t : this.mPartie.getPlateau().getCompTuile()) {
            t.setPersOnTuile();
            t.porteSurTuile();
            t.setTuileAccessible();
        }
        ArrayList<PersonnageModele> p=new ArrayList<PersonnageModele>();
        for(TuileModele t:mPartie.getPlateau().getCompTuile()){
            for(PersonnageModele pers:t.getPersOnTuile()){
                if(pers instanceof ProfModele && pers.getPv()>0){
                    p.add(pers);
                }
            }
        }
        for(TuileModele t:mPartie.getPlateau().getCompTuile()){
            for(PersonnageModele pers:t.getPersOnTuile()){
                if(pers instanceof EtudiantModele && pers.getPv()>0){
                    p.add(pers);
                }
            }
        }
        this.mPartie.setListePerso(p);
    }
    public boolean defaite()
    {
        for(PersonnageModele p : this.mPartie.getListePerso()){
            if(p instanceof ProfModele)
            {
                return false;
            }
        }
        return true;
    }
    public boolean victoire(){
        for(PersonnageModele p : this.mPartie.getListePerso()){
            if(p instanceof ProfModele)
            {
                for(ElemCaseModele e:p.getMaCase().getCompElemCase()){
                    if(this.mPartie.getListeObjectif().size()==0){
                       if(e instanceof SortieModele) {
                           return true;
                       }
                    }
                }

            }
        }
        return false;
    }
    // Getters et Setters
    public PartieModele getmPartie() {
        return mPartie;
    }

    public void setmPartie(PartieModele mPartie) {
        this.mPartie = mPartie;
    }

    public GameFen getgameFen() {
        return gameFen;
    }

    public void setgameFen(GameFen gameFen) {
        this.gameFen = gameFen;
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
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == gameFen.getGamePane().getGbp().getValidation()) {
            this.actionJoueur=gameFen.getGamePane().getGbp().getValidation().getActionJoueur();
        }
        if (e.getSource() == gameFen.getGamePane().getGbp().getFouiller()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getFouiller().getActionJoueur();
        }
        if (e.getSource() == gameFen.getGamePane().getGbp().getDeplacer()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getDeplacer().getActionJoueur();
        }
        if (e.getSource() == gameFen.getGamePane().getGbp().getOuvPorte()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getOuvPorte().getActionJoueur();
        }
        if (e.getSource() == gameFen.getGamePane().getGbp().getModifInv()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getModifInv().getActionJoueur();
        }
        if(e.getSource() == gameFen.getGamePane().getGbp().getActObj()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getActObj().getActionJoueur();
        }
        if(e.getSource() == gameFen.getGamePane().getGbp().getCapAct()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getCapAct().getActionJoueur();
        }
        if (e.getSource() == gameFen.getGamePane().getGbp().getCapPas()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getCapPas().getActionJoueur();
        }
        if (e.getSource() == gameFen.getGamePane().getGbp().getPasser()){
            this.actionJoueur=gameFen.getGamePane().getGbp().getPasser().getActionJoueur();
        }
    }


}
