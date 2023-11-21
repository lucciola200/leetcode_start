package AlgoritmAndDataStructureLessons.LinkedLists;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.append(8);

        myLinkedList.reverseBetween(2,5);
        myLinkedList.printList();
    }
}
