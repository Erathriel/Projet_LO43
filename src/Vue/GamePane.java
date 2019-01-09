package Vue;

import Controleur.PartieControlleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;

public class GamePane extends JPanel {
    private GamePanelInfo gamePanelInfo;
    private PlateauPanel plateau;
    private PartieModele mpartie;
    private GameButtonpane gbp;
    GamePane(PartieModele mPartie){
        this.mpartie = mPartie;
        this.setLayout(new BorderLayout());
        this.gamePanelInfo=new GamePanelInfo(mPartie.getJoueurEnAction());
        this.gbp=new GameButtonpane();
        this.add(gbp,BorderLayout.PAGE_END);
        initAttribut();
        this.add(plateau,BorderLayout.CENTER);
        this.add(this.gamePanelInfo,BorderLayout.LINE_START);
        this.setVisible(true);
    }
    // Init des attributs de la fenetre
    public void initAttribut(){
        this.plateau = new PlateauPanel(mpartie.getPlateau());
        this.plateau.updateListeTuile();
        plateau.setBorder(null);
        plateau.setOpaque(false);
    }
    public PlateauPanel getPlateau() {
        return plateau;
    }

    public void setPlateau(PlateauPanel plateau) {
        this.plateau = plateau;
    }
    public GamePanelInfo getGamePanelInfo(){
        return this.gamePanelInfo;
    }

    public GameButtonpane getGbp() {
        return gbp;
    }

    public void setGbp(GameButtonpane gbp) {
        this.gbp = gbp;
    }
}
