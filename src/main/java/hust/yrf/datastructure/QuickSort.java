package hust.yrf.datastructure;

/**
 * @ClassName QuickSort
 * @Descripition 快速排序
 * @Author Administrator
 * @Date 2018/12/13 18:53
 **/
public class QuickSort {
    public static int sort(int[] arrs, int low, int high) {
        int temp = arrs[low];
        while (low < high) {
            while (low < high && arrs[high] >=temp) high--;
            arrs[low] = arrs[high];
            while (low < high && arrs[low] <=temp) low++;
            arrs[high] = arrs[low];
        }
        arrs[low] = temp;
        return low;
    }

    public static void recursiveSort(int[] arrs, int low, int high) {
        if(low<high){
            int middle = sort(arrs, low, high);
            recursiveSort(arrs,low,middle-1);
            recursiveSort(arrs,middle+1,high);
        }
    }

    private static void printResult(int[] a, int n) {
        System.out.print("最终排序结果：");
        for (int j = 0; j < n; j++) {
            System.out.print(" " + a[j]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {2,2,3,7,3,4,9,6,3,11};
        recursiveSort(a,0,a.length-1);
        printResult(a,a.length);
    }


}
