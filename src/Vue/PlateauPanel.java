package Vue;

import Modele.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PlateauPanel extends JPanel {

    public PlateauPanel() {
        super();
        /*JPanel jtest = new JPanel();
        jtest.setOpaque(false);
        jtest.setSize(100,100);
        File nomImage = new File("img/mur.png");
        Image img = Toolkit.getDefaultToolkit().getImage(nomImage.getAbsolutePath());
        JLabel image = new JLabel(new ImageIcon(nomImage.getAbsolutePath()));
        this.setLayout(new BorderLayout());
        this.add(image,BorderLayout.CENTER);*/
    }

    public void affichageMapConsole(String name){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        //String map = "maps\\mapTest.txt";
        //System.out.println(map);
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            //byte[] buffer = new byte[8];
            int buffer;
            String ligne="";
            while((buffer = fis.read()) != -1){
                //System.out.println((char) buffer);
                ligne= ligne + (char) buffer;
            }
            System.out.println(ligne);
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[][] parcoursMap(String name){
        char[][] map = new char[10][10];
        int i=0;
        int j=0;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File file = new File(name);
        System.out.println(file.getAbsoluteFile());
        try {
            fis = new FileInputStream(file.getAbsoluteFile());
            bis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
            int buffer;
            String ligne="";
            while((buffer = fis.read()) != -1){
                //System.out.println("start boucle : i : "+i+"     j : "+j); DEBUG
                if (buffer != 32 && buffer != 10 && i<map.length){
                    //System.out.print((char)buffer); DEBUG
                    if (j == 10){
                        i++;
                        j=0;
                        map[i][j]=(char)buffer;
                        //System.out.println("passage cond i = 10"); DEBUG
                    }
                    else{
                        map[i][j]=(char)buffer;
                        j++;
                        //System.out.println("passage else"); DEBUG
                    }
                    //System.out.println("end boucle : i : "+i+"     j : "+j); DEBUG
                }
            }
            // DEBUG affiche le tableau map en console
            for (int k=0; k<10; k++){
                for (int l = 0; l<10; l++){
                    if (l == 9){
                        System.out.println(map[k][l]);
                    }
                    else{
                        System.out.print(map[k][l]+" ");
                    }
                }
            }
            bis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public void afficheMapGraphique(Graphics g) throws IOException {
        CaseModele[][] cases = new CaseModele[10][10];
        ElemCaseModele[][] elemMap = new ElemCaseModele[10][10];
            File nomImage;
            Image img;
            char [][] map = parcoursMap("maps/mapTest.txt");
            for (int i=0; i<10; i++){
                for (int j=0; j<10; j++){
                    System.out.println("Element"+ map[i][j]);
                    switch (map[i][j])
                    {
                        case '1':
                            nomImage = new File("img/mur.png");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            elemMap[i][j]= new MurModele(img, null); // A modifier pour maCase
                            g.drawImage(elemMap[i][j].getImage(),j*60,i*60,null);
                            break;
                        case '2':
                            nomImage = new File("img/sol1.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            elemMap[i][j]=new SolModele(img,null);
                            g.drawImage(elemMap[i][j].getImage(),j*60,i*60,null);
                            break;
                        case '3':
                            nomImage = new File("img/sol2.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            elemMap[i][j]=new SolModele(img,null);
                            g.drawImage(elemMap[i][j].getImage(),j*60,i*60,null);
                            break;
                        case '4':
                            nomImage = new File("img/porte.jpg");
                            img = ImageIO.read(nomImage.getAbsoluteFile());
                            elemMap[i][j]=new PorteModele(img,null,true);
                            g.drawImage(elemMap[i][j].getImage(),j*60,i*60,null);
                            break;
                    }
                }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            afficheMapGraphique(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "PlateauPanel{}";
    }
}
