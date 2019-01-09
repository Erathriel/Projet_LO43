package Vue;

import Controleur.PartieControlleur;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameButtonpane extends JPanel {
    private GameButton validation, fouiller, deplacer, ouvPorte, modifInv, actObj, capAct, capPas, passer;
    GameButtonpane(){
        validation=new GameButton(1,"Validation");
        fouiller=new GameButton(2,"Fouiller");
        deplacer=new GameButton(3,"Déplacement");
        ouvPorte=new GameButton(4,"Ouverture porte");
        modifInv=new GameButton(5,"Modif Inventaire");
        actObj=new GameButton(6,"Activer objectif");
        capAct=new GameButton(7,"Cap active");
        capPas=new GameButton(8,"Cap passive");
        passer=new GameButton(9,"Passer");
        this.add(validation);
        this.add(fouiller);
        this.add(deplacer);
        this.add(ouvPorte);
        this.add(modifInv);
        this.add(actObj);
        this.add(capAct);
        this.add(capAct);
        this.add(passer);
    }

    public void addListeners(ActionListener a){
        validation.addActionListener(a);
        fouiller.addActionListener(a);
        deplacer.addActionListener(a);
        ouvPorte.addActionListener(a);
        modifInv.addActionListener(a);
        actObj.addActionListener(a);
        capAct.addActionListener(a);
        capPas.addActionListener(a);
        passer.addActionListener(a);
    }

    public GameButton getValidation() {
        return validation;
    }

    public void setValidation(GameButton validation) {
        this.validation = validation;
    }

    public GameButton getFouiller() {
        return fouiller;
    }

    public void setFouiller(GameButton fouiller) {
        this.fouiller = fouiller;
    }

    public GameButton getDeplacer() {
        return deplacer;
    }

    public void setDeplacer(GameButton deplacer) {
        this.deplacer = deplacer;
    }

    public GameButton getOuvPorte() {
        return ouvPorte;
    }

    public void setOuvPorte(GameButton ouvPorte) {
        this.ouvPorte = ouvPorte;
    }

    public GameButton getModifInv() {
        return modifInv;
    }

    public void setModifInv(GameButton modifInv) {
        this.modifInv = modifInv;
    }

    public GameButton getActObj() {
        return actObj;
    }

    public void setActObj(GameButton actObj) {
        this.actObj = actObj;
    }

    public GameButton getCapAct() {
        return capAct;
    }

    public void setCapAct(GameButton capAct) {
        this.capAct = capAct;
    }

    public GameButton getCapPas() {
        return capPas;
    }

    public void setCapPas(GameButton capPas) {
        this.capPas = capPas;
    }

    public GameButton getPasser() {
        return passer;
    }

    public void setPasser(GameButton passer) {
        this.passer = passer;
    }
}
