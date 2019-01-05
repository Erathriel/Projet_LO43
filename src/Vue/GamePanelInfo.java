package Vue;



import Modele.ObjetModele;
import Modele.PersonnageModele;
import Modele.ProfModele;

import javax.swing.*;
import java.awt.*;

public class GamePanelInfo extends JPanel {
    private ProfModele p;
    GamePanelInfo(ProfModele p){
        super();
        this.setPreferredSize(new Dimension(200,500));
        this.p=p;
    }
    public void setJoueur(ProfModele p){
        this.p=p;
        this.repaint();
    }
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        int y=0;
        int x=0;
        for (ObjetModele e:p.getInventaire().getContenuInventaire()) {
            g.drawImage(e.getImg(), x, y, this);
            x+=80;
            if(x==160) {
                y += 105;
                x=0;
            }
        }
        y+=105;
        g.drawString(p.getNom(),0,y);
        y+=15;
        g.drawString("\n Point de Stress : "+p.getPv(),0,y);
        y+=15;
        g.drawString("\n Point d'action : "+p.getPa(),0,y);
        y+=15;
        g.drawString("\n Experience : "+p.getExp(),0,y);
    }
}
