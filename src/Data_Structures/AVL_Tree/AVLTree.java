package Data_Structures.AVL_Tree;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    public AVLTree() {
        setRoot(null);
    }

    // insert a node in the AVL tree
    public void insert(T data) {
        setRoot(insertNode(getRoot(),data));
    }

    private AVLNode<T> insertNode(AVLNode<T> node, T data) {
        if (node == null) {
            return new AVLNode<T>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insertNode(node.getLeft(), data));
        } else {
            node.setRight(insertNode(node.getRight(), data));
        }

        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (data.compareTo(node.getLeft().getData()) >= 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }

        if (balanceFactor < -1) {
            if (data.compareTo(node.getRight().getData()) <= 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    // delete a node from the AVL tree
    public void delete(T data) {
        setRoot(deleteNode(getRoot(),data));
    }

    private AVLNode<T> deleteNode(AVLNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(deleteNode(node.getRight(), data));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                AVLNode<T> temp = null;
                if (temp == node.getLeft()) {
                    temp = node.getRight();
                } else {
                    temp = node.getLeft();
                }

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                AVLNode<T> temp = findMinNode(node.getRight());
                node.setData(temp.getData());
                node.setRight(deleteNode(node.getRight(), temp.getData()));
            }
        }

        if (node == null) {
            return null;
        }

        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }

        if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    // search for a node in the AVL tree
    public boolean search(T data) {
        return searchNode(getRoot(), data);
    }

    private boolean searchNode(AVLNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.getData()) == 0) {
            return true;
        } else if (data.compareTo(node.getData()) < 0) {
            return searchNode(node.getLeft(), data);
        } else {
            return searchNode(node.getRight(), data);
        }
    }

    // get the height of a node
    private int getHeight(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    // get the balance factor of a node
    private int getBalanceFactor(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    // perform left rotation
    private AVLNode<T> rotateLeft(AVLNode<T> z) {
        AVLNode<T> y = z.getRight();
        AVLNode<T> T2 = y.getLeft();

        y.setLeft(z);
        z.setRight(T2);

        z.setHeight(1 + Math.max(getHeight(z.getLeft()), getHeight(z.getRight())));
        y.setHeight(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));

        return y;
    }

    // perform right rotation
    private AVLNode<T> rotateRight(AVLNode<T> z) {
        AVLNode<T> y = z.getLeft();
        AVLNode<T> T3 = y.getRight();

        y.setRight(z);
        z.setLeft(T3);

        z.setHeight(1 + Math.max(getHeight(z.getLeft()), getHeight(z.getRight())));
        y.setHeight(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));

        return y;
    }

    // Method to find the minimum node in a subtree
    private AVLNode<T> findMinNode(AVLNode<T> node) {
        AVLNode<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void printInorder() {
        inorderTraversal(getRoot());
        System.out.println();
    }

    private void inorderTraversal(AVLNode<T> node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversal(node.getRight());
        }
    }

    public void printPreorder() {
        preorderTraversal(getRoot());
        System.out.println();
    }

    private void preorderTraversal(AVLNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }

    public void printPostorder() {
        postorderTraversal(getRoot());
        System.out.println();
    }

    private void postorderTraversal(AVLNode<T> node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Insert nodes
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("AVL Tree after insertions:");
        System.out.print("Inorder: ");
        avlTree.printInorder();
        System.out.print("Pre-order: ");
        avlTree.printPreorder();
        System.out.print("Post-order: ");
        avlTree.printPostorder();

        // Search for a node
        int searchData = 30;
        boolean isFound = avlTree.search(searchData);
        System.out.println("Search for " + searchData + ": " + isFound);

        System.out.println("AVL Height: " + avlTree.getHeight(avlTree.getRoot()));

        // Delete a node
        int deleteData = 40;
        avlTree.delete(deleteData);
        System.out.println("AVL Tree after deletion of " + deleteData + ":");
        avlTree.printInorder();
    }

}
