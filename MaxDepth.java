public class MaxDepth {
    //最大深度
    public int maxDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
