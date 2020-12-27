package Grille;

import java.util.ArrayList;
import java.util.Arrays;

public class Grille {

	public int[][] grille = new int[9][9];

	public Grille() {
		super();
	}

	public Grille(int[][] grille) {
		super();
		this.grille = grille;
	}

	public int getGrille(int i, int j) {
		return grille[i][j];
	}

	public void setGrille(int i, int j, int valeur) {
		grille[i][j] = valeur;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < 3; i++) {
			str += grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + "|" + grille[i][3] + " " + grille[i][4]
					+ " " + grille[i][5] + "|" + grille[i][6] + " " + grille[i][7] + " " + grille[i][8] + "\n";
		}
		str += "-----------------\n";
		for (int i = 3; i < 6; i++) {
			str += grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + "|" + grille[i][3] + " " + grille[i][4]
					+ " " + grille[i][5] + "|" + grille[i][6] + " " + grille[i][7] + " " + grille[i][8] + "\n";
		}
		str += "-----------------\n";
		for (int i = 6; i < 9; i++) {
			str += grille[i][0] + " " + grille[i][1] + " " + grille[i][2] + "|" + grille[i][3] + " " + grille[i][4]
					+ " " + grille[i][5] + "|" + grille[i][6] + " " + grille[i][7] + " " + grille[i][8] + "\n";
		}
		return str;
	}

	public boolean testLigne(int i) {
		int[] test = new int[10];
		for (int j = 0; j < 9; j++) {
			if (grille[i][j] < 1 || grille[i][j] > 9) {
				return false;
			} else if (test[grille[i][j]] == 0) {
				test[grille[i][j]] = 1;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean testLigneAutre(int i) {
		for (int j = 0; j < 9; j++) {
			if (grille[i][j] > 9 || grille[i][j] < 1) {
				return false;
			}
		}
		for (int j = 0; j < 9; j++) {
			for (int k = 0; k < 9; k++) {
				if (grille[i][j] == grille[i][k] && j != k) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean testColonne(int j) {
		int[] test = new int[10];
		for (int i = 0; i < 9; i++) {
			if (grille[i][j] < 1 || grille[i][j] > 9) {
				return false;
			} else if (test[grille[i][j]] == 0) {
				test[grille[i][j]] = 1;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean testCarre(int i0, int j0) {
		int[] test = new int[10];
		for (int i = i0; i < i0 + 3; i++) {
			for (int j = j0; j < j0 + 3; j++) {
				if (grille[i][j] < 1 || grille[i][j] > 9) {
					return false;
				} else if (test[grille[i][j]] == 0) {
					test[grille[i][j]] = 1;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean testGrille() {
		for (int i = 0; i < 9; i++) {
			if (!testLigne(i) || !testLigneAutre(i)) {
				return false;
			}
		}
		for (int j = 0; j < 9; j++) {
			if (!testColonne(j)) {
				return false;
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!testCarre(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isCorrect(int i, int j, int valeur) {
		//vérifie qu'il n'y ait pas la valeur sur sa ligne
		for(int k=0;k<9;k++) {
			if(grille[i][k]==valeur) {
				return false;
			}
		}
		//vérifie qu'il n'y ait pas la valeur sur sa colonne
		for(int k=0;k<9;k++) {
			if(grille[k][j]==valeur) {
				return false;
			}
		}
		//on trouve les valeurs des coins, pour pouvoir trouver les carrés et vérifier qu'il y ait pas la valeur dans le carré
		int i0 = i-i%3;
		int j0 = j-j%3;
		for(int ki=i0;ki<i0+3;ki++) {
			for(int kj=j0;kj<j0+3;kj++) {
				if(grille[ki][kj]==valeur) {
					return false;
				}
			}
		}
		return true;
	}

}
