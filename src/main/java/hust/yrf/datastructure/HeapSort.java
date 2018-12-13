package hust.yrf.datastructure;

/**
 * @ClassName HeapSort
 * @Descripition 堆排序
 * @Author Administrator
 * @Date 2018/12/13 19:59
 **/
public class HeapSort {
    public static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    //对数组从0到lastIndex建堆
    public static void buildMaxHeap(int[] arrs, int lastIndex) {
        //从最后一个节点的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前K节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果k节点的左子节点的biggerIndex小于lastIndex，也就是biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //如果右子节点的值较大
                    if(arrs[biggerIndex]<arrs[biggerIndex+1]){//改为arrs[biggerIndex]>arrs[biggerIndex+1]就是倒叙
                        biggerIndex++;//biggerIndex记录较大子节点的索引
                    }
                }
                //如果k节点的值小于其较大的子节点的值 ，交换他们
                if(arrs[k]<arrs[biggerIndex]){//改为arrs[k]>arrs[biggerIndex]就是倒叙
                    swap(arrs,k,biggerIndex);
                    k=biggerIndex;//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                }else{
                    break;// 当前判断结点k（父结点），大于他的两个子节点时，跳出while循环
                }
            }
        }
    }

    private static void print(int[] a, int n, int i) {
        System.out.print("第"+i+"次排序后，堆：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6,13,11};
        int length = a.length;
        //循环建堆
        for(int i=0;i<length-1;i++){
            buildMaxHeap(a,length-i-1);//建堆，建一次最大堆，寻到一个待排序序列的最大数
            print(a,a.length,i);
            swap(a,0,length-1-i);// 交换堆顶（待排序序列最大数）和最后一个元素
        }
        for(int j=0;j<length;j++){
            System.out.print(a[j]+" ");
        }
    }
}
