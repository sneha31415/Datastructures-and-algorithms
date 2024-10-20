package C6_binaryTrees;
import java.util.*;
public class BinaryTreeUse {
    public static void print(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }
    public static void printBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data+":");
        if(root.left!=null){
            System.out.print("L:"+root.left.data+", ");
        }
        if(root.right!=null){
            System.out.print("R:"+root.right.data+", ");
        }
        System.out.println();
    }
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root==null){
        }

        Queue <BinaryTreeNode<Integer>> pendingnodes = new LinkedList<>();
        pendingnodes.add(root);
         while(!pendingnodes.isEmpty()){
             BinaryTreeNode<Integer> front = pendingnodes.remove();
             String p = front.data + ": ";
             if(front.left!=null){
                 p += "L:" + front.left.data + ",";
                 pendingnodes.add(front.left);
             }
             if(front.right!=null){
                 p += "R:" + front.right.data;
                 pendingnodes.add(front.right);
             }
             System.out.println(p);
         }
    }

    public static BinaryTreeNode<Integer> takeInput(){
        System.out.println("enter the root data");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        BinaryTreeNode<Integer> leftChild = takeInput();
        BinaryTreeNode<Integer> rightChild = takeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    // GO THROUGH THE CODE ONCE //still recursive
    public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if (isRoot) {  //we want to say enter root data only when we have the root snd not for the children
            System.out.println("enter the root data");
        } else{  //now, if it is not the root, then ask if it is left or right child
             if(isLeft){
                 System.out.println("Enter left child of " + parentData);
             }
             else{
                 System.out.println("Enter right child of " + parentData);
             }
        }
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        BinaryTreeNode<Integer> leftChild = takeInputBetter(false,data,true); //we are not looking for overall root, so isRoot = false
        BinaryTreeNode<Integer> rightChild = takeInputBetter(false,data,false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static int numNodes(BinaryTreeNode<Integer> root){
        if (root==null){
            return 0;
        }
        int leftnodes = numNodes(root.left);
        int rightnodes = numNodes(root.right);
        return 1+leftnodes+rightnodes;
    }
    public static int getSum(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int sumLeft = getSum(root.left);
        int sumRight = getSum(root.right);
        return root.data+sumLeft+sumRight;
    }
    public static int largestNode(BinaryTreeNode<Integer> root){
        if(root==null){
            return -1;
        }
        int largestLeft = largestNode(root.left);
        int largestRight = largestNode(root.right);
        return Math.max(root.data, Math.max(largestLeft,largestRight));
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x){
        int count = 0;
        if(root==null){
            return 0;
        }
        if(root.data>x){
            count ++;
        }
        count += countNodesGreaterThanX(root.left,x);
        count += countNodesGreaterThanX(root.right,x);
        return count;
    }

    public static int height(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int hLeft = height(root.left);
        int hRight = height(root.right);
        return 1+Math.max(hLeft,hRight);

    }

    public static int numLeafNodes(BinaryTreeNode<Integer> root){
        int count = 0;
        if(root == null){
            return 0;
        }
        //if roor is a leaf, then it must meet these conditions
        if(root.left==null && root.right==null){
            count++;
        }
        count += numLeafNodes(root.left);
        count += numLeafNodes(root.right);
        return count;
        //or return numLeafNodes(root.left)+numLeafNodes(root.right)
    }

    public static void PrintNodesAtdepth(BinaryTreeNode<Integer> root,int depth){
        if(root == null){
            return;
        }
        if(depth == 0){
            System.out.print(root.data+" ");
            return;
        }
        PrintNodesAtdepth(root.left, depth-1);
        PrintNodesAtdepth(root.right, depth -1);
    }

    public static BinaryTreeNode<Integer> removeleaves(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        //condition to detect a node
        if (root.left == null && root.right == null){
            return null;
        }
        root.left = removeleaves(root.left);
        root.right = removeleaves(root.right);
        return root;
    }
    public static void mirror(BinaryTreeNode<Integer> root){
        if(root ==null){
            return;
        }
        mirror(root.left);
        mirror(root.right);
        //swapping the smaller mirrored trees obtained by recursion
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1){
           return false;
        }

        Boolean isleftBalanced =  isBalanced(root.left);
        Boolean isRightBalanced= isBalanced(root.right);
        return isleftBalanced && isRightBalanced;
    }

    public static balancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        //Base case
        if(root == null){
            int height = 0;
            boolean isBal = true;
            balancedTreeReturn ans = new balancedTreeReturn();
            ans.isBalanced = isBal;
            ans.height= height;
            return ans;
        }
        balancedTreeReturn leftOutput = isBalancedBetter(root.left);
        balancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        //After these two recursive calls, we have all the four info i.e height of left and right tree and whether left and right subtree is balanced or not
        //based of these info return true or false

        if(Math.abs(leftOutput.height-rightOutput.height)>1){
           isBal = false;
        }
        //if either of left or right subtree is not balanced then the whole tree is unbalanced
        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }
        balancedTreeReturn ans = new balancedTreeReturn();
        ans.isBalanced = isBal;
        ans.height = height;
        return ans;
    }

    public static int diameter(BinaryTreeNode<Integer> root){
        if(root== null){
            return 0; //diameter is zero if root is null
        }
        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1,Math.max(option2,option3));
    }

    public static diameterReturn diameterBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            diameterReturn ans = new diameterReturn();
            ans.diameter = 0;
            ans.height=0;
            return ans;
        }
        diameterReturn leftoutput = diameterBetter(root.left);
        diameterReturn rightoutput = diameterBetter(root.right);

        int height = 1 + Math.max(leftoutput.height,rightoutput.height);
        /*option1 denotes the longest distance between
        * the deepest node of the left and right subtree*/
        int option1 = leftoutput.height + rightoutput.height;

        diameterReturn ans = new diameterReturn();
        ans.height = height;
        ans.diameter = Math.max(option1,Math.max(leftoutput.diameter,rightoutput.diameter));
        return ans;
    }

    //since its level wise, we cannot use recursion
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        System.out.println("enter root data");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        //this is not a base case as its not a recursive function
        if(data ==-1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        //Queue is an interface so we need a class which implements queue in the java collections framework
        //Queue must be of nodes and not data cuz we cannot make connections to left and right child using just data
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.remove();
            System.out.println("enter left child of "+ front.data);
            int leftdata = s.nextInt();
            if(leftdata==-1){

            }
            else {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftdata);
                front.left = leftChild;
                pendingNodes.add(leftChild);
            }


            System.out.println("enter right child of "+ front.data);
            int rightdata = s.nextInt();
            if(rightdata==-1){
               //do nothing cuz it means that this node is not there thus no need of creating a node
            }
            else {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightdata);
                front.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }
        return root;
    }
        //pre = preorder , in = inorder
    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn){
        //the length of preorder and inorder is same so if siPre>eiPre then same will happend for inorder aswell
        if(siPre> eiPre){
            return null;
        }
        int rootData = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for(int i=0;i<in.length;i++){
            if(in[i]==rootData){
                rootIndex = i;
            }
        }

        int siPreLeft = siPre+1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex-1;
        int eiPreRight = eiPre;
        int siInRight = rootIndex+1;
        int eiInRight = eiIn;

        //int lenLeft = rootIndex - siIn; // eiInLeft + 1 - siInLeft  WHY IS THIS INCORRECT??????
        int lenLeft = eiInLeft - siInLeft;

        int eiPreLeft = siPre + lenLeft +1;
        int siPreRight = eiPreLeft + 1;

        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
        root.left = left;
        root.right = right ;
        return root;

    }

    public static BinaryTreeNode<Integer> BuildTreefromPreIn(int pre[], int inorder[]){
        return buildTreeFromPreInHelper(pre,inorder,0, pre.length-1,0,inorder.length-1);
    }

    //build tree using the given preoder and inorder
    /*  THIS IS NOT A GOOD CODE AS NEWER ARRAYS WILL USE A LOT OF SPACE IN RECURSION CALL SO USE POINTERS
    public static BinaryTreeNode<Integer> buildTree(int preorder[],int inorder[]){
        //
        if(preorder.length==0 && inorder.length==0){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preorder[0]);
        if(preorder.length==1 && inorder.length==1){
            return root;
        }
        int index = 0;
        while(inorder[index]!=root.data){
            index++;
        }
        int leftinorder[] = Arrays.copyOfRange(inorder,0,index);
        int rightinorder[] = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int leftpreorder[] = Arrays.copyOfRange(preorder,1,leftinorder.length+1);
        int rightpreorder[] = Arrays.copyOfRange(preorder,1+leftinorder.length,inorder.length);

        BinaryTreeNode<Integer> leftroot = buildTree(leftpreorder, leftinorder);
        BinaryTreeNode<Integer> rightroot = buildTree(rightpreorder, rightinorder);
        root.left = leftroot;
        root.right = rightroot;
        return root;
    }*/

    //NOT WORKING
    public static BinaryTreeNode<Integer> BuildTreeFromInPostHelper(int inorder[], int post[], int siIn, int eiIn, int siPost, int eiPost){
        if(siIn>eiIn){
            return null;
        }

        //ROOT IS THE LAST NODE IN THE POST ORDER
        int rootData = post[post.length-1];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        //getting the index of root in the INORDER
        int rootindexIn = -1;
        for(int i=0;i<inorder.length;i++) {
            if (inorder[i] == rootData) {
                rootindexIn = i;
            }
        }
            int siInLeft= siIn;
            int eiInLeft = rootindexIn-1;
            int siPostLeft = siPost;
            int siInRight = rootindexIn + 1 ;
            int eiInRight = eiIn;
            int eiPostRight = eiPost -1 ;

            int lenLeft = eiInLeft-siInLeft;
            int eiPostLeft = lenLeft-1;
            int siPostRight = eiPostLeft+1;

            BinaryTreeNode<Integer> left = BuildTreeFromInPostHelper(inorder,post,siInLeft,eiInLeft,siPostLeft,eiPostLeft);
            BinaryTreeNode<Integer> right = BuildTreeFromInPostHelper(inorder,post,siInRight,eiInRight,siPostRight,eiPostRight);
            root.left = left;
            root.right = right;
            return root;
        }

        public static BinaryTreeNode<Integer> BuildTreeFromInPost(int inorder[], int post[]){
        return BuildTreeFromInPostHelper(inorder,post,0,inorder.length-1,0,post.length-1);
        }



    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> r2 = new BinaryTreeNode<>(3);
