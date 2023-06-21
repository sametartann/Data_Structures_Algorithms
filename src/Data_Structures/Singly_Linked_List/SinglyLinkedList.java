package Data_Structures.Singly_Linked_List;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private Linked_List_Node<T> head;
    private int size;

    public SinglyLinkedList() {
        setHead(null);
        setSize(0);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    public void addFirst(T data) {
        Linked_List_Node<T> newNode = new Linked_List_Node<>(data);
        if (isEmpty()) {
            setHead(newNode);
        } else {
            newNode.setNext(getHead());
            setHead(newNode);
        }
        size++;
    }

    public void addLast(T data) {
        Linked_List_Node<T> newNode = new Linked_List_Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Linked_List_Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == getSize()) {
            addLast(data);
        } else {
            Linked_List_Node<T> newNode = new Linked_List_Node<>(data);
            Linked_List_Node<T> current = getHead();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getHead().getData();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Linked_List_Node<T> current = getHead();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T getAtIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        Linked_List_Node<T> current = getHead();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedData = getHead().getData();
        setHead(getHead().getNext());
        size--;
        return removedData;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            T removedData = head.getData();
            setHead(null);
            size--;
            return removedData;
        }
        Linked_List_Node<T> current = getHead();
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        T removedData = current.getNext().getData();
        current.setNext(null);
        size--;
        return removedData;
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == getSize() - 1) {
            return removeLast();
        } else {
            Linked_List_Node<T> current = getHead();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            T removedData = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            size--;
            return removedData;
        }
    }

    public Linked_List_Node<T> getHead() {
        return head;
    }

    public void setHead(Linked_List_Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        // Adding elements to the list
        myList.addFirst(5);
        myList.addLast(10);
        myList.addAtIndex(8, 1);

        // Getting elements from the list
        System.out.println("First element: " + myList.getFirst());
        System.out.println("Last element: " + myList.getLast());
        System.out.println("Element at index 1: " + myList.getAtIndex(1));

        // Removing elements from the list
        System.out.println("Removed first element: " + myList.removeFirst());
        System.out.println("Removed last element: " + myList.removeLast());
        System.out.println("Removed element at index 0: " + myList.removeAtIndex(0));

        // Checking size and emptiness
        System.out.println("Size of the list: " + myList.getSize());
        System.out.println("Is the list empty? " + myList.isEmpty());
    }

}
