package Data_Structures.Binary_Tree;
import java.util.Comparator;
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        setRoot(null);
        this.comparator = comparator;
    }

    public void insert(T value) {
        setRoot(insertRecursive(getRoot(), value));
    }

    private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> current, T value) {
        if (current == null) {
            return new BinaryTreeNode<>(value);
        }

        if (comparator.compare(value, current.getData()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (comparator.compare(value, current.getData()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    // Search for a value in the binary tree
    public boolean search(T value) {
        return searchRecursive(getRoot(), value);
    }

    private boolean searchRecursive(BinaryTreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (comparator.compare(value, current.getData()) == 0) {
            return true;
        } else if (comparator.compare(value, current.getData()) < 0) {
            return searchRecursive(current.getLeft(), value);
        } else {
            return searchRecursive(current.getRight(), value);
        }
    }

    // Perform an inorder traversal of the binary tree
    public void inorderTraversal() {
        inorderTraversalRecursive(getRoot());
    }

    private void inorderTraversalRecursive(BinaryTreeNode<T> node) {
        if (node != null) {
            inorderTraversalRecursive(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversalRecursive(node.getRight());
        }
    }

    // Perform a pre-order traversal of the binary tree
    public void preorderTraversal() {
        preorderTraversalRecursive(getRoot());
    }

    private void preorderTraversalRecursive(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversalRecursive(node.getLeft());
            preorderTraversalRecursive(node.getRight());
        }
    }

    // Perform a post-order traversal of the binary tree
    public void postorderTraversal() {
        postorderTraversalRecursive(getRoot());
    }

    private void postorderTraversalRecursive(BinaryTreeNode<T> node) {
        if (node != null) {
            postorderTraversalRecursive(node.getLeft());
            postorderTraversalRecursive(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    // Calculate the height of the binary tree
    public int getHeight() {
        return calculateHeight(getRoot());
    }

    private int calculateHeight(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public static void main(String[] args) {
        // Create a comparator for Integer type
        Comparator<Integer> comparator = Comparator.naturalOrder();
        BinaryTree<Integer> binaryTree = new BinaryTree<>(comparator);

        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(-1);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(9);
        binaryTree.insert(17);



        System.out.println("Root: " + binaryTree.getRoot().getData());

        System.out.println("Inorder Traversal:");
        binaryTree.inorderTraversal();
        System.out.println();

        System.out.println("Pre-order Traversal:");
        binaryTree.preorderTraversal();
        System.out.println();

        System.out.println("Post-Order Traversal:");
        binaryTree.postorderTraversal();
        System.out.println();


        int searchValue = 6;
        if (binaryTree.search(searchValue)) {
            System.out.println("Value " + searchValue + " found in the binary tree.");
        } else {
            System.out.println("Value " + searchValue + " not found in the binary tree.");
        }

        int height = binaryTree.getHeight();
        System.out.println("Height of the binary tree: " + height);
    }
}
