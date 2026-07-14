package Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TraversalTest {

    private Node root;
    private Traversal traversal;

    //        1
    //      /   \
    //     2     5
    //    / \   / \
    //   3   4 6   7
    @BeforeEach
    void setUp(){
        traversal = new Traversal();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
    @Test
    void testInorder() {
        assertEquals(
                Arrays.asList(3, 2, 4, 1, 6, 5, 7),
                traversal.inorder(root)
        );
    }

    @Test
    void testPreorder() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                traversal.preorder(root)
        );
    }

    @Test
    void testPostorder() {
        assertEquals(
                Arrays.asList(3, 4, 2, 6, 7, 5, 1),
                traversal.postorder(root)
        );
    }
}
