package Modele;

import java.awt.*;

public class PorteModele extends MurModele {
    private boolean verrouiller;

    // Constructeur
    public PorteModele(Image image, CaseModele maCase, boolean verrouiller) {
        super(image, maCase);
        this.verrouiller=verrouiller;
    }

    // Getters et Setters
    public boolean isVerrouiller() {
        return verrouiller;
    }

    public void setVerrouiller(boolean verrouiller) {
        this.verrouiller = verrouiller;
    }
}