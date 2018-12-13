package hust.yrf.datastructure;

/**
 * @ClassName SimpleChoiceSort
 * @Descripition 简单选择排序
 * @Author Administrator
 * @Date 2018/12/13 19:25
 **/
public class SimpleChoiceSort {
    public static void sort(int[] arrs) {
        for(int i=0;i<arrs.length;i++){
            int temp=arrs[i];
            int k = i;
            for(int j=i+1;j<arrs.length;j++){
               if(arrs[j]<arrs[k]){
                   k=j;
               }
            }

            arrs[i]=arrs[k];
            arrs[k]=temp;
            print(arrs,arrs.length,i);
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
