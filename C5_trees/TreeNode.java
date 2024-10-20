package C5_trees;

import java.util.ArrayList;

public class TreeNode <T> {
   public T data;
    public ArrayList <TreeNode<T>> children;
    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>(); //capability of storing multiple children
    }
}