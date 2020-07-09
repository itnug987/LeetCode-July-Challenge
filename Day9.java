/**
	Problem: Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = 0;
        while(! q.isEmpty()){
            int n = q.size();
            
            if(n > max) max = n;
            
            for(int i=0; i<n; i++){
                TreeNode tn = q.remove(0);
                
                if(tn != null){
                    q.add(tn.left);
                    q.add(tn.right);
                }else{
                    q.add(null);
                    q.add(null);
                }
            }
            
            // trim the queue from left
            while(!q.isEmpty() && q.get(0) == null){
                q.remove(0);
            }
            // trim the queue from right
            while(!q.isEmpty() && q.get(q.size()-1) == null){
                q.remove(q.size()-1);
            }
        }
        
        return max;
        
    }
}