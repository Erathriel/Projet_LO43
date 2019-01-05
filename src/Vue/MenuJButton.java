package Vue;

import Controleur.PartieControlleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuJButton extends JButton implements MouseListener {
    private ImageIcon img1;
    private ImageIcon img2;
    MenuJButton(ImageIcon img1, ImageIcon img2){
        super();
        this.img1=img1;
        this.img2=img2;
        this.setIcon(img1);
        this.setSize(100,100);
        this.setBorder(null);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setIcon(img2);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(img1);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
