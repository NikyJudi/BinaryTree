public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        //镜像二叉树
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        return isSymmetric(root.left, root.right) ;
    }
    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
