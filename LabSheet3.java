1.class StackArray {
    int maxSize;
    int[] stack;
    int top;

    // Constructor
    StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    // Push
    void push(int item) {
        if (isFull()) {
            System.out.println("Stack is Full");
        } else {
            stack[++top] = item;
        }
    }

    // Pop
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return stack[top--];
        }
    }

    // Peek
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    // isEmpty
    boolean isEmpty() {
        return top == -1;
    }

    // isFull
    boolean isFull() {
        return top == maxSize - 1;
    }

    // Display
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

2 public class Main {
    public static void main(String[] args) {
        StackArray s = new StackArray(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Pop: " + s.pop());
        System.out.println("Peek: " + s.peek());
    }
}

3.import java.util.Scanner;

class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String input = sc.nextLine();

        StackArrayChar stack = new StackArrayChar(input.length());

        // Push characters
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Pop to reverse
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        System.out.println("Reversed: " + reversed);
    }
}

// Stack for characters
class StackArrayChar {
    char[] stack;
    int top;
    int size;

    StackArrayChar(int size) {
        this.size = size;
        stack = new char[size];
        top = -1;
    }

    void push(char c) {
        stack[++top] = c;
    }

    char pop() {
        return stack[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

4.class BalancedParentheses {

    public static boolean isBalanced(String str) {
        StackArrayChar stack = new StackArrayChar(str.length());

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "{[()]}";

        if (isBalanced(test)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}