/**
	Problem: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
         List<List<Integer>> result = new  ArrayList<List<Integer>>();
 
    if(root == null){
        return result;
    }
 
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    LinkedList<TreeNode> next = new LinkedList<TreeNode>();
    current.offer(root);
 
    ArrayList<Integer> numberList = new ArrayList<Integer>();
 
    // need to track when each level starts
    while(!current.isEmpty()){
        TreeNode head = current.poll();
 
        numberList.add(head.val);
 
        if(head.left != null){
            next.offer(head.left);
        }
        if(head.right!= null){
            next.offer(head.right);
        }
 
        if(current.isEmpty()){
            current = next;
            next = new LinkedList<TreeNode>();
            result.add(numberList);
            numberList = new ArrayList<Integer>();
        }
    }
 
    
    List<List<Integer>> reversedResult = new  ArrayList<List<Integer>>();
    for(int i=result.size()-1; i>=0; i--){
        reversedResult.add(result.get(i));
    }
 
    return reversedResult;
        
    }
}