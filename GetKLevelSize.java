public class GetKLevelSize {
    public Integer getKLevelSize(TreeNode root, int k) {
        //第k层的节点数
        if (root == null) {
            return 0;
        }
        if (k < 0 ) {
            return null;
        }
        if (k > getDepth(root)) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }
    public int getDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right ==null){
            return 1;
        }
        return 1 + Math.max(getDepth(root.right), getDepth(root.left));
    }
    public static void main(String[] args) {
        GetKLevelSize text = new GetKLevelSize();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = D;
        A.right = B;
        B.left = E;
        B.right = C;
        E.left = F;
        F.right = G;
        System.out.println(text.getKLevelSize(A, 6));
    }
}
