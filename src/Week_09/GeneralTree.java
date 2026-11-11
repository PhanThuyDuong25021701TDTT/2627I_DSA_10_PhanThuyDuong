package Week_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Lớp đại diện cho một Node trong cây
class Node {
    String data;
    int parentIndex;
    int firstChildIndex;
    int nextSiblingIndex;

    public Node(String data) {
        this.data = data;
        this.parentIndex = -1;       // -1 nghĩa là chưa có (Null)
        this.firstChildIndex = -1;
        this.nextSiblingIndex = -1;
    }
}

public class GeneralTree {
    private List<Node> nodes;

    public GeneralTree() {
        nodes = new ArrayList<>();
    }

    // Hàm thêm Node mới vào mảng
    public void addNode(String data) {
        nodes.add(new Node(data));
    }

    // Hàm thêm cạnh (Thiết lập quan hệ Cha - Con)
    public void addEdge(int parentIdx, int childIdx) {
        if (parentIdx < 0 || parentIdx >= nodes.size() || childIdx < 0 || childIdx >= nodes.size()) {
            System.out.println("Chỉ số (Index) không hợp lệ!");
            return;
        }

        Node parent = nodes.get(parentIdx);
        Node child = nodes.get(childIdx);

        // Đặt cha cho con
        child.parentIndex = parentIdx;

        // Xử lý con trưởng và em liền kề
        if (parent.firstChildIndex == -1) {
            // Nếu cha chưa có con, thì đây là con trưởng
            parent.firstChildIndex = childIdx;
        } else {
            // Nếu cha đã có con, duyệt tìm đứa con út để gán làm em liền kề
            int currentChildIdx = parent.firstChildIndex;
            while (nodes.get(currentChildIdx).nextSiblingIndex != -1) {
                currentChildIdx = nodes.get(currentChildIdx).nextSiblingIndex;
            }
            nodes.get(currentChildIdx).nextSiblingIndex = childIdx;
        }
    }

    // 1. Phép toán: Tìm bố
    public void findParent(int nodeIdx) {
        if (nodeIdx < 0 || nodeIdx >= nodes.size()) {
            System.out.println("Node không tồn tại.");
            return;
        }
        int pIdx = nodes.get(nodeIdx).parentIndex;
        if (pIdx != -1) {
            System.out.println("=> BỐ của [" + nodes.get(nodeIdx).data + "] là: " + nodes.get(pIdx).data + " (Index: " + pIdx + ")");
        } else {
            System.out.println("=> [" + nodes.get(nodeIdx).data + "] là gốc, không có bố.");
        }
    }

    // 2. Phép toán: Tìm con trưởng
    public void findFirstChild(int nodeIdx) {
        if (nodeIdx < 0 || nodeIdx >= nodes.size()) {
            System.out.println("Node không tồn tại.");
            return;
        }
        int fcIdx = nodes.get(nodeIdx).firstChildIndex;
        if (fcIdx != -1) {
            System.out.println("=> CON TRƯỞNG của [" + nodes.get(nodeIdx).data + "] là: " + nodes.get(fcIdx).data + " (Index: " + fcIdx + ")");
        } else {
            System.out.println("=> [" + nodes.get(nodeIdx).data + "] là node lá, không có con trưởng.");
        }
    }

    // 3. Phép toán: Tìm em liền kề
    public void findNextSibling(int nodeIdx) {
        if (nodeIdx < 0 || nodeIdx >= nodes.size()) {
            System.out.println("Node không tồn tại.");
            return;
        }
        int nsIdx = nodes.get(nodeIdx).nextSiblingIndex;
        if (nsIdx != -1) {
            System.out.println("=> EM LIỀN KỀ của [" + nodes.get(nodeIdx).data + "] là: " + nodes.get(nsIdx).data + " (Index: " + nsIdx + ")");
        } else {
            System.out.println("=> [" + nodes.get(nodeIdx).data + "] không có em liền kề.");
        }
    }

    // Hàm tiện ích: In ra bảng biểu diễn mảng để dễ hình dung
    public void printTable() {
        System.out.println("\n BẢNG BIỂU DIỄN TRONG BỘ NHỚ ");
        System.out.printf("%-7s | %-10s | %-7s | %-12s | %-12s\n", "Index", "Giá trị", "Bố", "Con trưởng", "Em liền kề");
        System.out.println("");
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            System.out.printf("%-7d | %-10s | %-7d | %-12d | %-12d\n", i, n.data, n.parentIndex, n.firstChildIndex, n.nextSiblingIndex);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GeneralTree tree = new GeneralTree();

        System.out.println(" CHƯƠNG TRÌNH KHỞI TẠO CÂY TỔNG QUÁT ");

        // 1. Nhập số lượng và thông tin Node
        System.out.print("Nhập tổng số node có trong cây: ");
        int n = sc.nextInt();
        sc.nextLine(); // Xóa bộ đệm

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên/giá trị cho Node " + i + ": ");
            tree.addNode(sc.nextLine());
        }

        // 2. Nhập các cạnh (Quan hệ Cha - Con)
        System.out.print("\nNhập số lượng cạnh (quan hệ cha-con): ");
        int e = sc.nextInt();
        System.out.println("Nhập các cạnh theo cú pháp: <Index_Bố> <Index_Con> (cách nhau bởi dấu cách)");
        for (int i = 0; i < e; i++) {
            System.out.print("Cạnh thứ " + (i + 1) + ": ");
            int parentIdx = sc.nextInt();
            int childIdx = sc.nextInt();
            tree.addEdge(parentIdx, childIdx);
        }

        // 3. In ra bảng kết quả cấu trúc mảng
        tree.printTable();

        // 4. Menu chức năng kiểm tra các phép toán
        int choice;
        do {
            System.out.println("\nMENU CÁC PHÉP TOÁN");
            System.out.println("1. Tìm bố");
            System.out.println("2. Tìm con trưởng");
            System.out.println("3. Tìm em liền kề");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng (0-3): ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Nhập Index của Node cần tìm: ");
                int searchIdx = sc.nextInt();

                System.out.println("");
                if (choice == 1) tree.findParent(searchIdx);
                else if (choice == 2) tree.findFirstChild(searchIdx);
                else if (choice == 3) tree.findNextSibling(searchIdx);
                System.out.println("");
            }
        } while (choice != 0);

        System.out.println("Đã thoát chương trình!");
        sc.close();
    }
}