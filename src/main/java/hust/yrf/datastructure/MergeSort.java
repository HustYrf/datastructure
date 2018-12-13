package hust.yrf.datastructure;

/**
 * @ClassName MergeSort
 * @Descripition 归并排序
 * @Author Administrator
 * @Date 2018/12/13 21:13
 **/
public class MergeSort {
    public static void merge(int[] arrs, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arrs[i] < arrs[j]) {
                temp[k++] = arrs[i++];
            } else {
                temp[k++] = arrs[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arrs[i++];
        }
        while (j <= high) {
            temp[k++] = arrs[j++];
        }

       for(int m=0;m<temp.length;m++){
            arrs[low+m]=temp[m];
       }
    }

    public static void sort(int[] arrs, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        if(low<high) {
            sort(arrs, low, mid);
            sort(arrs, mid + 1, high);
            merge(arrs, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6, 13, 11};
        int len = a.length;
        sort(a, 0, len - 1);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
