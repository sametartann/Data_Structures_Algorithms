package Data_Structures.Sorted_Linked_List;

public class SortedLinkedList <T extends Comparable<T>> {

    private Sorted_LinkedList_Node<T> head;
    private int size;

    public SortedLinkedList() {
        setHead(null);
        setSize(0);
    }

    public void insert(T data) {
        Sorted_LinkedList_Node<T> newNode = new Sorted_LinkedList_Node<>(data);

        if (getHead() == null || data.compareTo(getHead().getData()) < 0) {
            newNode.setNext(getHead());
            setHead(newNode);
        } else {
            Sorted_LinkedList_Node<T> current = getHead();

            while (current.getNext() != null && data.compareTo(current.getNext().getData()) > 0) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    public boolean contains(T data) {
        Sorted_LinkedList_Node<T> current = getHead();

        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void remove(T data) {
        if (getHead() == null) {
            return;
        }

        if (getHead().getData().equals(data)) {
            setHead(getHead().getNext());
            size--;
            return;
        }

        Sorted_LinkedList_Node<T> current = getHead();
        Sorted_LinkedList_Node<T> previous = null;

        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return;
        }

        assert previous != null;
        previous.setNext(current.getNext());
        size--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        Sorted_LinkedList_Node<T> current = getHead();
        Sorted_LinkedList_Node<T> previous = null;
        int count = 0;

        while (count < index) {
            previous = current;
            current = current.getNext();
            count++;
        }

        previous.setNext(current.getNext());
        size--;
    }

    public void display() {
        Sorted_LinkedList_Node<T> current = getHead();

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    public Sorted_LinkedList_Node<T> getHead() {
        return head;
    }

    public void setHead(Sorted_LinkedList_Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();

        // Testing insert method
        list.insert(5);
        list.insert(2);
        list.insert(8);
        list.insert(1);
        list.insert(4);
        list.insert(10);

        // Testing display method
        System.out.println("Linked List after insertions:");
        list.display();  // Output: 1 2 4 5 8 10

        // Testing contains method
        System.out.println("Contains 4: " + list.contains(4));  // Output: true
        System.out.println("Contains 7: " + list.contains(7));  // Output: false

        // Testing remove method
        list.remove(5);
        list.remove(10);

        System.out.println("Linked List after removals:");
        list.display();  // Output: 1 2 4 8

        // Testing removeAt method
        list.removeAt(1);

        System.out.println("Linked List after removeAt:");
        list.display();  // Output: 1 4 8

        // Testing size method
        System.out.println("Size of the Linked List: " + list.getSize());  // Output: 3

    }

}
