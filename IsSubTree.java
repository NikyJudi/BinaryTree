public class IsSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret =false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        if (!ret) {
            ret = isSubtree(s.left, t);
        }
        if (!ret) {
            ret = isSubtree(s.right, t);
        }
        return ret;
    }
    public boolean isSameTree (TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
