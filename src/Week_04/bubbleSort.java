package Week_04;

public class bubbleSort {
    public static void bubble(int[] a, int n){
        for (int i=1; i<= n-1; i++){
            for (int j =1 ; j<= n-1 ;j++){
                if ( a[j] > a[ j +1]){
                    int tmp = a[j];
                    a[j]= a[j+1];
                    a[j+1]= tmp;
                }
            }
        }
    }
}
