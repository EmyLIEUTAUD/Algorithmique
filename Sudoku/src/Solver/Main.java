package Solver;

import Grille.Grille;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Sudoku facile avec la méthode solve() : ");
		
		int[][] aux = {{1,0,3,8,6,0,5,7,4},{0,9,0,5,0,1,0,0,3},{0,0,0,0,0,0,1,8,0},{0,1,0,0,5,7,3,9,0},{0,7,0,2,0,6,0,1,0},{0,5,2,1,9,0,0,4,0},{0,6,4,0,0,0,0,0,0},{7,0,0,9,0,3,0,2,0},{9,3,1,0,2,4,7,0,8}};
		Grille maGrille = new Grille(aux);
		Solver solveMaGrille = new Solver(maGrille);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrille);
		long time1 = System.currentTimeMillis();
		solveMaGrille.solve();
		long time2 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrille);
		System.out.println("Sudoku résolu en : "+(time2-time1)+" ms. \n");
		System.out.println("------------------------------------------------------ \n");
		
		System.out.println("Sudoku facile avec la méthode solve2() : ");
		
		int[][] aux00 = {{1,0,3,8,6,0,5,7,4},{0,9,0,5,0,1,0,0,3},{0,0,0,0,0,0,1,8,0},{0,1,0,0,5,7,3,9,0},{0,7,0,2,0,6,0,1,0},{0,5,2,1,9,0,0,4,0},{0,6,4,0,0,0,0,0,0},{7,0,0,9,0,3,0,2,0},{9,3,1,0,2,4,7,0,8}};
		Grille maGrille00 = new Grille(aux00);
		Solver solveMaGrille00 = new Solver(maGrille00);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrille00);
		long time100 = System.currentTimeMillis();
		solveMaGrille00.solve2();
		long time200 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrille00);
		System.out.println("Sudoku résolu en : "+(time200-time100)+" ms. \n");
		System.out.println("------------------------------------------------------ \n");

		System.out.println("Sudoku medium avec la méthode solve() : ");
		
		int[][] aux3 = {{8,0,0,0,1,3,6,0,0},{0,6,0,5,0,0,0,0,3},{0,1,0,6,0,0,0,0,0},{4,3,2,0,7,0,0,0,0},{0,0,6,4,2,1,7,0,0},{0,0,0,0,3,0,2,4,9},{0,0,0,0,0,4,0,2,0},{3,0,0,0,0,8,0,9,0},{0,0,4,2,5,0,0,0,1}};
		Grille maGrilleMoyenne = new Grille(aux3);
		Solver solveMaGrilleMoyenne = new Solver(maGrilleMoyenne);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleMoyenne);
		long time5 = System.currentTimeMillis();
		solveMaGrilleMoyenne.solve();
		long time6 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleMoyenne);
		System.out.println("Sudoku résolu en : "+(time6-time5)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");
		
		System.out.println("Sudoku medium avec la méthode solve2() : ");
		
		int[][] aux32 = {{8,0,0,0,1,3,6,0,0},{0,6,0,5,0,0,0,0,3},{0,1,0,6,0,0,0,0,0},{4,3,2,0,7,0,0,0,0},{0,0,6,4,2,1,7,0,0},{0,0,0,0,3,0,2,4,9},{0,0,0,0,0,4,0,2,0},{3,0,0,0,0,8,0,9,0},{0,0,4,2,5,0,0,0,1}};
		Grille maGrilleMoyenne2 = new Grille(aux32);
		Solver solveMaGrilleMoyenne2 = new Solver(maGrilleMoyenne2);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleMoyenne2);
		long time52 = System.currentTimeMillis();
		solveMaGrilleMoyenne2.solve2();
		long time62 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleMoyenne2);
		System.out.println("Sudoku résolu en : "+(time62-time52)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");
		
		System.out.println("Sudoku difficile avec la méthode solve(): ");
		
		int[][] aux2 = {{0,2,0,0,0,5,0,7,3},{0,0,0,1,0,0,0,8,0},{0,0,0,9,0,0,2,0,1},{0,0,0,0,3,0,0,0,9},{0,0,8,2,0,7,4,0,0},{9,0,0,0,1,0,0,0,0},{8,0,3,0,0,6,0,0,0},{0,9,0,0,0,1,0,0,0},{6,5,0,3,0,0,0,1,0}};
		Grille maGrilleDifficile = new Grille(aux2);
		Solver solveMaGrilleDifficile = new Solver(maGrilleDifficile);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleDifficile);
		long time3 = System.currentTimeMillis();
		solveMaGrilleDifficile.solve();
		long time4 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleDifficile);
		System.out.println("Sudoku résolu en : "+(time4-time3)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");
		
		System.out.println("Sudoku difficile avec la méthode solve2() : ");
		
		int[][] aux22 = {{0,2,0,0,0,5,0,7,3},{0,0,0,1,0,0,0,8,0},{0,0,0,9,0,0,2,0,1},{0,0,0,0,3,0,0,0,9},{0,0,8,2,0,7,4,0,0},{9,0,0,0,1,0,0,0,0},{8,0,3,0,0,6,0,0,0},{0,9,0,0,0,1,0,0,0},{6,5,0,3,0,0,0,1,0}};
		Grille maGrilleDifficile2 = new Grille(aux22);
		Solver solveMaGrilleDifficile2 = new Solver(maGrilleDifficile2);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleDifficile2);
		long time32 = System.currentTimeMillis();
		solveMaGrilleDifficile2.solve2();
		long time42 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleDifficile2);
		System.out.println("Sudoku résolu en : "+(time42-time32)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");

		System.out.println("Sudoku diabolique avec la méthode solve() : ");
		
		int[][] aux4 = {{9,0,0,0,0,0,0,0,0},{0,0,0,8,0,0,0,0,0},{7,0,6,0,4,3,2,0,0},{0,0,0,0,0,2,4,0,0},{0,3,0,4,0,8,9,0,2},{0,2,9,0,5,0,0,0,7},{0,1,0,0,0,0,0,0,5},{0,0,0,1,0,7,3,0,0},{0,0,2,0,0,0,6,0,0}};
		Grille maGrilleDiabolique = new Grille(aux4);
		Solver solveMaGrilleDiabolique = new Solver(maGrilleDiabolique);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleDiabolique);
		long time7 = System.currentTimeMillis();
		solveMaGrilleDiabolique.solve();
		long time8 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleDiabolique);
		System.out.println("Sudoku résolu en : "+(time8-time7)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");
		
		System.out.println("Sudoku diabolique avec la méthode solve2() : ");
		
		int[][] aux42 = {{9,0,0,0,0,0,0,0,0},{0,0,0,8,0,0,0,0,0},{7,0,6,0,4,3,2,0,0},{0,0,0,0,0,2,4,0,0},{0,3,0,4,0,8,9,0,2},{0,2,9,0,5,0,0,0,7},{0,1,0,0,0,0,0,0,5},{0,0,0,1,0,7,3,0,0},{0,0,2,0,0,0,6,0,0}};
		Grille maGrilleDiabolique2 = new Grille(aux42);
		Solver solveMaGrilleDiabolique2 = new Solver(maGrilleDiabolique2);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleDiabolique2);
		long time72 = System.currentTimeMillis();
		solveMaGrilleDiabolique2.solve2();
		long time82 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleDiabolique2);
		System.out.println("Sudoku résolu en : "+(time82-time72)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");
		
		System.out.println("Sudoku diabolique 2 avec la méthode solve() : ");
		
		int[][] aux41 = {{0,0,0,0,0,7,0,3,0},{9,7,5,0,1,0,8,6,4},{0,2,0,8,0,0,0,0,0},{7,0,0,0,0,0,9,0,0},{0,5,0,0,0,0,0,4,0},{0,0,1,0,0,0,0,0,8},{0,0,0,0,0,9,0,2,0},{8,4,9,0,3,0,7,5,6},{0,3,0,6,0,0,0,0,0}};
		Grille maGrilleDiabolique21 = new Grille(aux41);
		Solver solveMaGrilleDiabolique21 = new Solver(maGrilleDiabolique21);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleDiabolique21);
		long time711 = System.currentTimeMillis();
		solveMaGrilleDiabolique21.solve();
		long time811 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleDiabolique21);
		System.out.println("Sudoku résolu en : "+(time811-time711)+" ms. \n");
		System.out.println("----------------------------------------------------- \n"); 
		
		System.out.println("Sudoku diabolique 2 avec la méthode solve2() : ");
		
		int[][] aux412 = {{0,0,0,0,0,7,0,3,0},{9,7,5,0,1,0,8,6,4},{0,2,0,8,0,0,0,0,0},{7,0,0,0,0,0,9,0,0},{0,5,0,0,0,0,0,4,0},{0,0,1,0,0,0,0,0,8},{0,0,0,0,0,9,0,2,0},{8,4,9,0,3,0,7,5,6},{0,3,0,6,0,0,0,0,0}};
		Grille maGrilleDiabolique22 = new Grille(aux412);
		Solver solveMaGrilleDiabolique22 = new Solver(maGrilleDiabolique22);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleDiabolique22);
		long time712 = System.currentTimeMillis();
		solveMaGrilleDiabolique22.solve2();
		long time812 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleDiabolique22);
		System.out.println("Sudoku résolu en : "+(time812-time712)+" ms. \n");
		System.out.println("----------------------------------------------------- \n"); 
		
		System.out.println("Sudoku extrême : ");
		
		int[][] aux5 = {{0,7,0,0,9,0,0,3,0},{9,0,0,8,0,3,0,0,1},{0,0,3,0,0,0,2,0,0},{0,4,0,0,2,0,0,7,0},{6,0,0,1,0,4,0,0,5},{0,3,0,0,5,0,0,6,0},{0,0,8,0,0,0,9,0,0},{7,0,0,5,0,9,0,0,3},{0,9,0,0,4,0,0,5,0}};
		Grille maGrilleExtreme = new Grille(aux5);
		Solver solveMaGrilleExtreme = new Solver(maGrilleExtreme);
		System.out.println("Grille de départ : \n");
		System.out.println(maGrilleExtreme);
		long time9 = System.currentTimeMillis();
		solveMaGrilleExtreme.solve2();
		long time99 = System.currentTimeMillis();
		System.out.println("Grille remplie : \n");
		System.out.println(solveMaGrilleExtreme);
		System.out.println("Sudoku résolu en : "+(time99-time9)+" ms. \n");
		System.out.println("----------------------------------------------------- \n");
	}

}
