package Traversals.BFS;

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

public class BinaryTree {

    public Node root=null;
 

 
   
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

         // Create root
          tree.root = new Node(1);

         /* Following is the tree after above statement
            1
           / \
         null null
         */

          tree.root.left = new Node(2);
          tree.root.right = new Node(3);
         /* 2 and 3 become left and right children of 1
               1
              / \
             2   3
            / \ / \
        null null null null */
          tree.root.left.left = new Node(4);
          tree.root.left.right = new Node(5);

          tree.root.right.left = new Node(6);
          tree.root.right.right = new Node(7);


         /* 
         
         4 becomes left child of 2
                 1
               /   \
              2     3
             / \   /  \
            4   5 6    7
           / \
         null null

         */

//         tree.insert(root, 1);
//         tree.insert(root, 2);
//         tree.insert(root, 3);
//         tree.insert(root, 4);
//         tree.insert(root, 5);
//         tree.insert(root, 6);
//         tree.insert(root, 7);


         tree.printTree();
    }
    
    public  void printTree(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            printTree(root.left);
            printTree(root.right);
        }

    }
    public void printTree(){
        printTree(root);
    }

    public  void insert(Node temp, int key)
    {
 
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

   

   
}
 