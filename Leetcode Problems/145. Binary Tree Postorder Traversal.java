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

//  https://leetcode.com/problems/binary-tree-postorder-traversal/description/

class Solution {


    // One stack method
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new LinkedList<>();

        if(root ==null){
            return ans;
        } 

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr!=null || !st.isEmpty()){
             // if curr is not null push in the stack and go to left child
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;  // right child of stack's top element
                if(temp==null){
                    // 1) If temp is null then pop from stack
                    temp = st.pop();
                    ans.add(temp.val);

               // 2) If stack is not empty and popped item is right child of stack's top then continue popping
                    while(!st.isEmpty() && temp == st.peek().right ){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }
                else{
                     // if temp is not null then assign it to curr
                    curr = temp;
                }
            }
        }
        return ans;
    }


   
    // TWO STACK METHOD

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        if(root ==null){
            return ans;
        } 

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode curr = s1.pop();

            if(curr.left != null){
                s1.push(curr.left);
            }
              if(curr.right != null){
                s1.push(curr.right);
            }
            s2.push(curr);  // push popped element in s2
        }

        while(!s2.isEmpty()){
            root = s2.pop();
            ans.add(root.val);
        }
        return ans;
    }

    

}