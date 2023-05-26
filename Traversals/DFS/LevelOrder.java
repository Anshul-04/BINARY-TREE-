package Traversals.DFS;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left=right=null;
    }
}

public class LevelOrder {
    static Node root;
    LevelOrder(){
        root=null;
    }

    public static void main(String[] args) {
        LevelOrder tree = new LevelOrder();

        tree.root = new Node(1);   
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The Level Order Traversal is : ");
        tree.levelOrder(root);
    }

    public void levelOrder(Node root){

        if(root==null){
            return;
        }

        Queue<Node> q = new LinkedList<>();

        // add root into the queue
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.remove();       
            System.out.print(temp.data+" ");

            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return;

    }
}

/*    
 
# Level Order Binary Tree Traversal Using Queue

    For each node, first, the node is visited and then it’s child nodes are put in a FIFO queue. 
    Then again the first node is popped out and then it’s child nodes are put in a FIFO queue and 
    repeat until queue becomes empty.

    Follow the below steps to Implement the above idea:

    1. Create an empty queue q and push root in q.
    2. Run While loop until q is not empty. 
    3. Initialize temp_node = q.front() and print temp_node->data.
    4. Push temp_node’s children i.e. temp_node -> left then temp_node -> right to q
    5. Pop front node from q.

 */