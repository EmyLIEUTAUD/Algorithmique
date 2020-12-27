package Solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Grille.Grille;

public class Solver {

	Grille grille;
	
	//constructeur
	public Solver(Grille grille) {
		this.grille = grille;
	}
	
	//convertit un objet en liste
	public static List convertObjectToList(Object obj) {
	    List liste = new ArrayList<Object>();
	    if (obj.getClass().isArray()) {
	        liste = Arrays.asList((Object[])obj);
	    } else if (obj instanceof Collection) {
	        liste = new ArrayList<>((Collection<?>)obj);
	    }
	    return liste;
	}
	
	//parcourt la grille en stockant tous les indices possibles dans chaque case vide
	public void redefinirListeIndices(Object[][] maGrille) { 
		ArrayList listeIndices;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				maGrille[i][j] = this.grille.getGrille(i, j);
				if(maGrille[i][j].equals(0)) {
					listeIndices = new ArrayList<>();
					for(int k=1;k<10;k++) {
						if(this.grille.isCorrect(i, j, k)) {
							listeIndices.add(k);
						}
					}
					maGrille[i][j] = listeIndices.toArray();
				}
			}
		}
	}
	
	//renvoie false si la colonne ne contient pas la valeur en indice
	public boolean verifierIndicesColonne(Object[][] maGrille, int i, int j, int valeur) {
		for(int l=0;l<9;l++) {
			if((convertObjectToList(maGrille[l][j])).contains(valeur) && l!=i) {
				return true;
			}
		}
		return false;
	}
	
	//renvoie false si la ligne ne contient pas la valeur en indice
	public boolean verifierIndicesLigne(Object[][] maGrille, int i, int j, int valeur) {
		for(int c=0;c<9;c++) {
			if((convertObjectToList(maGrille[i][c])).contains(valeur) && c!=j) {
				return true;
			}
		}
		return false;
	}
	
	//renvoie false si la colonne ne contient pas la valeur
	public boolean colonneContientValeur(Object[][] maGrille, int i, int j, int valeur) {
		for(int l=0;l<9;l++) {
			if(maGrille[l][j].equals(valeur)) { 
				return true;
			}
		}
		return false;
	}
	
	//renvoie false si la ligne ne contient pas la valeur 
	public boolean ligneContientValeur(Object[][] maGrille, int i, int j, int valeur) {
		for(int c=0;c<9;c++) {
			if(maGrille[i][c].equals(valeur)) { 
				return true;
			}
		}
		return false;
	}
	
	//renvoie true si la colonne ne contient pas la valeur en indice en sautant le carré où l'on travaille
	public boolean parcourtColonneDesAutresCarres(Object[][] maGrille, int i, int j, int valeur) {
		//si on est dans les carrés du haut
		if(i<3) {
			for(int k=3;k<9;k++) {
				if(convertObjectToList(maGrille[k][j]).contains(valeur)) {
					return false;
				}
			}
		}
		//si on est dans les carrés du milieu
		else if(i>2 && i<6) {
			for(int k=0;k<9;k++) {
				if(convertObjectToList(maGrille[k][j]).contains(valeur) && k!=3 && k!=4 && k!= 5) {
					return false;
				}
			}
		}
		//si on est dans les carrés à droite
		else {
			for(int k=0;k<6;k++) {
				if(convertObjectToList(maGrille[k][j]).contains(valeur)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//renvoie true si la ligne ne contient pas la valeur en indice en sautant le carré où l'on travaille
	public boolean parcourtLigneDesAutresCarres(Object[][] maGrille, int i, int j, int valeur) {
		//si on est dans les carrés du haut
		if(j<3) {
			for(int k=3;k<9;k++) {
				if(convertObjectToList(maGrille[i][k]).contains(valeur)) {
					return false;
				}
			}
		}
		//si on est dans les carrés du milieu
		else if(j>2 && j<6) {
			for(int k=0;k<9;k++) {
				if(convertObjectToList(maGrille[i][k]).contains(valeur) && k!=3 && k!=4 && k!= 5) {
					return false;
				}
			}
		}
		//si on est dans les carrés à droite
		else {
			for(int k=0;k<6;k++) {
				if(convertObjectToList(maGrille[i][k]).contains(valeur)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//renvoie true si la colonne ne contient pas la valeur en indice en sautant le carré en mettant le carré à sauter en paramètre
	public boolean parcourtColonneEnSautantUnCarre(Object[][] maGrille, int i, int j, int valeur, int ligneCarreASauter) {
		//si le carré à sauter est au milieu
		if(ligneCarreASauter>2 && ligneCarreASauter<6) {
			for(int k=0;k<9;k++) {
				if(convertObjectToList(maGrille[k][j]).contains(valeur) && (k<3 || k>5) && k!=i && this.grille.getGrille(k, j)==0) {
					return false;
				}
			}
		}
		//si le carré à sauter est en haut
		else if(ligneCarreASauter<3) {
			for(int k=3;k<9;k++) {
				if(convertObjectToList(maGrille[k][j]).contains(valeur) && k!=i && this.grille.getGrille(k, j)==0) {
					return false;
				}
			}
		}
		//si le carré à sauter est en bas
		else {
			for(int k=0;k<6;k++) {
				if(convertObjectToList(maGrille[k][j]).contains(valeur) && k!=i && this.grille.getGrille(k, j)==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	//renvoie true si la ligne ne contient pas la valeur en indice en sautant le carré en mettant le carré à sauter en paramètre
	public boolean parcourtLigneEnSautantUnCarre(Object[][] maGrille, int i, int j, int valeur, int colonneCarreASauter) {
		//si le carré à sauter est au milieu
		if(colonneCarreASauter>2 && colonneCarreASauter<6) {
			for(int k=0;k<9;k++) {
				if(convertObjectToList(maGrille[i][k]).contains(valeur) && (k<3 || k>5) && k!=j && this.grille.getGrille(i, k)==0) {
					return false;
				}
			}
		}
		//si le carré à sauter est à gauche
		else if(colonneCarreASauter<3) {
			for(int k=3;k<9;k++) {
				if(convertObjectToList(maGrille[i][k]).contains(valeur) && k!=j && this.grille.getGrille(i, k)==0) {
					return false;
				}
			}
		}
		//si le carré à sauter est à droite
		else {
			for(int k=0;k<6;k++) {
				if(convertObjectToList(maGrille[i][k]).contains(valeur) && k!=j && this.grille.getGrille(i, k)==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	//renvoie true si on peut placer la valeur : si les deux colonnes (ou lignes) adjascentes dans le même carré contiennent la valeur et que les lignes (ou colonnes) adjascentes dans le même carré contiennent la valeur également ou que ces deux cases au dessus et en dessous (à gauche ou à droite) de la case où l'on travaille ne soient pas vides
	public boolean hiddenSingle(Object[][] maGrille, int i, int j, int valeur) {
		//si on est sur la 1ère colonne et sur la 1ère ligne d'un carré
		if((j==0 || j==3 || j==6) && (i==0 || i==3 || i==6)) {
			if(colonneContientValeur(maGrille, i, j+1, valeur) && colonneContientValeur(maGrille, i, j+2, valeur) && (this.grille.getGrille(i+1, j)!=0 || ligneContientValeur(maGrille, i+1, j, valeur)) && (this.grille.getGrille(i+2, j)!=0 || ligneContientValeur(maGrille, i+2, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i+1, j, valeur) && ligneContientValeur(maGrille, i+2, j, valeur) && (this.grille.getGrille(i, j+1)!=0 || colonneContientValeur(maGrille, i, j+1, valeur)) && (this.grille.getGrille(i, j+2)!=0 || colonneContientValeur(maGrille, i, j+2, valeur))) {
				return true;
			}
		}
		//si on est sur la 1ère colonne et sur la 2ème ligne d'un carré
		else if((j==0 || j==3 || j==6) && (i==1 || i==4 || i==7)) {
			if(colonneContientValeur(maGrille, i, j+1, valeur) && colonneContientValeur(maGrille, i, j+2, valeur) && (this.grille.getGrille(i-1, j)!=0 || ligneContientValeur(maGrille, i-1, j, valeur)) && (this.grille.getGrille(i+1, j)!=0 || ligneContientValeur(maGrille, i+1, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i+1, j, valeur) && ligneContientValeur(maGrille, i-1, j, valeur) && (this.grille.getGrille(i, j+1)!=0 || colonneContientValeur(maGrille, i, j+1, valeur)) && (this.grille.getGrille(i, j+2)!=0 || colonneContientValeur(maGrille, i, j+2, valeur))) {
				return true;
			}
		}
		//si on est sur la 1ère colonne et sur la 3ème ligne d'un carré
		else if((j==0 || j==3 || j==6) && (i==2 || i==5 || i==8)) {
			if(colonneContientValeur(maGrille, i, j+1, valeur) && colonneContientValeur(maGrille, i, j+2, valeur) && (this.grille.getGrille(i-1, j)!=0 || ligneContientValeur(maGrille, i-1, j, valeur)) && (this.grille.getGrille(i-2, j)!=0 || ligneContientValeur(maGrille, i-2, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i-1, j, valeur) && ligneContientValeur(maGrille, i-2, j, valeur) && (this.grille.getGrille(i, j+1)!=0 || colonneContientValeur(maGrille, i, j+1, valeur)) && (this.grille.getGrille(i, j+2)!=0 || colonneContientValeur(maGrille, i, j+2, valeur))) {
				return true;
			}
		}
		//si on est sur la 2ème colonne et sur la 1ère ligne d'un carré
		else if((j==1 || j==4 || j==7) && (i==0 || i==3 || i==6)) {
			if(colonneContientValeur(maGrille, i, j+1, valeur) && colonneContientValeur(maGrille, i, j-1, valeur) && (this.grille.getGrille(i+1, j)!=0 || ligneContientValeur(maGrille, i+1, j, valeur)) && (this.grille.getGrille(i+2, j)!=0 || ligneContientValeur(maGrille, i+2, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i+1, j, valeur) && ligneContientValeur(maGrille, i+2, j, valeur) && (this.grille.getGrille(i, j-1)!=0 || colonneContientValeur(maGrille, i, j-1, valeur)) && (this.grille.getGrille(i, j+1)!=0 || colonneContientValeur(maGrille, i, j+1, valeur))) {
				return true;
			}
		}
		//si on est sur la 2ème colonne et sur la 2ème ligne d'un carré
		else if((j==1 || j==4 || j==7) && (i==1 || i==4 || i==7)) {
			if(colonneContientValeur(maGrille, i, j-1, valeur) && colonneContientValeur(maGrille, i, j+1, valeur) && (this.grille.getGrille(i-1, j)!=0 || ligneContientValeur(maGrille, i-1, j, valeur)) && (this.grille.getGrille(i+1, j)!=0 || ligneContientValeur(maGrille, i+1, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i-1, j, valeur) && ligneContientValeur(maGrille, i+1, j, valeur) && (this.grille.getGrille(i, j-1)!=0 || colonneContientValeur(maGrille, i, j-1, valeur)) && (this.grille.getGrille(i, j+1)!=0 || colonneContientValeur(maGrille, i, j+1, valeur))) {
				return true;
			}
		}
		//si on est sur la 2ème colonne et sur la 3ème ligne d'un carré
		else if((j==1 || j==4 || j==7) && (i==2 || i==5 || i==8)) {
			if(colonneContientValeur(maGrille, i, j-1, valeur) && colonneContientValeur(maGrille, i, j+1, valeur) && (this.grille.getGrille(i-1, j)!=0 || ligneContientValeur(maGrille, i-1, j, valeur)) && (this.grille.getGrille(i-2, j)!=0 || ligneContientValeur(maGrille, i-2, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i-1, j, valeur) && ligneContientValeur(maGrille, i-2, j, valeur) && (this.grille.getGrille(i, j-1)!=0 || colonneContientValeur(maGrille, i, j-1, valeur)) && (this.grille.getGrille(i, j+1)!=0 || colonneContientValeur(maGrille, i, j+1, valeur))) {
				return true;
			}
		}
		//si on est sur la 3ème colonne et sur la 1ère ligne d'un carré
		else if((j==2 || j==5 || j==8) && (i==0 || i==3 || i==6)) {
			if(colonneContientValeur(maGrille, i, j-1, valeur) && colonneContientValeur(maGrille, i, j-2, valeur) && (this.grille.getGrille(i+1, j)!=0 || ligneContientValeur(maGrille, i+1, j, valeur)) && (this.grille.getGrille(i+2, j)!=0 || ligneContientValeur(maGrille, i+2, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i+1, j, valeur) && ligneContientValeur(maGrille, i+2, j, valeur) && (this.grille.getGrille(i, j-1)!=0 || colonneContientValeur(maGrille, i, j-1, valeur)) && (this.grille.getGrille(i, j-2)!=0 || colonneContientValeur(maGrille, i, j-2, valeur))) {
				return true;
			}
		}
		//si on est sur la 3ème colonne et sur la 2ème ligne d'un carré
		else if((j==2 || j==5 || j==8) && (i==1 || i==4 || i==7)) {
			if(colonneContientValeur(maGrille, i, j-1, valeur) && colonneContientValeur(maGrille, i, j-2, valeur) && (this.grille.getGrille(i-1, j)!=0 || ligneContientValeur(maGrille, i-1, j, valeur)) && (this.grille.getGrille(i+1, j)!=0 || ligneContientValeur(maGrille, i+1, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i-1, j, valeur) && ligneContientValeur(maGrille, i+1, j, valeur) && (this.grille.getGrille(i, j-1)!=0 || colonneContientValeur(maGrille, i, j-1, valeur)) && (this.grille.getGrille(i, j-2)!=0 || colonneContientValeur(maGrille, i, j-2, valeur))) {
				return true;
			}
		}
		//si on est sur la 3ème colonne et sur la 3ème ligne d'un carré
		else if((j==2 || j==5 || j==8) && (i==2 || i==5 || i==8)) {
			if(colonneContientValeur(maGrille, i, j-1, valeur) && colonneContientValeur(maGrille, i, j-2, valeur) && (this.grille.getGrille(i-1, j)!=0 || ligneContientValeur(maGrille, i-1, j, valeur)) && (this.grille.getGrille(i-2, j)!=0 || ligneContientValeur(maGrille, i-2, j, valeur))) {
				return true;
			}
			else if(ligneContientValeur(maGrille, i-1, j, valeur) && ligneContientValeur(maGrille, i-2, j, valeur) && (this.grille.getGrille(i, j-1)!=0 || colonneContientValeur(maGrille, i, j-1, valeur)) && (this.grille.getGrille(i, j-2)!=0 || colonneContientValeur(maGrille, i, j-2, valeur))) {
				return true;
			}
		}
		return false;
	}
	
	//renvoie true si dans un carré, il n'y a une seule case qui peut contenir la valeur
	public boolean nakedSingle(Object[][] maGrille, int i, int j, int valeur) {
		//si on est dans le 1er carré
		if(j<3 && i<3) {
			for(int l=0;l<3;l++) {
				for(int c=0;c<3;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 2ème carré
		else if(j>2 && j<6 && i<3) {
			for(int l=0;l<3;l++) {
				for(int c=3;c<6;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 3ème carré
		else if(j>5 && i<3) {
			for(int l=0;l<3;l++) {
				for(int c=6;c<9;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 4ème carré
		else if(j<3 && i>2 && i<6) {
			for(int l=3;l<6;l++) {
				for(int c=0;c<3;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 5ème carré
		else if(j>2 && j<6 && i>2 && i<6) {
			for(int l=3;l<6;l++) {
				for(int c=3;c<6;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 6ème carré
		else if(j>5 && i>2 && i<6) {
			for(int l=3;l<6;l++) {
				for(int c=6;c<9;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 7ème carré
		else if(j<3 && i>5) {
			for(int l=6;l<9;l++) {
				for(int c=0;c<3;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 8ème carré
		else if(j>2 && j<6 && i>5) {
			for(int l=6;l<9;l++) {
				for(int c=3;c<6;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		//si on est dans le 9ème carré
		else if(j>5 && i>5) {
			for(int l=6;l<9;l++) {
				for(int c=6;c<9;c++) {
					if((l!=i || c!=j) && convertObjectToList(maGrille[l][c]).contains(valeur)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	//si sur une même ligne (ou colonne) on a deux cases vides ayant une même liste d'indices avec 2 indices, alors on peut éliminer ces deux indices sur les autres cases de la même ligne (ou colonne)
	public boolean nakedPair(Object[][] maGrille, int i, int j) {
		List<Integer> listeIndices;
		//si deux cases possèdent sur une colonne que 2 indices et si ces indices sont identiques (2 paires d'indices)
		for(int l=0;l<9;l++) {
			if(convertObjectToList(maGrille[l][j]).size()==2 && convertObjectToList(maGrille[i][j]).size()==2 && l!=i && convertObjectToList(maGrille[l][j]).equals(convertObjectToList(maGrille[i][j])) && this.grille.getGrille(i, j)==0 && this.grille.getGrille(l, j)==0) {
				for(int x=0;x<9;x++) {
					if(this.grille.getGrille(x, j)==0) {
						listeIndices = new LinkedList<>(convertObjectToList(maGrille[x][j]));
						if(listeIndices.contains(convertObjectToList(maGrille[i][j]).get(0)) && i!=x && l!=x) {
							listeIndices.remove(convertObjectToList(maGrille[i][j]).get(0));
							maGrille[x][j] = listeIndices;
							if(listeIndices.size()==1 && this.grille.isCorrect(x, j, listeIndices.get(0))) {
								this.grille.setGrille(x, j, listeIndices.get(0));
								return true;
							}
						}
						if(listeIndices.contains(convertObjectToList(maGrille[i][j]).get(1)) && i!=x && l!=x) {
							listeIndices.remove(convertObjectToList(maGrille[i][j]).get(1));
							maGrille[x][j] = listeIndices;
							if(listeIndices.size()==1 && this.grille.isCorrect(x, j, listeIndices.get(0))) {
								this.grille.setGrille(x, j, listeIndices.get(0));
								return true;
							}
						}
					}
				}
			}
		}
		//si deux cases possèdent sur une ligne que 2 indices et si ces indices sont identiques (2 paires d'indices)
		for(int c=0;c<9;c++) {
			if(convertObjectToList(maGrille[i][c]).size()==2 && convertObjectToList(maGrille[i][j]).size()==2 && c!=j && convertObjectToList(maGrille[i][c]).equals(convertObjectToList(maGrille[i][j])) && this.grille.getGrille(i, j)==0 && this.grille.getGrille(i, c)==0) {
				for(int x=0;x<9;x++) {
					if(this.grille.getGrille(i, x)==0) {
						listeIndices = new LinkedList<>(convertObjectToList(maGrille[i][x]));
						if(listeIndices.contains(convertObjectToList(maGrille[i][j]).get(0)) && j!=x && c!=x) {
							listeIndices.remove(convertObjectToList(maGrille[i][j]).get(0));
							maGrille[i][x] = listeIndices;
							if(listeIndices.size()==1 && this.grille.isCorrect(i, x, listeIndices.get(0))) {
								this.grille.setGrille(i, x, listeIndices.get(0));
								return true;
							}
						}
						if(listeIndices.contains(convertObjectToList(maGrille[i][j]).get(1)) && j!=x && c!=x) {
							listeIndices.remove(convertObjectToList(maGrille[i][j]).get(1));
							maGrille[i][x] = listeIndices;
							if(listeIndices.size()==1 && this.grille.isCorrect(i, x, listeIndices.get(0))) {
								this.grille.setGrille(i, x, listeIndices.get(0));
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	//si sur une ligne (ou colonne) on a une case avec 3 indices possibles et deux cases avec deux indices possibles ou une case avec deux indices possibles et une case avec les 3 mêmes indices et que ces indices forment un triplet, alors on peut supprimer ces 3 indices des autres cases sur la même ligne (ou colonne)
	public void nakedTriplet(Object[][] maGrille, int i, int j) {
		List<Integer> listeIndices;
		List<Integer> triplet;
		//On parcourt la colonne
		for(int l=0;l<9;l++) {
			for(int x=0;x<9;x++) {
				if((convertObjectToList(maGrille[i][j]).size()==2 || convertObjectToList(maGrille[i][j]).size()==3) && (convertObjectToList(maGrille[l][j]).size()==2 || convertObjectToList(maGrille[l][j]).size()==3) && (convertObjectToList(maGrille[x][j]).size()==2 || convertObjectToList(maGrille[x][j]).size()==3) && x!=i && l!=i && x!=l){
					triplet = new LinkedList<>();
					if(convertObjectToList(maGrille[i][j]).size()==2) {
						triplet.add((Integer) convertObjectToList(maGrille[i][j]).get(0));
						triplet.add((Integer) convertObjectToList(maGrille[i][j]).get(1));
						if(triplet.contains(convertObjectToList(maGrille[l][j]).get(0)) && convertObjectToList(maGrille[l][j]).size()==2 && !triplet.contains(convertObjectToList(maGrille[l][j]).get(1))) {
							triplet.add((Integer) convertObjectToList(maGrille[l][j]).get(1));
						}
						else if(triplet.contains(convertObjectToList(maGrille[l][j]).get(1)) && convertObjectToList(maGrille[l][j]).size()==2 && !triplet.contains(convertObjectToList(maGrille[l][j]).get(0))){
							triplet.add((Integer) convertObjectToList(maGrille[l][j]).get(0));
						}
						else if(triplet.contains(convertObjectToList(maGrille[l][j]).get(0)) && triplet.contains(convertObjectToList(maGrille[l][j]).get(1)) && convertObjectToList(maGrille[l][j]).size()==3) {
							triplet.add((Integer) convertObjectToList(maGrille[l][j]).get(2));
						}
						Collections.sort(triplet);
						if(convertObjectToList(maGrille[x][j]).size()==3 && triplet.size()==3 && convertObjectToList(maGrille[x][j]).contains(triplet.get(0)) && convertObjectToList(maGrille[x][j]).contains(triplet.get(1)) && convertObjectToList(maGrille[x][j]).contains(triplet.get(2))) {
							for(int v=0;v<9;v++) {
								if(convertObjectToList(maGrille[v][j]).contains(triplet.get(0)) && v!=i && v!=x && v!=l) {
									listeIndices = new LinkedList<>(convertObjectToList(maGrille[v][j]));
									listeIndices.remove(triplet.get(0));
									maGrille[v][j] = listeIndices;
								}
								if(convertObjectToList(maGrille[v][j]).contains(triplet.get(1)) && v!=i && v!=x && v!=l) {
									listeIndices = new LinkedList<>(convertObjectToList(maGrille[v][j]));
									listeIndices.remove(triplet.get(1));
									maGrille[v][j] = listeIndices;
								}
								if(convertObjectToList(maGrille[v][j]).contains(triplet.get(2)) && v!=i && v!=x && v!=l) {
									listeIndices = new LinkedList<>(convertObjectToList(maGrille[v][j]));
									listeIndices.remove(triplet.get(2));
									maGrille[v][j] = listeIndices;
								}
							}
						}
					}
				}
			}
		}
		//On parcourt la ligne
		for(int c=0;c<9;c++) {
			for(int x=0;x<9;x++) {
				if((convertObjectToList(maGrille[i][j]).size()==2 || convertObjectToList(maGrille[i][j]).size()==3) && (convertObjectToList(maGrille[i][c]).size()==2 || convertObjectToList(maGrille[i][c]).size()==3) && (convertObjectToList(maGrille[i][x]).size()==2 || convertObjectToList(maGrille[i][x]).size()==3) && x!=j && c!=j && x!=c){
					triplet = new LinkedList<>();
					if(convertObjectToList(maGrille[i][j]).size()==2) {
						triplet.add((Integer) convertObjectToList(maGrille[i][j]).get(0));
						triplet.add((Integer) convertObjectToList(maGrille[i][j]).get(1));
						if(triplet.contains(convertObjectToList(maGrille[i][c]).get(0)) && convertObjectToList(maGrille[i][c]).size()==2 && !triplet.contains(convertObjectToList(maGrille[i][c]).get(1))) {
							triplet.add((Integer) convertObjectToList(maGrille[i][c]).get(1));
						}
						else if(triplet.contains(convertObjectToList(maGrille[i][c]).get(1)) && convertObjectToList(maGrille[i][c]).size()==2 && !triplet.contains(convertObjectToList(maGrille[i][c]).get(0))){
							triplet.add((Integer) convertObjectToList(maGrille[i][c]).get(0));
						}
						else if(triplet.contains(convertObjectToList(maGrille[i][c]).get(0)) && triplet.contains(convertObjectToList(maGrille[i][c]).get(1)) && convertObjectToList(maGrille[i][c]).size()==3) {
							triplet.add((Integer) convertObjectToList(maGrille[i][c]).get(2));
						}
						Collections.sort(triplet);
						if(convertObjectToList(maGrille[i][x]).size()==3 && triplet.size()==3 && convertObjectToList(maGrille[i][x]).contains(triplet.get(0)) && convertObjectToList(maGrille[i][x]).contains(triplet.get(1)) && convertObjectToList(maGrille[i][x]).contains(triplet.get(2))) {
							for(int v=0;v<9;v++) {
								if(convertObjectToList(maGrille[i][v]).contains(triplet.get(0)) && v!=j && v!=x && v!=c) {
									listeIndices = new LinkedList<>(convertObjectToList(maGrille[i][v]));
									listeIndices.remove(triplet.get(0));
									maGrille[i][v] = listeIndices;
								}
								if(convertObjectToList(maGrille[i][v]).contains(triplet.get(1)) && v!=j && v!=x && v!=c) {
									listeIndices = new LinkedList<>(convertObjectToList(maGrille[i][v]));
									listeIndices.remove(triplet.get(1));
									maGrille[i][v] = listeIndices;
								}
								if(convertObjectToList(maGrille[i][v]).contains(triplet.get(2)) && v!=j && v!=x && v!=c) {
									listeIndices = new LinkedList<>(convertObjectToList(maGrille[i][v]));
									listeIndices.remove(triplet.get(2));
									maGrille[i][v] = listeIndices;
								}
							}
						}
					}
				}
			}
		}
	}
	
	//si il y a deux possibilités (deux listes de deux indices avec les mêmes indices) sur une même ligne (ou colonne) et dans un même carré, alors on regarde sur une ligne (ou colonne) si on a seulement cette indice dans cette case cherchée	 en sautant le carré où l'on travaille
	public int deductionIndices(Object[][] maGrille, int i, int j) {
		int possibilite1;
		int possibilite2;
		boolean flag;
		for(int c=0;c<9;c++) {
			//si il y a 2 possibilités sur la même ligne et dans le même carré
			if(convertObjectToList(maGrille[i][j]).equals(convertObjectToList(maGrille[i][c])) && c!=j && convertObjectToList(maGrille[i][j]).size()==2) {
				possibilite1 = (int) convertObjectToList(maGrille[i][j]).get(0);
				possibilite2 = (int) convertObjectToList(maGrille[i][j]).get(1);
				//si la possibilité est à gauche du carré
				if(j==0 || j==3 || j==6) {
					//si le trou restant dans le même carré est au milieu
					if(c==j+1 && this.grille.getGrille(i, j+2)!=0) {
						if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite1)==false && (parcourtColonneDesAutresCarres(maGrille, i, c+1, possibilite1)==false || colonneContientValeur(maGrille, i, c+1, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite2)==false && (parcourtColonneDesAutresCarres(maGrille, i, c+1, possibilite2)==false || colonneContientValeur(maGrille, i, c+1, possibilite2)==true)) {
							return possibilite2;
						}
					}
					//si le trou restant dans le même carré est à droite
					else if(c==j+2 && this.grille.getGrille(i, j+1)!=0) {
						if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite1)==false && (parcourtColonneDesAutresCarres(maGrille, i, c-1, possibilite1)==false || colonneContientValeur(maGrille, i, c-1, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite2)==false && (parcourtColonneDesAutresCarres(maGrille, i, c-1, possibilite2)==false || colonneContientValeur(maGrille, i, c-1, possibilite2)==true)) {
							return possibilite2;
						}
					}
				}
				//si la possibilité est au milieu du carré
				else if(j==1 || j==4 || j==7) {
					//si le trou restant dans le même carré est à gauche
					if(c==j-1 && this.grille.getGrille(i, j+1)!=0) {
						if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite1)==false && (parcourtColonneDesAutresCarres(maGrille, i, c+2, possibilite1)==false || colonneContientValeur(maGrille, i, c+2, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite2)==false && (parcourtColonneDesAutresCarres(maGrille, i, c+2, possibilite2)==false || colonneContientValeur(maGrille, i, c+2, possibilite2)==true)) {
							return possibilite2;
						}
					}
					//si le trou restant dans le même carré est à droite
					else if(c==j+1 && this.grille.getGrille(i, j-1)!=0) {
						if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite1)==false && (parcourtColonneDesAutresCarres(maGrille, i, c-2, possibilite1)==false || colonneContientValeur(maGrille, i, c-2, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite2)==false && (parcourtColonneDesAutresCarres(maGrille, i, c-2, possibilite2)==false || colonneContientValeur(maGrille, i, c-2, possibilite2)==true)) {
							return possibilite2;
						}
					}
				}
				//si la possibilité est à droite du carré
				else if(j==2 || j==5 || j==8) {
					//si le trou restant dans le même carré est au milieu
					if(c==j-1 && this.grille.getGrille(i, j-2)!=0) {
						if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite1)==false && (parcourtColonneDesAutresCarres(maGrille, i, c-1, possibilite1)==false || colonneContientValeur(maGrille, i, c-1, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite2)==false && (parcourtColonneDesAutresCarres(maGrille, i, c-1, possibilite2)==false || colonneContientValeur(maGrille, i, c-1, possibilite2)==true)) {
							return possibilite2;
						}
					}
					//si le trou restant dans le même carré est à gauche
					else if(c==j-2 && this.grille.getGrille(i, j-1)!=0) {
						if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite1)==false && (parcourtColonneDesAutresCarres(maGrille, i, c+1, possibilite1)==false || colonneContientValeur(maGrille, i, c+1, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtColonneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtColonneDesAutresCarres(maGrille, i, c, possibilite2)==false && (parcourtColonneDesAutresCarres(maGrille, i, c+1, possibilite2)==false || colonneContientValeur(maGrille, i, c+1, possibilite2)==true)) {
							return possibilite2;
						}
					}
				}
			}
			//si il y a 2 possibilités sur la même colonne et dans le même carré
			else if(convertObjectToList(maGrille[i][j]).equals(convertObjectToList(maGrille[c][j])) && c!=i && convertObjectToList(maGrille[i][j]).size()==2) {
				possibilite1 = (int) convertObjectToList(maGrille[i][j]).get(0);
				possibilite2 = (int) convertObjectToList(maGrille[i][j]).get(1);
				//si la possibilité est à gauche du carré
				if(i==0 || i==3 || i==6) {
					//si le trou restant dans le même carré est au milieu
					if(c==i+1 && this.grille.getGrille(i+2, j)!=0) {
						if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite1)==false && (parcourtLigneDesAutresCarres(maGrille, c+1, j, possibilite1)==false || ligneContientValeur(maGrille, i, j, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite2)==false && (parcourtLigneDesAutresCarres(maGrille, c+1, j, possibilite2)==false || ligneContientValeur(maGrille, i, j, possibilite2)==true)) {
							return possibilite2;
						}
					}
					//si le trou restant dans le même carré est à droite
					else if(c==i+2 && this.grille.getGrille(i+1, j)!=0) {
						if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite1)==false && (parcourtLigneDesAutresCarres(maGrille, c-1, j, possibilite1)==false || ligneContientValeur(maGrille, i, j, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite2)==false && (parcourtLigneDesAutresCarres(maGrille, c-1, j, possibilite2)==false || ligneContientValeur(maGrille, i, j, possibilite2)==true)) {
							return possibilite2;
						}
					}
				}
				//si la possibilité est au milieu du carré
				else if(i==1 || i==4 || i==7) {
					//si le trou restant dans le même carré est à gauche
					if(c==i-1 && this.grille.getGrille(i+1, j)!=0) {
						if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite1)==false && (parcourtLigneDesAutresCarres(maGrille, c+2, j, possibilite1)==false || ligneContientValeur(maGrille, i, j, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite2)==false && (parcourtLigneDesAutresCarres(maGrille, c+2, j, possibilite2)==false || ligneContientValeur(maGrille, i,j,  possibilite2)==true)) {
							return possibilite2;
						}
					}
					//si le trou restant dans le même carré est à droite
					else if(c==i+1 && this.grille.getGrille(i-1, j)!=0) {
						if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite1)==false && (parcourtLigneDesAutresCarres(maGrille, c-2, j, possibilite1)==false || ligneContientValeur(maGrille, i, j, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite2)==false && (parcourtLigneDesAutresCarres(maGrille, c-2, j, possibilite2)==false || ligneContientValeur(maGrille, i, j, possibilite2)==true)) {
							return possibilite2;
						}
					}
				}
				//si la possibilité est à droite du carré
				else if(i==2 || i==5 || i==8) {
					//si le trou restant dans le même carré est au milieu
					if(c==i-1 && this.grille.getGrille(i-2, j)!=0) {
						if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite1)==false && (parcourtLigneDesAutresCarres(maGrille, c-1, j, possibilite1)==false || ligneContientValeur(maGrille, i, j, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtLigneDesAutresCarres(maGrille, c, i, possibilite2)==false && (parcourtLigneDesAutresCarres(maGrille, c-1, j, possibilite2)==false || ligneContientValeur(maGrille, i, j, possibilite2)==true)) {
							return possibilite2;
						}
					}
					//si le trou restant dans le même carré est à gauche
					else if(c==i-2 && this.grille.getGrille(i-1, j)!=0) {
						if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite1)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite1)==false && (parcourtLigneDesAutresCarres(maGrille, c+1, j, possibilite1)==false || ligneContientValeur(maGrille, i, j, possibilite1)==true)) {
							return possibilite1;
						}
						else if(parcourtLigneDesAutresCarres(maGrille, i, j, possibilite2)==true && parcourtLigneDesAutresCarres(maGrille, c, j, possibilite2)==false && (parcourtLigneDesAutresCarres(maGrille, c+1, j, possibilite2)==false || ligneContientValeur(maGrille, i, j, possibilite2)==true)) {
							return possibilite2;
						}
					}
				}
			}
		}
		return 0;
	}
	
	//il regarde sur une ligne (ou une colonne) si il y a deux mêmes listes d'indices dans un seul carré, on prend ensuite la colonne (ou ligne) où il n'y a pas cette liste d'indices, toujours dans le même carré, puis on regarde sur cette colonne (ou ligne) et hors de ce carré si il y a un chiffre qui n'a qu'une seule possibilité
	public boolean testLigneEtColonne(Object[][] maGrille, int i){
		int num = 0;
		boolean flag;
		//si sur cette ligne il y a une valeur qui peut se trouver que dans un seul carré
		for(int k=1;k<10;k++) {
			flag = true;
			for(int j=0;j<9;j++) {
				for(int c=0;c<9;c++) {
					if(convertObjectToList(maGrille[i][j]).contains(k) && convertObjectToList(maGrille[i][c]).contains(k) && j!=c) {		
					//si la valeur peut se trouver dans le 1er carré
						for(int x=0;x<9;x++) {
							if(convertObjectToList(maGrille[i][x]).contains(k) && x!=j && x!=c) {
								flag = false;
							}
						}
						if(flag==true) {
							if(j<3 && c<3) {
								if((j==0 || c==0) && (j==1 || c==1)) {
									num = 2;
								}
								else if((j==0 || c==0) && (j==2 || c==2)) {
									num = 1;
								}
								else if((j==1 || c==1) && (j==2 || c==2)) {
									num = 0;
								}
								for(int l=0;l<9;l++) {
									if(parcourtColonneEnSautantUnCarre(maGrille, l, num, k, i) && this.grille.isCorrect(l, num, k) && this.grille.getGrille(l, num)==0) { // && this.grille.getGrille(i, num)==0
										this.grille.setGrille(l, num, k);
										return true;
									}
								}
							}
							//si la valeur peut se trouver dans le 2ème carré
							else if(j>2 && j<6 && c>2 && c<6) {
								if((j==3 || c==3) && (j==4 || c==4)) {
									num = 5;
								}
								else if((j==3 || c==3) && (j==5 || c==5)) {
									num = 4;
								}
								else if((j==4 || c==4) && (j==5 || c==5)) {
									num = 3;
								}
								for(int l=0;l<9;l++) {
									if(parcourtColonneEnSautantUnCarre(maGrille, l, num, k, i) && this.grille.isCorrect(l, num, k) && this.grille.getGrille(l, num)==0) {
										this.grille.setGrille(l, num, k);
										return true;
									}
								}
							}
							//si la valeur peut se trouver dans le 3ème carré
							else if(j>5 && c>5) {
								if((j==6 || c==6) && (j==7 || c==7)) {
									num = 8;
								}
								else if((j==6 || c==6) && (j==8 || c==8)) {
									num = 7;
								}
								else if((j==7 || c==7) && (j==8 || c==8)) {
									num = 6;
								}
								for(int l=0;l<9;l++) {
									if(parcourtColonneEnSautantUnCarre(maGrille, l, num, k, i) && this.grille.isCorrect(l, num, k) && this.grille.getGrille(l, num)==0) {
										this.grille.setGrille(l, num, k);
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		//si sur cette colonne il y a une valeur qui peut se trouver que dans un seul carré
		for(int k=1;k<10;k++) {
			flag = true;
			for(int j=0;j<9;j++) {
				for(int c=0;c<9;c++) {
						if(convertObjectToList(maGrille[j][i]).contains(k) && convertObjectToList(maGrille[c][i]).contains(k) && j!=c) {
							for(int x=0;x<9;x++) {
								if(convertObjectToList(maGrille[x][i]).contains(k) && x!=j && x!=c) {
									flag = false;
								}
							}
							if(flag==true) {
							//si la valeur peut se trouver dans le 1er carré
							if(j<3 && c<3) {
								if((j==0 || c==0) && (j==1 || c==1)) {
									num = 2;
								}
								else if((j==0 || c==0) && (j==2 || c==2)) {
									num = 1;
								}
								else if((j==1 || c==1) && (j==2 || c==2)) {
									num = 0;
								}
								for(int l=0;l<9;l++) {
									if(parcourtLigneEnSautantUnCarre(maGrille, num, l, k, i) && this.grille.isCorrect(num, l, k) && this.grille.getGrille(num, l)==0) {
										this.grille.setGrille(num, l, k);
										return true;
									}
								}
							}
							//si la valeur peut se trouver dans le 2ème carré
							else if(j>2 && j<6 && c>2 && c<6) {
								if((j==3 || c==3) && (j==4 || c==4)) {
									num = 5;
								}
								else if((j==3 || c==3) && (j==5 || c==5)) {
									num = 4;
								}
								else if((j==4 || c==4) && (j==5 || c==5)) {
									num = 3;
								}
								for(int l=0;l<9;l++) {
									if(parcourtLigneEnSautantUnCarre(maGrille, num, l, k, i) && this.grille.isCorrect(num, l, k) && this.grille.getGrille(num, l)==0) {
										this.grille.setGrille(num, l, k);
										return true;
									}
								}
							}
							//si la valeur peut se trouver dans le 3ème carré
							else if(j>5 && c>5) {
								if((j==6 || c==6) && (j==7 || c==7)) {
									num = 8;
								}
								else if((j==6 || c==6) && (j==8 || c==8)) {
									num = 7;
								}
								else if((j==7 || c==7) && (j==8 || c==8)) {
									num = 6;
								}
								for(int l=0;l<9;l++) {
									if(parcourtLigneEnSautantUnCarre(maGrille, num, l, k, i) && this.grille.isCorrect(num, l, k) && this.grille.getGrille(num, l)==0) {
										this.grille.setGrille(num, l, k);
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public void attendre() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solve() {
		Object[][] maGrille = new Object[9][9];
		int myIndice;
		boolean flag;
		boolean flagNakedPair;
		redefinirListeIndices(maGrille);
		while(this.grille.testGrille()==false) {
			flag=true;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(this.grille.getGrille(i, j)==0) {
						if(convertObjectToList(maGrille[i][j]).size()==1) {
							flag = false;
							myIndice = (int)convertObjectToList(maGrille[i][j]).get(0);
							if(this.grille.isCorrect(i, j, myIndice)) {
								this.grille.setGrille(i, j, myIndice);
								redefinirListeIndices(maGrille);
							}
						}
						else {
							for(int k=1;k<10;k++) {
								if(this.grille.isCorrect(i, j, k) && this.grille.getGrille(i, j)==0) {
									if(hiddenSingle(maGrille, i, j, k)==true) {
										flag = false;
										this.grille.setGrille(i, j, k);
										redefinirListeIndices(maGrille);
									}
									else if(verifierIndicesColonne(maGrille, i, j, k)==false || verifierIndicesLigne(maGrille, i, j, k)==false) {
										flag = false;
										this.grille.setGrille(i, j, k);
										redefinirListeIndices(maGrille);
									}
									else if(deductionIndices(maGrille, i, j)==k) {
										flag = false;
										this.grille.setGrille(i, j, k);
										redefinirListeIndices(maGrille);
									}
									else if(nakedSingle(maGrille, i, j, k)==true) {
										flag = false;
										this.grille.setGrille(i, j, k);
										redefinirListeIndices(maGrille);
									}
									else if(testLigneEtColonne(maGrille, i)==true){
										flag = false;
										redefinirListeIndices(maGrille);
									}
								}
							}
						}
					}
				}
			}
			if(flag==true) {
				flagNakedPair = true;
				for(int i=0;i<9;i++) {
					for(int j=0;j<9;j++) {
						if(nakedPair(maGrille, i, j)==true) {
							flagNakedPair = false;
							redefinirListeIndices(maGrille);
							break;
						}
					}
				}
				if(flagNakedPair==true) {
					for(int i=0;i<9;i++) {
						for(int j=0;j<9;j++) {
							nakedTriplet(maGrille, i, j);
						}
					}
				}
			}
		}
	}
	
	public boolean solve2() {
		for (int l = 0; l < 9; l++) {
			for (int c = 0;c < 9; c++) {
				if(this.grille.getGrille(l, c)==0) {
					for (int k=1; k<10; k++) {
						if(this.grille.isCorrect(l, c, k)) {
							this.grille.setGrille(l, c, k);
							if(solve2()) {
								return true;
							}
							this.grille.setGrille(l, c, 0);
						}
					}
					return false;
				} 
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < 3; i++) {
			str += this.grille.getGrille(i, 0) + " " + this.grille.getGrille(i, 1) + " " + this.grille.getGrille(i, 2) + "|" + this.grille.getGrille(i, 3) + " " + this.grille.getGrille(i, 4)+ " " + this.grille.getGrille(i, 5) + "|" + this.grille.getGrille(i, 6) + " " + this.grille.getGrille(i, 7) + " " + this.grille.getGrille(i, 8) + "\n";
		}
		str += "-----------------\n";
		for (int i = 3; i < 6; i++) {
			str += this.grille.getGrille(i, 0) + " " + this.grille.getGrille(i, 1) + " " + this.grille.getGrille(i, 2) + "|" + this.grille.getGrille(i, 3) + " " + this.grille.getGrille(i, 4)+ " " + this.grille.getGrille(i, 5) + "|" + this.grille.getGrille(i, 6) + " " + this.grille.getGrille(i, 7) + " " + this.grille.getGrille(i, 8) + "\n";
		}
		str += "-----------------\n";
		for (int i = 6; i < 9; i++) {
			str += this.grille.getGrille(i, 0) + " " + this.grille.getGrille(i, 1) + " " + this.grille.getGrille(i, 2) + "|" + this.grille.getGrille(i, 3) + " " + this.grille.getGrille(i, 4)+ " " + this.grille.getGrille(i, 5) + "|" + this.grille.getGrille(i, 6) + " " + this.grille.getGrille(i, 7) + " " + this.grille.getGrille(i, 8) + "\n";
		}
		return str;
	}
	
}
