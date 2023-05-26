package Traversals.DFS;

import java.util.*;

//class Node{
//    int data;
//    Node left;
//    Node right;
//
//    Node(int data){
//        this.data = data;
//        left=right=null;
//    }
//}

public class LevelOrder2 {
    static Node root;
    LevelOrder2(){
        root=null;
    }

    public static void main(String[] args) {

        LevelOrder2 tree = new LevelOrder2();

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


        System.out.println("The Level Order Traversal is : ");
        List<List<Integer>> ans = tree.levelOrder2(root);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ans.size(); i++) {
            sb.append("[");
            List<Integer> level = ans.get(i);
            for (int j = 0; j < level.size(); j++) {
                sb.append(level.get(j));
                if (j < level.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i < ans.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

    public List<List<Integer>> levelOrder2(Node root){

        List<List<Integer>> ans = new LinkedList<>();        

        Queue<Node> q = new LinkedList<>();
        // add root into the queue
        q.add(root);

        if(root==null){
            return ans ;
        }

        while(!q.isEmpty()){

           // List to store each levels

           List<Integer> list = new LinkedList<>();
           int n = q.size();  // size of current level

           for(int i=0;i<n;i++){

            Node temp = q.remove();
            list.add(temp.data);
           
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
           }
           // Adding each level list to main list
           ans.add(list);
        }   
        return ans;

    }
}

/*  
 In this we are return List of each level

           1                  Level - 1
         /    \
       2       3              Level - 2
     /   \    /  \
    4     5  6    7           Level - 3
         /       /  \
        8       9    10       Level - 4

        Return out as List of List ==> [ [Level-1],[Level-2],[Level-3],[Level-4]]

       O/P -  [ [1], [2,3], [4,5,6,7], [8,9,10] ]

       This method is most important because with the help of this we can solve many questions.

*/
