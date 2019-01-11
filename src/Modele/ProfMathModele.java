package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProfMathModele extends ProfModele {
    public ProfMathModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
        try{
            File nomImage = new File("img/mathinfo.png");
            this.setImage(ImageIO.read(nomImage.getAbsoluteFile()));
            BufferedImage cle=ImageIO.read(new File("img/Cle.png"));
            ImageIcon cleI=new ImageIcon("img/Cle.png");
            this.getInventaire().getContenuInventaire().add(new CleModele(cleI,cle,"L'Objet Utile qui vous sauvera","Cle",0));

        }
        catch(Exception e){
            System.out.println("Error Reading File prof math");
        }
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        //divise par deux la vie des étudiants
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof EtudiantModele){
                action=true;
                p.setPv(p.getPv()/2);
            }
        }
       if(action) {
           JOptionPane d= new JOptionPane();
           d.showMessageDialog(d,"Vous avez divisé par deux les UVs nécéssaires à la validation des étudiants présent ","Capacité Active activé",0);
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
        //Augmente de 2 le nbr d'activation des objets
        for (ObjetModele o:this.getInventaire().getContenuInventaire()) {
            if(o instanceof OutilValidationModele){
                if(!((OutilValidationModele) o).getModifier()){
                    modif=true;
                    ((OutilValidationModele) o).setNbActivation(((OutilValidationModele) o).getNbActivation()+2);
                    ((OutilValidationModele) o).setModifier();
                }
            }
        }
        if(modif) {
            this.setPa(this.getPa() - 1);
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Vous avez ameliorer le nbr d'activation de vos Objets","Capacité passive activé",0);
        }
        else{
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Action Impossible aucun objet à mofifier","Action Impossible",0);
        }
    }
}
