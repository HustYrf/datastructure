package hust.yrf.datastructure;


import java.util.LinkedList;


/**
 * @ClassName BinaryTree
 * @Descripition 二叉树的各种遍历
 * @Author Administrator
 * @Date 2018/12/13 22:21
 **/
public class BinaryTree<T> {
    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    //创建二叉树,返回根节点
    public TreeNode<T> createTreePre(LinkedList<T> treeData) {
        T data = treeData.removeFirst();
        TreeNode<T> root = null;
        if (data != null) {
            root = new TreeNode<T>(data, null, null);
            root.left = createTreePre(treeData);
            root.right = createTreePre(treeData);
        }
        return root;
    }

    //递归前序遍历
    public void binaryTreePreRecur(TreeNode<T> root) {
        if (root != null) {
            System.out.println(root.data);
            binaryTreePreRecur(root.left);
            binaryTreePreRecur(root.right);
        }
    }

    //递归前序遍历
    public void binaryTreeMidRecur(TreeNode<T> root) {
        if (root != null) {
            binaryTreeMidRecur(root.left);
            System.out.println(root.data);
            binaryTreeMidRecur(root.right);
        }
    }

    //递归前序遍历
    public void binaryTreeBacRecur(TreeNode<T> root) {
        if (root != null) {
            binaryTreeBacRecur(root.left);
            binaryTreeBacRecur(root.right);
            System.out.println(root.data);
        }
    }

    //层次遍历
    public void layerTraversal(TreeNode<T> root) {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        TreeNode<T> p = null;
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.println(p.data);
            if (p.left != null) queue.offer(p.left);
            if (p.right != null) queue.offer(p.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree<>();

        //输入ABDH##I##E##CF#J##G##（#用null代替）
        LinkedList<Character> tree = new LinkedList<>();
        tree.add('A');
        tree.add('B');
        tree.add('D');
        tree.add('H');
        tree.add(null);
        tree.add(null);
        tree.add('I');
        tree.add(null);
        tree.add(null);
        tree.add('E');
        tree.add(null);
        tree.add(null);
        tree.add('C');
        tree.add('F');
        tree.add(null);
        tree.add('J');
        tree.add(null);
        tree.add(null);
        tree.add('G');
        tree.add(null);
        tree.add(null);

        TreeNode<Character> root = binaryTree.createTreePre(tree);

        //先序遍历（递归）
        binaryTree.binaryTreePreRecur(root);
        System.out.println();
        //中序遍历（递归）
        binaryTree.binaryTreeMidRecur(root);
        System.out.println();
        //后序遍历（递归）
        binaryTree.binaryTreeBacRecur(root);
        System.out.println();
        binaryTree.layerTraversal(root);

    }
}
