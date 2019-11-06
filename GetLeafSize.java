public class GetLeafSize {
    //求叶子节点
    public int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left ==null && root.right ==null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    public static void main(String[] args) {
        GetLeafSize text = new GetLeafSize();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        System.out.println(text.getLeafSize(A));
    }
}
