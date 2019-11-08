import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    //完全二叉树判定
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            //层序遍历
            TreeNode cur = queue.poll();
            if (!flag) {
                //遍历过程中：
                if (cur.left != null && cur.right != null) {
                    //每个节点都有两个子树

                    //层序遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if (cur.left == null && cur.right != null) {
                    //存在一个节点只有右子树，那么肯定不是完全二叉树
                    return false;
                } else if (cur.left != null) {
                    //存在一个节点只有左子树，开始剩下的遍历，准备跳转到最外层 else
                    queue.offer(cur.left);
                    flag = true;
                } else {
                    //存在一个节点没有左右子树，开始剩下的遍历，准备跳转到最外层 else
                    flag = true;
                }
            } else {
                //跳转到这里
                //如果在剩下的遍历过程中，有一个节点有子树，那么肯定也不是完全二叉树
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        //遍历结束，没有不符合的节点，那么就是完全二叉树
        return true;
    }
}
