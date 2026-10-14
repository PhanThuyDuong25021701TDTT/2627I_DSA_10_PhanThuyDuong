package Week_05;

import java.util.Scanner;

public class Merge_1 {
    private static final int CUTOFF = 7;
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {

            }
        }
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sort(Comparable[] a){
        Comparable[] aux= new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }
    private static void sort (Comparable[] a, Comparable[] aux, int lo, int hi){

        if (hi <= lo + CUTOFF - 1) {
            insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort (a, aux, lo, mid);
        sort (a, aux, mid+1, hi);
        merge(a, aux, lo ,mid ,hi);
    }
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];       // 1. Nửa trái hết -> lấy bên phải (j++)
            } else if (j > hi) {
                a[k] = aux[i++];       // 2. Nửa phải hết -> lấy bên trái (i++)
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];       // 3. Số bên phải nhỏ hơn -> lấy bên phải (j++)
            } else {
                a[k] = aux[i++];       // 4. Số bên trái nhỏ hơn hoặc bằng -> lấy bên trái (i++)
            }
        }
    }
    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Hàm in các phần tử trong mảng ra màn hình
    private static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập số lượng phần tử
        System.out.print("Nhập số lượng phần tử n = ");
        int n = scanner.nextInt();

        // Sử dụng Integer (Wrapper class) thay cho int để tương thích với Comparable
        Integer[] a = new Integer[n];

        // 2. Nhập từng phần tử
        System.out.println("Nhập " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử [" + i + "] = ");
            a[i] = scanner.nextInt();
        }

        // 3. Hiển thị mảng ban đầu
        System.out.print("\nMảng ban đầu: ");
        show(a);

        // 4. Sắp xếp mảng
        sort(a);

        // 5. Hiển thị mảng đã sắp xếp
        System.out.print("Mảng sau khi sắp xếp: ");
        show(a);

        scanner.close();
    }
}
