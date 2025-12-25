import java.util.*;

public class ImplementQueueUsingStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public ImplementQueueUsingStack() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        updateReverse();
        this.stack1.push(x);
    }
    
    public int pop() {
        update();
        int temp = this.stack2.pop();
        return temp;
    }
    
    public int peek() {
        update();
        return this.stack2.peek();
    }
    
    public boolean empty() {
        update();
        return this.stack2.isEmpty();
    }

    public void update(){
        int size = stack1.size();
        for(int i = 0; i < size; i++){
            stack2.push(stack1.pop());
        }
    }

    public void updateReverse(){
            int size = stack2.size();
            for(int i = 0; i < size; i++){
                stack1.push(stack2.pop());
            }
    }
}