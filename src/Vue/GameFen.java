package Vue;

        import Controleur.PartieControlleur;
        import Modele.*;

        import javax.swing.*;
        import java.util.ArrayList;

public class GameFen extends JFrame {
    private PartieModele mpartie;
    private GamePane gamePane;

    public GameFen(PartieModele partie){
        super();
        this.mpartie = partie;
        this.setTitle("Jeu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gamePane=new GamePane(mpartie);
        this.add(gamePane);
        this.setVisible(true);

    }


    // Getters et Setters
    public PartieModele getPartie() {
        return mpartie;
    }

    public void setPartie(PartieModele partie) {
        this.mpartie = partie;
    }

    public void repaintInfo(ProfModele p){
        this.gamePane.getGamePanelInfo().setJoueur(p);
        this.gamePane.getGamePanelInfo().repaint();
        this.gamePane.repaint();
    }
    /*public static void main(String Args[]){
        PartieModele mPartie=new PartieModele();
        //PartieVue vPartie=new PartieVue(mPartie);
        GameFen g= new GameFen(mPartie);
        PartieControlleur control=new PartieControlleur(mPartie,g);
        mPartie.creationPersoObjM();
        control.jeu();
    }*/

    public GamePane getGamePane() {
        return gamePane;
    }

    public void setGamePane(GamePane gamePane) {
        this.gamePane = gamePane;
    }
}
