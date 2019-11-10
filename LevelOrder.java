import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    //给定二叉树: [3,9,20,null,null,15,7]
    //层序遍历，结果：
    // [
    //  [3],
    //  [9,20],
    //  [15,7]
    //]
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        helper(root, 0);
        return list;
    }
    public void helper (TreeNode root, int level) {
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null ){
            helper(root.right, level + 1);
        }
    }
}
