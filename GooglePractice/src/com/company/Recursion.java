package com.company;

import java.util.Stack;

/**
 * Created by arun on 9/9/16.
 */
public class Recursion {

    public static class Node{
        int data;
        Node left;
        Node right;
        int size;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.size = 0;
        }
    }


    public static Node addNodeBST(Node root, int data){
        if (root == null){
            return new Node(data);
        }

        if (root.data > data){
            root.left = addNodeBST(root.left,data);
        }else {
            root.right = addNodeBST(root.right,data);
        }
        return root;
    }

    public static String printInorderString(Node root) {
        String str = "";
        if (root == null){
            return "";
        }
        str += printInorderString(root.left);
        str+= root.data+" ";
        str += printInorderString(root.right);
        return str;
    }

    public static void printInorder_StackString(Node root) {
        Stack<Node> st = new Stack<>();
        if (root == null){
            return;
        }
        Node current = root;
        while (current!=null){
            st.push(current);
            current = current.left;
        }
        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.print(temp.size + " ");
            if (temp.right !=null){
                temp = temp.right;
                while (temp!=null){
                    st.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    public static int updateSizeRank(Node root){
        if (root==null){
            return -1;
        }
        int LeftSize = updateSizeRank(root.right);
        int RightSize = updateSizeRank(root.left);
        if(LeftSize ==-1 && RightSize==-1){
            root.size = 0;
        }
        if (LeftSize != -1&&RightSize!=-1){
            root.size = LeftSize+RightSize+2;
        }else if (LeftSize == -1){
            root.size = RightSize+1;
        }else {
            root.size = LeftSize+1;
        }
        return root.size;
    }


    public static int findKthLargest(Node root, int k){
        Node current = root;
        int value = -1;
        while (current!=null) {
            if((k==0)&&(current.right==null)){
                value = current.data;
                break;
            }else if((current.right==null)&&(current.size==k)) {
                k = k - 1;
                current = current.left;
            }else if((current.right!=null)&&(k == current.right.size+1)){
                value = current.data;
                break;
            }else if((current.right!=null)&&(k> current.right.size)){
                k = k-current.right.size-2;
                current  = current.left;
            }else {
                current = current.right;
            }
        }
        return value;
    }

    public static void main(String[] args) {

        Node root = addNodeBST(null, 60);
        root = addNodeBST(root,80);
        root = addNodeBST(root,40);
        root = addNodeBST(root,90);
        root = addNodeBST(root,70);
        root = addNodeBST(root,50);
        root = addNodeBST(root,30);
        root = addNodeBST(root,35);
        root = addNodeBST(root,20);
        root = addNodeBST(root,10);
        root = addNodeBST(root,37);
        root = addNodeBST(root,38);
        root = addNodeBST(root,36);
        System.out.println(printInorderString(root));
        updateSizeRank(root);
        //printInorder_StackString(root);
        System.out.println();
        for(int i=0;i<14;i++){
            System.out.print(findKthLargest(root,i)+" ");
        }
        System.out.println();

    }
}
