import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    //完全二叉树判定
    public boolean isComplete(TreeNode root){
        if (root == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                flag = true;
                continue;
            }
            if (flag) {
                return false;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return true;
    }
}
