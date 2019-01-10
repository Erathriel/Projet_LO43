package Vue;

import Controleur.PartieControlleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuFen extends JFrame {
    private MenuPanel mPanel;
    public MenuFen(){
        super();
        mPanel = new MenuPanel();
        this.setTitle("Menu");
        this.setPreferredSize(new Dimension(450,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(mPanel);
    }

    public MenuPanel getmPanel() {
        return mPanel;
    }

    public void setmPanel(MenuPanel mPanel) {
        this.mPanel = mPanel;
    }
}
