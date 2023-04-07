package AIgorithm;

public class Leapear {
	
	public static void main(String[] args) {
		
		int[] arr = new int[40];
		int i = 0;
		
		for(int a = 2023; ; a++) {
			if(a % 4 == 0 && a % 100 != 0) {
				arr[i] = a;
				System.out.println(arr[i]);
				i++;
			}else if((a % 4 == 0 && a % 100 == 0 && a % 400 == 0)){
				arr[i] = a;
				System.out.println(arr[i]);
				i++;
			}
			
			if (i == 40)
				break;
		}
		
//		for(int i = 0; i <= arr.length; i++) {
//			if(a % 4 == 0 && a % 100 != 0) {
//				arr[i] = a;
//				System.out.println(arr[i]);
//				a++;
//			}else if((a % 4 == 0 && a % 100 == 0 && a % 400 == 0)){
//				arr[i] = a;
//				System.out.println(arr[i]);
//				a++;
//			}else {
//				a++;
//				i--;
//			}
//		}
		
		
		
		//	System.out.println("배열:" + arr);
		
		/*
		for(int j:arr) {
			System.out.println(j);
		}
		*/
	}

}
