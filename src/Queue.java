import java.util.Arrays;

public class Queue {
int size = 0;
int[] nodes;
int rear = -1;
int front = 0;
int totalElements = 0;

    @Override
    public String toString() {
        return "Queue{" +
            "size=" + size +
            ", nodes=" + Arrays.toString(nodes) +
            ", rear=" + rear +
            ", front="+front+
            '}';
    }

public Queue(int size){
    nodes = new int[size];
    this.size=size;
}

public boolean isQueueEmpty(){
    return totalElements == 0;
}

public boolean isQueueFull(){
    return totalElements >= size-1;
}

public void enqueue(int i){
    if(isQueueFull()){
        System.out.println("Cannot add, queue is full");
    }
    else {
        rear++;
        nodes[rear] = i;
        totalElements++;
    }
}

public int dequeue(){
    int val = 0;
    if(isQueueEmpty()) {
        System.out.println("Cannot get, queue is empty");
        return val;
    }
    else {
        val = nodes[front];
        nodes[front] = 0;
        totalElements--;
        front++;
    }
    return val;
}

public int peekFront(){
    int returnVal = 0;
    if(isQueueEmpty()) System.out.println("Cannot get, queue is empty");
    return nodes[front];
}

    public int peekRear(){
        if(isQueueEmpty()) {
            System.out.println("Cannot get, queue is empty");
            return 0;
        }
        return nodes[rear];
    }
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.enqueue(3);
        System.out.println("added "+ "3");
        queue.enqueue(1);
        System.out.println("added "+ "1");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.dequeue();
        System.out.println("removed last");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.dequeue();
        System.out.println("removed last");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.dequeue();
        System.out.println("removed last");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.dequeue();
        System.out.println("removed last");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.dequeue();
        System.out.println("removed last");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
        queue.dequeue();
        System.out.println("removed last");
        System.out.println(queue.toString());
        System.out.println("Front is "+queue.peekFront());
        System.out.println("Last is "+queue.peekRear());
    }

}
