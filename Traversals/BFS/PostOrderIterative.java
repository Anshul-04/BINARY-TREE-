package Traversals.BFS;
import java.util.*;

/* 
Theory - https://www.geeksforgeeks.org/iterative-postorder-traversal/
https://practice.geeksforgeeks.org/problems/postorder-traversal/1?page=1&difficulty[]=-1&category[]=Tree&sortBy=submissions
*/

class PostOrderIterative{
    static Node root;

    PostOrderIterative(){root=null;}



    /* 
    
    # Using Two Stack 
     
    APPROACH : -

    1) Create two stacks s1 & s2.
    2) Push root in to S1 .
    3) Then we put a condition that untill
      a) s1 is not empty we gonna pop element from the top of the s1 stack and then push the popped item into s2.
      b) also push the popped element's left and right child into the s1.
    4) Keep repeating step 2 untill all node are processed.
    5) Pop from s2 and print it.  

    NOTE : First push LEFT child into the stack S! then the RIGHT child.
    
    */

    public void postOrderUsingTwoStack(Node root){

        if(root==null){return;}

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        //push root into s1
        s1.push(root);

        while(!s1.isEmpty()){

            //pop from top of s1 
            root = s1.pop();

            // and push it to s2
            s2.push(root);  

            // If Left & Right child of popped item  is not null ,then push it into s1

            if(root.left!=null){
                s1.push(root.left);
            }

            if(root.right!=null){
                s1.push(root.right);
            }
        }

        // Pop from s2 and print it

        while(!s2.isEmpty()){
            root = s2.pop();
            System.out.print(root.data+" ");
        }

    }

      /* 
    
    # Using One Stack 
     
    APPROACH : -

    1) Create stack s and Node curr and assign it the root


    2) While stack is not empty or curr is not null we are gonna keep looping.

      a) If curr is not null then push into the stack and go to its left child.

      b) If curr is null then pop from the stack .In this we pop in 2 conditions only
        1) If stack's top element right child is null ,then pop Or
        2) If popped item is right child of the top of stack,if it is then keep popping.

      c) Make  a temp node to store stack 's top element .When popping from stack store it in temp and print it.

      4) And when temp is not null then make it equal to curr --> curr = temp
    */

    public void postorderWithOneStack(Node root){

        Node curr = root;
        Stack<Node> s = new Stack<>();
        
        while(curr!=null || !s.isEmpty()){
             // if curr is not null push in the stack and go to left child
            if(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            else{
                


                Node temp = s.peek().right;   // right child of stack's top element

                if(temp==null){
                    // 1) If temp is null then pop from stack 
                    temp = s.pop();
                    System.out.print(temp.data+" ");
 
                    // 2) If stack is not empty and popped item is right child of stack's top then continue popping
                    while(!s.isEmpty() && temp == s.peek().right){
                        temp = s.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    // if temp is not null then assign it to curr
                    curr = temp;
                }
            }
        }
    }


    public static void main(String[] args) {

        PostOrderIterative tree = new PostOrderIterative();

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

        System.out.println();
        System.out.print(" POST-ORDER Traversal Using Two Stacks : ");
        tree.postOrderUsingTwoStack(root);

        System.out.println();
        System.out.print(" \nPOST-ORDER Traversal Using One Stack : ");
        tree.postorderWithOneStack(root);
    }


}

/* 

##  APPROACH FOR ONE STACK METHOD IN HINGLISH

1. Ek stack lena hai and ek curr node usko root ke equal krna h.

2. Jabtak stack empty ni hota ya curr node null nahi hota tab tak while loop run hoga.

    1) agr curr null nahi h to stack me push karo and curr ke left child me jao.And again usko stack me push kro firse 
       jabtak left child null ni pahuch jata.
    2) agar curr null ho jata h to hum pop krenge stack se.

    3) Hum ek temp node lenge aur usko stack ke top element ke right child ke equal krdenge. 
       [Node temp = st.peek().right]

    4) Hum stack me se sirf 2 conditions me hi pop krenge    (temp null h to)

      a) Agar temp null  h to hum pop krenge stack se(iska mtlb stack's top 's right child is null) and print it.
      b) agr popped item (in step a) right child h stack ke top ka,then pop it and print it untill

                while(!s.isEmpty() && temp == s.peek().right){
                                    temp = s.pop();
                                    System.out.print(temp.data+" ");
                                }

     5) Agar temp null nahi h to --> curr = temp 
   


*/