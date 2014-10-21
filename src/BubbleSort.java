import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

	// number of pass can vary from 1 to (n-1)
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		System.out.println("Enter elements");
		for (int loopCnt = 0; loopCnt < cnt; loopCnt++) {
			arr[loopCnt] = sc.nextInt();
		}
		int i;
		int arrSize = arr.length;
		int tmp;
		int passCnt = 1;
		int sizeCnter = cnt;

		while (passCnt <= cnt) {
			boolean flag = false;
			for (int k = 0; k < sizeCnter-1; k++) {
				if (arr[k] > arr[k + 1]) {
					tmp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = tmp;
					flag = true;
				}
			}
			if (flag) {
				System.out.print("\npass number :" + passCnt+" - ");
				for (int j = 0; j < cnt; j++) {
					System.out.print(arr[j] + " ");
				}
				passCnt++;
			} else {
				System.out.print("\npass number :" + passCnt+" - ");
				for (int j = 0; j < cnt; j++) {
					System.out.print(arr[j] + " ");
				}
				passCnt++;
				break;
			}
			sizeCnter--;
		}
		System.out.print("\nTotal number of passes :"+(passCnt-1));
	}
}
