package Modele;

import Vue.PartieVue;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class PartieModele {
    private int tourActuel;
    private ArrayList<PersonnageModele> listePerso;
    private ArrayList<ObjectifModele> listeObjectif;
    private ArrayList<MachineCafeModele> machineCafeModele;
    private PileCarteModele pileCarte;
    private PlateauModele plateau;
    private ProfModele joueurEnAction;

    // Contructeur
    public PartieModele() {
        this.tourActuel = 0;
        this.listePerso = new ArrayList<PersonnageModele>();
        this.listeObjectif= new ArrayList<ObjectifModele>();
        this.machineCafeModele=new ArrayList<MachineCafeModele>();
        this.pileCarte = new PileCarteModele();
        this.plateau = new PlateauModele(25); // nb tuile de 16 normalement 4 pour les test
    }

    // Getters et Setters
    public void creationPersoObjM() {
        /*Initialisation des différent prof ainsi que des objectifs , de la sortie et des machines à café */
        Image profHuma;
        Image profInfo;
        Image profMath;
        Image profPhysique;
        Image objectif;
        Image cafe;
        Image sortie;
        try {
            File nomImage = new File("img/profhuma.png");
            profHuma = ImageIO.read(nomImage.getAbsoluteFile());
            nomImage = new File("img/profinfo.png");
            profInfo = ImageIO.read(nomImage.getAbsoluteFile());
            nomImage = new File("img/profmath.png");
            profMath = ImageIO.read(nomImage.getAbsoluteFile());
            nomImage = new File("img/profpysique.png");
            profPhysique = ImageIO.read(nomImage.getAbsoluteFile());
            nomImage = new File("img/objectif.png");
            objectif = ImageIO.read(nomImage.getAbsoluteFile());
            nomImage = new File("img/CAFE.png");
            cafe = ImageIO.read(nomImage.getAbsoluteFile());
            nomImage = new File("img/sortie.png");
            sortie = ImageIO.read(nomImage.getAbsoluteFile());
        this.listePerso.add(new ProfHumaModele(profHuma, this.plateau.getCompTuile().get(1).getCompCase()[2][2], 25, 3, "Prof Huma", true, 0));
        this.listePerso.add(new ProfMathModele(profMath, this.plateau.getCompTuile().get(1).getCompCase()[2][2], 25, 3, "Prof Math", true, 0));
        this.listePerso.add(new ProfInfoModele(profInfo, this.plateau.getCompTuile().get(1).getCompCase()[2][2], 25, 3, "Prof Info", true, 0));
        this.listePerso.add(new ProfPhysiqueModele(profPhysique, this.plateau.getCompTuile().get(1).getCompCase()[2][2], 25, 3, "Prof Physique", true, 0));
        this.listeObjectif.add(new ObjectifModele(objectif, this.plateau.getCompTuile().get(3).getCompCase()[2][2], false, 5));
        this.listeObjectif.add(new ObjectifModele(objectif, this.plateau.getCompTuile().get(10).getCompCase()[2][2], false, 5));
        this.listeObjectif.add(new ObjectifModele(objectif, this.plateau.getCompTuile().get(15).getCompCase()[2][2], false, 5));
        this.machineCafeModele.add(new MachineCafeModele(cafe, this.plateau.getCompTuile().get(22).getCompCase()[2][1]));
        this.machineCafeModele.add(new MachineCafeModele(cafe, this.plateau.getCompTuile().get(8).getCompCase()[2][1]));
        this.plateau.getCompTuile().get(2).getCompCase()[2][2].getCompElemCase().add(new SortieModele(sortie, this.plateau.getCompTuile().get(24).getCompCase()[2][2]));
        this.plateau.getCompTuile().get(1).getCompCase()[2][2].getCompElemCase().add(this.listePerso.get(0));
        this.plateau.getCompTuile().get(1).getCompCase()[2][2].getCompElemCase().add(this.listePerso.get(1));
        this.plateau.getCompTuile().get(1).getCompCase()[2][2].getCompElemCase().add(this.listePerso.get(2));
        this.plateau.getCompTuile().get(1).getCompCase()[2][2].getCompElemCase().add(this.listePerso.get(3));
        this.plateau.getCompTuile().get(3).getCompCase()[2][2].getCompElemCase().add(this.listeObjectif.get(0));
        this.plateau.getCompTuile().get(10).getCompCase()[2][2].getCompElemCase().add(this.listeObjectif.get(1));
        this.plateau.getCompTuile().get(15).getCompCase()[2][2].getCompElemCase().add(this.listeObjectif.get(2));
        this.plateau.getCompTuile().get(22).getCompCase()[2][1].getCompElemCase().add(this.machineCafeModele.get(0));
        this.plateau.getCompTuile().get(8).getCompCase()[2][1].getCompElemCase().add(this.machineCafeModele.get(1));
    }catch(Exception e ){
            System.out.println("Error Reading File Partie modele");
        }
    }
    public int getTourActuel() {
        return tourActuel;
    }

    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    public ArrayList<PersonnageModele> getListePerso() {
        return listePerso;
    }

    public void setListePerso(ArrayList<PersonnageModele> listePerso) {
        this.listePerso = listePerso;
    }

    public ArrayList<ObjectifModele> getListeObjectif() {
        return listeObjectif;
    }

    public void setListeObjectif(ArrayList<ObjectifModele> listeObjectif) {
        this.listeObjectif = listeObjectif;
    }

    public PileCarteModele getPileCarte() {
        return pileCarte;
    }

    public void setPileCarte(PileCarteModele pileCarte) {
        this.pileCarte = pileCarte;
    }

    public PlateauModele getPlateau() {
        return plateau;
    }

    public void setPlateau(PlateauModele plateau) {
        this.plateau = plateau;
    }
    public ArrayList<MachineCafeModele> getMachineCafeModele(){
        return this.machineCafeModele;
    }
    @Override
    public String toString() {
        return "PartieModele{" +
                "tourActuel=" + tourActuel +
                ", listePerso=" + listePerso +
                ", listeObjectif=" + listeObjectif +
                '}';
    }

    public ProfModele getJoueurEnAction() {
        return joueurEnAction;
    }

    public void setJoueurEnAction(ProfModele joueurEnAction) {
        this.joueurEnAction = joueurEnAction;
    }

    public void setMachineCafeModele(ArrayList<MachineCafeModele> machineCafeModele) {
        this.machineCafeModele = machineCafeModele;
    }
}
