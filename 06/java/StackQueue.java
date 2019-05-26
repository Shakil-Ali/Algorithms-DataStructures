public class StackQueue {
    private static Stack s;
    private static Queue q;
    public static void main(String[] args) {
	prepare();
	System.out.print(q.dequeue());
	System.out.print(s.pop());
	System.out.print(s.pop());
	System.out.print(q.dequeue());
	s.pop();
	q.dequeue();
	System.out.print(s.pop());
	System.out.print(q.dequeue());
	System.out.print(s.pop());
	System.out.println(q.dequeue());
	s.pop();
	q.dequeue();
    }

    private static void prepare() {
    	// Initialise s and q to stacks and queues
    	s = new Stack();
    	q = new Queue();

    	s.push(100);
    	s.push(0);
    	s.push(8);
    	s.push(100);
    	s.push(5);
    	s.push(3);

    	q.enqueue(3);
    	q.enqueue(0);
    	q.enqueue(100);
    	q.enqueue(4);
    	q.enqueue(2);
    	q.enqueue(100);

    }
}
