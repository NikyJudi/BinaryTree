import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal {
    public void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.println(tmp.val + "");
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
    }
    public static void main(String[] args) {
        LevelTraversal text = new LevelTraversal();
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
        text.levelTraversal(A);
    }
}
