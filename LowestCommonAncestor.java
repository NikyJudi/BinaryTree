public class LowestCommonAncestor {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        helper(root, p, q);
        return lca;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int mid = (p == root || q == root) ? 1 : 0;
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        if (mid + left + right >= 2) {
            lca = root;
        }
        return mid + left + right > 0;
    }
}
