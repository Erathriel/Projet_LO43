package Controleur;

import Modele.PartieModele;
import Vue.GameFen;
import Vue.MenuFen;

import java.awt.event.*;

public class MenuControlleur implements KeyListener, MouseListener, ActionListener {

    private MenuFen mMenu;
    public MenuControlleur(MenuFen mMenu) {
        this.mMenu=mMenu;
        this.mMenu.getmPanel().addListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mMenu.getmPanel().getB1()) {
            mMenu.launch();
        }
        /*if (e.getSource() == mMenu.getmPanel().getB2()) {

        }*/
        if (e.getSource() == mMenu.getmPanel().getB3()) {
            this.mMenu.dispatchEvent(new WindowEvent(this.mMenu, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
