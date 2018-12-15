package Modele;

public class OutilValidationModele extends ObjetModele {
    private int portee;
    private int nbUVVal;
    private int nbActivation;
    private int nbTentative;
    private String[] typeUV;

    // Constructeur
    public OutilValidationModele(String intitule, String nom, int emplacement, int portee, int nbUVVal, int nbActivation, int nbTentative,String [] typeUV) {
        super(intitule, nom, emplacement);
        this.portee=portee;
        this.nbUVVal=nbUVVal;
        this.nbActivation=nbActivation;
        this.nbTentative=nbTentative;
        this.typeUV=typeUV;
    }

    // Getters et Setters
    public int getNbActivation() {
        return nbActivation;
    }

    public void setNbActivation(int nbActivation) {
        this.nbActivation = nbActivation;
    }

    public int getNbTentative() {
        return nbTentative;
    }

    public void setNbTentative(int nbTentative) {
        this.nbTentative = nbTentative;
    }
    public int getPortee() {
        return portee;
    }

    public int getNbUVVal() {
        return nbUVVal;
    }

    public String[] getTypeUV() {
        return typeUV;
    }

}
