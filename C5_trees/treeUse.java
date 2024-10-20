package C5_trees;

import com.sun.source.tree.Tree;
import C4_queue.QueueEmptyException;
import C4_queue.queueUsingLinklist;

import java.util.Scanner;

public class treeUse {
    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
      //Scanner s = new Scanner(System.in); MAKE A COMMON SCANNER
        System.out.println("enter next node data");
        n = s.nextInt();
        TreeNode<Integer> root =  new TreeNode<>(n);
        System.out.println("enter number of children for "+n);
        int childCount = s.nextInt();
        for(int i=0;i<childCount;i++){
            TreeNode<Integer> child = takeInput(s);
            //jab iss func se return honge tab child ko add karna hai
            root.children.add(child);
        }
    return root;
    }

    public static void print(TreeNode<Integer> root){
        String s = root.data + ":";
        for(int i=0;i<root.children.size();i++){
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i =0;i<root.children.size();i++){
            print(root.children.get(i)) ;
        }
    }
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("enter root data");
        int rootdata = s.nextInt();
        queueUsingLinklist <TreeNode<Integer>> pendingNodes = new queueUsingLinklist<>();
        TreeNode<Integer> root = new TreeNode<>(rootdata);
        pendingNodes.enqueue(root);
        while(!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("enter num of children of "+frontNode.data);
                int numChildren = s.nextInt();

                //putting the value of each of children data for the frontNode
                for(int i=0;i<numChildren;i++){
                    System.out.println("enter the data  "+ (i+1) + "th child of " + frontNode.data);
                    int child = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode); //building the connection of root with child
                    pendingNodes.enqueue(childNode);  //adding the child in the stack of pending nodes cuz uske bhi children hume puchne hai
                }
            } catch (QueueEmptyException e) {
                //the code is anyways not gonna come here at catch cuz we have put the case while(!pendingNodes.isEmpty())
                return null;
            }
        }
        return root;
    }
    public static void printLevelWise(TreeNode<Integer> root){
        queueUsingLinklist <TreeNode<Integer>> pendingNode = new queueUsingLinklist<>();
        String s = root.data + ":";
        pendingNode.enqueue(root);
        while(!pendingNode.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNode.dequeue();
                String p = frontNode.data + ":" ;
                for(int i=0;i<frontNode.children.size();i++){
                    p = p + frontNode.children.get(i).data+",";
                    pendingNode.enqueue(frontNode.children.get(i));
                }
                System.out.println(p);

            } catch (QueueEmptyException e) {
                return;
            }
        }
    }
    public static int largestNode(TreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int ans = root.data;
        for(int i =0;i<root.children.size();i++){
            int child= largestNode(root.children.get(i));
            if(child>ans){
                ans = child;
            }
        }
        return ans;
    }
    public static int numNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int ans = 1;
        for(int i=0;i<root.children.size();i++){
            ans += numNodes(root.children.get(i));
        }
        return ans ;
    }
    public static int height(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int height =1;
        for(int i=0;i<root.children.size();i++){
           int heightsmall = 1;
           heightsmall += height(root.children.get(i));
           if (heightsmall>height){
               height=heightsmall;
           }
        }
        return height;
    }
    public static void printAtk(TreeNode<Integer> root, int k){
        if(k<0 || root==null){
            return ;
        }
        if(k==0){
            System.out.print(root.data+ " ");
        }
        for(int i=0;i<root.children.size();i++) { // ek ek karke haar ek child pe print at k-1 call karo
            printAtk(root.children.get(i),k-1 );
        }
    }
    public static int numLeaf(TreeNode<Integer> root) {
        int num =0;
        if (root == null) {
            return 0;
        }
        if(root.children.size()==0){
            return 1;
        }
        for (int i = 0; i < root.children.size(); i++) {
            num +=numLeaf(root.children.get(i));

        }
        return num;
    }
    public static void preorder(TreeNode<Integer> root){
        System.out.print(root.data + " ");
        for(int i =0;i<root.children.size();i++){
            preorder(root.children.get(i));
        }
    }
    public static void postorder(TreeNode<Integer> root){
        for(int i=0;i<root.children.size();i++){
            postorder(root.children.get(i));
           // System.out.print(root.data+" "); ***PRINTING INSIDE THE FOR LOOP IS WRONG****
        }
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>( 9);
//        TreeNode<Integer> node4 = new TreeNode<>(6);
//        TreeNode<Integer> node5 = new TreeNode<>(7);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//        node2.children.add(node5);
//        System.out.println(root);
       // Scanner s = new Scanner(System.in);
       // TreeNode<Integer> t =takeInput(s);
        TreeNode<Integer> t =takeInputLevelWise();
        printLevelWise(t);
        /*System.out.println(numNodes(t));
        System.out.println(largestNode(t));
        System.out.println(height(t));
        printAtk(t,1);
        System.out.println();
        System.out.println(numLeaf(t));*/
        postorder(t);
        preorder(t);
    }
}
