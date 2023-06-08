package Traversals.BFS;

public class HeightBalancedBinaryTree {
    static Node root;

    HeightBalancedBinaryTree(){root=null;}

    /* 
    Brute force Method

    TC - O(n2) and SC - O(n)
    */

    public boolean isBalanced (Node root){

        if(root==null){
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight-rightHeight)<=1){
            return true;
        }
        else{
            return false;
        }
    }
    public int height(Node root){

        if(root==null){return 0;}

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh,rh);

    }

    /* 
    Method 2 - Optimised method Writing the boolean and height functionality in one method

    In this we are calculatig the height and same time also checking if its balanced tree or not.

    The height2() function calculates the height of the binary tree rooted at the given node root.

    1) If the root node is null, it means we have reached the end of a subtree, so we return 0 to indicate a height of 0.

    2) Otherwise, we recursively calculate the height of the left subtree by calling height2() on the root.left node
       and store it in the variable lh.

    3) If the height of the left subtree (lh) is -1, it means the left subtree is not balanced. 
       In this case, we immediately return -1 from the current call to height2().
       This -1 value will be propagated up the recursive calls to indicate that the overall tree is not balanced.

    4) Similarly do the same thing for right subtree.

    5) If the heights of both the left and right subtrees differ by more than 1 (i.e., Math.abs(lh - rh) > 1),
       we return -1 to indicate an unbalanced tree.

    6) If none of the above conditions are met, it means the current subtree is balanced. We return the height of the
       subtree as 1 plus the maximum height between the left and right subtrees (1 + Math.max(lh, rh)).
     
           TC - O(n) and SC - O(n)

     */

     public boolean isBalanced2(Node root){
        if(height2(root)== -1){
            return false;
        }
        return true;
     }

     public int height2(Node root){

        if(root==null){return 0;} 

        //checking height of left subtree
        int lh = height2(root.left);
        // if it;s -1 then we know that it is not balanced and direct return it,then we don't need to check further
        if(lh == -1){return -1;}

        int rh = height2(root.right);
        if(rh == -1){ return -1;}
        
        if(Math.abs(lh-rh)>1){
            return -1;
        }
      
        return 1 + Math.max(lh,rh);
       
    }
    

    public static void main(String[] args) {
        
        HeightBalancedBinaryTree tree = new HeightBalancedBinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("The tree is Balanced tree : "+   tree.isBalanced(root));
      
    }
}

/* 

A tree is Balanced Binary tree if it satisfiy 3 conditions : 

1. The difference between height of left subtree and right subtree for any Node is less than or equal to 1.
2. The left subtree for that Node is also Balanced Binary tree.
3. The right subtree for that Node is also Balanced Binary tree.

   difference  =
    [ height(left) - height(right)] <= 1

*/