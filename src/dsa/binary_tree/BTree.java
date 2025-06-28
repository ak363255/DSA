package dsa.binary_tree;

public class BTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static class TreeNodeWithCoordinate{
        int x,y;
        TreeNode node;
        TreeNodeWithCoordinate(int x,int y,TreeNode node){
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }

    static class NodeWithCoordinate{
        int x,y;
        Node node;
        NodeWithCoordinate(int x,int y,Node node){
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
}
