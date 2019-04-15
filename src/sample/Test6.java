package sample;

/**
 * ������6���ؽ�������
 * ��Ŀ������ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}��
 * �����������{4,7,2,1,5,3,8,6},
 * ���ؽ������������������ͷ��㡣
 */
public class Test6 {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
    }

    /**
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
     * @param preorder ǰ�����
     * @param inorder �������
     * @return ���ĸ��ڵ�
     */
    public static BinaryTreeNode construct(int[] preorder,int[] inorder){
        //����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }

        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    /**
     * �����������ǰ���������������Ľ�����ؽ���������
     * @param preorder ǰ�����
     * @param ps ǰ������Ŀ�ʼλ��
     * @param pe ǰ������Ľ���λ��
     * @param inorder �������
     * @param is ��������Ŀ�ʼλ��
     * @param ie ��������Ľ���λ��
     * @return ���ĸ��ڵ�
     */
    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder,int is,int ie){
        //��ʼλ�ô��ڽ���λ��˵��û����Ҫ�����Ԫ����
        if(ps > pe){
            return null;
        }

        //ȡǰ������ĵ�һ�����֣����ǵ�ǰ���ڵ�
        int value = preorder[ps];
        int index = is;
        //������������������Ҹ��ڵ��λ��
        while(index <= ie && inorder[index] != value){
            index++;
        }

        //������������������������û���ҵ�����������Ϸ�
        if(index > ie){
            throw new RuntimeException("Invalid input");
        }

        //������ǰ�ĸ��ڵ㣬����Ϊ�ڵ㸳ֵ
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        //�ݹ鴴����ǰ���ڵ������������������Ԫ����ʽ��index-is+1��
        //��������Ӧ��ǰ�������λ����[ps+1,ps+index-is]
        //��������Ӧ�����������λ����[is,index-1]
        node.leftChild = construct(preorder, ps+1, ps + index - is,inorder,is,index-1);
        //�ݹ鹹����ǰ���ڵ������������������Ԫ�ظ�����ie-index��
        //��������Ӧ��ǰ�������λ����[ps+index-is+1,pe]
        //��������Ӧ�����������λ����[index+1,ie]
        node.rightChild = construct(preorder,ps+index-is+1,pe,inorder,index+1,ie);

        //���ش����ĸ��ڵ�
        return node;
    }

    //�������������
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