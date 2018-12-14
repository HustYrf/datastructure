package hust.yrf.datastructure;

/**
 * @ClassName BinarySearch
 * @Descripition 二分查找
 * @Author Administrator
 * @Date 2018/12/14 11:55
 **/
public class BinarySearch {
    public static int binarySearch(int arrs[], int value) {//非递归
        int i = 0;
        int j = arrs.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (arrs[middle] < value) {
                i = middle + 1;
            } else if (arrs[middle] > value) {
                j = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int recursiveSearch(int[] arrs, int value,int low,int high) {//递归二分查找
        if(high<low) return -1;
        int middle = (low + high )/2;
        if(value>arrs[middle]){
             return recursiveSearch(arrs,value,middle+1,high);
        }else if(value<arrs[middle]){
            return recursiveSearch(arrs,value,low,middle-1);
        }else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 5, 6, 34, 5324, 23124,24325, 34324, 324325, 324400, 32432532};
        System.out.println(binarySearch(arrs, 32400));
        System.out.println(recursiveSearch(arrs, 3240,0,arrs.length-1));
    }
}
