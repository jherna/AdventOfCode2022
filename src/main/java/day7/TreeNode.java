package day7;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
    private String tag;
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    public TreeNode(String tag, T data) {
        this.data = data;
        this.tag = tag;
        this.children = new LinkedList<TreeNode<T>>();
    }
    public TreeNode(String tag) {
        this.tag = tag;
        this.children = new LinkedList<TreeNode<T>>();
    }

    public TreeNode<T> addChild(String tag, T data) {
        TreeNode<T> childNode = new TreeNode<T>(tag, data);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "tag='" + tag + '\'' +
                ", data=" + data +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}
