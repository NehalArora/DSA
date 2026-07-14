package Trees;
import java.util.Scanner;

public class Main {

    /**
     * It is a recursive function to build a tree
     * */
    public static Node buildTree(Node node){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the node data: ");
        int data = sc.nextInt();
        Node root = new Node(data);

        if(data == -1) return null;

        System.out.println("Enter the left of node " + root.data + " ->");
        root.left = buildTree(root.left);

        System.out.println("Enter the right node value " + root.data + " ->");
        root.right = buildTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node tree = buildTree(root);

        Traversal t = new Traversal();
        System.out.println("\nLevel Order:");
        t.levelOrder(tree);

        System.out.println("Inorder: " + t.inorder(tree));
        System.out.println("Preorder: " + t.preorder(tree));
        System.out.println("Postorder: " + t.postorder(tree));
    }
}

//1 2 3 -1 -1 4 -1 -1 5 6 -1 -1 7 -1 -1