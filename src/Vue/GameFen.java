package Vue;

        import Controleur.PartieControlleur;
        import Modele.PartieModele;
        import Modele.ProfModele;

        import javax.swing.*;

public class GameFen extends JFrame {
    private GamePane gamePane;
    GameFen(PartieControlleur control){
        this.setTitle("Menu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gamePane=new GamePane(control);
        this.add(gamePane);
        this.setVisible(true);

    }
    public void repaintInfo(ProfModele p){
        System.out.println("Chenille");
        this.gamePane.getGamePanelInfo().setJoueur(p);
        this.gamePane.getGamePanelInfo().repaint();
    }
    public static void main(String Args[]){
        PartieModele mPartie=new PartieModele();
        PartieControlleur control=new PartieControlleur(mPartie,null);
        GameFen g= new GameFen(control);
        control.jeu();
    }
}
