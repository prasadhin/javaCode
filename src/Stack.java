import java.util.Arrays;

public class Stack {
    @Override
    public String toString() {
        return "Stack{" +
            "nodes=" + Arrays.toString(nodes) +
            ", size=" + size +
            ", top=" + top +
            '}';
    }

    int[] nodes;
    int size;
    int top = -1;

    public Stack(int size){
     nodes = new int[size];
     this.size = size;
    }

    private void enqueue(int value){
        if(top >= size-1) System.out.println("Stack is full, Unable to add");
        else {
            top++;
            nodes[top]=value;
        }
    }

    private int pop(){
        int topElement = 0;
        if(top==-1) {
            System.out.println("No record in stack, unable to pop");
        }
        else {
            topElement = nodes[top];
            nodes[top] = 0;
            top--;
        }
        return topElement;
    }

    private int peek(){
        return nodes[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.enqueue(5);
        stack.enqueue(6);
        stack.enqueue(3);
        stack.enqueue(1);
        System.out.println(stack.toString());
        System.out.println("Top element is "+stack.peek());
        stack.pop();
        System.out.println(stack.toString());
    }
}
