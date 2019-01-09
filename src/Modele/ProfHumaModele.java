package Modele;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class ProfHumaModele extends ProfModele {
    ProfHumaModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int  exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
        try{
            File nomImage = new File("img/humainfo.png");
            this.setImage(ImageIO.read(nomImage.getAbsoluteFile()));
        }
        catch(Exception e){
            System.out.println("Error Reading File");
        }
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof ProfModele){
                action=true;
                p.setPv(p.getPv()+10);
            }
        }
        if(action) {
            this.setPa(this.getPa() - 1);
        }
        else{

        }
    }

    @Override
    public void capacitePassive() {
        boolean modif=false;
        for (ObjetModele o:this.getInventaire().getContenuInventaire()) {
            if(o instanceof OutilValidationModele){
                if(!((OutilValidationModele) o).getModifier()){
                 modif=true;
                ((OutilValidationModele) o).setTauxDeReussite(((OutilValidationModele) o).getTauxDeReussite()-1);
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
