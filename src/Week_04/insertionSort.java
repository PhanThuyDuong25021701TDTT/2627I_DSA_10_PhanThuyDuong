package Week_04;

public class insertionSort {
    public static void insertionSort( int[] a, int n ){
        for ( int i=2 ; i<= n ; i++) {
            int j = i-1; 
            boolean ok = false;
            int temp = a[i];
            while ( j>= 1 && ! ok){
                if ( a[j]> temp ){
                    a[j+1] = a[j];
                    j--;
                }else {
                    ok= true;
                }
            }
            a[j+1] = temp;
        }
    }
}
