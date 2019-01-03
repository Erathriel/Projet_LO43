package Modele;

import java.util.Arrays;

public class OutilValidationModele extends ObjetModele {
    private boolean modifier;
    private int portee;
    private int nbUVVal;
    private int nbActivation;
    private int nbTentative;
    private int tauxDeReussite;
    private String[] typeUV;

    // Constructeur
    public OutilValidationModele(String intitule, String nom, int emplacement, int portee, int nbUVVal, int nbActivation, int nbTentative,String [] typeUV,int tauxDeReussite) {
        super(intitule, nom, emplacement);
        this.portee=portee;
        this.nbUVVal=nbUVVal;
        this.nbActivation=nbActivation;
        this.nbTentative=nbTentative;
        this.typeUV=typeUV;
        this.tauxDeReussite=tauxDeReussite;
        this.modifier=false;
    }

    // Getters et Setters
    public boolean getModifier(){return this.modifier;}
    public void setModifier(){this.modifier=true;}
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
    public void setPortee(int portee){this.portee=portee;}

    public int getNbUVVal() {
        return nbUVVal;
    }

    public String[] getTypeUV() {
        return typeUV;
    }
    public int getTauxDeReussite(){return this.tauxDeReussite;}
    public void setTauxDeReussite(int taux){this.tauxDeReussite=taux;}
    @Override
    public String toString() {
        return "OutilValidationModele{" +
                "portee=" + portee +
                ", nbUVVal=" + nbUVVal +
                ", nbActivation=" + nbActivation +
                ", nbTentative=" + nbTentative +
                ", tauxDeReussite=" + tauxDeReussite +
                ", typeUV=" + Arrays.toString(typeUV) +
                '}';
    }
}
