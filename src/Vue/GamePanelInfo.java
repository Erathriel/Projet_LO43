package Vue;



import Modele.EtudiantModele;
import Modele.ObjetModele;
import Modele.PersonnageModele;
import Modele.ProfModele;

import javax.swing.*;
import java.awt.*;

public class GamePanelInfo extends JPanel {
    private ProfModele p;
    GamePanelInfo(ProfModele p){
        super();
        this.setPreferredSize(new Dimension(200,200));
    }
    public void setJoueur(ProfModele p){
        this.p=p;
        this.repaint();
    }
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        int y=0;
        int x=0;
        int etudiant=0;
        if(p!=null) {
            if (p.getInventaire().getContenuInventaire().size() > 0) {
                for (ObjetModele e : p.getInventaire().getContenuInventaire()) {
                    g.drawImage(e.getImg(), x, y, this);
                    x += 80;
                    if (x == 160) {
                        y += 105;
                        x = 0;
                    }
                }
            }
            x=0;
            y += 115;
            g.drawString(p.getNom(), 0, y);
            y += 15;
            g.drawString("\n Résistance au stress : " + p.getPv(), 0, y);
            y += 15;
            g.drawString("\n Point d'action : " + p.getPa(), 0, y);
            y += 15;
            g.drawString("\n Experience : " + p.getExp(), 0, y);
            y+=100;
            x=0;
            g.drawImage(p.getInfo(),x,y,this);

                     for(int i=0;i<p.getMaCase().getMaTuile().getPersOnTuile().size();i++) {
                        if (p.getMaCase().getMaTuile().getPersOnTuile().get(i) instanceof EtudiantModele) {
                            etudiant++;
                        }
                    }
            y-=20;
            g.drawString("Il y a "+etudiant+" étudiants sur la case",x,y);
            y+=15;
            g.drawString("ou vous êtes !",x,y);
        }
    }
}
