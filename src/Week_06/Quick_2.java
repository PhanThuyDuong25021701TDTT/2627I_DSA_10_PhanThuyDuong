package Week_06;

import java.util.Scanner;

public class Quick_2 {
    public static void quickSort(int[] ar, int low, int high) {
        if (low < high) {
            int p = partition(ar, low, high);
            printArray(ar);
            quickSort(ar, low, p - 1);
            quickSort(ar, p + 1, high);
        }
    }

    public static int partition(int[] ar, int low, int high) {
        int pivot = ar[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (ar[j] <= pivot) {
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
            }
        }

        int temp = ar[i];
        ar[i] = ar[high];
        ar[high] = temp;

        return i;
    }

    public static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + (i == ar.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        quickSort(ar, 0, n - 1);
        sc.close();
    }
}
