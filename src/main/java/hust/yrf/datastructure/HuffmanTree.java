package hust.yrf.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanTree
 * @Descripition TODO
 * @Author Administrator
 * @Date 2018/12/14 10:29
 **/
public class HuffmanTree {
    static class HuffmanTreeNode<T> implements Comparable<HuffmanTreeNode<T>> {
        private T data;
        private int weight;
        private HuffmanTreeNode<T> left;
        private HuffmanTreeNode<T> right;

        public HuffmanTreeNode(T data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "HuffmanTreeNode{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(HuffmanTreeNode<T> o) {
            if (o.weight > this.weight) return 1;
            if (o.weight < this.weight) return -1;
            return 0;
        }


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public HuffmanTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(HuffmanTreeNode<T> left) {
            this.left = left;
        }

        public HuffmanTreeNode<T> getRight() {
            return right;
        }

        public void setRight(HuffmanTreeNode<T> right) {
            this.right = right;
        }
    }

    public static  <T> HuffmanTreeNode<T> createHuffmanTree(List<HuffmanTreeNode<T>> nodes) {//返回根节点
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanTreeNode<T> left = nodes.get(nodes.size() - 1);
            HuffmanTreeNode<T> right = nodes.get(nodes.size() - 2);
            HuffmanTreeNode<T> Parent = new HuffmanTreeNode<>(null, left.weight + right.weight);
            Parent.setLeft(left);
            Parent.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(Parent);
        }
        return nodes.get(0);
    }

    public static  <T>List<HuffmanTreeNode<T>> traversa(HuffmanTreeNode<T> root){
        ArrayList<HuffmanTreeNode<T>> list = new ArrayList<>();
        ArrayDeque<HuffmanTreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            HuffmanTreeNode<T> node = queue.poll();
            list.add(node);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<HuffmanTreeNode<String>> list = new ArrayList<HuffmanTreeNode<String>>();
        list.add(new HuffmanTreeNode<>("a",7));
        list.add(new HuffmanTreeNode<>("b",5));
        list.add(new HuffmanTreeNode<>("c",4));
        list.add(new HuffmanTreeNode<>("d",2));

        HuffmanTreeNode<String> root = createHuffmanTree(list);
        System.out.println(traversa(root));

    }
}
