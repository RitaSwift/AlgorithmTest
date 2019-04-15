package sample;

/**
 * 面试题6：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6},
 * 则重建出二叉树并输出它的头结点。
 */
public class Test6 {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 树的根节点
     */
    public static BinaryTreeNode construct(int[] preorder,int[] inorder){
        //输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }

        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    /**
     * 输入二叉树的前序遍历和中序遍历的结果，重建二叉树。
     * @param preorder 前序遍历
     * @param ps 前序遍历的开始位置
     * @param pe 前序遍历的结束位置
     * @param inorder 中序遍历
     * @param is 中序遍历的开始位置
     * @param ie 中序遍历的结束位置
     * @return 树的根节点
     */
    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder,int is,int ie){
        //开始位置大于结束位置说明没有需要处理的元素了
        if(ps > pe){
            return null;
        }

        //取前序遍历的第一个数字，就是当前根节点
        int value = preorder[ps];
        int index = is;
        //在中序遍历的数组中找根节点的位置
        while(index <= ie && inorder[index] != value){
            index++;
        }

        //如果在整个中序遍历中数组中没有找到，则参数不合法
        if(index > ie){
            throw new RuntimeException("Invalid input");
        }

        //创建当前的根节点，并且为节点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        //递归创建当前根节点的左子树，左子树的元数格式：index-is+1个
        //左子树对应的前序遍历的位置在[ps+1,ps+index-is]
        //左子树对应的中序遍历的位置在[is,index-1]
        node.leftChild = construct(preorder, ps+1, ps + index - is,inorder,is,index-1);
        //递归构建当前根节点的右子树，右子树的元素个数：ie-index个
        //右子树对应的前序遍历的位置在[ps+index-is+1,pe]
        //右子树对应的中序遍历的位置在[index+1,ie]
        node.rightChild = construct(preorder,ps+index-is+1,pe,inorder,index+1,ie);

        //返回创建的根节点
        return node;
    }

    //中序遍历二叉树
    public static void printTree(BinaryTreeNode root){
        if(root != null){
            printTree(root.leftChild);
            System.out.println(root.value + " ");
            printTree(root.rightChild);
        }
    }

    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    public static void main(String[] args) {
        test1();
    }


}