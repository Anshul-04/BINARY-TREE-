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

 // https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){return ans;}

        q.offer(root);

        while(!q.isEmpty()){           
            List<Integer> list = new LinkedList<>();
             int size = q.size();

            for(int i = 0 ; i < size ; i++ ){

                TreeNode temp = q.poll();
                list.add(temp.val);
                
                if(temp.left!=null){
                        q.add(temp.left);
                }
                if(temp.right!=null){
                        q.add(temp.right);
                }
            }
            ans.add(list);  // add each level node as a list in ans list

        }
        return ans;
    }
}