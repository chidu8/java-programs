package random;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Brute force sudoku solver using recursive backtracking. 
 * Need to implement a method to check if the partial sudoku input matrix is solvable at all or unsolvable, and do this check at the very beginning to avoid lots of computation.  
 */
public class SudokuSolver {
	public final int SUDOKU_SIZE=9;
	
	public boolean solve (int[][] a, int i, int j) {
		if(a.length!=9 || a[0].length!=9) return false; //Length incorrect
		if(i==SUDOKU_SIZE && j==(SUDOKU_SIZE-1)) {
			System.out.println(Arrays.deepToString(a)); 
			return true;
		}	
		if(i==SUDOKU_SIZE) {
			i=0;
			j++;
		}
		if (a[i][j]!=0) {
			return solve (a,i+1,j);
		}
		else {
			for (int k=1;k<=SUDOKU_SIZE;k++) {
				boolean returnValue = false;
				a[i][j] = k;
				if (isValid(a,i,j)) {
					returnValue = solve (a,i+1,j);
					if (returnValue) return true;
				}
				a[i][j] = 0;
			}
		}
		return false;
	}
	
	public boolean isValid(int[][] a,int i,int j) {
		return checkRow(a,i,j) && checkColumn(a,i,j) && checkSquareBox(a,i,j);
	}
	
	
	public boolean checkRow(int[][] a,int i,int j) {
		HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
		for (int p=1;p<=SUDOKU_SIZE;p++) {
			hMap.put(p, 0);
		}
		for (int q=0;q<SUDOKU_SIZE;q++) {
			if(a[i][q]!=0) {
				if (hMap.get(a[i][q])!=0) {
					return false;
				}
				hMap.put(a[i][q],1);
			}
		}
		return true;
	}
	public boolean checkColumn(int[][] a,int i,int j) {
		HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
		for (int p=1;p<=SUDOKU_SIZE;p++) {
			hMap.put(p, 0);
		}
		for (int q=0;q<SUDOKU_SIZE;q++) {
			if(a[q][j]!=0) {
				if (hMap.get(a[q][j])!=0) {
					return false;
				}
				hMap.put(a[q][j],1);
			}
		}
		return true;
	}
	
	
	public boolean checkSquareBox(int[][] a,int i,int j) {
		int rowMin=-1,rowMax=-1,colMin=-1,colMax=-1;
		if (i>=0 && i<=2) {
			rowMin=0;
			rowMax=2;
		}
		else if (i>=3 && i<=5) {
			rowMin=3;
			rowMax=5;
		}
		else if (i>=6 && i<=8) {
			rowMin=6;
			rowMax=8;
		}
		if (j>=0 && j<=2) {
			colMin=0;
			colMax=2;
		}
		else if (j>=3 && j<=5) {
			colMin=3;
			colMax=5;
		}
		else if (j>=6 && j<=8) {
			colMin=6;
			colMax=8;
		}
		return checkSquareBox(a,rowMin,rowMax,colMin,colMax);
	}
	
	public boolean checkSquareBox(int[][] a,int rowMin,int rowMax,int colMin,int colMax) {
		HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
		for (int p=1;p<=SUDOKU_SIZE;p++) {
			hMap.put(p, 0);
		}
		for (int i=rowMin;i<=rowMax;i++) {
			for (int j=colMin;j<=colMax;j++) {
				if(a[i][j]!=0) {
					if (hMap.get(a[i][j])!=0) {
						return false;
					}
					hMap.put(a[i][j],1);
				}
			}	
		}
		return true;
	}
	
	public void prettyPrintBoundingBoxes() {
		for(int i=0;i<SUDOKU_SIZE;i=i+3) {
			for(int j=0;j<SUDOKU_SIZE;j=j+3) {
				for(int r=i;r<i+3;r++) {
					for(int c=j;c<j+3;c++) {
						System.out.print(r+""+c+"\t");
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		SudokuSolver s = new SudokuSolver();
		int[][] a = new int[][]{
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

		        { 0, 0, 0, 0, 0, 0, 0, 0, 8 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 9 }
		};
		System.out.println(s.solve (a,0,0));
	}

}
