package hust.yrf.datastructure;

/**
 * @ClassName BubbleSort
 * @Descripition 冒泡排序
 * @Author Administrator
 * @Date 2018/12/13 17:11
 **/
public class BubbleSort {
    public static void sort(int[] arrs) {
        int length = arrs.length;
        boolean flag = false;
        for(int i=0;i<length-1;i++){
            for(int j=0;j<length-i-1;j++){
                if(arrs[j]>arrs[j+1]){
                    int temp = arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false) break;
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
