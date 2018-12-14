package Modele;

public class CaseModele {
    private int idTuile;
    private int coordX;
    private int coordY;
    private boolean passable;

    // Contructeur
    public CaseModele(int idTuile, int coordX, int coordY, boolean passable) {
        this.idTuile = idTuile;
        this.coordX = coordX;
        this.coordY = coordY;
        this.passable = passable;
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
}
