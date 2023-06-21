package Data_Structures.Sorted_Linked_List;

public class Sorted_LinkedList_Node<T> {
    private T data;
    private Sorted_LinkedList_Node<T> next;

    public Sorted_LinkedList_Node(T data) {
        setData(data);
        setNext(null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Sorted_LinkedList_Node<T> getNext() {
        return next;
    }

    public void setNext(Sorted_LinkedList_Node<T> next) {
        this.next = next;
    }
}
