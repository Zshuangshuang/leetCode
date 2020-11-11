import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-11
 * Time: 9:05
 **/

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int val){
        this.val = val;
    }
    
}
public class TestTree {
    //找到两个节点的公共祖先
    //思路:
    //(1)两个节点可能均在左子树中
    //(2)两个数可能都在左子树中
    //(3)一个在左子树，一个在右子树（自己就是自己的公共祖先）
    //(4)一个是根节点，一个在左右子树中（只能是自己）
    private boolean search(TreeNode root,TreeNode t){
        if (root == null){
            return true;
        }
        if (root == t){
            return true;
        }
        if (search(root.left,t)){
            return true;
        }
        return search(root.right,t);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //若其中有一个节点就是根节点，那么直接返回根节点
        if (root == p || root == q){
            return root;
        }
        //判断节点是不是在左子树中或者在右子树当中
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root,q);
        //若均在左子树，就递归访问左子树
        if (pInLeft && qInLeft){
            return  lowestCommonAncestor(root.left,p,q);
        }
        //若均在右子树，则对右子树递归访问
        if (!pInLeft && !qInLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        //当前节点就是根节点
        return root;

    }

    //将二叉搜索树转换成一个有序的双向链表
    public static TreeNode Convert(TreeNode pRootOfTree) {
        //如果当前搜索树为空树，直接返回null
        if (pRootOfTree == null) {
            return  null;
        }
        //如果当前搜索树仅有一个叶子节点，则直接返回该节点
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //找到当前二叉搜索树的左子树的尾巴节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //将尾巴节点和根节点连起来
        if (left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //找到当前二叉搜索树的右子树，把根节点和右子树连接起来
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        if (left == null){
            return pRootOfTree;
        }
        return left;
    }
    //前序遍历和中序遍历二叉树
    //将数组转为List
    private List<Integer> intArrayToList(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int e : array){
            list.add(e);
        }
        return list;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> prevOrderList = intArrayToList(preorder);
        List<Integer> inOrderList = intArrayToList(inorder);


        return buildTreeHelper(prevOrderList,inOrderList);
    }

    private TreeNode buildTreeHelper(List<Integer> prevOrderList, List<Integer> inOrderList) {
        if (prevOrderList.isEmpty()){
            return null;
        }
        int rootVal = prevOrderList.get(0);
        TreeNode root = new TreeNode(rootVal);
        if (prevOrderList.size() == 1){
            return root;
        }
        //找到左子树的值的位置
        int leftSize = inOrderList.indexOf(rootVal);
        //切割
        List<Integer> leftPrev = prevOrderList.subList(1,1+leftSize);
        List<Integer> rightPrev = prevOrderList.subList(1+leftSize,prevOrderList.size());
        List<Integer> leftIn = inOrderList.subList(0,leftSize);
        List<Integer> rightIn = inOrderList.subList(leftSize+1,inOrderList.size());
        //构建左子树
        root.left = buildTreeHelper(leftPrev,leftIn);
        //构建右子树
        root.right = buildTreeHelper(rightPrev,rightIn);
        return root;
    }
    public String tree2str(TreeNode t) {
        StringBuilder stringBuilder = new StringBuilder();
        prevOrder(stringBuilder,t);
        return stringBuilder.toString();
    }

    private void prevOrder(StringBuilder stringBuilder, TreeNode t) {

        if (t != null){
            stringBuilder.append(t.val);
            if (t.left == null && t.right == null){
                return;
            }
            if (t.left != null && t.right == null){
                stringBuilder.append("(");
                prevOrder(stringBuilder,t.left);
                stringBuilder.append(")");
            }
            stringBuilder.append("(");
            prevOrder(stringBuilder,t.left);
            stringBuilder.append(")");

            stringBuilder.append("(");
            prevOrder(stringBuilder,t.right);
            stringBuilder.append(")");
        }
    }
}
