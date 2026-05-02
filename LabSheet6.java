Practical 6 – Trees

Node Class

class Node {
    int empNo;
    String name;
    Node left, right;

    public Node(int empNo, String name) {
        this.empNo = empNo;
        this.name = name;
        left = right = null;
    }

    public void displayNode() {
        System.out.println("Emp No: " + empNo + ", Name: " + name);
    }
}

Tree Class (BST)

class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    // Insert
    public void insert(int empNo, String name) {
        Node newNode = new Node(empNo, name);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current;
            if (empNo < current.empNo) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    // Recursive Find
    public Node findRecursive(Node root, int empNo) {
        if (root == null || root.empNo == empNo)
            return root;

        if (empNo < root.empNo)
            return findRecursive(root.left, empNo);
        else
            return findRecursive(root.right, empNo);
    }

    // Traversals
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            root.displayNode();
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            root.displayNode();
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            root.displayNode();
        }
    }

    // Delete all nodes
    public void deleteAll() {
        root = null;
    }
}

Main Class

import java.util.Scanner;

public class TreeApp {
    public static void main(String[] args) {
        Tree t = new Tree();

        // Insert 10 nodes
        t.insert(50, "A");
        t.insert(30, "B");
        t.insert(70, "C");
        t.insert(20, "D");
        t.insert(40, "E");
        t.insert(60, "F");
        t.insert(80, "G");
        t.insert(10, "H");
        t.insert(35, "I");
        t.insert(90, "J");

        System.out.println("Inorder:");
        t.inorder(t.root);

        System.out.println("\nPreorder:");
        t.preorder(t.root);

        System.out.println("\nPostorder:");
        t.postorder(t.root);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter employee number to search: ");
        int key = sc.nextInt();

        Node result = t.findRecursive(t.root, key);
        if (result != null)
            result.displayNode();
        else
            System.out.println("Employee not found");

        t.deleteAll();
        System.out.println("\nTree deleted.");
    }
}







