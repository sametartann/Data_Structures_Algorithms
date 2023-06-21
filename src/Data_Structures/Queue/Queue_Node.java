package Data_Structures.Queue;

public class Queue_Node<T> {
    private T data;
    private Queue_Node<T> next;

    // Constructor
    public Queue_Node(T data) {
        setData(data);
        setNext(null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Queue_Node<T> getNext() {
        return next;
    }

    public void setNext(Queue_Node<T> next) {
        this.next = next;
    }
}
