package Exercise04;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class GenericStack {
    public static void main(String[] args) {
        // Example usage
        ClonedStack<Integer> intStack = new ClonedStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        System.out.println("Top of intStack: " + intStack.peek()); // Output: 3
        System.out.println("intStack size: " + intStack.size()); // Output: 3
        System.out.println("Popped from intStack: " + intStack.pop()); // Output: 3
        System.out.println("intStack size after pop: " + intStack.size()); // Output: 2

        ClonedStack<String> stringStack = new ClonedStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Top of stringStack: " + stringStack.peek()); // Output: World
        System.out.println("stringStack size: " + stringStack.size()); // Output: 2
        System.out.println("Popped from stringStack: " + stringStack.pop()); // Output: World
        System.out.println("stringStack size after pop: " + stringStack.size()); //

    }

    protected static class ClonedStack<T> {
        private final List<T> stack;

        public ClonedStack() {
            this.stack = new ArrayList<>();
        }

        public void push(T item) {
            stack.add(item);
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.removeLast();
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.getLast();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int size() {
            return stack.size();
        }
    }
}
