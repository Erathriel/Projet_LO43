package Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PileCarteModele {
    private int nbCarte;
    private ArrayList<CarteModele> listeCarte;

    // Constructeur
    public PileCarteModele() {
        try {
             BufferedImage carteCs= ImageIO.read(new File("img/Carte cs.png"));
             BufferedImage carteCsMultiSite= ImageIO.read(new File("img/Carte CsMultiSite.png"));
            BufferedImage carteHuma= ImageIO.read(new File("img/Carte Huma.png"));
            BufferedImage carteHumaMultiSite= ImageIO.read(new File("img/Carte HumaMultiSite.png"));
            BufferedImage carteTM= ImageIO.read(new File("img/Carte TM.png"));
            BufferedImage carteTmMultiSite= ImageIO.read(new File("img/Carte TmMultiSite.png"));
            BufferedImage carteMultiUVN= ImageIO.read(new File("img/Carte MultiUVNeuve.png"));
            BufferedImage carteMultiUVA= ImageIO.read(new File("img/Carte MultiUVAbimé.png"));
            BufferedImage carteMultiUVTa= ImageIO.read(new File("img/Carte MultiUVTrèsAbimé.png"));
            BufferedImage carteEtu1= ImageIO.read(new File("img/CarteEtu1.png"));
            BufferedImage carteEtu2= ImageIO.read(new File("img/CarteEtu2.png"));
            BufferedImage carteEtu3= ImageIO.read(new File("img/CarteEtu3.png"));
            BufferedImage carteEtu4= ImageIO.read(new File("img/CarteEtu4.png"));
            BufferedImage carteEtu5= ImageIO.read(new File("img/CarteEtu5.png"));
            BufferedImage carteEtu6= ImageIO.read(new File("img/CarteEtu6.png"));
            BufferedImage tC=ImageIO.read(new File("img/tamponCS.png"));
            BufferedImage tCMs=ImageIO.read(new File("img/TamponCsMultiSite.png"));
            BufferedImage tH=ImageIO.read(new File("img/tamponHUMA.png"));
            BufferedImage tHMs=ImageIO.read(new File("img/TamponHumaMultiSite.png"));
            BufferedImage tT=ImageIO.read(new File("img/tamponTM.png"));
            BufferedImage tTMs=ImageIO.read(new File("img/TamponTmMultisite.png"));
            BufferedImage tMUN=ImageIO.read(new File("img/TamponMultiUVNeuf.png"));
            BufferedImage tMUV=ImageIO.read(new File("img/TamponMultiUVVieux.png"));
            BufferedImage tMUTV=ImageIO.read(new File("img/TamponMultiUVTresVieux.png"));
            BufferedImage cle=ImageIO.read(new File("img/Cle.png"));

            ImageIcon cC= new ImageIcon("img/Carte cs.png");
            ImageIcon cCMS=new ImageIcon("img/Carte CsMultiSite.png");
            ImageIcon cH= new ImageIcon("img/Carte Huma.png");
            ImageIcon cHMS= new ImageIcon("img/Carte HumaMultiSite.png");
            ImageIcon cT= new ImageIcon("img/Carte TM.png");
            ImageIcon cTMS= new ImageIcon("img/Carte TmMultiSite.png");
            ImageIcon cMUN= new ImageIcon("img/Carte MultiUVNeuve.png");
            ImageIcon cMUA= new ImageIcon("img/Carte MultiUVAbimé.png");
            ImageIcon cMUTA= new ImageIcon("img/Carte MultiUVTrèsAbimé.png");
            ImageIcon cE1= new ImageIcon("img/CarteEtu1.png");
            ImageIcon cE2= new ImageIcon("img/CarteEtu2.png");
            ImageIcon cE3= new ImageIcon("img/CarteEtu3.png");
            ImageIcon cE4= new ImageIcon("img/CarteEtu4.png");
            ImageIcon cE5= new ImageIcon("img/CarteEtu5.png");
            ImageIcon cE6= new ImageIcon("img/CarteEtu6.png");
            ImageIcon tCI=new ImageIcon("img/tamponCS.png");
            ImageIcon tCMsI=new ImageIcon("img/TamponCsMultiSite.png");
            ImageIcon tHI=new ImageIcon("img/tamponHUMA.png");
            ImageIcon tHMsI=new ImageIcon("img/TamponHumaMultiSite.png");
            ImageIcon tTI=new ImageIcon("img/tamponTM.png");
            ImageIcon tTMsI=new ImageIcon("img/TamponTmMultisite.png");
            ImageIcon tMUNI=new ImageIcon("img/TamponMultiUVNeuf.png");
            ImageIcon tMUVI=new ImageIcon("img/TamponMultiUVVieux.png");
            ImageIcon tMUTVI=new ImageIcon("img/TamponMultiUVTresVieux.png");
            ImageIcon cleI=new ImageIcon("img/Cle.png");
            String tab1[]={"CS",null,null};
            String tab3[]={"CS","HUMA","TM"};
            String tab4[]={"TM",null,null};
            String tab6[]={"HUMA",null,null};
        this.listeCarte=new ArrayList<CarteModele>();
        for (int i = 0; i <15; i++) {
            this.listeCarte.add(new CleModele(cleI,cle,"L'Objet Utile qui vous sauvera","Cle",0));
        }
        for (int i = 0; i <20; i++) {
            this.listeCarte.add(new CarteEtudianteModele(cE1,carteEtu1,"Manque de Chance ",1));
        }
        for (int i = 0; i <8; i++) {
            this.listeCarte.add(new CarteEtudianteModele(cE2,carteEtu2,"La chance commence a s'éloigner",2));
        }
        for (int i = 0; i <3; i++) {
            this.listeCarte.add(new CarteEtudianteModele(cE3,carteEtu3,"La chance vous regarde au loin",3));
        }
        for (int i = 0; i <3; i++) {
            this.listeCarte.add(new CarteEtudianteModele(cE4,carteEtu4,"Ne comptez plus sur la chance",4));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new CarteEtudianteModele(cE5,carteEtu5,"COURER",5));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new CarteEtudianteModele(cE6,carteEtu6,"AU SECOURS VITE ",6));
        }
        //Fiche UV
        for (int i = 0; i <8; i++) {
            this.listeCarte.add(new OutilValidationModele(cH,carteHuma,"Simple à trouver difficile à valider","Fiche Humanité",0,0,2,5,4,tab6,3));
        }

        for (int i = 0; i <8; i++) {
            this.listeCarte.add(new OutilValidationModele(cC,carteCs,"x*x+13600","Fiche Cs",0,0,2,5,4,tab1,3));
        }

        for (int i = 0; i <8; i++) {
            this.listeCarte.add(new OutilValidationModele(cT,carteTM,"Beaucoup de choix","Fiche Tm",0,0,2,5,4,tab4,3));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(cHMS,carteHumaMultiSite,"Basique mais fantastique","Fiche Huma multi-sites",0,0,4,4,4,tab6,4));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(cCMS,carteCsMultiSite,"Mathématique tu feras","Fiche Cs multi-sites",0,0,4,4,4,tab1,4));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(cTMS,carteTmMultiSite,"Coder ta mission sera","Fiche Tm multi-sites",0,0,4,4,4,tab4,4));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(cMUTA,carteMultiUVTa,"Ephémère...ment destructeur ","Fiche multi Uv abimée ",0,0,6,1,5,tab3,5));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele(cMUA,carteMultiUVA,"La chance comme dirait Larry","Fiche multi Uv déjà utilisé",0,0,6,2,5,tab3,5));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele(cMUN,carteMultiUVN,"Le saint graal : <c'est pas faux >","Fiche multi Uv fraichement imprimé",0,0,5,3,5,tab3,5));
        }
        //Tampon Encreur

        for (int i = 0; i <5; i++) {
            this.listeCarte.add(new OutilValidationModele(tHI,tH,"Classique mais pas fantastique","Tampon Huma",0,1,2,5,3,tab6,4));
        }

        for (int i = 0; i <5; i++) {
            this.listeCarte.add(new OutilValidationModele(tCI,tC,"2*12+3455/3446","Tampon CS",0,1,2,5,3,tab1,4));
        }

        for (int i = 0; i <5; i++) {
            this.listeCarte.add(new OutilValidationModele(tTI,tT,"Beaucoup de choix","Tampon TM",0,1,2,5,3,tab4,4));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(tCMsI,tCMs,"Math Physique Super","Tampon Cs multi-site",0,1,4,4,3,tab1,4));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(tHMsI,tHMs,"Fantastique","Tampon Huma multi-site",0,1,4,4,3,tab6,4));
        }

        for (int i = 0; i <4; i++) {
            this.listeCarte.add(new OutilValidationModele(tTMsI,tTMs,"Beaucoup de choix grace à ca","Tampon Tm multi-site",0,1,4,4,3,tab4,4));
        }

        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele(tMUNI,tMUN,"Vraiment chanceux ","Tampon Multi Uv ",0,1,5,3,5,tab3,5));
        }
        for (int i = 0; i <1; i++) {
            this.listeCarte.add(new OutilValidationModele(tMUVI,tMUV,"Plutot chanceux ","Tampon Multi Uv ",0,1,5,2,5,tab3,5));
        }
        for (int i = 0; i <1; i++) {

            this.listeCarte.add(new OutilValidationModele(tMUTVI,tMUTV,"Un peu de chance mais pas trop non plus ","Tampon Multi Uv ",0,1,5,1,5,tab3,5));
        }
        }catch (IOException e){System.out.print("FATAL ERROR");}
    }
    public void remplissage(){
        int nbrcle=0;
        int nbrCarteEtu=0;
        int nbrOutil=0;
        for (CarteModele c:this.listeCarte) {
            if(c instanceof CleModele){
                nbrcle++;
            }
            else if(c instanceof  CarteEtudianteModele){
                nbrCarteEtu++;
            }
            else if(c instanceof OutilValidationModele){
                nbrOutil++;
            }
        }
        if(nbrcle<2 || nbrCarteEtu <5 || nbrOutil <5){
            PileCarteModele p =new PileCarteModele();
            this.listeCarte=p.getListeCarte();
        }
    }
    // Getters et Setters
    public int getNbCarte() {
        return nbCarte;
    }

    public void setNbCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public ArrayList<CarteModele> getListeCarte() {
        return listeCarte;
    }

    public void setListeCarte(ArrayList<CarteModele> listeCarte) {
        this.listeCarte = listeCarte;
    }

    @Override
    public String toString() {
        return "PileCarteModele{" +
                "nbCarte=" + nbCarte +
                ", listeCarte=" + listeCarte +
                '}';
    }
}
