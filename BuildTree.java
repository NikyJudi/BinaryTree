public class BuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelp(preorder, inorder, 0, inorder.length);
    }
    public TreeNode buildTreeHelp(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (index > preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder, left, right, root.val);
        root.left = buildTreeHelp(preorder, inorder, left, pos);
        root.right = buildTreeHelp(preorder, inorder, pos + 1, right);
        return root;
    }
    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
