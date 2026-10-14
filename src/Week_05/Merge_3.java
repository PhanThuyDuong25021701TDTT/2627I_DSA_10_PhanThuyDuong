package Week_05;

import java.util.Scanner;

public class Merge_3 {

    public static void sort(Comparable[] a) {
        // [CẢI TIẾN 3 - SỬA LỖI 1] Phải clone mảng a sang aux ngay từ đầu
        Comparable[] aux = a.clone();

        // [CẢI TIẾN 3 - SỬA LỖI 2] Truyền aux làm src (nguồn), a làm dst (đích)
        sort(aux, a, 0, a.length - 1);
    }

    // sort(src, dst, lo, hi): Sắp xếp dữ liệu từ mảng src và ghi kết quả vào mảng dst
    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        // [CẢI TIẾN 3] Đảo vai trò src và dst ở tầng đệ quy tiếp theo
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);

        // Trộn từ src sang dst
        merge(src, dst, lo, mid, hi);
    }

    // merge(src, dst): Đọc dữ liệu từ src, trộn và ghi trực tiếp vào dst (không cần copy)
    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dst[k] = src[j++];
            } else if (j > hi) {
                dst[k] = src[i++];
            } else if (less(src[j], src[i])) {
                dst[k] = src[j++];
            } else {
                dst[k] = src[i++];
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Hàm in các phần tử trong mảng ra màn hình
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

        // 4. Sắp xếp mảng
        sort(a);

        // 5. Hiển thị mảng đã sắp xếp
        System.out.print("Mảng sau khi sắp xếp: ");
        show(a);

        scanner.close();
    }
} 