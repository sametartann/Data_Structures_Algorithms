package Data_Structures.Queue;

public class MyQueue<T> {
    private Queue_Node<T> front;
    private Queue_Node<T> rear;

    // Constructor
    public MyQueue() {
        setFront(null);
        setRear(null);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return getFront() == null;
    }

    // Get the element at the front of the queue
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Data_Structures.Queue is empty");
        }
        return getFront().getData();
    }

    // Add an element to the rear of the queue
    public void enqueue(T data) {
        Queue_Node<T> newNode = new Queue_Node<>(data);
        if (isEmpty()) {
            setFront(newNode);
            setRear(newNode);
        } else {
            getRear().setNext(newNode);
            setRear(newNode);
        }
    }

    // Remove and return the element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Data_Structures.Queue is empty");
        }
        T data = getFront().getData();
        setFront(getFront().getNext());
        if (getFront() == null) {
            setRear(null);
        }
        return data;
    }

    public void printQueue() {
        System.out.print("Data_Structures.Queue Elements: ");
        if (isEmpty()) {
            System.out.println("Data_Structures.Queue is empty");
            return;
        }

        Queue_Node<T> current = front;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public Queue_Node<T> getFront() {
        return front;
    }

    public void setFront(Queue_Node<T> front) {
        this.front = front;
    }

    public Queue_Node<T> getRear() {
        return rear;
    }

    public void setRear(Queue_Node<T> rear) {
        this.rear = rear;
    }

    public static void main(String[] args) {
        // Create a queue of integers
        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.printQueue();
        // Enqueue elements
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        myQueue.printQueue();

        // Dequeue elements and print them
        while (!myQueue.isEmpty()) {
            int element = myQueue.dequeue();
            System.out.println("Dequeued: " + element);
        }
        myQueue.printQueue();

        // Enqueue more elements
        myQueue.enqueue(50);
        myQueue.enqueue(60);

        myQueue.printQueue();

        // Get the element at the front of the queue
        int frontElement = myQueue.peek();
        System.out.println("Front element: " + frontElement);

        // Dequeue elements again
        while (!myQueue.isEmpty()) {
            int element = myQueue.dequeue();
            System.out.println("Dequeued: " + element);
        }

        myQueue.printQueue();
    }
}
