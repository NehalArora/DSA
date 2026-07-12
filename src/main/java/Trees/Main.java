package Trees;
import java.util.Scanner;

public class Main {

    /**
     * It is a recursive function to build a tree
     * */
    public Node buildTree(Node node){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the node data");
        int data = sc.nextInt();
        Node root = new Node(data);

        if(data == -1) return null;

        System.out.println("Enter the left node value");
        root.left = buildTree(root.left);

        System.out.println("Enter the right node value");
        root.right = buildTree(root.right);

        return root;
    }
}
