/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/
class Queue {
public:
    stack<int>input;
    stack<int>output;
    // Push element x to the back of queue.
    void push(int x) {
        while(!input.empty())
        {
            output.push(input.top());
            input.pop();
        }
        input.push(x);
        while(!output.empty())
        {
            input.push(output.top());
            output.pop();
        }
    }

    // Removes the element from in front of queue.
    void pop(void) {
        input.pop();
    }

    // Get the front element.
    int peek(void) {
        return input.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return input.empty();
    }
};
