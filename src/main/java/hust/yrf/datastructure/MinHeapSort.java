package hust.yrf.datastructure;

/**
 * @ClassName MinHeapSort
 * @Descripition 小顶堆排序
 * @Author Administrator
 * @Date 2018/12/13 20:30
 **/
public class MinHeapSort {
    public static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    public static void bulidMinHeap(int[] arrs, int lastindex) {
        for (int i = (lastindex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <=lastindex) {
                int biggerindex = 2 * k + 1;
                if (biggerindex + 1 <= lastindex) {
                    if (arrs[biggerindex] > arrs[biggerindex + 1]) {
                        biggerindex++;
                    }
                }
                if (arrs[k] > arrs[biggerindex]) {
                    swap(arrs, k, biggerindex);
                    k = biggerindex;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6, 13, 11};
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            bulidMinHeap(a, length - i - 1);
            swap(a, 0, length - i - 1);
        }
        for (int j = 0; j < length; j++) {
            System.out.print(a[j] + " ");
        }
    }
}
