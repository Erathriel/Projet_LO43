package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProfPhysiqueModele extends ProfModele {
    public ProfPhysiqueModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
        try{
        File nomImage = new File("img/phyinfo.png");
        this.setImage(ImageIO.read(nomImage.getAbsoluteFile()));
            String tab4[]={"TM",null,null};
            BufferedImage carteTM= ImageIO.read(new File("img/Carte TM.png"));
            ImageIcon cT= new ImageIcon("img/Carte TM.png");
            this.getInventaire().getContenuInventaire().add(new OutilValidationModele(cT,carteTM,"Beaucoup de choix","Fiche Tm",0,0,2,5,4,tab4,3));
        }
        catch(Exception e){
            System.out.println("Error Reading File Prof physique");
        }
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        //Empeche les etudiants présent sur la meme tuile de jouer leur prochain tour
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof EtudiantModele){
                action=true;
                p.setJouable(false);
            }
        }
        if(action) {
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Les étudiants présent ne pourront rien faire ce tour","Capacité Active activé",0);
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
        //+3 laner de dés pour ces outils de validations
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
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Vous avez ameliorer le nbr de tentative de vos Objets","Capacité passive activé",0);

        }
        else{
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Action Impossible aucun objet à mofifier","Action Impossible",0);
        }
    }
}

