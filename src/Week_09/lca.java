package Week_09;

public class lca {
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        // Nếu cả v1 và v2 đều nhỏ hơn root, tìm ở cây con bên trái
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        // Nếu cả v1 và v2 đều lớn hơn root, tìm ở cây con bên phải
        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        // Điểm phân nhánh chính là Lowest Common Ancestor
        return root;
    }
}
