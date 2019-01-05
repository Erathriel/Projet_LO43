package Vue;

import Controleur.PartieControlleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuFen extends JFrame {
    MenuFen(){
        super();
       //PartieControlleur control=new PartieControlleur(new PartieModele(),null);
        this.setTitle("Menu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //MenuPanel menuPanel = new MenuPanel(control);*/
        ProfModele p=new ProfModele(null,new CaseModele(new TuileModele(1,1,null),0,0,true),100,3,"Jean",true,0);
        PileCarteModele carte=new PileCarteModele();
        p.fouiller(carte);
        p.fouiller(carte);
        p.fouiller(carte);
        p.fouiller(carte);
        p.fouiller(carte);
        p.fouiller(carte);
       GamePanelInfo gameInfoPan=new GamePanelInfo(p);
        this.setVisible(true);
        this.add(gameInfoPan);
    }
    public static void main(String args[]){
        MenuFen fen = new MenuFen();
    }
}
