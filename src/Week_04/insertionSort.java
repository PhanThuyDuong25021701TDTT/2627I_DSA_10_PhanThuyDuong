package Week_04;

import java.util.Arrays;

public class insertionSort {

    // Thuật toán Insertion Sort chuẩn chỉ số Java (từ 0 đến n-1)
    public static void insertionSort(int[] a, int n) {
        for ( int i=2; i<=n;i++){
            int tmp= a[i];
            int j=i-1;
            boolean ok= false;
            while (j>=1&& !ok){
                if (a[j]>tmp){
                    a[j+1]=a[j];
                    j--;
                }else{
                    ok= true;
                }

            }
            a[j+1]=tmp;

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