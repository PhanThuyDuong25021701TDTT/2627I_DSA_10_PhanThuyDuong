package Week_09;

public class insertInterative {
    public static Node insertIterative(Node root, int data) {
        Node newNode = new Node(data);
        // Trường hợp cây rỗng
        if (root == null) {
            return newNode;
        }

        Node current = root;
        Node parent = null;

        // Tìm vị trí cần chèn
        while (current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                // Giá trị đã tồn tại trong BST (nếu bài toán không chấp nhận trùng)
                return root;
            }
        }

        // Chèn node mới vào vị trí con thích hợp của parent
        if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }
}
