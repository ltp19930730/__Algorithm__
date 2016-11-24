public class MinStack {
    private ArrayList<Integer> array;
    private ArrayList<Integer> min_stack;
    public MinStack() {
        // do initialize if necessary
        array = new ArrayList<Integer>();
        min_stack = new ArrayList<Integer>();
    }

    public void push(int number) {
        // write your code here
        array.add(number);
        if (min_stack.size()!=0 && min_stack.get(min_stack.size()-1) >= number){
            min_stack.add(number);
        }else if (min_stack.size()==0){
            min_stack.add(number);
        }
    }

    public int pop() {
        // write your code here
        if (array.size()!= 0){
            int top = array.get(array.size() - 1);
            array.remove(array.size() - 1);
            if (top == min_stack.get(min_stack.size()-1)){
                min_stack.remove(min_stack.size()-1);
            }
            return top;
        }
        return -1;
    }

    public int min() {
        // write your code here
        return min_stack.get(min_stack.size()-1);
    }
}