//        BinaryTreeNode<Integer> r3 = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> r4 = new BinaryTreeNode<>(5);
//        root.left = r1;
//        root.right = r2;
//        r1.left = r3;
//        r1.right = r4;


//        System.out.println(largestNode(root));
//        System.out.println(countNodesGreaterThanX(root,3));
//        System.out.println(height(root));
//        System.out.println(numLeafNodes(root));
         // PrintNodesAtdepth(root,3);
        //  print(root);
//        printLevelWise(root);
//        BinaryTreeNode<Integer> root1 = takeInput();
//        printLevelWise(root1);

//        BinaryTreeNode<Integer> root = takeInputBetter(true,0,true); //data of the node will be asked by the function itself by use of scanner
        // isroot = true is passed cuz our first input is root, and the moment isroot is true, the next two parameters do not matter cuz vo else condition mei jayega hi nahi.. if(isRoot) mei jayega
//        removeleaves(root);
//        printBetter(root);

//        printBetter(root);
//        System.out.println();
//        mirror(root);
//        printBetter(root);

        //     System.out.println(isBalanced(root));

//        BinaryTreeNode<Integer> root2 = takeInputBetter(true,0,false);
//        System.out.println(diameterBetter(root2).diameter);

//        BinaryTreeNode<Integer> root3 =takeInputLevelWise();
//        printLevelWise(root3);

        /*int preoder[] = {1,2,4,5,3,6,7};
        int inorder[] = {4,2,5,1,6,3,7};
        BinaryTreeNode<Integer> root = BuildTreefromPreIn(preoder,inorder);
        printLevelWise(root);*/


        int inorder[] = {4,2,5,1,6,3,7};
        int postorder[] = {4,5,2,6,7,3,1};
        BinaryTreeNode<Integer> root = BuildTreeFromInPost(inorder,postorder);
        printLevelWise(root);
    }
}
