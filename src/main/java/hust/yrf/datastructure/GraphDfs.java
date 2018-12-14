package hust.yrf.datastructure;

/**
 * @ClassName GraphDfs
 * @Descripition 图的深度优先遍历
 * @Author Administrator
 * @Date 2018/12/14 18:41
 **/
public class GraphDfs {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    static int[] visited = new int[9];//int数组来记录该node是否被访问过
    Node first;
    Node last;
    static GraphDfs[] dfs = new GraphDfs[9];//Test数组来记录图中每一个节点

    public static void dfs(int current) {//dfs遍历
        visited[current] = 1;
        System.out.print("[" + current + "]");
        while (dfs[current].first != null) {
            if (visited[dfs[current].first.value] == 0) {
                dfs(dfs[current].first.value);
            } else {
                dfs[current].first = dfs[current].first.next;
            }
        }
    }


    public void buildTestArray(int value){
        Node node = new Node(value);
        if(this.first==null){
            this.first=node;
            this.last=node;
        }else{
            this.last.next = node;
            this.last = this.last.next;
        }
    }

    public static void main(String[] args) {
        int Data[][] = { {1,2}, {2,1}, {1,3}, {3,1}, {2,4}, {4,2},
                {2,5}, {5,2}, {3,6}, {6,3}, {3,7}, {7,3}, {4,5}, {5,4},
                {6,7}, {7,6}, {5,8}, {8,5}, {6,8}, {8,6} };
        int i,j;
        for(i=1;i<9;i++){
            visited[i] = 0;
            dfs[i] = new GraphDfs();
            for(j=0;j<20;j++){
                if(Data[j][0]==i){
                    dfs[i].buildTestArray(Data[j][1]);
                }
            }
        }
        System.out.println("深度优先遍历顶点：");
        dfs(1);
    }
}
