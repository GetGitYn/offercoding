package Tree;

public class BinaryTreeNextNode {

     public static TreeNode getNextNode(TreeNode node){
         if (node == null) return null;
        TreeNode nextNode=null;
         if(node.RNode!=null){ //如果存在右子树
             nextNode=node.RNode;
           while(nextNode.LNode!=null){
               nextNode=node.LNode;
           }

         }else if(node==node.PNode.LNode){//当前节点为父节点的左子树 且没有右子树
             nextNode=node.PNode;
         }else{//当前节点为父节点的右子树
             while(node.PNode!=null&&node.PNode.PNode!=null&&node.PNode.PNode.RNode==node.PNode){
                 node=node.PNode;
             }
             nextNode=node.PNode;
         }
       return nextNode;
     }
}
