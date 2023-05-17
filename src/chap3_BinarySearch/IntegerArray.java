package chap3_BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class IntegerArray {
	
	private static void inputData(int[] data) {
		Random rd = new Random();
		
		for(int i = 0; i < data.length; i++) {
			data[i] = rd.nextInt(100);
		}
	}

	private static void showData(int[] data) {
		
		System.out.print("showData : ");
		for(int d : data) {
			System.out.print(d + " ");
		}
	}
	
	private static void sortData(int[] data) {
		
		System.out.print("\nsortData : ");
		int temp = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data.length; j++) {
				if(data[i] < data[j]) {
					temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}
	}
	
	private static int linearSearch(int[] data, int key) {
		int i = 0;
		
		while(i < data.length) {
			if(data[i] == key) {
				return i;
			}
			else {
				i++;
			}
		}
		return -1;
	}
	
	private static int binarySearch(int[] data, int key) {
		int left = 0;
		int right = data.length - 1;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if (data[mid] < key) left = mid + 1;
			else if (data[mid] > key) right = mid - 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		
		for(int num : data) {
			System.out.print(num + " ");
		}
		
		int key = 25;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}


}
