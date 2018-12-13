package hust.yrf.datastructure;

/**
 * @ClassName DirectInsertSort
 * @Descripition 直接插入排序
 * @Author Administrator
 * @Date 2018/12/13 15:05
 **/
public class DirectInsertSort {

    public static void sort(int[] arrs) {
        int temp = 0;
        int i = 1;
        while (i < arrs.length) {
            if (arrs[i] < arrs[i - 1]) {
                for (int j = i; j >= 1; j--) {
                    if (arrs[j] < arrs[j-1]) {
                        temp = arrs[j];
                        arrs[j] = arrs[j-1];
                        arrs[j-1] = temp;
                    } else {
                        break;
                    }
                }
            }
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
