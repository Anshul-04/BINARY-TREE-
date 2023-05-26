package Traversals.DFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SpiralFormLevelOrder {
    static Node root;
    
    SpiralFormLevelOrder(){root=null;}

    /*  
    # Using Two Stacks
    
        1) Make two stack s1 and s2 and push root in s1.
        2) While s1 is not empty pop from it and push its left and right child in s2.
        3) While s2 is not empty pop from it and push its  right and left  child in s1.
        4) So, when popping from s1 push its left and right child in s2 and 
        when popping from s2 push right and left child in s1.

        # TC: O(N)
        # SC: O(N)
    */

    void spiralWithTwoStack(Node root){
        if(root==null){return;}

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){

            while(!s1.isEmpty()){
                root = s1.pop();
                System.out.print(root.data + " ");

                // left first then right

                if(root.left!=null){
                    s2.push(root.left);
                }

                if(root.right!=null){
                    s2.push(root.right);
                }
            }
            while(!s2.isEmpty()){
                root = s2.pop();
                System.out.print(root.data + " ");

                // Right first then left

                if(root.right!=null){
                    s1.push(root.right);
                }

                if(root.left!=null){
                    s1.push(root.left);
                }
               
            }

        }
    }

    /*  
        
        # Using A Deque and a Deimiter
        
        1) Intilize a Deque q and add delimiter(null) in q ,then add root on top of q.
        2) Pop from q if its not empty

         a) When popping element from top(front) add its left & right child in the bottom(end) of q. 
         b) When top becomes null pop from bottom.
         c) When popping from bottom add its right child first & then left child in the top of q.  

        # TC: O(N)
        # SC: O(N)
    */

    public void spiralWithDequeAndDelimiter(Node root){
        if(root==null){return;}

        Deque<Node> q = new LinkedList<>();

        q.add(null);  // Delimiter
        q.addFirst(root);

        while(!q.isEmpty()){
            
            // First popping from top if q is not null.
            root = q.peekFirst();
            
            // If only delimiter(null) is present in the dwque then break from the loop.
            while(q.size()>1){
                root = q.pollFirst();
                System.out.print(root.data + " ");

                // When popping from top , add its left & right child on the bottom of q.
             
                if(root.left!=null){
                    q.addLast(root.left);
                }
                if(root.right!=null){
                    q.addLast(root.right);
                }
                root = q.peekFirst();
            }

            // When we come out of the above while loop it means that the top of q have become null.

            // So when queue top become null ,then pop element from the bottom .

            root = q.peekLast();
            while(root!=null){
                root = q.pollLast();
                System.out.print(root.data + " ");

                // When popping from bottom ,first push right child then left child in the top of the q.
                if(root.right!=null){
                    q.addLast(root.right);
                }
                if(root.left!=null){
                    q.addLast(root.left);
                }

                root = q.peekLast();

            }

           
        }
    }


    public static void main(String[] args) {
        
        SpiralFormLevelOrder tree = new SpiralFormLevelOrder();

          
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

        System.out.println("Spiral Using Two Stack  : ");
        tree.spiralWithTwoStack(root);

        System.out.println("\nSpiral Using Dequeue and Delimiter  : ");
        tree.spiralWithTwoStack(root);
        
    }
}

/*   

SPIRAL FORM OF LEVEL ORDEER

                 1    ---->------>        L -> R 
               /   \
              2     3    <----<-----<-     L <- R
             / \   /  \
            4   5 6    7   --->------->    L -> R 
               /      / \
               8     9  10  <---<-----<--   L <- R
        
           Output : - 1 3 2 4 5 6 7 10 9 8 
           
*/