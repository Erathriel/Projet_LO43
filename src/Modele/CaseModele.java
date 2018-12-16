package Modele;

import java.util.ArrayList;

public class CaseModele {
    private int idTuile;
    private int coordX;
    private int coordY;
    private boolean passable;
    private ArrayList<ElemCaseModele> compElemCase;

    // Contructeur
    public CaseModele(int idTuile, int coordX, int coordY, boolean passable) {
        this.idTuile = idTuile;
        this.coordX = coordX;
        this.coordY = coordY;
        this.passable = passable;
        this.compElemCase=new ArrayList<ElemCaseModele>();
    }

    // Getters et Setters
    public int getIdTuile() {
        return idTuile;
    }


    public int getCoordX() {
        return coordX;
    }


    public int getCoordY() {
        return coordY;
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
                "idTuile=" + idTuile +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", passable=" + passable +
                ", compElemCase=" + compElemCase +
                '}';
    }
}
