/************
@author : -
***********/


/************************/
/*     ROBOT ROULANT    */
/************************/

public class RobotRoulant
{
    /*----Numero sequentiel auto-incremente----*/
    private static int nbRobot=0;
    private int numRobot;

    /*----Informations sur le robots----*/
    private int ligne;
    private int colonne;
    private String couleur;
    private int energie;

    public RobotRoulant(int ligne, int colonne, String couleur)
    {
        this.numRobot= ++RobotRoulant.nbRobot;
        this.couleur = couleur;

        this.energie = 100; // Barre d'energie

        /****************************************/
        /*      ROBOT QUI SORT DU TABLEAU      */
        /****************************************/
        if (this.ligne < 0){ this.ligne = 0; }
        else if (this.ligne > 0) {this.ligne = 7;}
        else {this.ligne = ligne;}

        if(this.colonne < 0) {this.colonne = 0;}
        else if (this.colonne > 0) {this.colonne = 7;}
        else {this.colonne = colonne;}
    }

    public boolean deplacer(String dir, RobotRoulant tabRobot[])
    {
        /*----Coordonnees temporaires----*/
        int lig=this.ligne;
        int col=this.colonne;

        switch(dir)
        {
            case "N" : 
                lig++;
                break;
            case "NE" : 
                lig++;
                col++;
                break;
            case "E": 
                col++;
                break;
            case "SE": 
                lig--;
                col++;
                break;
            case "S": 
                lig--;
                break;
            case "SO": 
                lig--;
                col --;
                break;
            case "O": 
                col--;
                break;
            case "NO": 
                lig++;
                col--;
            break; 
        }


        if(lig < 0 || lig > 7 || col < 0 || col > 7){return false;}
        
        for (RobotRoulant rbt : tabRobot)
        {
            if(lig == rbt.getLigne() && col == rbt.getColonne()){return false;}
        }

        /*----Controle de l'energie----*/
        if(this.energie == 0){return false;}
        this.energie -= 2;

        // Si aucun false alors on peut effectuer le deplacement
        this.ligne = lig;
        this.colonne = col;

        return true;
    }

    public int getLigne(){return this.ligne;}
    public int getColonne(){return this.colonne;}
    public int getNum(){return this.numRobot;}
    public int getEnergie(){return this.energie;}

    public String toString()
    {
        return getType() + String.format("%2d", numRobot ) + " " +
        String.format("%-10s", couleur ) + "(" +
        String.format("%2d", ligne ) + ":" +
        String.format("%2d", colonne ) + ")" + 
        String.format("%20s %2d", " Niveau de energie : ", this.getEnergie() );
    }

    public String getType() // nous verrons ultérieurement l’utilité d’une telle méthode
    {
        return "RobotR";
    }
}