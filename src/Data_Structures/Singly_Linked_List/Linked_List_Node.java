package Data_Structures.Singly_Linked_List;

public class Linked_List_Node<T> {

    private T data;
    private Linked_List_Node<T> next;

    public Linked_List_Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Linked_List_Node<T> getNext() {
        return next;
    }

    public void setNext(Linked_List_Node<T> next) {
        this.next = next;
    }
}
