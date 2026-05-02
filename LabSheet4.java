//Exercise 1

class QueueArray {
    int maxSize;
    int[] queue;
    int front, rear, count;

    public QueueArray(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        queue[++rear] = item;
        count++;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        count--;
        return queue[front++];
    }

    public int peekFront() {
        return queue[front];
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == maxSize);
    }

    public int getCount() {
        return count;
    }
}

Main Method

public class QueueTest {
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.insert(10);
        q.insert(20);
        q.insert(30);

        System.out.println("Front: " + q.peekFront());
        System.out.println("Removed: " + q.remove());
        System.out.println("Count: " + q.getCount());
    }
}

Exercise 2: Circular Queue

Java Code

class CircularQueue {
    int maxSize;
    int[] queue;
    int front, rear, count;

    public CircularQueue(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = item;
        count++;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        int temp = queue[front];
        front = (front + 1) % maxSize;
        count--;
        return temp;
    }

    public int peekFront() {
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }
}

Main Method (User Input Demo)

import java.util.Scanner;

public class CircularQueueTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue q = new CircularQueue(size);

        // Fill queue
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value: ");
            q.insert(sc.nextInt());
        }

        // Remove 2 elements
        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        // Insert again (circular behavior)
        q.insert(99);
        q.insert(100);

        System.out.println("Front element: " + q.peekFront());
    }
}


