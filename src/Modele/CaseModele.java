package Modele;

import java.util.ArrayList;

public class CaseModele {
    private TuileModele maTuile;
    private int coordX;
    private int coordY;
    private boolean passable;
    private ArrayList<ElemCaseModele> compElemCase;

    // Contructeur
    public CaseModele(TuileModele maTuile, int coordX, int coordY, boolean passable) {
        this.maTuile = maTuile;
        this.coordX = coordX;
        this.coordY = coordY;
        this.passable = passable;
        this.compElemCase=new ArrayList<ElemCaseModele>();
    }
    public boolean containDoorLocked(){
        for (ElemCaseModele e:this.compElemCase) {
            if(e instanceof PorteModele){
                if(((PorteModele) e).isVerrouiller())
                {
                    return true;
                }
            }
        }
        return false;

    }
    public int nombreEtu(){
        int nbreEtu=0;
        for (ElemCaseModele e:this.getCompElemCase()) {
            if(e instanceof EtudiantModele){
                nbreEtu++;
            }
        }
        return nbreEtu;
    }
    // Getters et Setters
    public TuileModele getMaTuile() {
        return maTuile;
    }


    public int getCoordX() {
        return coordX;
    }


    public int getCoordY() {
        return coordY;
    }
    public boolean getPassable(){
        return passable;
    }

    public boolean isPassable() {
        return passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public ArrayList<ElemCaseModele> getCompElemCase() {
        return compElemCase;
    }

    public void setCompElemCase(ArrayList<ElemCaseModele> compElemCase) {
        this.compElemCase = compElemCase;
    }

    @Override
    public String toString() {
        return "CaseModele{" +
                "maTuile=" + maTuile.toString() +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", passable=" + passable +
                ", compElemCase=" + compElemCase +
                '}';
    }
}
