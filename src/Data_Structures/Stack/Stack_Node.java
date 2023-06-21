package Data_Structures.Stack;

public class Stack_Node<T> {
    private T data;
    private Stack_Node<T> next;

    public Stack_Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Stack_Node<T> getNext() {
        return next;
    }

    public void setNext(Stack_Node<T> next) {
        this.next = next;
    }
}
