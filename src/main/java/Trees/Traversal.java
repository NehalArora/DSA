package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    public List<Integer> inorder(Node root){
        List<Integer> ans = new ArrayList<>();
        inorderHelper(root,ans);
        return ans;
    }
    public List<Integer> preorder(Node root){
        List<Integer> ans = new ArrayList<>();
        preorderHelper(root,ans);
        return ans;
    }
    public List<Integer> postorder(Node root){
        List<Integer> ans = new ArrayList<>();
        postorderHelper(root,ans);
        return ans;
    }

    /**
     * Travels the tree level wise.
     * Printing each level separately
     **/
    public void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()){
            Node curr = q.poll();


            if(curr == null){
                System.out.println();
                if(!q.isEmpty()) q.offer(null);
            }
            else{
                System.out.print(curr.data + " ");
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
    }

    /**
     *Inorder traversal -> LNR
     * It travels LEFT NODE RIGHT
     **/
    private void inorderHelper(Node root, List<Integer> ans){
        if(root == null) return;

        if(root.left != null) inorderHelper(root.left,ans);
        ans.add(root.data);
        if(root.right != null) inorderHelper(root.right,ans);
    }

    /**
     *Preorder traversal -> NLR
     * It travels NODE LEFT RIGHT
     **/
    private void preorderHelper(Node root, List<Integer> ans){
        if(root == null) return;

        ans.add(root.data);
        if(root.left != null) preorderHelper(root.left,ans);
        if(root.right != null) preorderHelper(root.right,ans);
    }

    /**
     *Postorder traversal -> LRN
     * It travels LEFT RIGHT NODE
     **/
    private void postorderHelper(Node root, List<Integer> ans){
        if(root == null) return;

        if(root.left != null) postorderHelper(root.left,ans);
        if(root.right != null) postorderHelper(root.right,ans);
        ans.add(root.data);
    }
}