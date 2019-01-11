package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProfHumaModele extends ProfModele {
    public ProfHumaModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int exp){
        super(image, maCase,pv,pa,nom,jouable,exp);
        try{
            File nomImage = new File("img/humainfo.png");
            this.setImage(ImageIO.read(nomImage.getAbsoluteFile()));
            String tab1[]={"CS",null,null};
            BufferedImage carteCs= ImageIO.read(new File("img/Carte cs.png"));
            ImageIcon cC= new ImageIcon("img/Carte cs.png");
            this.getInventaire().getContenuInventaire().add(new OutilValidationModele(cC,carteCs,"x*x+13600","Fiche Cs",0,0,2,5,4,tab1,3));
        }
        catch(Exception e){
            System.out.println("Error Reading File prof huma");
        }
    }

    @Override
    public void capaciteActive() {
        boolean action=false;
        //Ajoute 10 pv a tout les profs qui se situe sur la même tuile
        for (PersonnageModele p:this.getMaCase().getMaTuile().getPersOnTuile()) {
            if(p instanceof ProfModele && p.getPv()<100){
                action=true;
                p.setPv(p.getPv()+10);
            }
        }
        if(action) {
            this.setPa(this.getPa() - 1);
        }
        else{
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Action Impossible , resistance au stress des profs trop importante ","Action Impossible",0);

        }
    }

    @Override
    public void capacitePassive() {
        //Baisse le taux de reussite de toute ces armes non modifier
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
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Taux de réussite des UVs baissé validation plus facile","Capacité passive activé",0);

        }
        else{
            JOptionPane d= new JOptionPane();
            d.showMessageDialog(d,"Action Impossible aucun objet à mofifier","Action Impossible",0);
        }
    }
}
