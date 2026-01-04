import java.util.*;

public class queuePractice{
    public static void main(String[] args){
        //Queue
        //├── Deque
        //│     └── ArrayDeque
        //|       |___LinkedList
        //|
        //└── PriorityQueue

        Queue<Integer> q1 = new ArrayDeque<>();
        // Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new PriorityQueue<>();

        Deque<Integer> q4 = new ArrayDeque<>();
    
        // Deque<Integer> q5 = new LinkedList<>();

        //add first in first out
        //q1.add(100) when you want to handle exception
        q1.offer(100); //O(1)
        q1.offer(10);  
        q1.offer(1000);
        System.out.println(q1);
        q1.poll(); //O(1)
        System.out.println(q1); 
        System.out.println(q1.peek()); //O(1)
        //q.isEmpty(),q.size() //O(1)

        //add first, add last
        q4.offer(100);
        q4.addFirst(1);
        q4.addLast(3);
        System.out.println(q4);
        q4.pollFirst();
        System.out.println(q4);
        q4.pollLast();
        System.out.println(q4);
        q4.offerFirst(1);
        System.out.println("*****************"+q4);
        //contains(5)  //O(n)


        //ArrayDeque = circular array
        //[ ][ ][A][B][C][ ][ ]
        //↑ front         ↑ rear

        //LinkedList = doubly linked list
        //null ← A ↔ B ↔ C → null

        //Use ArrayDeque when:
        //Implementing Queue / Stack
        //BFS / sliding window
        //Performance matters
        //No nulls 

        //Use LinkedList when:
        //Need frequent middle insert/remove with iterator
        //Need to store null
        //(rare in practice)
        //ArrayDeque = array speed, LinkedList = pointer overhead

        //“ArrayDeque is generally preferred over LinkedList for queue 
        //and stack implementations due to better performance and lower memory overhead.”


        //Priority Queue
        //❌ NOT FIFO  
        //Highest (or lowest) priority comes out first
        //PriorityQueue<Integer> pq = new PriorityQueue<>(); smallest element has highest priority
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); largest element come out first
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(100);
        pq.offer(10);
        pq.offer(1);
        pq.offer(100);
        System.out.println("**PQ**");
        System.out.println(pq.poll());
        Queue<Integer> pq1 = new PriorityQueue<>((a,b) -> b - a);
        pq1.offer(100);
        pq1.offer(10);
        pq1.offer(1);
        pq1.offer(100);
        System.out.println(pq1);

        Queue<int[]> pq2 = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq2.offer(new int[]{1,5});
        pq2.offer(new int[]{2,1});
        pq2.offer(new int[]{3,7});
        System.out.println(pq2);
        System.out.println(pq2.poll()[1]);
        Queue<int[]> pq3 = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        pq3.offer(new int[]{1,5});
        pq3.offer(new int[]{2,1});
        pq3.offer(new int[]{3,7});
        System.out.println(pq3.poll()[1]);


        System.out.println("**QUEUE**");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(100);
        queue.offer(1);
        queue.offer(10);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

        System.out.println("**STACK**");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(100);
        stack.push(1);
        stack.push(10);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);


        PriorityQueue<Map.Entry<Integer,Integer>> pqTest1 = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey());
        
        PriorityQueue<Map.Entry<Integer,List<Integer>>> pqTest2 = new PriorityQueue<>((a,b) -> a.getValue().get(0) - b.getValue().get(0));
    }
}