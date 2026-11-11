package Week_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// Nút biểu diễn cây Huffman
class Node {
    int data;        // Tần suất xuất hiện
    int index;       // Chỉ số xuất hiện ban đầu (dùng để phá hòa - tie-break)
    Node left, right;

    // Nút lá (biểu diễn 1 ký tự)
    Node(int d, int i) {
        data = d;
        index = i;
        left = right = null;
    }

    // Nút trung gian (kết hợp 2 nút con)
    Node(Node l, Node r) {
        data = l.data + r.data;
        index = Math.min(l.index, r.index);
        left = l;
        right = r;
    }
}

// Bộ so sánh cho Min-Heap (PriorityQueue)
class Compare implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        // Ưu tiên nút có tần suất nhỏ hơn
        if (a.data != b.data) {
            return Integer.compare(a.data, b.data);
        }
        // Nếu tần suất bằng nhau, ưu tiên nút có chỉ số nhỏ hơn
        return Integer.compare(a.index, b.index);
    }
}

class Main {

    // Duyệt cây theo tiền thứ tự (Preorder) để lấy chuỗi mã hóa cho từng ký tự
    static void preOrder(Node root, ArrayList<String> ans, String curr) {
        if (root == null) return;

        // Nếu là nút lá
        if (root.left == null && root.right == null) {
            if (curr.equals("")) curr = "0"; // Trường hợp chỉ có đúng 1 ký tự
            ans.add(curr);
            return;
        }

        preOrder(root.left, ans, curr + '0');
        preOrder(root.right, ans, curr + '1');
    }

    // Hàm tạo cây Huffman và trả về danh sách mã bit
    static ArrayList<String> huffmanCodes(String s, int[] freq) {
        int n = s.length();

        // Min-Heap chứa các nút
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        for (int i = 0; i < n; i++) {
            pq.add(new Node(freq[i], i));
        }

        // Trường hợp chỉ có 1 ký tự duy nhất
        if (n == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }

        // Dựng cây Huffman
        while (pq.size() >= 2) {
            Node l = pq.poll(); // Nút con trái
            Node r = pq.poll(); // Nút con phải

            Node newNode = new Node(l, r);
            pq.add(newNode);
        }

        Node root = pq.peek();
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập dữ liệu đầu vào
        System.out.print("Nhập chuỗi ký tự (ví dụ: abcdef): ");
        String s = sc.nextLine().trim();

        int n = s.length();
        int[] freq = new int[n];

        System.out.println("Nhập tần suất tương ứng cho từng ký tự:");
        for (int i = 0; i < n; i++) {
            System.out.print("Tần suất của '" + s.charAt(i) + "': ");
            freq[i] = sc.nextInt();
        }

        // 2. Tạo mã hóa Huffman
        ArrayList<String> ans = huffmanCodes(s, freq);

        // 3. Hiển thị kết quả và tính Tổng Huffman (Tổng số bit thu được)
        System.out.println("\n--- BẢNG MÃ HUFFMAN ---");
        int totalHuffmanBits = 0;

        for (int i = 0; i < n; i++) {
            String code = ans.get(i);
            int codeLength = code.length();
            int bitContribution = freq[i] * codeLength;
            totalHuffmanBits += bitContribution;

            System.out.printf("Ký tự: '%c' | Tần suất: %d | Mã Bit: %-6s | Số bit chiếm: %d bit\n",
                    s.charAt(i), freq[i], code, bitContribution);
        }

        System.out.println("----------------------------------------");
        System.out.println("TỔNG HUFFMAN (Tổng số bit sau khi nén): " + totalHuffmanBits + " bits");

        sc.close();
    }
}