package hust.yrf.datastructure;

/**
 * @ClassName ShellSort
 * @Descripition 希尔排序
 * @Author Administrator
 * @Date 2018/12/13 16:18
 **/
public class ShellSort {
    public static void sort(int[] arrs) {
        int length = arrs.length;
        int gap = length / 2;
        while (gap>=1){
            for(int i=gap;i<length;i++){
                int j = 0;
                int temp = arrs[i];
                for(j=i-gap;j>=0&&temp<arrs[j];j=j-gap){
                    arrs[j+gap] = arrs[j];
                }
                arrs[j+gap] = temp;
            }
            gap=gap/2;
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
        int a[] = {3,1,5,7,2,4,9,6,13,11};
        sort(a);
        printResult(a,a.length);
    }
}
