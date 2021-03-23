package Tree;


/**
 * 根据前序与中序遍历顺序重构二叉树
 * 思想：
 * 根据前序遍历找到根节点 ，
 * 对于中序遍历而言，根节点之前的节点都是左子树，根节点之后的节点都是右子树
 * 对于左/右子树而言，前序遍历中的第二个节点为左子树的根节点，前序遍历中的（1+左子树长度）处对应的节点为右子树根节点，
 * 根据左右子树的根节点继续划分左子树与右子树
 *
 *
 * 根据中序和后序遍历重建二叉树：
 *
 */
public class RebuildBinaryTree {

    public static TreeNode buildTreeNodeRelation(int[] bsf,int bstart,int bend,int[] msf,int mstart,int mend){
        if(bstart>bend||mstart>mend){return null;}
        TreeNode root=new TreeNode(bsf[bstart]);
        for(int i=mstart;i<=mend;i++){
            if(msf[i]==bsf[bstart]){
                root.LNode=buildTreeNodeRelation(bsf,bstart+1,bstart+(i-mstart),msf,mstart,i-1);
                root.RNode=buildTreeNodeRelation(bsf,bstart+(i-mstart)+1,bend,msf,i+1,mend);
            }
        }
    return root;
    }


    /**
     * 根据中序和后序重构二叉树
     * 在后序遍历中，每次每个树的遍历的最后一个节点为根节点
     *
     * int []inorder = {1, 2, 3, 4, 5, 6, 7};
     * 	int []postorder = {2, 4, 3, 1, 6, 7, 5};
     *
     * @return
     */
    public static TreeNode buildTreeByML(int[] msf,int mstart,int mend,int[] lsf,int lstart,int lend){
        if(mstart>mend||lstart>lend) {return null;}
        TreeNode root=new TreeNode(lsf[lend]);
        for(int i=mstart;i<=mend;i++){
            if(msf[i]==lsf[lend]){
                root.LNode=buildTreeByML(msf,mstart,i-1,lsf,lstart,lstart+(i-1-mstart));
                root.RNode=buildTreeByML(msf,i+1,mend,lsf,lstart+(i-mstart),lend);
            }
        }
    return root;
    }



    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root=buildTreeNodeRelation(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        System.out.println(root);
    }
}
