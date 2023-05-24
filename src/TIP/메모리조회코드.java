package TIP;

public class 메모리조회코드 {
	public static void main(String args[]) {
		
		// 시작 메모리 조회
		System.gc();
		long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println(before);
		
		
		/*
		 * 코드
		 * 코드
		 * 코드
		 * 코드
		 * 코드
		 * */
		
		
		// 코드 실행 후 메모리 조회
		System.gc();
		long after  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println(after);
		
		
		// 메모리가 얼마나 남아있는 지 조회
		long usedMemory = (before - after)/1024/1024;
		System.out.println("Used Memory : " + usedMemory);
	}
}
