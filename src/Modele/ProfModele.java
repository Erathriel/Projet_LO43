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
    public void choixOutilEtZone(){
        int rangOutil;
       if(inventaire.getContenuInventaire().size()>=2) {
           if (this.inventaire.getContenuInventaire().get(0)instanceof OutilValidationModele && this.inventaire.getContenuInventaire().get(1)instanceof OutilValidationModele)
           {
               String outilValidation[]={this.inventaire.getContenuInventaire().get(0).getNom(),this.inventaire.getContenuInventaire().get(1).getNom()};
               rangOutil = JOptionPane.showOptionDialog(null,  "Choix de l'objet utiliser pour la validation des UVs","Choix de l'objet a utilisé", JOptionPane.DEFAULT_OPTION, 0, null,outilValidation,outilValidation[0]);
           }
           else if(this.inventaire.getContenuInventaire().get(0)instanceof OutilValidationModele){
               rangOutil=0;
           }
           else if(this.inventaire.getContenuInventaire().get(1)instanceof OutilValidationModele){
               rangOutil=1;
           }
           else{rangOutil=-1;}
       }
       else if(this.inventaire.getContenuInventaire().get(0)instanceof OutilValidationModele)
        {
            rangOutil=0;
        }
        else
       {
           rangOutil=-1;
       }
        if(rangOutil>=0){
            if(((OutilValidationModele)this.inventaire.getContenuInventaire().get(rangOutil)).getPortee()>0){
                String tab[]=new String[this.getMaCase().getMaTuile().getTuileAccessible().size()+1];
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
                tab[positionTab]="Position Actuelle";
                int tuileViser=JOptionPane.showOptionDialog(null, "Choisissez la tuile qui va être la cible de votre validation", "Choix de la tuile qui va être valider", JOptionPane.DEFAULT_OPTION, 0, null,tab,tab[0]);
                if(tuileViser==this.getMaCase().getMaTuile().getTuileAccessible().size()){
                    if(this.getMaCase().getMaTuile().tuileContainEtu())
                    {
                        this.valider(this.getMaCase().getMaTuile().getPersOnTuile(),rangOutil);
                    }
                    else{
                        System.out.println("Error aucune cible");
                    }
                }
                else{
                    if(this.getMaCase().getMaTuile().getTuileAccessible().get(tuileViser).tuileContainEtu())
                    {
                        this.valider(this.getMaCase().getMaTuile().getTuileAccessible().get(tuileViser).getPersOnTuile(),rangOutil);
                    }
                    else{
                        System.out.println("Error Aucune cible valide");
                    }
                }
            }
        }
        else{
            System.out.println("Aucun Outil valide");
        }

    }
    public void valider(ArrayList<PersonnageModele> per,int indexObjet){
        System.out.println("Nbr tentatives : "+((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbTentative());
        int nbValidation=1,parcours=0,lancerDé;
        boolean validationPossible=false;
        while(nbValidation <= ((OutilValidationModele)this.inventaire.getContenuInventaire().get(indexObjet)).getNbTentative() && parcours<per.size())
        {
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
                        (per.get(parcours)).setPv((per.get(parcours)).getPv() - ((OutilValidationModele) this.inventaire.getContenuInventaire().get(indexObjet)).getNbUVVal());
                        nbValidation++;
                        if (per.get(parcours).isValider()) {
                            this.setExp(this.getExp() + ((EtudiantModele) per.get(parcours)).getExpRapporte());
                            parcours++;
                        }
                    } else {
                        nbValidation++;
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
                if( per.get(i).isValider())
                {
                    per.remove(i);
                }
            }
        }
        this.setPa(this.getPa()-1);
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
            this.getMaCase().getMaTuile().rangementEtudiants();
        }
        p.setNbCarte(p.getNbCarte()-1);
        this.setPa(this.getPa()-1);
    }
    public void choixPorte(){
        if(this.getMaCase().getMaTuile().getPorteFermer().size()>0){
            String tab[]= new String[this.getMaCase().getMaTuile().getPorteFermer().size()];
            for (int i = 0; i <this.getMaCase().getMaTuile().getPorteFermer().size() ; i++) {
                if(this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordX()==2 && this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordY()==0){
                    tab[i]="Nord";
                }
                else if(this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordX()==0 && this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordY()==2){
                    tab[i]="Ouest";
                }
                else if(this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordX()==4 && this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordY()==2){
                    tab[i]="Est";
                }
                else if(this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordX()==2 && this.getMaCase().getMaTuile().getPorteFermer().get(i).getCoordY()==4){
                    tab[i]="Sud";
                }
            }
            int porteChoisie=JOptionPane.showOptionDialog(null,  "Choisissez la porte dans la direction que vous souaitez ouvrir","Choix de la porte a ouvrir", JOptionPane.DEFAULT_OPTION, 0, null,tab,tab[0]);
            CaseModele c;
            c=this.getMaCase().getMaTuile().getPorteFermer().get(porteChoisie);
            for (ElemCaseModele e : c.getCompElemCase()) {
                if(e instanceof PorteModele)
                {

                    if(this.ouvriPorte(((PorteModele)e))){
                        this.getMaCase().getMaTuile().getCompCase()[c.getCoordX()][c.getCoordY()].setPassable(true);
                        ArrayList<TuileModele> comparePassage=c.getMaTuile().getTuileAccessible();
                        c.getMaTuile().setTuileAccessible();
                        for (TuileModele t:c.getMaTuile().getTuileAccessible()) {
                            if(!comparePassage.contains(t))
                            {
                                if(t.getId()==c.getMaTuile().getId()-1){
                                    for (ElemCaseModele cp:t.getCompCase()[4][2].getCompElemCase()) {
                                        if(cp instanceof PorteModele){
                                            ((PorteModele) cp).setVerrouiller();
                                        }
                                    }
                                }
                                else if(t.getId()==c.getMaTuile().getId()+1){
                                    for (ElemCaseModele cp:t.getCompCase()[0][2].getCompElemCase()) {
                                        if(cp instanceof PorteModele){
                                            ((PorteModele) cp).setVerrouiller();
                                        }
                                    }
                                }
                                else if(t.getId()==c.getMaTuile().getId()-3){
                                    for (ElemCaseModele cp:t.getCompCase()[2][0].getCompElemCase()) {
                                        if(cp instanceof PorteModele){
                                            ((PorteModele) cp).setVerrouiller();
                                        }
                                    }
                                }
                                else if(t.getId()==c.getMaTuile().getId()+3){
                                    for (ElemCaseModele cp:t.getCompCase()[2][4].getCompElemCase()) {
                                        if(cp instanceof PorteModele){
                                            ((PorteModele) cp).setVerrouiller();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else{

        }
    }
    public boolean ouvriPorte(PorteModele porte){
        // Teste si l'un des 2 premiers elements de l'inventaire est une clé si c'est le cas on deverrouille la porte et supprime la cle
        if (inventaire.getContenuInventaire().get(0) instanceof CleModele || inventaire.getContenuInventaire().get(1) instanceof CleModele){
            porte.setVerrouiller();
            if (inventaire.getContenuInventaire().get(1) instanceof CleModele){
                this.inventaire.suppressionObjet(0);
            }
            else {
                this.inventaire.suppressionObjet(1);
            }
            this.setPa(this.getPa()-1);
            return true;
        }
        else {
            System.out.println("Action impossible");
            return false;

        }
    }
    public void choixModifInventaire(){
        if(this.getInventaire().getContenuInventaire().size()>2)
        {
            String tab1[]={this.getInventaire().getContenuInventaire().get(0).getNom(),this.getInventaire().getContenuInventaire().get(1).getNom()};
            String tab2[] = new String[this.getInventaire().getContenuInventaire().size()-2];
            for (int i = 2; i <this.getInventaire().getContenuInventaire().size() ; i++) {
                tab2[i-2]=this.getInventaire().getContenuInventaire().get(i).getNom();
            }
            int objetAdeplacer = JOptionPane.showOptionDialog(null,  "Choisissez l'objet qui va etre placer dans les objets actifs pour utilisation","Choix de l'objet à remplacer", JOptionPane.DEFAULT_OPTION, 0, null,tab2,tab2[0]);
            int objetRemplacer = JOptionPane.showOptionDialog(null,  "Choisissez l'objet qui va etre remplacer par celui choisis avant dans l'organisation de l'inventaire ","Choix de l'objet qui va être remplacer", JOptionPane.DEFAULT_OPTION, 0, null,tab1,tab1[0]);
            modifInventaire(objetAdeplacer+2,objetRemplacer);
            this.setPa(this.getPa()-1);
        }
        else{
            System.out.println("Pas assez d'objets pour permettre un changement");
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
                this.setPa(this.getPa()-1);
            }
        }
    }

    @Override
    public void deplacement() {
        JOptionPane d = new JOptionPane();
        if(!this.getMaCase().getMaTuile().tuileContainEtu())
        {
           if(this.getMaCase().getMaTuile().getTuileAccessible().size()>0) {
               CaseModele anciennePosition = this.getMaCase();
               String tab[] = new String[this.getMaCase().getMaTuile().getTuileAccessible().size()];
               int positionTab = 0;
               for (int i = 0; i < this.getMaCase().getMaTuile().getTuileAccessible().size(); i++) {
                   if (this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId() == this.getMaCase().getMaTuile().getId() - 3) {
                       tab[positionTab] = "Nord";
                       positionTab++;
                   } else if (this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId() == this.getMaCase().getMaTuile().getId() - 1) {
                       tab[positionTab] = "Ouest";
                       positionTab++;
                   } else if (this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId() == this.getMaCase().getMaTuile().getId() + 1) {
                       tab[positionTab] = "Est";
                       positionTab++;
                   } else if (this.getMaCase().getMaTuile().getTuileAccessible().get(i).getId() == this.getMaCase().getMaTuile().getId() + 3) {
                       tab[positionTab] = "Sud";
                       positionTab++;
                   }
               }

               int deplacement = JOptionPane.showOptionDialog(null, "Choix du déplacement", "Déplacement Possible", JOptionPane.DEFAULT_OPTION, 0, null, tab, tab[0]);
               this.setMaCase(this.getMaCase().getMaTuile().getTuileAccessible().get(deplacement).getCompCase()[this.getMaCase().getCoordX()][this.getMaCase().getCoordY()]);
               this.getMaCase().getCompElemCase().add(this);
               anciennePosition.getCompElemCase().remove(this);
               anciennePosition.getMaTuile().setPersOnTuile();
               this.getMaCase().getMaTuile().setPersOnTuile();
               this.setPa(this.getPa()-1);
           }
           else
           {
               d.showMessageDialog(d, "Déplacement Impossible", "Tentative de déplacement frauduleuse",JOptionPane.INFORMATION_MESSAGE);
           }
        }
        else
        {
            d.showMessageDialog(d, "Déplacement Impossible", "Tentative de déplacement frauduleuse",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void capaciteActive(){ //Acton avec effet sur les autres prof présent au même endroit ou alors les sur les etudiants present au même endroit//

    }
    public void capacitePassive(){//Modification sur les objets de validations

    }

    // Getters et Setters
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public InventaireModele getInventaire() {
        return this.inventaire;
    }

    @Override
    public String toString() {
        return "ProfModele{" +
                "exp=" + exp +
                ", inventaire=" + inventaire +
                '}';
    }
}
