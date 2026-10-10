import java.util.Scanner;

public class Counting_Sort{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();

        // Mảng đếm kích thước 100, mặc định khởi tạo các giá trị bằng 0
        int[] count = new int[100];

        // Đọc từng phần tử và tăng tần suất xuất hiện
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x >= 0 && x < 100) {
                count[x]++;
            }
        }

        // Dùng StringBuilder để tối ưu việc ghép chuỗi đầu ra
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(count[i]);
            if (i < 99) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
        scanner.close();
    }
}
