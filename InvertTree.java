public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null ||
                (root.left == null && root.right == null) ) {
            return root;
        }
        if (root.left == null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        } else {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        invertTree(root);
    }
}
