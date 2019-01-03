package Modele;

public class CarteEtudianteModele extends CarteModele {
    private int malchance;

    // Constructeur
    public CarteEtudianteModele(String intitule, int malchance) {
        super(intitule);
        this.malchance = malchance;
    }

    // Methodes
    public void apparition(CaseModele c,int exp){
        String tab[]=new String[2];
        if(this.malchance>=1)
        {
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,5,2,"etudiant simple",true,2,tab,2));
            }
        }
        else if(this.malchance>=2){
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,5,2,"etudiant simple",true,2,tab,2));
            }
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,10,1,"etudiant",true,2,tab,4));
            }
        }
        else if(this.malchance>=3){
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="TM";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,5,2,"etudiant simple",true,2,tab,3));
            }
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]=null;
                c.getCompElemCase().add(new EtudiantModele(null,c,10,1,"etudiant",true,2,tab,6));
            }
        }
        else if(this.malchance>=4){
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,5,2,"etudiant simple",true,2,tab,2));
            }
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,10,1,"etudiant",true,2,tab,4));
            }
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,3,3,"etudiant",true,2,tab,8));
            }
        }
        else if(this.malchance>=5){
            tab[0]="HUMA";
            tab[1]=null;
            c.getCompElemCase().add(new EtudiantModele(null,c,20,1,"etudiant ultime",true,10,tab,20));
        }
        else if(this.malchance>=6){
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,5,2,"etudiant simple",true,2,tab,2));
            }
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,10,1,"etudiant",true,2,tab,4));
            }
            for(int i=0;i<(exp/25)+1;i++)
            {
                tab[0]="HUMA";
                tab[1]="CS";
                c.getCompElemCase().add(new EtudiantModele(null,c,3,3,"etudiant",true,2,tab,8));
            }
            tab[0]="HUMA";
            tab[1]=null;
            c.getCompElemCase().add(new EtudiantModele(null,c,20,1,"etudiant ultime",true,10,tab,20));

        }
    }

    @Override
    public String toString() {
        return "CarteEtudianteModele{" +
                "malchance=" + malchance +
                '}';
    }
}
