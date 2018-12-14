package hust.yrf.datastructure;

/**
 * @ClassName MyStack
 * @Descripition 自定义栈
 * @Author Administrator
 * @Date 2018/12/14 16:49
 **/
public class MyStack {
    private int []arrs;
    private int top;
    private static final int SIZE = 66;

    public MyStack() {
        this.arrs = new int[SIZE];
        this.top = -1;
    }

    public void push(int j){
        arrs[++top] = j;
    }

    public int pop(){
        if(top==-1){
            return -1;
        }
        return arrs[top--];
    }

    public int peek(){
        return arrs[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
