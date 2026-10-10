package Week_04;

import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] count = new int[100]; // Mảng đếm kích thước 100

            // Đếm tần suất xuất hiện
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                count[num]++;
            }

            // In kết quả
            for (int i = 0; i < 100; i++) {
                System.out.print(count[i] + (i == 99 ? "" : " "));
            }
        }

        scanner.close();
    }
}
