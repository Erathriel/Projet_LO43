package Vue;

        import Controleur.PartieControlleur;
        import Modele.*;

        import javax.swing.*;

public class GameFen extends JFrame {
    private PartieModele mpartie;
    private GamePane gamePane;
    private PlateauPanel plateau;
    GameFen(PartieControlleur control,PartieModele partie){
        super();
        this.mpartie = partie;
        this.setTitle("Jeu");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initAttribut();
        creerFenetre();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gamePane=new GamePane(control);
        this.add(gamePane);
        this.setVisible(true);

    }
    // Init des attributs de la fenetre
    public void initAttribut(){
        this.plateau = new PlateauPanel(mpartie.getPlateau());
        plateau.setBorder(null);
        plateau.setOpaque(false);
    }

    // Creation de la fenetre avec l'ajout des different componsant
    public void creerFenetre(){
        this.setContentPane(plateau);
    }


    // Getters et Setters
    public PartieModele getPartie() {
        return mpartie;
    }

    public void setPartie(PartieModele partie) {
        this.mpartie = partie;
    }

    public PlateauPanel getPlateau() {
        return plateau;
    }

    public void setPlateau(PlateauPanel plateau) {
        this.plateau = plateau;
    }
    public void repaintInfo(ProfModele p){
        this.gamePane.getGamePanelInfo().setJoueur(p);
        this.gamePane.getGamePanelInfo().repaint();
    }
    public static void main(String Args[]){
        PartieModele mPartie=new PartieModele();
        //PartieVue vPartie=new PartieVue(mPartie);
        PartieControlleur control=new PartieControlleur(mPartie,);
        GameFen g= new GameFen(control,mPartie);

        vPartie.setGamefen(control);
        mPartie.creationPersoObjM();
        control.jeu();
    }
}
