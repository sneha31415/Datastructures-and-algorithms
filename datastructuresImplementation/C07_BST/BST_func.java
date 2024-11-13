package C7_BST;

import C6_binaryTrees.*;
import org.example.test.Person;

import java.util.Arrays;

import static C6_binaryTrees.BinaryTreeUse.*;
//import static binaryTrees.BinaryTreeUse.takeInputLevelWise;

public class BST_func {
    //return true is x is present in the tree else false
    public static boolean search(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        else if(root.data>x){
            return search(root.left,x);
        }
        else{
            return search(root.right,x);
        }
    }
        //return the pointer of the node if x is present in the tree or else return null
    public static BinaryTreeNode<Integer> searchNode(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return null;
        }
        if(root.data == x){
            return root;
        }
        else if(root.data > x){
            return searchNode(root.left, x);
        }
        else{
            return searchNode(root.right, x);
        }
    }

    public static void printInRangek1k2(BinaryTreeNode<Integer> root, int lowerlimit, int upperlimit){
        if(root==null){
            return;
        }
        if(root.data>=lowerlimit && root.data<=upperlimit){
            printInRangek1k2(root.left,lowerlimit,upperlimit);
            System.out.print(root.data + " ");
            printInRangek1k2(root.right, lowerlimit, upperlimit);
        }
        else if(root.data>upperlimit){
            printInRangek1k2(root.left,lowerlimit,upperlimit);
        }
        //CHECK ON LEETCODE IF THE <= IS NECESSARY OR JUST < IS ENOUGH
        else if(root.data<=lowerlimit){ //<= buz rightsubtree may contain child nodes with data equal to the root as per the defn of bst
            printInRangek1k2(root.right, lowerlimit, upperlimit);
        }
    }

    public static BinaryTreeNode<Integer> sortedArrayToBSTHelper(int arr[],int si, int ei){
        //IN POINTER METHOD, THE BASE CASE IS ALWAYSSSS THIS!!!
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
       BinaryTreeNode<Integer> left = sortedArrayToBSTHelper(arr,si,mid-1);
       BinaryTreeNode<Integer> right = sortedArrayToBSTHelper(arr,mid+1,ei);

        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode<Integer> sortedArrayToBST(int arr[]){
        return sortedArrayToBSTHelper(arr, 0, arr.length-1);
    }

    public static int minimum(BinaryTreeNode<Integer> root){
        if(root==null){
            return -1;
        }
        int minLeft = minimum(root.left);
        int minRight = minimum(root.right);
        return Math.min(root.data,Math.min(minLeft,minRight));
    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }
        int maxLeft = largestNode(root.left);
        if(root.data<=maxLeft){
            return false;
        }
        int minRight = minimum(root.right);
        if(root.data>minRight){
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return (isLeftBST && isRightBST);
    }
     /* public static boolean isBSTbetter(BinaryTreeNode<Integer> root){
        //an emptytree is always a BST
        if(root==null){
            return true;
        }

        if(root.left!=null && root.left.data>=root.data){
            return false;
        }
        if(root.right!=null && root.right.data<root.data){
            return false;
        }
        boolean isleftBST = isBSTbetter(root.left);
        boolean isRightBST = isBSTbetter(root.right);
        return (isRightBST && isleftBST);

    }   **THIS CODE WILL NOT WORK FOR A TREE LIKE=
                 5
               /   \
              4     6
                   / \
                  3   7
    */

    public static isBSTReturn isBSTBetter(BinaryTreeNode<Integer> root){
        if(root == null){
            //if root is null, then min is +infinity and max is -infinity
            isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }
        //left se teeno values mangaoo
        isBSTReturn leftAns = isBSTBetter(root.left);
        isBSTReturn rightAns = isBSTBetter(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));

        boolean isBST = true;
        //now check the 4 conditions of a bst
        if(leftAns.max >= root.data){
            isBST = false;
        }
        if(rightAns.min < root.data){
            isBST = false;
        }
        if(!leftAns.isBST){
            isBST = false;
        }
        if(!rightAns.isBST){
            isBST = false;
        }
        isBSTReturn ans = new isBSTReturn(min,max,isBST);
        return ans;
    }

    public static boolean isBSTBest(BinaryTreeNode<Integer> root, int minRange, int maxRange){
        if(root == null){
            return true;
        }
        if(root.data < minRange || root.data > maxRange){
            return false;
        }

        boolean isLeftWithinRange = isBSTBest(root.left,minRange,root.data + 1);
        boolean isRightWithinRange = isBSTBest(root.right, root.data, maxRange);
        return (isLeftWithinRange && isRightWithinRange);
    }



    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println(isBST(root));

        //printInRangek1k2(root,5,18);
        int arr[] = {1,2,3,4,5,6,7};
       BinaryTreeNode<Integer> root1 = sortedArrayToBST(arr);
       printLevelWise(root1);
        System.out.println(isBST(root1));

    }
}
