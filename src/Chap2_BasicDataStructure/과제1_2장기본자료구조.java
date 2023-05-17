package Chap2_BasicDataStructure;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {

	String name;
	int height;
	double vision;

	public PhyscData(String string, int i, double d) {
		name = string;
		height = i;
		vision = d;
	}

	@Override
	public int compareTo(PhyscData data) {
int result = this.name.compareTo(data.name);	// 양수 음수 판단
		
		if (result == 0) {	// 문자열 비교값이 같을 때 
			int hresult = this.height - data.height;
			if (hresult == 0) {
				return (int) (this.vision - data.vision);
			} else
				return hresult;
		} else
			return result;	// -1 or 1
	}
	

	@Override
	public String toString() {
		return "name : " + name + ", height : " + height + ", vision : " + vision;
	}

	static void showData(PhyscData[] data) {
		for (PhyscData datas : data) {
			System.out.println(datas.toString());
		}
	}

	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i].compareTo(data[j]) == 0) {
					if (data[i].height - data[j].height == 0) {
						if (data[i].vision - data[j].vision < 0) {
							PhyscData temp = data[j];
							data[j] = data[i];
							data[i] = temp;
						}
					} else if (data[i].height - data[j].height < 0) {
						PhyscData temp = data[j];
						data[j] = data[i];
						data[i] = temp;
					}
				} else if (data[i].compareTo(data[j]) < 0) {
					PhyscData temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}
	}

}

public class 과제1_2장기본자료구조 {

	public static void main(String[] args) {
		PhyscData[] data = { 
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5), };

		
		PhyscData.showData(data);
		System.out.println();
		PhyscData.sortData(data);
		System.out.println();
		PhyscData.showData(data);
	}
}



// comparator 과 compareble의 차이점

