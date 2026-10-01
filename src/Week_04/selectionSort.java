package Week_04;

public class selectionSort {
    public static void selectionSort(int[] a, int n){
        for (int i=1; i<= n-1; i++){
            int min= a[i];
            int index=i;
            for (int j=i+1; j<=n; j++) {
                if (min > a[j]) {
                    min = a[j];
                    index = j;
                }
            }
            int tmp = a[i];
            a[i] =  a[index];
            a[index] = tmp;
        }
    }
}
