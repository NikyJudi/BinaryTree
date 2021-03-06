public class Convert {
//    使用中序遍历, 就能够得到有序序列.
//    把相邻元素相互指向就行了. left 指向前一个元素, right 指向后一个元素
//    递归把左子树变成双向链表, 并返回这个链表的第一个节点
//    如果左侧链表头结点不为 null, 当前左侧链表的尾巴找到,
//    让左侧链表的尾节点和当前 root 节点相互指向.
//    循环结束之后, leftTail 就指向了左侧链表的最后一个节点.
//    要时刻注意, left 可能是 null
//    递归讲右子树也构造成双向链表, 同时也得到右子树链表的第一个节点
//    把右侧链表的头结点和当前节点相互指向
//    返回整个链表的头结点
    //-----汤神
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left =  convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }
}
