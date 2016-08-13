package com.company;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.right = new Node(12);
        root.left.left = new Node(4);
        rangePrint(root, 10, 25);
    }
    public static void rangePrint(Node root, int low, int high) {
        if (root == null) {
            return;
        }
        if (low < root.data){
            rangePrint(root.left,low,high);
        }
        if ((root.data >low)&&(root.data<high)){
            System.out.print(root.data+" ");
        }
        if (high > root.data){
            rangePrint(root.right,low,high);
        }

    }
}
