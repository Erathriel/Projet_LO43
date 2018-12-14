package Modele;

public class InventaireModele {
    private int capacite;
    private int nbObjetActuel;

    // Constructeur
    public InventaireModele(int capacite) {
        this.capacite = capacite;
        this.nbObjetActuel = 0;
    }

    // Methodes
    public void suppressionObjet(){

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

}
