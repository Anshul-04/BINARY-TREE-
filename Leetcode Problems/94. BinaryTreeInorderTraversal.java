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

//  https://leetcode.com/problems/binary-tree-inorder-traversal/ 

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new LinkedList<>();       
        Stack<TreeNode> st =  new Stack<>();

        if(root ==null){  // if root is null then return
            return ans;
        }

        while(root!=null || !st.isEmpty()){           

            // if curr node is not null push it into the stack and go left child
            if(root !=null){
                st.push(root);
                root = root.left;  // go to left child
            }
            else{
                // if stack is empty then break from loop
                if(st.isEmpty()){
                    break;
                }
                //if curr node  is null then pop from stack and print it and go to its right  child
                root = st.pop();   
                ans.add(root.val);
                root = root.right;  // go to right child
            }
        }
        return ans;
    }
}