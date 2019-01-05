package Vue;

import Controleur.PartieControlleur;
import Modele.CaseModele;
import Modele.PileCarteModele;
import Modele.ProfModele;
import Modele.TuileModele;

import javax.swing.*;
import java.awt.*;

public class GamePane extends JPanel {
    private GamePanelInfo gamePanelInfo;
    GamePane(PartieControlleur control){
        this.setLayout(new BorderLayout());
        this.gamePanelInfo=new GamePanelInfo(control.getJoueurEnAction());
        this.add(new GameButtonpane(control),BorderLayout.PAGE_END);
        this.add(this.gamePanelInfo,BorderLayout.LINE_START);
        this.setVisible(true);
    }
    public GamePanelInfo getGamePanelInfo(){
        return this.gamePanelInfo;
    }
}
