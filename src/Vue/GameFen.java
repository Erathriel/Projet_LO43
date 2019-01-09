package Vue;

        import Controleur.PartieControlleur;
        import Modele.*;

        import javax.swing.*;

public class GameFen extends JFrame {
    private PartieModele mpartie;
    private GamePane gamePane;

    GameFen(PartieModele partie){
        super();
        this.mpartie = partie;
        this.setTitle("Jeu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gamePane=new GamePane(mpartie);
        this.add(gamePane);
        this.setVisible(true);
        System.out.println(mpartie.getPlateau().getCompTuile().size());

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
    }
    public static void main(String Args[]){
        PartieModele mPartie=new PartieModele();
        //PartieVue vPartie=new PartieVue(mPartie);
        System.out.println(mPartie.getPlateau().getCompTuile().size());
        GameFen g= new GameFen(mPartie);
        System.out.println(mPartie.getPlateau().getCompTuile().size());
        PartieControlleur control=new PartieControlleur(mPartie,g);
        mPartie.creationPersoObjM();
        control.jeu();
    }

    public GamePane getGamePane() {
        return gamePane;
    }

    public void setGamePane(GamePane gamePane) {
        this.gamePane = gamePane;
    }
}
