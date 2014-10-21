import java.util.ArrayList;
import java.util.Scanner;

public class BankersAlgorithm {
    static int rows;
    static int columns;
    static int[] P;
    static int[] R;
    static int[] available;
    static int[][] maxAlloc;
    static int[][] alloted;
    static int[][] need;
    static boolean flag;
    static ArrayList<Integer> safeState = new ArrayList<Integer>();
    static ArrayList<Integer> tmp = new ArrayList<Integer>();

    public static void main(String args[]) {

	Scanner sc = new Scanner(System.in);

	System.out.println("enter number of processes");
	rows = sc.nextInt();
	P = new int[rows];

	System.out.println("enter number of Resources");
	columns = sc.nextInt();
	R = new int[columns];

	available = new int[columns];
	System.out.println("enter count of resources which are available");
	for (int i = 0; i < columns; i++) {
	    System.out.println(" R[" + i + "] = ");
	    available[i] = sc.nextInt();
	}

	maxAlloc = new int[rows][columns];
	System.out.println("enter max allocation possible for processes");
	for (int i = 0; i < rows; i++) {
	    System.out.println("for P[" + i + "]");
	    for (int j = 0; j < columns; j++) {
		System.out.print(" and for R[" + j + "] : ");
		maxAlloc[i][j] = sc.nextInt();
	    }
	}

	alloted = new int[rows][columns];
	System.out.println("enter details of resources alloted ");
	for (int i = 0; i < rows; i++) {
	    System.out.println("for P[" + i + "]");
	    for (int j = 0; j < columns; j++) {
		flag = true;
		while (flag) {
		    System.out.print(" and for R[" + j + "] : ");
		    alloted[i][j] = sc.nextInt();
		    if (alloted[i][j] <= maxAlloc[i][j]) {
			flag = false;
		    } else {
			System.out.println("no of resources alloted should be less than or equal to max allocation possible");
			flag = true;
		    }
		}
	    }
	}

	calcNeed();
	safeStateCheck();
	System.out.println("the safe state");
	for (Integer s : safeState) {
	    System.out.print(s + "--");
	}
    }

    public static void calcNeed() {
	need = new int[rows][columns];
	for (int i = 0; i < rows; i++) {
	    System.out.println();
	    for (int j = 0; j < columns; j++) {
		need[i][j] = maxAlloc[i][j] - alloted[i][j];
		if (need[i][j] < 0) {
		    System.out.println("allocated resources cannot exceed max allocation");
		} else {
		    System.out.print(need[i][j] + " ");

		}
	    }
	}

    }

    public static void safeStateCheck() {

	int k = 0;
	while (safeState.size() < rows) {
	    if (safeState.isEmpty() && tmp.isEmpty()) {
		while (k < rows) {
		    flag = true;
		    test(k);
		    if (flag) {
			safeState.add(k);
			for (int j = 0; j < columns; j++) {
			    available[j] = available[j] + alloted[k][j];
			}
			flag = true;
		    } else {
			tmp.add(k);
			flag = true;
		    }
		    k++;
		}
	    } else {
		for (Integer iTmp : tmp) {
		    flag = true;
		    test(iTmp);
		    if (flag) {
			safeState.add(iTmp);
			int a = tmp.indexOf(iTmp);
			tmp.remove(a);
			flag = true;
			break;
		    }
		}
	    }
	}
    }

    public static void test(int var) {
	for (int j = 0; j < columns; j++) {
	    if (need[var][j] > available[j]) {
		flag = false;
		break;
	    }
	}
    }

}
