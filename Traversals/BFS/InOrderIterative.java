package Traversals.BFS;
import java.util.*;

/* 
https://practice.geeksforgeeks.org/problems/inorder-traversal/1?page=1&difficulty[]=-1&category[]=Tree&sortBy=submissions
*/



class InOrderIterative {
     static Node root;

    // InOrderIterative(){root=null;}

    public static void main(String[] args) {

        InOrderIterative tree = new InOrderIterative();

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

        System.out.print("Iterative InORDER Traversal : ");
        tree.inOrderIterative(root);
    }


    // Function to return a list containing the inorder traversal of the tree.

    

    public void inOrderIterative (Node root){

        Stack<Node> s= new Stack<>();

        if(root==null){
            return;
        }

        while(root!=null || !s.isEmpty()){

            if(root!=null){
                s.push(root);
                root = root.left;
            }
            else{
                if(s.isEmpty()){
                    break;
                }

                root = s.pop();
                System.out.print(root.data+" ");
                root = root.right;
            }
           
     
        }
    }

}
