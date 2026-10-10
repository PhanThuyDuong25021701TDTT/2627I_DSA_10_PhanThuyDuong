package Week_04;

import java.util.Arrays;

public class insertionSort {

    // Thuật toán Insertion Sort chuẩn chỉ số Java (từ 0 đến n-1)
    public static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    // Hàm main để chương trình có thể bấm RUN trực tiếp
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        int n = arr.length;

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        insertionSort(arr, n);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
    }
}