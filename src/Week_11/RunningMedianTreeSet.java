package Week_11;

import java.util.*;

public class RunningMedianTreeSet {

    // Lớp lưu trữ giá trị và chỉ số để phân biệt các số trùng nhau
    static class Node implements Comparable<Node> {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            if (this.value != other.value) {
                return Integer.compare(this.value, other.value);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        TreeSet<Node> treeSet = new TreeSet<>();

        // Hai con trỏ duy trì vị trí trung vị
        // Nếu số lượng phần tử lẻ: leftMid == rightMid
        // Nếu số lượng phần tử chẵn: leftMid và rightMid là 2 phần tử đứng giữa
        Node leftMid = null;
        Node rightMid = null;

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            Node newNode = new Node(val, i);
            treeSet.add(newNode);

            if (i == 0) {
                // Phần tử đầu tiên
                leftMid = newNode;
                rightMid = newNode;
            } else if (treeSet.size() % 2 == 0) {
                // Trước khi thêm là LẺ (leftMid == rightMid), sau khi thêm thành CHẴN
                if (newNode.compareTo(leftMid) < 0) {
                    leftMid = treeSet.lower(leftMid);
                } else {
                    rightMid = treeSet.higher(rightMid);
                }
            } else {
                // Trước khi thêm là CHẴN (leftMid < rightMid), sau khi thêm thành LẺ
                if (newNode.compareTo(leftMid) < 0) {
                    rightMid = leftMid;
                } else if (newNode.compareTo(rightMid) > 0) {
                    leftMid = rightMid;
                } else {
                    // newNode nằm lọt vào giữa leftMid và rightMid
                    leftMid = newNode;
                    rightMid = newNode;
                }
            }

            // Tính và in ra trung vị với 1 chữ số thập phân
            double median = (leftMid.value + rightMid.value) / 2.0;
            System.out.printf("%.1f\n", median);
        }

        scanner.close();
    }
}
