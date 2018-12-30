package Modele;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProfModele extends PersonnageModele implements SpecialiteModele{
    private int exp;
    private InventaireModele inventaire;
    // Constructeur
    public ProfModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int  exp) {
        super(image, maCase, pv, pa, nom, jouable);
        this.exp=exp;
        inventaire= new InventaireModele(5);
    }


    // Methodes
    public void valider(ArrayList<ElemCaseModele> per,int indexObjet){
        System.out.println("Nbr tentatives : "+((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbTentative());
        int nbValidation=1,parcours=0,lancerDé;
        boolean validationPossible=false;
        while(nbValidation <= ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbTentative() && parcours<per.size())
        {
            if(per.get(parcours) instanceof PersonnageModele) {
                if (per.get(parcours) instanceof EtudiantModele) {
                    for (String type : ((OutilValidationModele) this.inventaire.getContenuInventaire().get(indexObjet)).getTypeUV()) {
                        for (String typeE : ((EtudiantModele) per.get(parcours)).getTypeUV()
                        ) {
                            if (typeE.compareTo(type) == 0) {
                                validationPossible = true;
                            }
                        }
                    }

                    if (validationPossible) {
                        lancerDé = (int) (Math.random() * (7));
                        System.out.print(lancerDé + " Lancer numéro : " + nbValidation + "  ");
                        if (lancerDé >= ((OutilValidationModele) this.inventaire.getContenuInventaire().get(indexObjet)).getTauxDeReussite()) {
                            ((PersonnageModele)per.get(parcours)).setPv(((PersonnageModele)per.get(parcours)).getPv() - ((OutilValidationModele) this.inventaire.getContenuInventaire().get(indexObjet)).getNbUVVal());
                            nbValidation++;
                            if (((EtudiantModele) per.get(parcours)).isValider()) {
                                this.setExp(this.getExp() + ((EtudiantModele) per.get(parcours)).getExpRapporte());
                                parcours++;
                            }
                        } else {
                            nbValidation++;
                        }
                    } else {
                        parcours++;
                    }
                } else {
                    parcours++;
                }
            }
                else{
                    parcours++;
            }
        }
        for (int i=0;i<per.size();i++) {
            if(per.get(i) instanceof EtudiantModele)
            {
                if(((EtudiantModele) per.get(i)).isValider())
                {
                    per.remove(i);
                }
            }
        }
        ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).setNbActivation(((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbActivation()-1);
    }

    public void fouiller(PileCarteModele p){
        int card = (int) (Math.random()*(p.getListeCarte().size()));
        System.out.println(card);
       CarteModele c =p.getListeCarte().get(card);
       p.getListeCarte().remove(card);
        if(c instanceof ObjetModele) {
            if (this.inventaire.getContenuInventaire().size() < 5) {
                this.inventaire.getContenuInventaire().add(((ObjetModele)c));
            }
            else{
                String tab[]={this.inventaire.getContenuInventaire().get(0).getNom(),this.inventaire.getContenuInventaire().get(1).getNom(),this.inventaire.getContenuInventaire().get(2).getNom(),this.inventaire.getContenuInventaire().get(3).getNom(),this.inventaire.getContenuInventaire().get(4).getNom
                        (),"Aucun"};
                    int rang = JOptionPane.showOptionDialog(null,  "Objet piocher : " + ((ObjetModele) c).getNom(),"Choix de l'objet à remplacer", JOptionPane.DEFAULT_OPTION, 0, null,tab,tab[0]);
                      if(rang<5){
                        this.inventaire.getContenuInventaire().set(rang,(ObjetModele)c);
                      }
            }
        }
        else
        {
            System.out.println(c.getIntitule());
            ((CarteEtudianteModele)c).apparition(this.getMaCase(),this.getExp());
        }
        p.setNbCarte(p.getNbCarte()-1);
    }

    public void ouvriPorte(PorteModele porte){
        // Teste si l'un des 2 premiers elements de l'inventaire est une clé si c'est le cas on deverrouille la porte et supprime la cle
        if (inventaire.getContenuInventaire().get(0) instanceof CleModele || inventaire.getContenuInventaire().get(1) instanceof CleModele){
            porte.setVerrouiller(false);
            if (inventaire.getContenuInventaire().get(1) instanceof CleModele){
                this.inventaire.suppressionObjet(0);
            }
            else {
                this.inventaire.suppressionObjet(1);
            }
        }
        else {
            System.out.println("Action impossible");
        }
    }

    public void modifInventaire(int indexDépart,int indexArriv){
        ObjetModele switchO;
        switchO=this.inventaire.getContenuInventaire().get(indexDépart);
        this.inventaire.getContenuInventaire().set(indexDépart,this.inventaire.getContenuInventaire().get(indexArriv));
        this.inventaire.getContenuInventaire().set(indexArriv,switchO);
    }

    public void activerObjectif(){
        for (ElemCaseModele e:this.getMaCase().getCompElemCase()) {
            if(e instanceof ObjectifModele)
            {
                this.setExp(this.getExp()+ ((ObjectifModele) e).getExpRapporte());
                this.getMaCase().getCompElemCase().remove(e);
            }
        }
    }

    @Override
    public void deplacement() {
        JOptionPane d = new JOptionPane();
        if(!this.getMaCase().getMaTuile().tuileContainEtu())
        {
            CaseModele anciennePosition=this.getMaCase();
            String tab[]=new String[this.getMaCase().getMaTuile().getTuileAccessible().size()];
            int positionTab=0;
            for(int i=0;i<this.getMaCase().getMaTuile().getTuileAccessible().size();i++)
            {
                if(this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId()==this.getMaCase().getMaTuile().getId()-3)
                {
                    tab[positionTab]="Nord";
                    positionTab++;
                }
                else if(this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId()==this.getMaCase().getMaTuile().getId()-1)
                {
                    tab[positionTab]="Ouest";
                    positionTab++;
                }
                else if(this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId()==this.getMaCase().getMaTuile().getId()+1)
                {
                    tab[positionTab]="Est";
                    positionTab++;
                }
                else if(this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId()==this.getMaCase().getMaTuile().getId()+3)
                {
                    tab[positionTab]="Sud";
                    positionTab++;
                }
            }

            int deplacement=JOptionPane.showOptionDialog(null, "Choix du déplacement", "Déplacement Possible", JOptionPane.DEFAULT_OPTION, 0, null,tab,tab[0]);
            this.setMaCase(this.getMaCase().getMaTuile().getTuileAccessible().get(deplacement).getCompCase()[this.getMaCase().getCoordX()][this.getMaCase().getCoordY()]);
            this.getMaCase().getCompElemCase().add(this);
            anciennePosition.getCompElemCase().remove(this);
            anciennePosition.getMaTuile().setPersOnTuile();
            this.getMaCase().getMaTuile().setPersOnTuile();
        }
        else
        {
            d.showMessageDialog(d, "Déplacement Impossible", "Tentative de déplacement frauduleuse",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Getters et Setters
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public InventaireModele getInventaire(){
        return this.inventaire;
    }
    public static void main(String args[]){
        CaseModele tab6[][]=new CaseModele[5][5];
        TuileModele t=new TuileModele(0,1,null,tab6);
        PileCarteModele pile= new PileCarteModele();
        String tab[]={"CS","HUMA"};
        String tab3[]={"TM"};
        ProfModele p = new ProfModele(null,null,10,1,"Jean",true,1);
        EtudiantModele e= new EtudiantModele(null,null,5,2,"etu1",true,2,tab,2);
        OutilValidationModele o= new OutilValidationModele("Tampon","Tampon Ultime 1",0,0,2,3,2,tab3,3);
        p.getInventaire().getContenuInventaire().add(o);
        EtudiantModele e2= new EtudiantModele(null,null,5,2,"etu2",true,2,tab,2);
        OutilValidationModele o2= new OutilValidationModele("Tampon","Tampon Ultime 2",0,0,2,3,3,tab,3);
        p.getInventaire().getContenuInventaire().add(o2);
        OutilValidationModele o3= new OutilValidationModele("Tampon","Tampon Ultime 3",0,0,2,3,3,tab,3);
        p.getInventaire().getContenuInventaire().add(o3);
        OutilValidationModele o4= new OutilValidationModele("Tampon","Tampon Ultime 4",0,0,2,3,3,tab,3);
        p.getInventaire().getContenuInventaire().add(o4);
        OutilValidationModele o5= new OutilValidationModele("Tampon","Tampon Ultime 5",0,0,2,3,3,tab,3);
        p.getInventaire().getContenuInventaire().add(o5);
        OutilValidationModele o6= new OutilValidationModele("Tampon","Tampon Ultime 6",0,0,2,3,3,tab,3);
        pile.getListeCarte().add(o6);
        OutilValidationModele o7= new OutilValidationModele("Tampon","Tampon Ultime 7",0,0,2,3,3,tab,3);
        pile.getListeCarte().add(o7);
        pile.getListeCarte().add(new CarteEtudianteModele("Carte moyenne",2));
        pile.getListeCarte().add(new CarteEtudianteModele("Carte moyenne",2));
        CaseModele case1=new CaseModele(t,0,0,true);
        for (String s:o.getTypeUV()
             ) {
                System.out.println(s);

        }
        ArrayList<ElemCaseModele> tab2=new ArrayList<ElemCaseModele>();
        tab2.add(p);
        tab2.add(e);
        tab2.add(e2);
        case1.setCompElemCase(tab2);
        p.valider(tab2,0);
        for (int i = 0; i < tab2.size(); i++) {
            if(tab2.get(i) instanceof EtudiantModele){
                ((EtudiantModele)tab2.get(i)).valider(tab2);
            }
            if(tab2.get(i) instanceof  PersonnageModele) {System.out.println(((PersonnageModele)tab2.get(i)).getPv()+" "+((PersonnageModele)tab2.get(i)).getNom());}

        }
        p.modifInventaire(0,1);
        p.valider(tab2,0);
        System.out.println("2nd attaque");
        for (ElemCaseModele a: tab2
        ) {

            if(a instanceof  PersonnageModele) {System.out.println(((PersonnageModele)a).getPv()+" "+((PersonnageModele)a).getNom());}

        }
        System.out.println(pile.getListeCarte().size());
        p.setMaCase(case1);
        p.fouiller(pile);
        p.fouiller(pile);
        p.fouiller(pile);
        p.setExp(50);
        System.out.println("3eme attaque : "+p.getExp()/25);
        for (ElemCaseModele a: tab2
        ) {

               if(a instanceof  PersonnageModele) {System.out.println(((PersonnageModele)a).getPv()+" "+((PersonnageModele)a).getNom());}

        }
        t.getCompCase()[0][0]=case1;
        t.setPersOnTuile();
        TuileModele t2=new TuileModele(0,1,null,null);
        TuileModele tab10[]={t2};
       // t.setTuileAccessible(tab10);
        //p.deplacement();
    }

    @Override
    public String toString() {
        return "ProfModele{" +
                "exp=" + exp +
                ", inventaire=" + inventaire +
                '}';
    }
}
