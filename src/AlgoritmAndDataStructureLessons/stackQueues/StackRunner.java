package AlgoritmAndDataStructureLessons.stackQueues;

public class StackRunner {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        myStack.push(2);
        myStack.push(3);

        myStack.printStack();
        System.out.println("----------");
        System.out.println(myStack.pop().value);
        System.out.println("----------");
        myStack.printStack();
    }
}
