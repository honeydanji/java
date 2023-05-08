package chap3_BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class StringArray{	

	private static void showData(String[] data) {
		for(String d : data) {
			System.out.print(d + " ");
		}
	}
	
	private static void sortData(String[] data) {
		for (int i = 0; i < data.length - 1; i++) {
		    for (int j = 0; j < data.length - i - 1; j++) {
		        if (data[j].compareTo(data[j+1]) > 0) {
		            String temp = data[j];
		            data[j] = data[j+1];
		            data[j+1] = temp;
		        }
		    }
		}
	}
	
	private static int linearSearch(String[] data, String key) {
		int i = 0;
		
		while(i < data.length) {
			if(data[i] == key) {
				return i;
			}else {
				i++;
			}
		}
		return -1;
	}
	
	private static int binarySearch(String[] data, String key) {
		int first = 0;
		int last = data.length;
		int mid = data.length / 2;
		
		while(first <= last) {
			if(data[mid] == key) {
				return mid;
			}else if(data[mid].compareTo(key) > 0) {
				mid = mid/2;
			}else if(data[mid].compareTo(key) < 0) {
				mid = (mid + last)/2;
			}
		}
		
		return 0;
	}

	
	
	
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "감", "배", "사과", "포도", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		System.out.print("정렬 전 : ");
		showData(data);
		System.out.println(" ");
		sortData(data);
		System.out.print("정렬 후 : ");
		showData(data);
		System.out.println(" ");
		
		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = "melon";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
		
	}

}
