
import java.util.*;

public class treePractice{
    public static void main(String[] args){
        TreeNode root = null;

        // root = insert(root,1);
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 2);
        root = insert(root, 4);

        inOrder(root);   // 2 3 4 5 7
        System.out.println();

        preOrder(root);  // 5 3 2 4 7
        System.out.println();

        postOrder(root); // 2 4 3 7 5
        System.out.println();

        levelOrder(root); 
        System.out.println();
        System.out.println("Count Nodes" + countNodes(root));
        System.out.println("Max Depth" + height(root));
    }

    public static TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(TreeNode root, int target){
        if(root == null) return false;

        if(root.val == target){
            return true;
        }   
        if(target < root.val){
            return search(root.left,target);
        }else{
            return search(root.left, target);
        }
    }

    public static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new ArrayDeque();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            System.out.print(cur.val+ " ");
            if(cur.left != null) q.offer(cur.left);
            if(cur.right != null) q.offer(cur.right);
        }
    }

    public static List<List<Integer>> levelOrderI(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                level.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    } 

    public static void inOrderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur != null || ! st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.val+ "");
            cur = cur.right;
        }
    }

    //leet code problem (find max height)
    public static int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left,right);
    }

    //leet code problem (find nodes)
    public static int countNodes(TreeNode root){
        int count = 0;
        if(root == null) return 0;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return 1 + count;
    }

    public static boolean isEmpty(TreeNode root){
        return root == null;
    }

    //leet code problems (invert tree)
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}