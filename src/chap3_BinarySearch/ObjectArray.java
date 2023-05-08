package chap3_BinarySearch;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String string, int i, double d) {
		this.name = string;
		this.height = i;
		this.vision = d;
	}
	
	@Override
	public String toString() {
		return "name : " + name + ", height : " + height + ", vision : " + vision;
	}


	@Override
	public int compareTo(PhyscData pd) {
		int result = this.name.compareTo(pd.name);	// 양수 음수 판단
		
		if (result == 0) {	// 문자열 비교값이 같을 때 
			int hresult = this.height - pd.height;
			if (hresult == 0) {
				return (int) (this.vision - pd.vision);
			} else
				return hresult;
		} else
			return result;	// -1 or 1
	}
}

public class ObjectArray {
	
	private static void showData(PhyscData[] data) {
		for(PhyscData d : data) {
			System.out.println(d.toString());
		}
	}

	private static void sortData(PhyscData[] data) {
		if(data[0].compareTo(data[1]) == 1) {
			
		}else if(data[0].compareTo(data[1]) == -1) {
			
		}
	}


	private static int binarySearch(PhyscData[] data, PhyscData key) {
		return 0;
	}

	private static int linearSearch(PhyscData[] data, PhyscData key) {
		return 0;
	}

	public static void main(String[] args) {
		PhyscData[] data = { // 객체가 만들어지는 순간 생성자로 인해 모든 값이 저장된다. 생성자의 수만큼 인스턴스가 생성되기 때문이다. 
				new PhyscData("홍길동", 162, 0.3), 
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), 
				new PhyscData("김홍길동", 172, 0.3), 
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), 
				new PhyscData("길동", 167, 0.5), };

		System.out.println("정렬 전 객체 배열 : ");
		showData(data);
		
		sortData(data);
		System.out.println("" );
		
		System.out.println("정렬 후 객체 배열 : ");
		showData(data);
		
		
//		PhyscData key = new PhyscData("길동", 167, 0.2);
//		int result = linearSearch(data, key);
//		System.out.println("\nlinearSearch(): result = " + result);
//		key = new PhyscData("길동", 167, 0.5);
//
//		result = binarySearch(data, key);
//		System.out.println("\nbinarySearch(): result = " + result);
//		int idx = Arrays.binarySearch(data, key);
//		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}
	
}

