package Traversals.BFS;



public class BinaryTreeTraversal {

    static Node root;
    BinaryTreeTraversal(){
        root=null;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        tree.root = new Node(1);   
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.print("Pre-Order : ");
        tree.preOrder(root);

        System.out.print("\nIn-Order : ");
        tree.inOrder(root);

        System.out.print("\nPost-Order : ");
        tree.postOrder(root);
    }

    /*
     
    # 1 - PreOrder Traversal :-
     
     1. Visit the root.
     2. Traverse the left subtree, i.e., call Preorder(left->subtree)
     3. Traverse the right subtree, i.e., call Preorder(right->subtree) 


     Uses of Preorder:-
     Preorder traversal is used to create a copy of the tree. 
     Preorder traversal is also used to get prefix expressions on an expression tree.
     */

    public void preOrder(Node root){      

        if(root==null){return;}

        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
     }

     /*
     
    # 2 - InOrder Traversal :-
     
     1. Traverse the left subtree, i.e., call Preorder(left->subtree)      
     2. Visit the root.
     3. Traverse the right subtree, i.e., call Preorder(right->subtree) 


     Uses of Inorder:-
     In the case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order
     */
    
    public void inOrder(Node root){      

        if(root==null){return;}

        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");           
            inOrder(root.right);
        }
     }

     /*
     
    # 3 - PostOrder Traversal :-
     
     1. Traverse the left subtree, i.e., call Preorder(left->subtree)      
     2. Traverse the right subtree, i.e., call Preorder(right->subtree) 
     3. Visit the root.


    Uses of PostOrder:-
        Postorder traversal is used to delete the tree. 
        Postorder traversal is also useful to get the postfix expression of an expression tree
     */
    
    public void postOrder(Node root){    
        
        if(root==null){return;}
        
        if(root != null){
            postOrder(root.left);                     
            postOrder(root.right);
            System.out.print(root.data+" "); 
        }
     }     

}

/*   
 
                 1 ------> root node
               /   \
              2     3 -----> internal node
             / \   /  \
            4   5 6    7 ------> leaf node

            

                               1 ----------> root
                            /     \
                     ---   2       3    --- 
   LEFT SUBTREE  <---|    / \     /  \    |----> RIGHT SUBTREE 
                     --- 4   5   6    7 --- 


1) 

PRE - ORDER :  [ 1 2 4 5 3 6 7 ] 

    1       2     4     5       3     6      7 
    |       |     |     |       |     |      | 
    |      root  left  right   root  left   right   
  |____|   |_______________|   |_______________| 
   ROOT         LEFT                 RIGHT


2)

IN - ORDER :  [ 4 2 5 1 6 3 7 ]

     4      2      5        1       6      3      7 
     |      |      |        |       |      |      |
    left   root   right     |      left   root   right
    |________________|    |___|    |________________| 
         LEFT              ROOT           RIGHT



3)

POST - ORDER :  [ 4 5 2 6 7 3 1 ]

   4     5     2         6     7      3      1
   |     |     |         |     |      |      |
  left  right root     left  right   root    |
  |______________|     |________________|  |___|
       LEFT                 RIGHT           ROOT
        
 
 */