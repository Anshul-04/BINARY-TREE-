package Traversals.BFS;

public class SizeOfBinaryTree {
    static Node root;

    SizeOfBinaryTree(){root=null;}
    public static void main(String[] args) {
        
        SizeOfBinaryTree tree = new SizeOfBinaryTree();
            
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

        int size = tree.sizeOfTree(root);
        System.out.println("Size of Tree is : "+size);
    }

    public int sizeOfTree(Node root){

        if(root==null){
            return 0;
        }

        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }
}


/* 

Size of a tree = Size of left subtree + 1 + Size of right subtree.

Approach :
1. If tree is empty then return 0
2. Else
     (a) Get the size of left subtree recursively  i.e., call 
          size( tree->left-subtree)
     (a) Get the size of right subtree recursively  i.e., call 
          size( tree->right-subtree)
     (c) Calculate size of the tree as following:
            tree_size  =  size(left-subtree) + size(right-
                               subtree) + 1
     (d) Return tree_size
*/
