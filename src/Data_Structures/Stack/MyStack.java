package Data_Structures.Stack;

public class MyStack<T> {
    private Stack_Node<T> top;

    public MyStack() {
        setTop(null);
    }

    public void push(T data) {
        Stack_Node<T> newNode = new Stack_Node<>(data);
        newNode.setNext(getTop());
        setTop(newNode);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Data_Structures.Stack is empty.");
        }
        T data = getTop().getData();
        setTop(getTop().getNext());
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Data_Structures.Stack is empty.");
        }
        return getTop().getData();
    }

    public boolean isEmpty() {
        return getTop() == null;
    }
    public int size() {
        int count = 0;
        Stack_Node<T> current = getTop();
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void clear() {
        setTop(null);
        System.out.println("Clear Data_Structures.Stack");
    }

    public void print() {
        Stack_Node<T> current = getTop();
        System.out.print("My Data_Structures.Stack: ");
        if (isEmpty()) {
            System.out.println("Data_Structures.Stack is empty!");
            return;
        }
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public Stack_Node<T> getTop() {
        return top;
    }

    public void setTop(Stack_Node<T> top) {
        this.top = top;
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.print();

        System.out.println("Size: " + myStack.size());
        System.out.println("Peek: "+myStack.peek());

        int poppedElement = myStack.pop();
        System.out.println("Popped Element: " +poppedElement);
        myStack.print();

        System.out.println("Is Empty: "+myStack.isEmpty());  // Output: false

        myStack.clear();
        myStack.print();
        System.out.println("Is Empty: "+myStack.isEmpty());  // Output: true
    }
}
