package AIgorithm;


public class Arrangement {
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12}};	
		int[][] brr = {{1,2,3},
						{5,6,7},
						{9,10,11},
						{12,13,14}};	
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		int sum5 = 0;
		int sum6 = 0;
		int sum7 = 0;
		int sum8 = 0;
		int sum9 = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				for(int k = 0; k < brr.length; k++) {
					for(int o = 0; o < brr[k].length; o++) {
						if(i == 0 && j == k && o == 0 ) {
							int ax1 = arr[i][j] * brr[k][o];
							sum1 = sum1 + ax1;
							}else if(i == 0 && j == k && o == 1) {
								int ax2 = arr[i][j] * brr[k][o];
								sum2 = sum2 + ax2;
							}else if(i == 0 && j == k && o == 2) {
								int ax3 = arr[i][j] * brr[k][o];
								sum3 = sum3 + ax3;
							}else if(i == 1 && j == k && o == 0) {
								int ax4 = arr[i][j] * brr[k][o];
								sum4 = sum4 + ax4;
							}else if(i == 1 && j == k && o == 1) {
								int ax5 = arr[i][j] * brr[k][o];
								sum5 = sum5 + ax5;
							}else if(i == 1 && j == k && o == 2) {
								int ax6 = arr[i][j] * brr[k][o];
								sum6 = sum6 + ax6;
							}else if(i == 2 && j == k && o == 0) {
								int ax7 = arr[i][j] * brr[k][o];
								sum7 = sum7 + ax7;
							}else if(i == 2 && j == k && o == 1) {
								int ax8 = arr[i][j] * brr[k][o];
								sum8 = sum8 + ax8;
							}else if(i == 2 && j == k && o == 2) {
								int ax9 = arr[i][j] * brr[k][o];
								sum9 = sum9 + ax9;
							}
						}
					}
				}
			}
			System.out.println(sum1+","+sum2+","+sum3);
			System.out.println(sum4+","+sum5+","+sum6);
			System.out.println(sum7+","+sum8+","+sum9);
	}	

}
