package sample;

/**
 * 二分查找：
 * 在一个升序的数组中，查找当前关键字。
 * 和中间关键字比较，比它小，在左边找，比它大，在右边找
 */
public class 二分查找 {
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
     * 二分查找
     * @param array 升序数组
     * @param key 查找关键字
     * @return 查找的最后下标，没有找到就返回-1
     */
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;
        //下面两行是重点；left<=right 要加上等于号
        //mid 是在这里算
        while(left <= right){
            int mid = (left + right) / 2;
            if(key == array[mid]){
                return mid;
            }else if(key < array[mid]){
                //在左边查找
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
