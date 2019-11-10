import java.util.Scanner;

public class StringToTree {
    static class Node{
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    private static int index = 0;
    public static Node buildTree(String line) {
        index = 0;
        return creatTreePre(line);
    }
    public static Node creatTreePre(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        Node root = new Node(c);
        index++;
        root.left = creatTreePre(line);
        index++;
        root.right = creatTreePre(line);
        return root;
    }
    public static void printInOrder (Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            Node root = buildTree(line);
            printInOrder(root);
            System.out.println();
        }
    }
}
