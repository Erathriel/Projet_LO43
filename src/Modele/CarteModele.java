package Modele;

public abstract class CarteModele {
    private String intitule;

    // Constructeur
    public CarteModele(String intitule) {
        this.intitule = intitule;
    }

    // Getters et Setters
    public String getIntitule() {
        return intitule;
    }

    @Override
    public String toString() {
        return "CarteModele{" +
                "intitule='" + intitule + '\'' +
                '}';
    }
}
