package AlgoritmAndDataStructureLessons.LinkedLists;

import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("head: " + head.value);
    }

    public void getTail() {
        System.out.println("tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLastItem() {
        if (length == 0) return null;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return null;
        }

        Node pre = head;
        Node temp = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length - 1) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index > length) return null;

        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLastItem();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse() {
        Node temp = head;
        this.head = tail;
        this.tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;

    }

    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = current;
        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
                prev = current.next;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        int num = 0;
        Node current = head;

        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }


    public void reverseBetween(int m, int n) {
        // Your implementation here
        if (head == null || m > n) return;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prevM = dummy;
        for (int i = 0; i < m; i++) {
            prevM = prevM.next;
        }

        Node current = prevM.next;
        for (int i = 0; i < n - m; i++) {
            Node nodeToMove = current.next;

            current.next = nodeToMove.next;

            nodeToMove.next = prevM.next;

            prevM.next = nodeToMove;
        }
        head = dummy.next;
    }
}
