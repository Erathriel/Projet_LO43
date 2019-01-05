package Vue;

import Controleur.PartieControlleur;
import Modele.CaseModele;
import Modele.PileCarteModele;
import Modele.ProfModele;
import Modele.TuileModele;

import javax.swing.*;
import java.awt.*;

public class GamePane extends JPanel {
    GamePane(PartieControlleur control){
        this.setLayout(new BorderLayout());
        ProfModele p= new ProfModele(null,new CaseModele(new TuileModele(1,1,null),0,0,true),10,3,"Jean",true,0);
        PileCarteModele pl=new PileCarteModele();
        p.fouiller(pl);
        p.fouiller(pl);
        p.fouiller(pl);
        p.fouiller(pl);
        p.fouiller(pl);
        p.fouiller(pl);
        this.add(new GameButtonpane(control),BorderLayout.PAGE_END);
        this.add(new GamePanelInfo(p),BorderLayout.LINE_START);
        this.setVisible(true);
    }
}
