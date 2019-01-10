package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ProfInfoModele extends ProfModele {
    ProfInfoModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int  exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
        try{
            File nomImage = new File("img/infoinfo.png");
            this.setImage(ImageIO.read(nomImage.getAbsoluteFile()));
        }
        catch(Exception e){
            System.out.println("Error Reading File prof info");
        }
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof EtudiantModele){
                action=true;
                ((EtudiantModele) p).setNbDemandeValidation(((EtudiantModele) p).getNbDemandeValidation()-2);
            }
        }
        if(action) {
            this.setPa(this.getPa() - 1);
        }
        else{
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Action Impossible aucun etudiant présent","Action Impossible",0);
        }
    }

    @Override
    public void capacitePassive() {
        boolean modif=false;
        for (ObjetModele o:this.getInventaire().getContenuInventaire()) {
            if(o instanceof OutilValidationModele){
                if(!((OutilValidationModele) o).getModifier()){
                   if(((OutilValidationModele) o).getPortee()==0){
                       modif=true;
                    ((OutilValidationModele) o).setPortee(((OutilValidationModele) o).getPortee()+1);
                    ((OutilValidationModele) o).setModifier();
                   }
                }
            }
        }
        if(modif) {
            this.setPa(this.getPa() - 1);
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Vous avez ameliorer la portée de vos Objets","Capacité passive activé",0);

        }
        else{
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Action Impossible aucun objet à mofifier","Action Impossible",0);
        }
    }
}

