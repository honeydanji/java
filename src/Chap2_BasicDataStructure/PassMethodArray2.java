package Chap2_BasicDataStructure;

import java.util.Random;

public class PassMethodArray2 {
	
	static void getData(int[][] A, int[][] A1, int[][] B) {
		
		for(int i=0; i < A.length; i++) {
			for(int j=0; j < A[i].length; j++) {
				Random rand = new Random();
				A[i][j] = rand.nextInt(20);
			}
		}
		
		for(int i=0; i < A1.length; i++) {
			for(int j=0; j < A1[i].length; j++) {
				Random rand = new Random();
				A1[i][j] = rand.nextInt(20);
			}
		}
		
		for(int i=0; i < B.length; i++) {
			for(int j=0; j < B[i].length; j++) {
				Random rand = new Random();
				B[i][j] = rand.nextInt(20);
			}
		}
	}
	
	static void showData(int[][] A, int[][] A1, int[][] B) {
		System.out.println("A 배열 : ");
		for(int i=0; i < A.length; i++) {
			for(int j=0; j < A[i].length; j++) {
				System.out.print(A[i][j] + " ");
			}
		}
		
		System.out.println("\nA1 배열 : ");
		for(int i=0; i < A1.length; i++) {
			for(int j=0; j < A1[i].length; j++) {
				System.out.print(A1[i][j] + " ");
				
			}
		}
		
		System.out.println("\nB 배열 : ");
		for(int i=0; i < B.length; i++) {
			for(int j=0; j < B[i].length; j++) {
				System.out.print(B[i][j] + " ");
			}
		}
		
	}
	
	static void addMatrix(int[][] A, int[][] A1, int[][] A2) {
		System.out.println("\nA2 배열 : ");
		for(int i=0; i < A.length; i++) {
			for(int j=0; j < A[i].length; j++) {
				A2[i][j] = A[i][j] + A1[i][j];
				System.out.print(A2[i][j] + " ");
			}
		}	
	}
	
	static void multiplyMatrix(int[][] A, int[][] A1, int[][] C) {
		System.out.println("\nC 배열 : ");
		
	}
	
	public static void main(String[] args) {
		
		// 난수 생성 2차원 배열
		int[][] A = new int[2][3];
		int[][] A1 = new int[2][3];
		int[][] B = new int[3][4];
		
		getData(A,A1,B);
		showData(A,A1,B);
		
		// A + A1 = A2
		int[][] A2 = new int[2][3];
		addMatrix(A,A1,A2);
		

		// A * B = C
		int[][] C = new int[2][4];
		multiplyMatrix(A,B,C);

	}

}
