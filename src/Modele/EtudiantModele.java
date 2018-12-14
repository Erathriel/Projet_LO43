package Modele;

import java.awt.*;

public class EtudiantModele extends PersonnageModele {
    private int nbDemandeValidation;
    private String[] typeUV;
    private int expRapporte;

    // Constructeur
    public EtudiantModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int nbDemandeValidation, String[] typeUV, int expRapporte) {
        super(image, maCase, pv, pa, nom, jouable);
        this.nbDemandeValidation=nbDemandeValidation;
        this.typeUV=typeUV;
        this.expRapporte=expRapporte;
    }

    public int getNbDemandeValidation() {
        return nbDemandeValidation;
    }

    public void setNbDemandeValidation(int nbDemandeValidation) {
        this.nbDemandeValidation = nbDemandeValidation;
    }

    public String[] getTypeUV() {
        return typeUV;
    }

    public void setTypeUV(String[] typeUV) {
        this.typeUV = typeUV;
    }

    public int getExpRapporte() {
        return expRapporte;
    }

    public void setExpRapporte(int expRapporte) {
        this.expRapporte = expRapporte;
    }
}
