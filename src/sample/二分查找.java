package sample;

/**
 * ���ֲ��ң�
 * ��һ������������У����ҵ�ǰ�ؼ��֡�
 * ���м�ؼ��ֱȽϣ�����С��������ң����������ұ���
 */
public class ���ֲ��� {
    public static void main(String[] args) {
        int[] array = {2,3,4,5,6};
        int key = 2;
        System.out.println(binarySearch(array,key));
        key = 3;
        System.out.println(binarySearch(array,key));
        key = 4;
        System.out.println(binarySearch(array,key));
        key = 5;
        System.out.println(binarySearch(array,key));
        key = 6;
        System.out.println(binarySearch(array,key));
    }

    /**
     * ���ֲ���
     * @param array ��������
     * @param key ���ҹؼ���
     * @return ���ҵ�����±꣬û���ҵ��ͷ���-1
     */
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;
        //�����������ص㣻left<=right Ҫ���ϵ��ں�
        //mid ����������
        while(left <= right){
            int mid = (left + right) / 2;
            if(key == array[mid]){
                return mid;
            }else if(key < array[mid]){
                //����߲���
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
