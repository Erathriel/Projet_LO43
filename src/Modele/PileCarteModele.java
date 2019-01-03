package Modele;

import java.util.ArrayList;

public class PileCarteModele {
    private int nbCarte;
    private ArrayList<CarteModele> listeCarte;

    // Constructeur
    public PileCarteModele() {
        this.listeCarte=new ArrayList<CarteModele>();
        for (int i = 0; i <10; i++) {
            this.listeCarte.add(new CleModele("L'Objet Utile qui vous sauvera","Cle",0));
        }
        for (int i = 0; i <10; i++) {
            this.listeCarte.add(new CarteEtudianteModele("Manque de Chance ",1));
        }
        for (int i = 0; i <8; i++) {
            this.listeCarte.add(new CarteEtudianteModele("La chance commence a s'éloigner",2));
        }
        for (int i = 0; i <6; i++) {
            this.listeCarte.add(new CarteEtudianteModele("La chance vous regarde au loin",3));
        }
        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new CarteEtudianteModele("Ne comptez plus sur la chance",4));
        }
        for (int i = 0; i <3; i++) {
            this.listeCarte.add(new CarteEtudianteModele("COURER",5));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new CarteEtudianteModele("AU SECOURS VITE ",6));
        }
        //Fiche UV
        for (int i = 0; i <3; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <3; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <3; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        //Tampon Encreur
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <2; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele("","",0,0,3,0,0,null,0));
        }
    }
    public void remplissage(){
        int nbrcle=0;
        int nbrCarteEtu=0;
        int nbrOutil=0;
        for (CarteModele c:this.listeCarte) {
            if(c instanceof CleModele){
                nbrcle++;
            }
            else if(c instanceof  CarteEtudianteModele){
                nbrCarteEtu++;
            }
            else if(c instanceof OutilValidationModele){
                nbrOutil++;
            }
        }
        if(nbrcle<2 || nbrCarteEtu <5 || nbrOutil <5){
            PileCarteModele p =new PileCarteModele();
            this.listeCarte=p.getListeCarte();
        }
    }
    // Getters et Setters
    public int getNbCarte() {
        return nbCarte;
    }

    public void setNbCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public ArrayList<CarteModele> getListeCarte() {
        return listeCarte;
    }

    public void setListeCarte(ArrayList<CarteModele> listeCarte) {
        this.listeCarte = listeCarte;
    }

    @Override
    public String toString() {
        return "PileCarteModele{" +
                "nbCarte=" + nbCarte +
                ", listeCarte=" + listeCarte +
                '}';
    }
}
