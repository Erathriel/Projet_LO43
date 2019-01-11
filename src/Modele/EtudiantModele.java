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
    public void valider(ArrayList<PersonnageModele> per)//Recupère un liste de Personnage Modele et pour chaque prof
            //baisse ces pv en fonction du nombre de demande de validation de l'étudiant
    {
           int parcours = 0;
           while (parcours < per.size()) {
                   if (per.get(parcours) instanceof PersonnageModele) {
                       if (per.get(parcours) instanceof ProfModele) {
                            (per.get(parcours)).setPv((per.get(parcours)).getPv() - this.getNbDemandeValidation());
                           parcours++;


                       } else {
                           parcours++;
                       }

                       for (int i = 0; i < per.size(); i++) {
                           if (per.get(i) instanceof ProfModele) {
                               if ((per.get(i)).isValider()) {
                                   per.get(i).getMaCase().getCompElemCase().remove(per.get(i));
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
    {/*Récupère la liste des tuile accessible et les sépare entre celle ou des prof sont dessus et cell ou il n'y en a pas
     si il existe une case avec des prof ou plusieur il ira sur une de ces cases aléatoirement*/
        if(!this.getMaCase().getMaTuile().tuileContainProf())
        {
            CaseModele anciennePosition=this.getMaCase();
            ArrayList<TuileModele> containProf=new ArrayList<TuileModele>();
              if(this.getMaCase().getMaTuile().getTuileAccessible().size()>0) {
                  for (TuileModele t : this.getMaCase().getMaTuile().getTuileAccessible()) {
                      if (t.tuileContainProf()) {
                          containProf.add(t);
                      } else {
                      }
                  }
                  if (containProf.size() > 0) {
                      int destination = (int) (Math.random()*(containProf.size()));
                      this.setMaCase(containProf.get(destination).getCompCase()[this.getMaCase().getCoordX()][this.getMaCase().getCoordY()]);
                      this.getMaCase().getCompElemCase().add(this);
                      anciennePosition.getCompElemCase().remove(this);
                      anciennePosition.getMaTuile().setPersOnTuile();
                      this.getMaCase().getMaTuile().setPersOnTuile();
                  } else {
                       int destination = (int) (Math.random() * (this.getMaCase().getMaTuile().getTuileAccessible().size()));
                      this.setMaCase(this.getMaCase().getMaTuile().getTuileAccessible().get(destination).getCompCase()[this.getMaCase().getCoordX()][this.getMaCase().getCoordY()]);
                      this.getMaCase().getCompElemCase().add(this);
                      anciennePosition.getCompElemCase().remove(this);
                      anciennePosition.getMaTuile().setPersOnTuile();
                      this.getMaCase().getMaTuile().setPersOnTuile();
                  }
                  this.setPa(this.getPa() - 1);
              }
              else{

                  this.setPa(0);
              }
        }
        else{
            this.setPa(0);
        }
    }
    public void tourDeJeu(){
        boolean attaque=true;
        /* déroulement d'un tour de jeu pour etu si il y a des profs leurs demande une validation sinon ce déplace jusqu'a trouver un prof
        * ou bien jusqu'a ne plus avoir de point d'action*/
        while(this.getPa()>0)
        {
            if (this.getMaCase().getMaTuile().tuileContainProf())
            {
                if(attaque) {
                    this.valider(this.getMaCase().getMaTuile().getPersOnTuile());
                }
                else{
                    this.setPa(0);
                }
            }
            else
            {
                this.deplacement();
                attaque=false;
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
