package Modele;

import java.awt.*;

public abstract class ElemCaseModele {
    private Image image;
    private CaseModele MaCase;

    public ElemCaseModele(Image image, CaseModele maCase) {
        this.image = image;
        MaCase = maCase;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
