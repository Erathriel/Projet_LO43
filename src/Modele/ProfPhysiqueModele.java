package Modele;

import java.awt.*;

public class ProfPhysiqueModele extends ProfModele {
    ProfPhysiqueModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int  exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof EtudiantModele){
                action=true;
                p.setJouable(false);
            }
        }
        this.setPa(this.getPa()-1);
    }

    @Override
    public void capacitePassive() {
        boolean modif=false;
        for (ObjetModele o:this.getInventaire().getContenuInventaire()) {
            if(o instanceof OutilValidationModele){
                if(!((OutilValidationModele) o).getModifier()){
                    modif=true;
                    ((OutilValidationModele) o).setNbTentative(((OutilValidationModele) o).getNbTentative()+3);
                    ((OutilValidationModele) o).setModifier();
                }
            }
        }
        if(modif) {
            this.setPa(this.getPa() - 1);
        }
        else{

        }
    }
}

