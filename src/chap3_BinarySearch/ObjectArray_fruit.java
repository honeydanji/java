package chap3_BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

class Fruit implements Comparator {
	String name;
	int price;
	String data;

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}

	public Fruit(String name, int price, String data) {
		this.name = name;
		this.price = price;
		this.data = data;
	}

	@Override
	public String toString() {
		return "name:" + this.name + " pric:" + this.price + " data:" + this.data;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

}

public class ObjectArray_fruit {

	public static void showData(Fruit[] arr) {
		for (Fruit a : arr) {
			System.out.println(a.toString());
		}
	}

	private static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<Fruit> cc_name) {
		int first = 0;
		int last = arr.length - 1;

		while (first <= last) {
			int mid = (first + last) / 2;
			int cmp = cc_name.compare(arr[mid], newFruit);
			if (cmp == 0) {
				return mid;
			} else if (cmp < 0) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;

	}

	private static void sortData(Fruit[] arr, Comparator<Fruit> cc_price) {
		Fruit temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int ccp = cc_price.compare(arr[i], arr[j]);
				if (ccp > 0) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		Fruit[] arr = { 
				new Fruit("사과", 200, "2023-5-8"), 
				new Fruit("키위", 500, "2023-6-8"),
				new Fruit("오렌지", 200, "2023-7-8"),
				new Fruit("바나나", 50, "2023-5-18"), 
				new Fruit("수박", 880, "2023-5-28"),
				new Fruit("체리", 10, "2023-9-8") };

		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		System.out.println();

		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("람다식 정렬(가격)후 객체 배열: ");
		showData(arr);
		System.out.println();

		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});

		System.out.println("comparator 정렬(이름)후 객체 배열: ");
		showData(arr);

		Comparator<Fruit> cc_name = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.name.compareTo(o2.name);
			}// 익명클래스 사용

		};

		Comparator<Fruit> cc_price = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.price - o2.price;
			}// 익명클래스 사용

		};

		Fruit newFruit = new Fruit("체리", 500, "2023-5-18"); // 생성자
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\nArrays.binarySearch() 조회결과: " + result3);

		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과: " + result3);
		System.out.println();
		
		sortData(arr, cc_price);
		System.out.println("comparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
	}

	static void showData(PhyscData[] arr) {
		System.out.println();
		for (PhyscData fruit : arr) {
			System.out.print(fruit + " ");
		}
		System.out.println();
	}
}
