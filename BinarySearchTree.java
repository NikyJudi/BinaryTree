public class BinarySearchTree {
     class Node{
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

         @Override
         public String toString() {
             return "{" +
                     "key=" + key +
                     ", value=" + value +
                     '}';
         }
     }
    public  Node root = null;
    public  Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
    public  boolean put(int key, int value) {
        //key 在树中已经存在，插入失败.或者：
        //key 在树中已经存在，直接修改 val
        if (root == null) {
            root = new Node(key, value);
            return true;
        }
        Node cur = root;
        Node par = null;
        while (cur != null) {
            if (key == cur.key) {
                return false;
            } else if (key < cur.key) {
                par = cur;
                cur = cur.left;
            } else {
                par = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key, value);
        if (key < par.key) {
            par.left = node;
        } else {
            par.right = node;
        }
        return true;
    }

    public Integer remove(int key) {
        Node par = null;
        Node cur = root;
        while (cur != null) {
            if (cur.key == key) {
                //找到这个节点了
                int n = cur.value;
                deleteNode(cur, par);
                return n;
            } else if (cur.key > key) {
                par = cur;
                cur = cur.left;
            } else {
                par = cur;
                cur = cur.right;
            }
        }
        return null;
    }

    private void deleteNode(Node cur, Node parent) {
        //真正做删除处理
        if (cur.left == null) {
            //被删除节点cur的左子树为空
            //1.cur是root
            if (cur == root) {
                root = cur.right;
            }else if (cur == parent.left) {//2.cur是parent的左孩子
                parent.left = cur.right;
            }else {//3.cur是parent的右孩子
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            //被删除节点cur的右子树为空
            //1.cur是root
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {//2.cur是parent的左孩子
                parent.left = cur.left;
            } else {//3.cur是parent的右孩子
                parent.right = cur.left;
            }
        }else {
            //cur左右子树都不为空
            //找到cur右子树中序遍历的第一个节点
            // 用这个节点
            Node cur2 = cur;
            Node temp = cur.right;
            while (temp.left != null) {
                cur2 = temp;
                temp = cur2.left;
            }
            //循环完成，temp为右子树最小值，cur2为temp的父亲节点
            cur.key = temp.key;
            cur.value = temp.value;
            //复制完成
            //判断temp节点是父亲节点的左子树还是右子树
            if (temp == cur2.left) {
                cur2.left = temp.right;
            } else {
                cur2.right = temp.right;
            }
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = {9,5,2,7,3,6,8};
        for (int x: arr) {
            tree.put(x, 0);
        }
        System.out.println(tree.search(2));
        System.out.println(tree.remove(2));
        System.out.println(tree.search(2));
    }

}
