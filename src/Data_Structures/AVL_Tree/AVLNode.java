package Data_Structures.AVL_Tree;

public class AVLNode<T> {
    private T data;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int height;

    public AVLNode(T data) {
        setData(data);
        setLeft(null);
        setRight(null);
        setHeight(1);
    }

    // Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}