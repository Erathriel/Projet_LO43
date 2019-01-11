package Modele;

import java.awt.*;

public class MachineCafeModele extends ElemCaseModele{

    // Constructeur
    public MachineCafeModele(Image image, CaseModele maCase) {
        super(image, maCase);
    }
    public void spawnDebutManche(PileCarteModele pile,int exptot)
    {
        /* Pioche une carte jusqu'a que se soit une carte étudiante*/
      boolean pioche=false;
      while(!pioche) {
          int card = (int) (Math.random() * (pile.getListeCarte().size()));
          if(pile.getListeCarte().get(card) instanceof CarteEtudianteModele)
          {
              pioche=true;
              ((CarteEtudianteModele) pile.getListeCarte().get(card)).apparition(this.getMaCase(),exptot);
              pile.getListeCarte().remove(card);
              this.getMaCase().getMaTuile().rangementEtudiants();
          }
      }
    }
}
