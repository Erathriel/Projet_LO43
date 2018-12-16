package Modele;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void valider(ArrayList<ElemCaseModele> per)
    {
        int parcours=0;
        while(parcours<per.size())
        {
            if(per.get(parcours) instanceof PersonnageModele) {
                if (per.get(parcours) instanceof PersonnageModele) {
                    if (per.get(parcours) instanceof ProfModele) {
                        System.out.println("dégat Prof");
                        ((PersonnageModele)per.get(parcours)).setPv(((PersonnageModele)per.get(parcours)).getPv() - this.getNbDemandeValidation());
                        parcours++;


                    } else {
                        parcours++;
                    }
                }
                for (int i = 0; i < per.size(); i++) {
                    if (per.get(i) instanceof ProfModele) {
                        if (((PersonnageModele)per.get(i)).isValider()) {
                            per.remove(i);
                        }
                    }
                }
            }
             else{
                parcours++;
            }
        }
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

    @Override
    public String toString() {
        return "EtudiantModele{" +
                "nbDemandeValidation=" + nbDemandeValidation +
                ", typeUV=" + Arrays.toString(typeUV) +
                ", expRapporte=" + expRapporte +
                '}';
    }
}
