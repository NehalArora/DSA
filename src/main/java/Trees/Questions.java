package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Questions {

    /**
     * Count nodes
     * */
    public int countNodes(Node root) {
        if(root == null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    /**
     * Count Leaf Nodes
     * **/
    public int countLeafNodes(Node root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        return countLeafNodes(root.left)+countLeafNodes(root.left);
    }
    /**
     * Height of the tree
     * */
    public int height(Node root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1+Math.max(left,right);
    }
    /***
     * Maximum Depth
     **/
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    /**
     * Min Depth
     * */
    public int minDepth(Node root){
        if(root == null) return 0;
        //Using BFS
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                Node curr = q.poll();

                if(curr.left == null && curr.right == null){
                    return depth;
                }

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            depth++;
        }

        return depth;
    }

}
