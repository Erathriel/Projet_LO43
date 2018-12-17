package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuFen extends JFrame {
    MenuFen(){
        super();
        this.setTitle("Menu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuPanel menuPanel = new MenuPanel();
        this.setVisible(true);
        this.add(menuPanel);
    }
    public static void main(String args[]){
        MenuFen fen = new MenuFen();
    }
}
