import java.util.Scanner;

public class InsertionSort {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array ");
		int cnt = sc.nextInt();
		System.out.println("enter elements");
		int[] arr = new int[cnt];
		for (int loopCnt = 0; loopCnt < cnt; loopCnt++) {
			arr[loopCnt] = sc.nextInt();
		}

		for (int i = 1; i < cnt; i++) {
			for (int k = i; k > 0; k--) {
				if (arr[k] < arr[k - 1]) {
					int tmp = arr[k];
					arr[k] = arr[k - 1];
					arr[k - 1] = tmp;
				}
			}
			System.out.println();
			for (int loopCnt = 0; loopCnt < cnt; loopCnt++) {
				System.out.print(arr[loopCnt]+"-");
			}

		}
	}
}
