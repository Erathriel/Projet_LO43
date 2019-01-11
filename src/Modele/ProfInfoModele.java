package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProfInfoModele extends ProfModele {
    public ProfInfoModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
        try{
            File nomImage = new File("img/infoinfo.png");
            this.setImage(ImageIO.read(nomImage.getAbsoluteFile()));
            BufferedImage cle=ImageIO.read(new File("img/Cle.png"));
            ImageIcon cleI=new ImageIcon("img/Cle.png");
            this.getInventaire().getContenuInventaire().add(new CleModele(cleI,cle,"L'Objet Utile qui vous sauvera","Cle",0));
           }
        catch(Exception e){
            System.out.println("Error Reading File prof info");
        }
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        //Baisse de 2 les degats infligés par les étudiants
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof EtudiantModele){
                if(((EtudiantModele)p).getNbDemandeValidation()>1) {
                    action = true;
                    ((EtudiantModele) p).setNbDemandeValidation(((EtudiantModele) p).getNbDemandeValidation() - 2);
                    if(((EtudiantModele)p).getNbDemandeValidation()==0){
                        ((EtudiantModele) p).setNbDemandeValidation(1);
                    }
                }
            }
        }
        if(action) {
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Vous avez réduit de 2 le stress que les étudiants présent vont vous faire","Capacité Active activé",0);
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
        //augmente de 1 la portée des armes ou elle est de 0
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

