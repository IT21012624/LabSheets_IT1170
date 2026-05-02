Practical 5 – Linked Lists

Exercise 1: Student Linked List

Link Class

class Link {
    int id;
    int marks;
    Link next;

    public Link(int id, int marks) {
        this.id = id;
        this.marks = marks;
    }

    public void displayLink() {
        System.out.println("ID: " + id + ", Marks: " + marks);
    }
}

LinkedList Class

class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, int marks) {
        Link newLink = new Link(id, marks);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current != null) {
            if (current.id == key)
                return current;
            current = current.next;
        }
        return null;
    }

    public void insertAfter(int key, int id, int marks) {
        Link current = first;
        while (current != null && current.id != key) {
            current = current.next;
        }
        if (current != null) {
            Link newLink = new Link(id, marks);
            newLink.next = current.next;
            current.next = newLink;
        }
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = null;

        while (current != null && current.id != key) {
            previous = current;
            current = current.next;
        }

        if (current == null)
            return null;

        if (current == first)
            first = first.next;
        else
            previous.next = current.next;

        return current;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}

Main Class

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(1, 80);
        list.insertFirst(2, 75);
        list.insertFirst(3, 90);

        list.displayList();

        list.insertAfter(2, 4, 85);
        System.out.println("\nAfter InsertAfter:");
        list.displayList();

        list.delete(1);
        System.out.println("\nAfter Delete:");
        list.displayList();
    }
}

Exercise 2: Library Management System

Link Class

class Book {
    int id;
    String title;
    int copies;
    Book next;

    public Book(int id, String title, int copies) {
        this.id = id;
        this.title = title;
        this.copies = copies;
    }

    public void displayBook() {
        System.out.println(id + " - " + title + " (Copies: " + copies + ")");
    }
}

LinkedList Class

class LibraryList {
    private Book first;

    public void insertFirst(int id, String title, int copies) {
        Book newBook = new Book(id, title, copies);
        newBook.next = first;
        first = newBook;
    }

    public void insertAfter(int key, int id, String title, int copies) {
        Book current = first;
        while (current != null && current.id != key) {
            current = current.next;
        }
        if (current != null) {
            Book newBook = new Book(id, title, copies);
            newBook.next = current.next;
            current.next = newBook;
        }
    }

    public Book find(int key) {
        Book current = first;
        while (current != null) {
            if (current.id == key)
                return current;
            current = current.next;
        }
        return null;
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void delete(int key) {
        Book current = first, prev = null;

        while (current != null && current.id != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) return;

        if (current == first)
            first = first.next;
        else
            prev.next = current.next;
    }

    public void display() {
        Book current = first;
        while (current != null) {
            current.displayBook();
            current = current.next;
        }
    }
}

Main Class

public class LibraryApp {
    public static void main(String[] args) {
        LibraryList lib = new LibraryList();

        // Insert initial books
        lib.insertFirst(1, "Java", 5);
        lib.insertFirst(2, "DSA", 3);
        lib.insertFirst(3, "DBMS", 4);

        lib.display();

        // Insert after
        lib.insertAfter(2, 4, "AI", 2);

        // Find
        System.out.println("\nFind Book ID 3:");
        Book b = lib.find(3);
        if (b != null) b.displayBook();

        // Delete
        lib.delete(1);

        // Delete first
        lib.deleteFirst();

        System.out.println("\nFinal List:");
        lib.display();
    }
}