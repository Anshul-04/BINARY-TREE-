package Traversals.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Traversal_Level_By_Level {
   static Node root;

    Level_Order_Traversal_Level_By_Level (){
        root=null;
    }

    /*
     # Method 1 : Using 2 Queues

     1. Make 2 queue q1 & q2.Insert root in q1 .
     2. Pop from q1 untill its not empty and  add popped element's left and right child into q2.
     3. Now Pop from q2 untill its not empty and print it,and  add popped element's left and right child into q1.
     4.Repeat step 2 & 3 till both q1 and q2 are not empty.

     trick : Each queue holds one level at a time during iteration.

    */

    public void levelByLevelUsingTwoQueue(Node root){
        if(root==null){return;}

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
   
        q1.add(root);

        while(!q1.isEmpty() || !q2.isEmpty()){

            // Pop from q1 and add its left & right child into q2
            while(!q1.isEmpty()){
                root = q1.poll();
                System.out.print(root.data+" ");
                
                if(root.left!=null){
                    q2.add(root.left);
                }
                if(root.right!=null){
                    q2.add(root.right);
                }
            }
            System.out.println();  // For printing in  new level

            // Pop from q2 and add its left & right child into q1
            while(!q2.isEmpty()){
                root = q2.poll();
                System.out.print(root.data+" ");

                if(root.left!=null){
                    q1.add(root.left);
                }
                if(root.right!=null){
                    q1.add(root.right);
                }
            }
            System.out.println();  // For printing in  new level
        }

    }

    /*
     # Method 2 : Using One Queue and Delimeter

     1. Make a queue q.
     2. add root and a null (which act as Delimiter) in the q. 
     3. while q is not empty, do following steps.
       a) Pop from q and assign the popped element to Node curr.
       b) If curr is not null print it and add its left & right child in the q.
       c) If curr is null ,then again add it in the queue ,this way it act as a delimiter. 

     
    */
 
    public void oneQueueAndDelimiter(Node root){

        if(root==null){return;}

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Delimiter

        while(!q.isEmpty()){

            Node curr = q.poll();

            if(curr!=null){
                System.out.print(curr.data+" ");

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            else{
                if(!q.isEmpty()){
                    System.out.println();
                    q.add(null); // again adding null to the queue
                }
            }
            
        }
    }

        /*
     # Method 3 : Using One Queue and Count

     1. Make a queue q. and isert root in it.    
     2. while q is not empty, do following steps.
       a) Create a variable levelCount = q.size() ,  to get no. of node in each level.
       b) Pop from q and add its left & right child in the q.
       c) Decrese levelCount
       d) Print new Line. 

     
    */

    public void levelCountMethod(Node root){

        if(root==null){return;}

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int levelCount = q.size();

            if(levelCount==0){break;}
            while(levelCount>0){
                Node curr = q.poll();
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                levelCount--;
            }
            System.out.println();  // printing new level
        }
    } 

    public static void main(String[] args) {
        
        Level_Order_Traversal_Level_By_Level  tree = new Level_Order_Traversal_Level_By_Level ();

        
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

        System.out.println("Level By Level by 2 Queue : ");
        tree.levelByLevelUsingTwoQueue(root);

        System.out.println("\nLevel By Level Using One queue and Delimiter : ");
        tree.oneQueueAndDelimiter(root);

        System.out.println("\nLevel By Level Using  Count Method : ");
        tree.levelCountMethod(root);

    }
}

/* 

#Line By Line 

    
         
       
                 1
               /   \
              2     3
             / \   /  \
            4   5 6    7
               /      / \
               8     9  10
        
            Output : 1
                     2 3
                     4 5 6 7 
                     8 9 10

         

*/