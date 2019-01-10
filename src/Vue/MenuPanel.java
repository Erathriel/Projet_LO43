package Vue;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JPanel {
    private BufferedImage background;
    //résolution image entière menu 1260/700
    private MenuJButton b1, b2, b3;
    MenuPanel(){
        super(new GridBagLayout());
        try {
            background = ImageIO.read(new File("C:/Users/cleme/OneDrive/Images/overlay4.png"));
        }catch (IOException e){System.out.print("FATAL ERROR");}
        //this.paintComponent();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        b1=new MenuJButton(new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay1.png"),new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay2.png"));
        this.add(b1,gbc);
        gbc.gridy = 2;
        JPanel J =new JPanel();
        J.setOpaque(false);
        J.setSize(100,100);
        this.add(J,gbc);
        gbc.gridy = 3;
        JPanel J2 =new JPanel();
        J2.setOpaque(false);
        J2.setSize(100,100);
        this.add(J2,gbc);
        b2=new MenuJButton(new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay2.png"),new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay1.png"));
        gbc.gridy = 4;
        this.add(b2,gbc);
        gbc.gridy = 5;
        JPanel J3 =new JPanel();
        J3.setOpaque(false);
        J3.setSize(100,100);
        this.add(J3,gbc);gbc.gridx = 3;

        gbc.gridy = 6;
        JPanel J4 =new JPanel();
        J4.setOpaque(false);
        J4.setSize(100,100);
        this.add(J4,gbc);
        b3=new MenuJButton(new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay1.png"),new ImageIcon("C:/Users/cleme/OneDrive/Images/overlay2.png"));
        gbc.gridy = 7;
        this.add(b3,gbc);
         }
    public void addListeners(ActionListener a){
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }

    public MenuJButton getB1() {
        return b1;
    }

    public void setB1(MenuJButton b1) {
        this.b1 = b1;
    }

    public MenuJButton getB2() {
        return b2;
    }

    public void setB2(MenuJButton b2) {
        this.b2 = b2;
    }

    public MenuJButton getB3() {
        return b3;
    }

    public void setB3(MenuJButton b3) {
        this.b3 = b3;
    }
}
