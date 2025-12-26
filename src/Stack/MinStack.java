import java.util.*;

class MinStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MinStack() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack1.push(val);
        if(stack2.isEmpty() || val <= stack2.peek()){
            stack2.push(val);
        }
    }
    
    public void pop() {
        int temp = this.stack1.pop();
        if(temp == this.stack2.peek()){
            stack2.pop();
        }
    }
    
    public int top() {
        return this.stack1.peek();
    }
    
    public int getMin() {
       return this.stack2.peek();
    }
}