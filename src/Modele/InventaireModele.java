package Modele;

import java.util.ArrayList;

public class InventaireModele {
    private int capacite;
    private int nbObjetActuel;
    private ArrayList<ObjetModele> contenuInventaire;
    // Constructeur
    public InventaireModele(int capacite) {
        this.capacite = capacite;
        this.nbObjetActuel = 0;
        this.contenuInventaire=new ArrayList<ObjetModele>();
    }

    // Methodes
    public void suppressionObjet(int index){
        this.contenuInventaire.remove(index);
    }
    public ObjetModele objetInventaire(int i){
        return this.contenuInventaire.get(i);
    }

    // Getters et Setters
    public int getNbObjetActuel() {
        return nbObjetActuel;
    }

    public void setNbObjetActuel(int nbObjetActuel) {
        this.nbObjetActuel = nbObjetActuel;
    }

    public int getCapacite() {
        return capacite;
    }
    public ArrayList<ObjetModele> getContenuInventaire(){
        return this.contenuInventaire;
    }

    @Override
    public String toString() {
        return "InventaireModele{" +
                "capacite=" + capacite +
                ", nbObjetActuel=" + nbObjetActuel +
                ", contenuInventaire=" + contenuInventaire +
                '}';
    }
}
