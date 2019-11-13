import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTra {
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while(cur!= null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()){
                break;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            cur = temp.right;
        }
        return list;
    }
}
