package Vue;

import Controleur.PartieControlleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;

public class GamePane extends JPanel {
    private GamePanelInfo gamePanelInfo;
    GamePane(PartieControlleur control){
        this.setLayout(new BorderLayout());
        this.gamePanelInfo=new GamePanelInfo(control.getJoueurEnAction());
        this.add(new GameButtonpane(control),BorderLayout.PAGE_END);
        //PlateauPanel map=new PlateauPanel(new PlateauModele(16));
        //map.setPreferredSize(new Dimension(600,600));
        //this.add(map,BorderLayout.CENTER);
        this.add(this.gamePanelInfo,BorderLayout.LINE_START);
        this.setVisible(true);
    }
    public GamePanelInfo getGamePanelInfo(){
        return this.gamePanelInfo;
    }
}
