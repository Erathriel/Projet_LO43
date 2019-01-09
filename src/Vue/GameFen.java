package Vue;

        import Controleur.PartieControlleur;
        import Modele.*;

        import javax.swing.*;

public class GameFen extends JFrame {
    private GamePane gamePane;
    GameFen(PartieControlleur control){
        this.setTitle("Jeu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gamePane=new GamePane(control);
        this.add(gamePane);
        this.setVisible(true);

    }
    public void repaintInfo(ProfModele p){
        this.gamePane.getGamePanelInfo().setJoueur(p);
        this.gamePane.getGamePanelInfo().repaint();
    }
    public static void main(String Args[]){
        PartieModele mPartie=new PartieModele();
        PartieVue vPartie=new PartieVue(mPartie);

        PartieControlleur control=new PartieControlleur(mPartie,vPartie);
        GameFen g= new GameFen(control);
        vPartie.setGamefen(control);
        mPartie.creationPersoObjM();
        control.jeu();
    }
}
