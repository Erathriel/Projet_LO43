package Modele;

import java.awt.*;

public abstract class ElemCaseModele {
    private Image image;
    private CaseModele MaCase;

    // Contructeur
    public ElemCaseModele(Image image, CaseModele maCase) {
        this.image = image;
        MaCase = maCase;
    }

    // Getters et Setters
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public CaseModele getMaCase() {
        return MaCase;
    }

    public void setMaCase(CaseModele maCase) {
        MaCase = maCase;
    }
}
