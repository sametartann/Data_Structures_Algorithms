package Data_Structures.Doubly_Linked_List;

import java.util.NoSuchElementException;

public class DoublyLinkedList <T>{

    private Doubly_LinkedList_Node<T> head;
    private Doubly_LinkedList_Node<T> tail;

    public DoublyLinkedList() {
        this.setHead(null);
        this.setTail(null);
    }

    public void insertAtBeginning(T data) {
        Doubly_LinkedList_Node<T> newNode = new Doubly_LinkedList_Node<>(data);
        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            setHead(newNode);
        }
    }

    public void insertAtEnd(T data) {
        Doubly_LinkedList_Node<T> newNode = new Doubly_LinkedList_Node<T>(data);
        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            setTail(newNode);
        }
    }

    public void printList() {
        Doubly_LinkedList_Node<T> current = getHead();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void insertAt(int position, T data) {
        if (position < 0 || position > size()) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        if (position == 0) {
            insertAtBeginning(data);
        } else if (position == size()) {
            insertAtEnd(data);
        } else {
            Doubly_LinkedList_Node<T> newNode = new Doubly_LinkedList_Node<>(data);
            Doubly_LinkedList_Node<T> current = getNode(position);
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        return getHead().getData();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getTail().getData();
    }

    public T getAt(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        Doubly_LinkedList_Node<T> current = getNode(index);
        return current.getData();
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        Doubly_LinkedList_Node<T> removedNode = getHead();
        setHead(getHead().getNext());
        if (getHead() != null) {
            getHead().setPrev(null);
        } else {
            setTail(null);
        }
        removedNode.setNext(null);
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }

        Doubly_LinkedList_Node<T> removedNode = getTail();
        setTail(getTail().getPrev());
        if (getTail() != null) {
            getTail().setNext(null);
        } else {
            setHead(null);
        }
        removedNode.setPrev(null);
    }

    public void removeAt(int position) {
        if (position < 0 || position >= size()) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }

        if (position == 0) {
            removeFirst();
        } else if (position == size() - 1) {
            removeLast();
        } else {
            Doubly_LinkedList_Node<T> removedNode = getNode(position);
            Doubly_LinkedList_Node<T> prevNode = removedNode.getPrev();
            Doubly_LinkedList_Node<T> nextNode = removedNode.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            removedNode.setPrev(null);
            removedNode.setNext(null);
        }
    }

    public int size() {
        int count = 0;
        Doubly_LinkedList_Node<T> current = getHead();
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private Doubly_LinkedList_Node<T> getNode(int position) {
        if (position < 0 || position >= size()) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        Doubly_LinkedList_Node<T> current = getHead();
        int currentPosition = 0;
        while (currentPosition < position) {
            current = current.getNext();
            currentPosition++;
        }
        return current;
    }

    public Doubly_LinkedList_Node<T> getHead() {
        return head;
    }

    public void setHead(Doubly_LinkedList_Node<T> head) {
        this.head = head;
    }

    public Doubly_LinkedList_Node<T> getTail() {
        return tail;
    }

    public void setTail(Doubly_LinkedList_Node<T> tail) {
        this.tail = tail;
    }

//Test
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.insertAtEnd(3);
        list.insertAt(1, 4);

        System.out.print("List: ");
        list.printList(); // Output: List: 1 4 2 3

        System.out.println("First element: " + list.getFirst()); // Output: First element: 1
        System.out.println("Last element: " + list.getLast()); // Output: Last element: 3
        System.out.println("Element at index 2: " + list.getAt(2)); // Output: Element at index 2: 2

        list.removeFirst();
        list.removeLast();
        list.removeAt(1);

        System.out.print("Updated List: ");
        list.printList(); // Output: Updated List: 4

        System.out.println("List size: " + list.size()); // Output: List size: 1
        System.out.println("Is the list empty? " + list.isEmpty()); // Output: Is the list empty? false

    }
}
