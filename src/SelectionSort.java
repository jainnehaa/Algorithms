import java.util.Scanner;

public class SelectionSort {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of elements");
		int cnt = sc.nextInt();

		System.out.println("enter elements");
		int[] arr = new int[cnt];
		for (int loopCnt = 0; loopCnt < cnt; loopCnt++) {
			arr[loopCnt] = sc.nextInt();
		}
		
		for(int i=0;i<cnt-1;i++)
		{
			for(int k=i+1;k<cnt;k++)
			{
				if(arr[i]>arr[k])
				{
					int tmp=arr[k];
					arr[k]=arr[i];
					arr[i]=tmp;
				}
			}
		}
		
		System.out.println("Sorted array");
		for (int loopCnt = 0; loopCnt < cnt; loopCnt++) {
			System.out.print(arr[loopCnt]+" ");
		}
	}
}
