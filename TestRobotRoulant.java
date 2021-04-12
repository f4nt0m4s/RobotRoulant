/************
@author : -
***********/

import java.util.Scanner;

/****************************/
/*    TEST ROBOT ROULANT    */
/****************************/

public class TestRobotRoulant
{
	public static void main(String[] args) 
	{
		/************************/
		/*		LE PLATEAU		*/
		/************************/		
		RobotRoulant[] tabRbt = new RobotRoulant[3];
		int[][] grille = new int[8][8];

		/************************************/
		/*		LECTURE DES INFOS ROBOTS	*/
		/************************************/
		Scanner sc, sc2;

		/****************************/
		/*		CONTROLES ROBOT		*/
		/****************************/
		int action;
		String dir;
		
		tabRbt[0] = new RobotRoulant(0,3,"Rouge");
		tabRbt[1] = new RobotRoulant(4,7,"Bleu");
		tabRbt[2] = new RobotRoulant(7,7,"Blanc");

		sc = new Scanner(System.in);
		sc2 = new Scanner(System.in);

		System.out.println( TestRobotRoulant.grilleRobot(tabRbt, grille) );

		while(true)
		{

		

			System.out.println("Quelle robot voulez vous deplacer ? Et quelle direction ? ");
			action = sc.nextInt();
			dir = sc2.nextLine();

			tabRbt[action-1].deplacer(dir, tabRbt);
			System.out.println( TestRobotRoulant.grilleRobot(tabRbt, grille) );
			System.out.println(tabRbt[action-1].toString());
		}
		
		

	}


	/************************************/
	/*		METHODE AFFICHER GRILLE 	*/
	/************************************/

	private static String grilleRobot(RobotRoulant[] tabRbt, int[][] grille)
	{
		String sRet = "";
		String sSep = "";

		/****************************************************/
		/*  CONSTRUCTION DU SEPARATEUR : +---+---+---+---+  */
		/****************************************************/

		sSep += String.format("%3s", "+");
		for(int i=0; i<grille.length; i++)
		{
			sSep += "---+";
		}
		sRet += sSep + "\n";

		/**************************************/
		/*  CONSTRUCTION DES CASES : 1 |   |  */
		/**************************************/

		for(int i=0; i<grille.length; i++)
		{
			sRet += i + " |";
			for(int j=0; j<grille.length; j++)
			{
				for(RobotRoulant cpt : tabRbt)
				{
					if(cpt.getLigne()==i && cpt.getColonne()==j){sRet += String.format("%2d %1s", cpt.getNum(), "|");}
					//String.format("%1s %1d %1s %30.5s","\u001B[31m", cpt.getNum(), "\u001B[0m", "|");}
					
				}
				sRet += "   " + "|";
			}
			sRet += "\n" + sSep + "\n";
			
			
		}

		/******************************************************/
		/*  CONSTRUCTION DES INDICES COLONNES : 0  1  2  3  4 */
		/******************************************************/

		for (int i=0; i<grille.length; i++)
		{
			if(i==0){sRet += String.format("%5d", i);}
			if(i!=0){sRet += String.format("%4d", i);}
			
		}

		return sRet;
	}

	/****************************************/
	/*		METHODE AFFICHER GRILLE VIDE	*/
	/****************************************/

	private static String grille(RobotRoulant[] tabRbt)
	{
		String sRet = "";
		String sSep = "";

		/****************************************************/
		/*  CONSTRUCTION DU SEPARATEUR : +---+---+---+---+  */
		/****************************************************/

		sSep += String.format("%3s", "+");
		for(int i=0; i<tabRbt.length; i++)
		{
			sSep += "---+";
		}
		sRet += sSep + "\n";

		/**************************************/
		/*  CONSTRUCTION DES CASES : 1 |   |  */
		/**************************************/

		for(int i=0; i<tabRbt.length; i++)
		{
			sRet += i + " |";
			for(int j=0; j<tabRbt.length; j++)
			{
				sRet += "   " + "|"; // "   " -> grille[i][j]
			}
			sRet += "\n" + sSep + "\n";
		}

		/******************************************************/
		/*  CONSTRUCTION DES INDICES COLONNES : 0  1  2  3  4 */
		/******************************************************/

		for (int i=0; i<tabRbt.length; i++)
		{
			if(i==0){sRet += String.format("%5d", i);}
			if(i!=0){sRet += String.format("%4d", i);}
			
		}

		return sRet;
	}
}