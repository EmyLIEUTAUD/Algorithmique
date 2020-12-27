package Grille;

public class Main {

	public static void main(String[] args) {

		int[][] aux = { { 1, 0, 3, 8, 6, 0, 5, 7, 4 }, { 0, 9, 0, 5, 0, 1, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 1, 8, 0 },
				{ 0, 1, 0, 0, 5, 7, 3, 9, 0 }, { 0, 7, 0, 2, 0, 6, 0, 1, 0 }, { 0, 5, 2, 1, 9, 0, 0, 4, 0 },
				{ 0, 6, 4, 0, 0, 0, 0, 0, 0 }, { 7, 0, 0, 9, 0, 3, 0, 2, 0 }, { 9, 3, 1, 0, 2, 4, 7, 0, 8 } };
		Grille maGrille = new Grille(aux);
		System.out.println(maGrille);
		System.out.println("Ligne 5 est : " + maGrille.testLigne(5));
		System.out.println("Ligne 5 est : " + maGrille.testLigneAutre(5) + " avec l'autre méthode");
		System.out.println("Colonne 3 est : " + maGrille.testColonne(3));
		System.out.println("Carré 2 est : " + maGrille.testCarre(0, 3));
		System.out.println("La grille est juste : " + maGrille.testGrille());

		System.out.println("\n****************************************** \n");

		int[][] aux2 = { { 1, 2, 3, 8, 6, 9, 5, 7, 4 }, { 8, 9, 7, 5, 4, 1, 2, 6, 3 }, { 5, 4, 6, 3, 7, 2, 1, 8, 9 },
				{ 6, 1, 8, 4, 5, 7, 3, 9, 2 }, { 4, 7, 9, 2, 3, 6, 8, 1, 5 }, { 3, 5, 2, 1, 9, 8, 6, 4, 7 },
				{ 2, 6, 4, 7, 8, 5, 9, 3, 1 }, { 7, 8, 5, 9, 1, 3, 4, 2, 6 }, { 9, 3, 1, 6, 2, 4, 7, 5, 8 } };
		Grille grilleJuste = new Grille(aux2);
		System.out.println(grilleJuste);
		System.out.println("Ligne 5 est : " + grilleJuste.testLigne(5));
		System.out.println("Ligne 5 est : " + grilleJuste.testLigneAutre(5) + " avec l'autre méthode");
		System.out.println("Colonne 3 est : " + grilleJuste.testColonne(3));
		System.out.println("Carré 5 est : " + grilleJuste.testCarre(3, 3));
		System.out.println("La grille est juste : " + grilleJuste.testGrille());
		System.out.println("La case 5,3 est correcte : "+grilleJuste.isCorrect(5, 3, 1));

	}

}
