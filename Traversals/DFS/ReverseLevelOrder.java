package Traversals.DFS;

import java.util.LinkedList;
import java.util.*;

public class ReverseLevelOrder {

    static Node root;
    
    ReverseLevelOrder(){root=null;}


    public void reverseLevelOrder(Node root){
     
        if(root==null);

        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();

        q.add(root);

        while(!q.isEmpty()){

            root = q.poll();   // poll from queue
            

            // first push right child and then left child

            if(root.right!=null){
                q.add(root.right);
            }
            if(root.left!=null){
                q.add(root.left);
            }

            // push popped element into the stack
            st.push(root);
        }

        while(!st.isEmpty()){
            root = st.pop();
            System.out.print(root.data+" ");
        }
    }


    public static void main(String[] args) {
        
        ReverseLevelOrder tree = new ReverseLevelOrder();

          
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

        System.out.println("Reverse Level Order : ");
        tree.reverseLevelOrder(root);

    }
}

/* 
# Reverse Level Order  or Bottom to Top Level order 

                 1    ---------->
               /   \
              2     3    ---------->
             / \   /  \
            4   5 6    7   ---------->
               /      / \
               8     9  10  ---------->
        
           Output : - 8 9 10 4 5 6 7 2 3 1 
           
     Approach :
     
     1) We do normal Level Order traversal and instead of printing we push it into a stack.
     2) Now we pop the elements from the q and and push it into stack st.
     3) And then add popped item's Right child first then left cild in the q .
     4) After that just pop from stack and print it.

*/