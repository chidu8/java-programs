package random;

import java.util.Arrays;
import java.util.HashMap;

public class SudokuSolver {
	public int SQUARE_SIZE;
	
	SudokuSolver(int size) {
		this.SQUARE_SIZE = size;
	}
	public boolean solve (int[][] a, int i, int j) {
		if(i==SQUARE_SIZE && j==(SQUARE_SIZE-1)) {
			System.out.println(Arrays.deepToString(a)); 
			return true;
		}	
		if(i==SQUARE_SIZE) {
			i=0;
			j++;
		}
		if (a[i][j]!=-1) {
			return solve (a,i+1,j);
		}
		else {
			for (int k=1;k<=SQUARE_SIZE;k++) {
				boolean returnValue = false;
				a[i][j] = k;
				if (isValid(a,i,j)) {
					returnValue = solve (a,i+1,j);
					if (returnValue) return true;
				}
				a[i][j] = -1;
			}
		}
		return false;
	}
	
	public boolean isValid(int[][] a,int i,int j) {
		return checkRow(a,i,j) && checkColumn(a,i,j);
	}
	
	public boolean checkRow(int[][] a,int i,int j) {
		HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
		for (int p=1;p<=SQUARE_SIZE;p++) {
			hMap.put(p, 0);
		}
		for (int q=0;q<SQUARE_SIZE;q++) {
			if(a[i][q]!=-1) {
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
		for (int p=1;p<=SQUARE_SIZE;p++) {
			hMap.put(p, 0);
		}
		for (int q=0;q<SQUARE_SIZE;q++) {
			if(a[q][j]!=-1) {
				if (hMap.get(a[q][j])!=0) {
					return false;
				}
				hMap.put(a[q][j],1);
			}
		}
		return true;
	}
	
	public void printBoundingBoxes() {
		for(int i=0;i<SQUARE_SIZE;i=i+3) {
			for(int j=0;j<SQUARE_SIZE;j=j+3) {
				
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
		SudokuSolver s = new SudokuSolver(3);
		int[][] a = new int[][]{{3, -1, 3}, {-1, -1, -1}, {-1, -1, -1}};
		System.out.println(s.solve (a,0,0));
	}

}
