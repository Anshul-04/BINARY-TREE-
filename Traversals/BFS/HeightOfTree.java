package Traversals.BFS;

public class HeightOfTree {
    static Node root;

    HeightOfTree(){root=null;}
    public static void main(String[] args) {
        
        HeightOfTree tree = new HeightOfTree();
            
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

    

        int height = tree.heightOfTree(root);
        System.out.println("Height of Tree is : "+ height);
    }

    public int heightOfTree(Node root){

        if(root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }
    
}

/* 

HEIGHT OR DEEPEST DEPTH OF TREE 


                   1 
                 /    \
                2       3 
              /  \     /  \
             4    5   6    7 
            / \  /\   /\   / \ 
           N  N  N N  N N  N  N
*/

