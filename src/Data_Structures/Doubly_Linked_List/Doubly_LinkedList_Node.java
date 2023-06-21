package Data_Structures.Doubly_Linked_List;

public class Doubly_LinkedList_Node<T> {
    private T data;
    private Doubly_LinkedList_Node<T> prev;
    private Doubly_LinkedList_Node<T> next;

    public Doubly_LinkedList_Node(T data) {
        this.setData(data);
        this.setPrev(null);
        this.setNext(null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Doubly_LinkedList_Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Doubly_LinkedList_Node<T> prev) {
        this.prev = prev;
    }

    public Doubly_LinkedList_Node<T> getNext() {
        return next;
    }

    public void setNext(Doubly_LinkedList_Node<T> next) {
        this.next = next;
    }
}
