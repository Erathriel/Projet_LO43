package Modele;

public class PileCarteModele {
    private int nbCarte;
    private CarteModele[] cartes;

    // Constructeur
    public PileCarteModele() {
    }

    // Getters et Setters
    public int getNbCarte() {
        return nbCarte;
    }

    public void setNbCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public CarteModele[] getCartes() {
        return cartes;
    }

    public void setCartes(CarteModele[] cartes) {
        this.cartes = cartes;
    }

}
