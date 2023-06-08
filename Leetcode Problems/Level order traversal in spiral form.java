/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

// https://bit.ly/3K6t9VR 

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
           while(!s1.isEmpty()){
               root = s1.pop();
               ans.add(root.data);
               
               if(root.right!=null){
                   s2.push(root.right);
               }
               
               if(root.left!=null){
                   s2.push(root.left);
               }
           }
           
           while(!s2.isEmpty()){
               root = s2.pop();
               ans.add(root.data);
               
               if(root.left!=null){
                   s1.push(root.left);
               }
                 
               if(root.right!=null){
                   s1.push(root.right);
               }
           }
        }
        return ans;
    }
}