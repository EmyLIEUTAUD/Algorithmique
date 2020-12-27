package Jeu;
import java.util.Scanner;

import Grille.*;

public class Jeu {

	public static void main(String[] args) {

		int[][] aux = {{1,0,3,8,6,0,5,7,4},{0,9,0,5,0,1,0,0,3},{0,0,0,0,0,0,1,8,0},{0,1,0,0,5,7,3,9,0},{0,7,0,2,0,6,0,1,0},{0,5,2,1,9,0,0,4,0},{0,6,4,0,0,0,0,0,0},{7,0,0,9,0,3,0,2,0},{9,3,1,0,2,4,7,0,8}};
		int[][] aux2 = {{1,0,3,8,6,0,5,7,4},{0,9,0,5,0,1,0,0,3},{0,0,0,0,0,0,1,8,0},{0,1,0,0,5,7,3,9,0},{0,7,0,2,0,6,0,1,0},{0,5,2,1,9,0,0,4,0},{0,6,4,0,0,0,0,0,0},{7,0,0,9,0,3,0,2,0},{9,3,1,0,2,4,7,0,8}};
		Grille maGrilleDepart = new Grille(aux2);
		Grille maGrille = new Grille(aux);
		Scanner sc = new Scanner(System.in);
		while(!maGrille.testGrille()) {
			System.out.println(maGrille);
			System.out.println("Ajouter une valeur (a) ou supprimer une valeur (s) ? ");
			String action = sc.next();
			if(action.equals("a")) {
				System.out.println("Où et quelle valeur voulez-vous ajouter ? ");
				System.out.println("Quelle ligne (0 à 8) ? ");
				int l = sc.nextInt();
				System.out.println("Quelle colonne (0 à 8) ? ");
				int c = sc.nextInt();
				System.out.println("Quelle valeur (1 à 9) ? ");
				int val = sc.nextInt();
				if(l<0 || l>8) {
					System.out.println("La ligne saisie n'est pas valable : elle doit être comprise entre 0 et 8");
				}
				if(c<0 || c>8) {
					System.out.println("La colonne saisie n'est pas valable : elle doit être comprise entre 0 et 8");
				}
				if(val<1 || val>9) {
					System.out.println("Il faut que la valeur soit comprise entre 1 et 9.");
				}
				if(l>=0 && l<9 && c>=0 && c<9 && val<10 && val>0) {
					if(maGrille.isCorrect(l, c, val)) {
						maGrille.setGrille(l, c, val);
					}
					else {
						System.out.println(val+" ne peut pas se trouver dans la case "+l+":"+c+".");
					}
				}
			}
			else if(action.equals("s")) {
				System.out.println("Quelle case voulez-vous supprimer ?");
				System.out.println("Quelle ligne ? ");
				int l = sc.nextInt();
				System.out.println("Quelle colonne ? ");
				int c = sc.nextInt();
				if(l<0 || l>8) {
					System.out.println("La ligne saisie n'est pas valable : elle doit être comprise entre 0 et 8");
				}
				if(c<0 || c>8) {
					System.out.println("La colonne saisie n'est pas valable : elle doit être comprise entre 0 et 8");
				}
				if(l>=0 && l<9 && c>=0 && c<9) {
					if(maGrille.getGrille(l, c)==maGrilleDepart.getGrille(l, c)) {
						System.out.println("Vous ne pouvez pas modifier cette case : elle appartient à la grille initiale.");
					}
					else {
						maGrille.setGrille(l, c, 0);
					}
				}
			}
			
		}
		System.out.println(maGrille);
		System.out.println("Bravo !");
		sc.close();
		
	}

}
