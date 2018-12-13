package hust.yrf.datastructure;

/**
 * @ClassName BinaryInsertSort
 * @Descripition 折半插入排序
 * @Author Administrator
 * @Date 2018/12/13 15:41
 **/
public class BinaryInsertSort {
    public static void sort(int[] arrs) {
        int i = 1;
        while (i < arrs.length) {
            int low = 0;
            int high = i - 1;
            int mid = 0;
            int temp = arrs[i];
            while (low <= high) {
                mid = (low + high) / 2;
                if (arrs[i] > arrs[mid]) {
                    low = mid + 1;
                }
                if (arrs[i] < arrs[mid]) {
                    high = mid - 1;
                }
            }
            for(int j=i-1;j>=low;j--){
                arrs[j+1]=arrs[j];
            }
            arrs[low]=temp;
            print(arrs,arrs.length,i);
            i++;
        }
    }
    private static void printResult(int[] a, int n) {
        System.out.print("最终排序结果：");
        for (int j = 0; j < n; j++) {
            System.out.print(" " + a[j]);
        }
        System.out.println();
    }

    private static void print(int[] a, int n, int i) {
        System.out.print("第"+i+"次：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6,13,11};
        sort(a);
        printResult(a,a.length);
    }
}
