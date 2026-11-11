package Week_09;

public class Insert {
    public static Node Insert(Node root, int data) {
        // Nếu cây rỗng, tạo đỉnh mới và trả về
        if (root == null) {
            return new Node(data);
        }

        // Nếu giá trị cần thêm nhỏ hơn giá trị đỉnh hiện tại -> thêm vào cây con bên trái
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        // Nếu giá trị lớn hơn -> thêm vào cây con bên phải
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }
}
