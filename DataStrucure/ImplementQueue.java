public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();

        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int top() {
        // write your code here
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();

        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
