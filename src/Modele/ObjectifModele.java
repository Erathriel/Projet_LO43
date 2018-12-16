package Modele;

import java.awt.*;

public class ObjectifModele extends ElemCaseModele {
    private boolean activer;
    private int expRapporte;

    // Contructeur
    public ObjectifModele(Image image, CaseModele maCase, boolean activer, int expRapporte) {
        super(image, maCase);
        this.activer=activer;
        this.expRapporte=expRapporte;
    }



    // Getters et Setters
    public boolean isActiver() {
        return activer;
    }

    public void setActiver(boolean activer) {
        this.activer = activer;
    }


    public int getExpRapporte() {
        return expRapporte;
    }

    @Override
    public String toString() {
        return "ObjectifModele{" +
                "activer=" + activer +
                ", expRapporte=" + expRapporte +
                '}';
    }
}
