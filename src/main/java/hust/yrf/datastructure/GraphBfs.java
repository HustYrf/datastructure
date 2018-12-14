package hust.yrf.datastructure;

/**
 * @ClassName GraphBfs
 * @Descripition 广度优先遍历
 * @Author Administrator
 * @Date 2018/12/14 19:28
 **/
public class GraphBfs {
    static class GraphNode {
        private int value;
        private GraphNode next;

        public GraphNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public GraphNode first;
    public GraphNode last;
    public final static int MAXSIZE = 10;
    static int[] visited = new int[9];
    static GraphBfs[] nodeArray = new GraphBfs[9];

    //用数组创建一个队列
    static int[] queue = new int[MAXSIZE];
    static int font = -1;
    static int rear = -1;

    public static void enqueue(int value) {
        if (rear >= MAXSIZE) {
            return;
        }
        queue[++rear] = value;
    }

    public static int dequeue() {
        if (font == rear) {
            return -1;
        }
        return queue[++font];
    }

    public static boolean queueIsEmpty() {
        return (font == rear);
    }

    public static void graphBfs(int curret) {
        visited[curret] = 1;
        enqueue(curret);
        System.out.print("[" + curret + "]");
        while (!queueIsEmpty()) {
            int dequeue = dequeue();
            while (nodeArray[dequeue].first != null) {
                if (visited[nodeArray[dequeue].first.value] == 0) {
                    visited[nodeArray[dequeue].first.value] = 1;
                    System.out.print("[" + nodeArray[dequeue].first.value + "]");
                    enqueue(nodeArray[dequeue].first.value);
                }
                nodeArray[dequeue].first = nodeArray[dequeue].first.next;
            }
        }
    }

    public void buildGraph(int value) {
        GraphNode graphNode = new GraphNode(value);
        if (this.first == null) {
            this.first = graphNode;
            this.last = graphNode;
        } else {
            this.last.next = graphNode;
            this.last = this.last.next;
        }
    }


    public static void main(String[] args) {
        int Data[][] = {{1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 4}, {4, 2},
                {2, 5}, {5, 2}, {3, 6}, {6, 3}, {3, 7}, {7, 3}, {4, 5}, {5, 4},
                {6, 7}, {7, 6}, {5, 8}, {8, 5}, {6, 8}, {8, 6}};

        for (int i = 1; i < 9; i++) {
            visited[i] = 0;
            nodeArray[i] = new GraphBfs();
            for (int j = 0; j < 20; j++) {
                if(Data[j][0]==i){
                    nodeArray[i].buildGraph(Data[j][1]);
                }
            }
        }
        System.out.println("深度优先遍历顶点：");
        graphBfs(1);
    }


}
