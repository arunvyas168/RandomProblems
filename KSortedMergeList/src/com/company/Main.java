package com.company;

public class Main {

    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        Node result = sortedMergeK(head1,head2,5);

        while (result!= null){
            System.out.println(result.data);
            result = result.next;
        }
    }

    public static Node sortedMergeK(Node list1, Node list2,int k){
        Node result = null;
        if (k < 1){
            return null;
        }else if ((list1 == null) && (list2 ==null)){
            return null;
        }else if (list1 == null) {
            k--;
            result = list2;
            result.next = sortedMergeK(null,list2.next,k);
        }else if (list2 == null) {
            k--;
            result = list1;
            result.next = sortedMergeK(list1.next,null,k);
        }else if (list1.data<list2.data){
            k = k-1;
            result = list1;
            result.next = sortedMergeK(list1.next,list2,k);
        }else {
            k = k-1;
            result = list2;
            result.next = sortedMergeK(list1,list2.next,k);
        }

        return result;

    }
}
