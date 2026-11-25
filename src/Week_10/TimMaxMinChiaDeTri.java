package Week_10;

import java.util.Scanner;

public class TimMaxMinChiaDeTri {

    // Lớp tĩnh dùng để lưu trữ cặp kết quả Min và Max
    static class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    /**
     * Hàm tìm Min và Max bằng thuật toán Chia để trị
     * @param arr  Mảng số nguyên đầu vào
     * @param low  Chỉ số bắt đầu của đoạn cần xét
     * @param high Chỉ số kết thúc của đoạn cần xét
     * @return Đối tượng Pair chứa giá trị min và max tìm được
     */
    public static Pair findMinMax(int[] arr, int low, int high) {
        // Trường hợp cơ sở 1: Mảng chỉ có 1 phần tử
        if (low == high) {
            return new Pair(arr[low], arr[low]);
        }

        // Trường hợp cơ sở 2: Mảng có 2 phần tử
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                return new Pair(arr[low], arr[high]);
            } else {
                return new Pair(arr[high], arr[low]);
            }
        }

        // Bước 1: Chia (Divide) - Chia mảng thành 2 nửa tại vị trí giữa
        int mid = low + (high - low) / 2;

        // Bước 2: Trị (Conquer) - Đệ quy tìm min, max ở nửa trái và nửa phải
        Pair leftResult = findMinMax(arr, low, mid);
        Pair rightResult = findMinMax(arr, mid + 1, high);

        // Bước 3: Kết hợp (Combine) - So sánh kết quả của 2 nửa để lấy min, max chung
        int overallMin = Math.min(leftResult.min, rightResult.min);
        int overallMax = Math.max(leftResult.max, rightResult.max);

        return new Pair(overallMin, overallMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử của dãy
        System.out.print("Nhập số lượng phần tử của dãy số (n): ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện mảng rỗng hoặc không hợp lệ
        if (n <= 0) {
            System.out.println("Số lượng phần tử phải lớn hơn 0!");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        // Nhập giá trị từng phần tử
        System.out.println("Nhập các phần tử của dãy số:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Gọi hàm tìm Min, Max
        Pair result = findMinMax(arr, 0, n - 1);

        // In kết quả ra màn hình
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Giá trị nhỏ nhất (Min): " + result.min);
        System.out.println("Giá trị lớn nhất (Max): " + result.max);

        scanner.close();
    }
}
