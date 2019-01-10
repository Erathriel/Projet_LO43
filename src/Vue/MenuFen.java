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
        this.setSize(new Dimension(600,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
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
