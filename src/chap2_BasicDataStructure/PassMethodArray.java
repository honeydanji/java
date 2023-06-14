package Chap2_BasicDataStructure;

import java.util.Arrays;
import java.util.Random;

public class PassMethodArray {
	
	static void getData(int[] data) {
		for(int i=0; i < data.length; i++) {
			Random rand = new Random();
			data[i] = rand.nextInt(10);
		}
	}
	
	static void showData(int[] data) {
		for(int i=0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	static int findMax(int[] data) {
		int max = 0;
		for(int i = 0; i < data.length; i++) {
			if(data[i] > max)
				max = data[i];
		}
		return max;
		
	}
	static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	static void sortData(int[] data) {	// 배열을 인자로 받는다.
		//Arrays.sort(data);
		for(int i = 0; i < data.length; i++) {
			for(int j = i+1; j < data.length; j++) {
				if(data[i] > data[j]) {
					swap(data, i, j);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println("\nmax = " + mvalue);
		sortData(data);
		System.out.println();
		System.out.println("정렬 후 결과 : ");
		showData(data);
	}
}

// 난수 : 정의된 범위 내에서 무작위로 추출된 수
