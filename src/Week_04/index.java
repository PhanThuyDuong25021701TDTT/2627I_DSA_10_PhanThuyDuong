
import java.util.Arrays;
import java.util.Scanner;

public class index {
    public static int index(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = a.length - 1; i >= 0; i--) {

            if (a[i] >= count + 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong bai bao: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Nhap so lan trich dan cua tung bai:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int result = index(a);

        System.out.println("H-index = " + result);
    }
}


