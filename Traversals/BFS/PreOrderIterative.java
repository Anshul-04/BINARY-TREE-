package Traversals.BFS;

import java.util.*;

/* 
https://practice.geeksforgeeks.org/problems/preorder-traversal/1?page=1&difficulty[]=-1&category[]=Tree&sortBy=submissions
*/


class PreOrderIterative{

    static Node root;

    PreOrderIterative(){root=null;}

    public static void main(String[] args) {

      

      PreOrderIterative tree = new PreOrderIterative();
      
      tree.root = new Node(1);

      tree.root.left = new Node(2);
      tree.root.right = new Node(3);

      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);

      tree.root.right.left = new Node(6);
      tree.root.right.right = new Node(7);

      tree.root.left.right.left = new Node(8);

      tree.root.right.right.left = new Node(9);
      tree.root.right.right.right = new Node(10);

      System.out.print("Iterative PreOrder : ");
      tree.preOrderIterative(root);
        
   
    }

    public void preOrderIterative(Node root){

        // 1. Create a Stack 
        Stack<Node> s = new Stack<>();

        if(root==null){
            return ;
        }
        // 2. Push root in the Stack
        s.push(root);

        // 3. Untill stack is not empty pop the top element of stack and
        // 4. push its right child first then left child to make sur left subtree will be processed first because stack is LIFO.

        while(!s.isEmpty()){
            Node curr = s.pop();
            System.out.print(curr.data+" ");

            // pushing right first
            if(curr.right!=null){
                s.push(curr.right);
            }

            // then pushing left
            if(curr.left!=null){
                s.push(curr.left);
            }
        }
    }
}
/*   

Approach

1. Create an empty stack  and push root node into the stack.
2. Do following if stack is not empty.
 a) Pop top of stack and print it.
 b) Push right child of popped item to the stack.
 c) then Push left child of popped item to the stack.

 Note : First push right child then left child.
 

  
 
 */

