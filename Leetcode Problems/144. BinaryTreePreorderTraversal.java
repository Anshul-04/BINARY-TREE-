package Leetcode Problems;
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

//  https://leetcode.com/problems/binary-tree-preorder-traversal/description/


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
       
        List<Integer> ans = new LinkedList<>();

         if(root ==null){return ans;}
         
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            ans.add(curr.val);

            if(curr.right!= null){
                st.push(curr.right);
            }
            if(curr.left != null ){
                st.push(curr.left);
            }
        }
        return ans;
       
    }
}