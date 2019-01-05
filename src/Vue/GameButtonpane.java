package Vue;

import Controleur.PartieControlleur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameButtonpane extends JPanel {
    private PartieControlleur control;
    GameButtonpane(PartieControlleur control){
        this.control=control;
        this.add(new GameButton(control,1,"Validation"));
        this.add(new GameButton(control,2,"Fouiller"));
        this.add(new GameButton(control,3,"Déplacement"));
        this.add(new GameButton(control,4,"Ouverture porte"));
        this.add(new GameButton(control,5,"Modification Inventaire"));
        this.add(new GameButton(control,6,"Activation objectif"));
        this.add(new GameButton(control,7,"Capacite active"));
        this.add(new GameButton(control,8,"Capacite passive"));
    }
}
