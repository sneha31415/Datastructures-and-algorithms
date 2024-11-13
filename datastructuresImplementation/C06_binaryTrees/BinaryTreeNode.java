package C6_binaryTrees;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> left;
    //constructor
    public BinaryTreeNode(T data){
        this.data = data;
    }
}
