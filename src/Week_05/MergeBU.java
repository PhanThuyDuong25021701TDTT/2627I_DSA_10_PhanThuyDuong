package Week_05;

import java.util.Scanner;

public class MergeBU {
    public static void merge( Comparable[] a,Comparable[] aux, int lo, int mid, int hi){
        for ( int k = lo; k<=hi; k++){
            aux[k]= a[k];
        }
        int i=lo,j= mid +1;
        for ( int k= lo; k<= hi; k++){
            if (i>mid){
                a[k]= aux[j++];
            }
            else if( j> hi){
                a[k]= aux[i++];
            }
            else if ( less(aux[j], aux[i])){
                a[k]= aux[j++];
            }
            else{
                a[k]= aux[i++];
            }
        }
    }
    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void sort(Comparable[] a){
        int N= a.length;
        Comparable[] aux= new Comparable[N];
        for ( int sz =1; sz< N; sz=sz+sz){
            for ( int lo= 0 ; lo < N-sz; lo +=sz+sz){
                int mid = lo +sz -1;
                int hi= Math. min(lo +sz+sz -1,N -1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }
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

        // 4. Sắp xếp Bottom-Up
        sort(a);

        // 5. Hiển thị mảng đã sắp xếp
        System.out.print("Mảng sau khi sắp xếp (MergeBU): ");
        show(a);

        scanner.close();
    }
}
