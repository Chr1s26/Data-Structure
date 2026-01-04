public class KthSmallestElementInBST{
    public static void main(String[] args){

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }

    public void inorder(TreeNode root,int k){
        if(root == null) return;

        inorder(root.left,k);

        count++;
        if(count == k){
            result = root.val;
            return;
        }

        inorder(root.right,k);
    }
}