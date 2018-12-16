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
        menuPanel.add(new MenuJButton(new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay1.png"),new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay2.png")),0);
        menuPanel.add(new MenuJButton(new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay2.png"),new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay1.png")),1);
        menuPanel.add(new MenuJButton(new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay1.png"),new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay2.png")),2);
        this.add(menuPanel);
        this.setVisible(true);
    }
    public static void main(String args[]){
        MenuFen fen = new MenuFen();
    }
}
