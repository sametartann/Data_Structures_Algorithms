package Data_Structures.Binary_Search_Tree;

import java.util.Comparator;

public class BinarySearchTree<T> {
    private BinarySearchTreeNode<T> root;
    private Comparator<T> comparator; //compare elements during insertion and searching

    //constructor
    public BinarySearchTree(Comparator<T> comparator) {
        setRoot(null);
        this.comparator = comparator;
    }

    public void insert(T value) {
        setRoot(insertRecursive(getRoot(), value));
    }

    private BinarySearchTreeNode<T> insertRecursive(BinarySearchTreeNode<T> current, T value) {
        if (current == null) {
            return new BinarySearchTreeNode<>(value);
        }

        //recursively traverses the tree to find the appropriate position
        if (comparator.compare(value, current.getData()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (comparator.compare(value, current.getData()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public boolean search(T value) {
        return searchRecursive(getRoot(), value);
    }

    private boolean searchRecursive(BinarySearchTreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }

        //recursively searches for the value
        if (comparator.compare(value, current.getData()) == 0) {
            return true;
        } else if (comparator.compare(value, current.getData()) < 0) {
            return searchRecursive(current.getLeft(), value);
        } else {
            return searchRecursive(current.getRight(), value);
        }
    }

    public void inorderTraversal() {
        inorderTraversalRecursive(getRoot());
    }

    private void inorderTraversalRecursive(BinarySearchTreeNode<T> node) {
        if (node != null) {
            inorderTraversalRecursive(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversalRecursive(node.getRight());
        }
    }

    public void preorderTraversal() {
        preorderTraversalRecursive(getRoot());
    }

    private void preorderTraversalRecursive(BinarySearchTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversalRecursive(node.getLeft());
            preorderTraversalRecursive(node.getRight());
        }
    }

    public void postorderTraversal() {
        postorderTraversalRecursive(getRoot());
    }

    private void postorderTraversalRecursive(BinarySearchTreeNode<T> node) {
        if (node != null) {
            postorderTraversalRecursive(node.getLeft());
            postorderTraversalRecursive(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public int getHeight() {
        return calculateHeight(getRoot());
    }

    private int calculateHeight(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public BinarySearchTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(comparator);

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(-1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(9);
        bst.insert(17);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();
        System.out.println();

        System.out.println("Pre-order Traversal:");
        bst.preorderTraversal();
        System.out.println();

        System.out.println("Post-order Traversal:");
        bst.postorderTraversal();
        System.out.println();

        int searchValue = 6; // replace with the search value
        if (bst.search(searchValue)) {
            System.out.println("Value " + searchValue + " found in the binary search tree.");
        } else {
            System.out.println("Value " + searchValue + " not found in the binary search tree.");
        }

        int height = bst.getHeight();
        System.out.println("Height of the binary search tree: " + height);
    }
}
