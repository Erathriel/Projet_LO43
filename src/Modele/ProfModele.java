package Modele;

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
    public void valider(ArrayList<PersonnageModele> per,int indexObjet){
        int nbValidation=1,parcours=0;
        boolean validationPossible=false;
        while(nbValidation != ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbTentative() && parcours<per.size())
        {
            if(per.get(parcours) instanceof EtudiantModele) {
                for (String type : ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getTypeUV()){
                    for (String typeE: ((EtudiantModele)per.get(parcours)).getTypeUV()
                         ) {
                        if (typeE.compareTo(type)==0) {
                            validationPossible = true;
                        }
                    }
                }
                if(validationPossible) {

                    per.get(parcours).setPv(per.get(parcours).getPv() - ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbUVVal());
                    nbValidation += 1;
                    if (((EtudiantModele)per.get(parcours)).isValider()) {
                        this.setExp(this.getExp()+((EtudiantModele)per.get(indexObjet)).getExpRapporte());
                        per.remove(parcours);
                        parcours += 1;
                    }
                }
                else
                {
                    parcours+=1;
                }
            }
            else{
              parcours+=1;
            }
        }
        ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).setNbActivation(((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbActivation()-1);
    }

    public void fouiller(PileCarteModele p){
        int card = (int) Math.random()*(p.getListeCarte().size());
       CarteModele c =p.getListeCarte().get(card);
       p.getListeCarte().remove(card);
        if(c instanceof ObjetModele) {
            if (this.inventaire.getContenuInventaire().size() < 5) {
                this.inventaire.getContenuInventaire().add(((ObjetModele)c));
            }
            else{

            }
        }
        else
        {

        }
    }

    public void ouvriPorte(){

    }

    public void modifInventaire(){

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
        String tab[]={"CS","HUMA"};
        ProfModele p = new ProfModele(null,null,10,1,"Jean",true,0);
        EtudiantModele e= new EtudiantModele(null,null,5,2,"etu1",true,2,tab,2);
        OutilValidationModele o= new OutilValidationModele("Tampon","Tampon Ultime",0,0,2,2,2,tab);
        p.getInventaire().getContenuInventaire().add(o);
        for (String s:o.getTypeUV()
             ) {
                System.out.println(s);

        }
        ArrayList<PersonnageModele> tab2=new ArrayList<PersonnageModele>();
        tab2.add(p);
        tab2.add(e);
        p.valider(tab2,0);
        for (PersonnageModele a: tab2
             ) {
                System.out.println(a instanceof EtudiantModele);
                System.out.println(a.getPv()+" "+a.getNom());

        }
        int test;
        for (int i = 0; i <5 ; i++) {
            test =(int)(Math.random()*(7));
                    System.out.print(test+" ");
        }
    }
}
