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
    public void valider(ArrayList<PersonnageModele> per)
    {
           int parcours = 0;
           while (parcours < per.size()) {
                   if (per.get(parcours) instanceof PersonnageModele) {
                       if (per.get(parcours) instanceof ProfModele) {
                           System.out.println("dégat Prof");
                           (per.get(parcours)).setPv((per.get(parcours)).getPv() - this.getNbDemandeValidation());
                           parcours++;


                       } else {
                           parcours++;
                       }

                       for (int i = 0; i < per.size(); i++) {
                           if (per.get(i) instanceof ProfModele) {
                               if ((per.get(i)).isValider()) {
                                   per.remove(i);
                               }
                           }
                       }
                   }
                else {
                   parcours++;
                }
           }
           this.setPa(0);
    }
    public void deplacement()
    {
        if(!this.getMaCase().getMaTuile().tuileContainProf())
        {
            CaseModele anciennePosition=this.getMaCase();
            ArrayList<TuileModele> containProf=new ArrayList<TuileModele>();
            for (TuileModele t:this.getMaCase().getMaTuile().getTuileAccessible()) {
                if(t.tuileContainProf()){
                    containProf.add(t);
                }
                else{
                }
            }
            System.out.print(containProf.size());
            if(containProf.size()>0){
                int  destination= (int) (Math.random()*(containProf.size()));
                this.setMaCase(containProf.get(destination).getCompCase()[this.getMaCase().getCoordX()][this.getMaCase().getCoordY()]);
                this.getMaCase().getCompElemCase().add(this);
                anciennePosition.getCompElemCase().remove(this);
                anciennePosition.getMaTuile().setPersOnTuile();
                this.getMaCase().getMaTuile().setPersOnTuile();
            }
            else{
                int  destination= (int) (Math.random()*(containProf.size()));
                this.setMaCase(this.getMaCase().getMaTuile().getTuileAccessible().get(destination).getCompCase()[this.getMaCase().getCoordX()][this.getMaCase().getCoordY()]);
                anciennePosition.getCompElemCase().remove(this);
                anciennePosition.getMaTuile().setPersOnTuile();
                this.getMaCase().getMaTuile().setPersOnTuile();
            }
            this.setPa(this.getPa()-1);
        }
    }
    public void tourDeJeu(){
        while(this.getPa()>0)
        {
            if (this.getMaCase().getMaTuile().tuileContainProf())
            {
                this.valider(this.getMaCase().getMaTuile().getPersOnTuile());
            }
            else
            {
                this.deplacement();
            }
        }
        this.setJouable(false);
        this.setPa(this.getNbPa());
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
