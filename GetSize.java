public class GetSize {
    //节点个数
    public int getSize (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public static void main(String[] args) {
        GetSize text = new GetSize();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(3);
        TreeNode C = new TreeNode(5);
        TreeNode D = new TreeNode(7);
        A.left = B;
        B.right = C;
        B.left = D;
        System.out.println(text.getSize(B));
    }
}
