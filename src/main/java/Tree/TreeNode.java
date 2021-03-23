package Tree;

public class TreeNode {
    private int data;
    public TreeNode PNode;
    public TreeNode LNode;
    public TreeNode RNode;

    public TreeNode(int data) {
        super();
        this.data = data;
    }

    public TreeNode getLNode() {
        return LNode;
    }

    public void setLNode(TreeNode LNode) {
        this.LNode = LNode;
    }

    public TreeNode getRNode() {
        return RNode;
    }

    public void setRNode(TreeNode RNode) {
        this.RNode = RNode;
    }
    public String toString() {
        return "TreeNode [data=" + data + ", left=" + LNode + ", right=" + RNode
                + "]";
    }

}
