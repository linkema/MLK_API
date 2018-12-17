package Collections.FIFO_Queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first;//指向最早添加的节点的链接
    private Node last;//指向最近添加的节点的链接
    private int N;//队列中元素的数量

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return last==null;
        }

        @Override
        public Item next() {
            Item item= first.item;
            first=first.next;
            return item;
        }
    }

    private class Node {
        //定义节点的内部类
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;//或者N==0
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        //向表尾添加元素且链接到表头
        Node oldlast=last;
        last=new Node();
        last.item=item;
        last.next=first;
        if(isEmpty ())
            first=last;
        else
            oldlast.next=last;
        N++;
    }
    public Item dequeue(){
        //从表头删除元素
        Item item=first.item;
        first=first.next;
        if(isEmpty ())
            last=null;
        N--;
        return item;
    }
    public Node reverse(Node x){
        //反转链表
        Node first=x;
        Node reverse=null;
        while(first!=null){
            Node second=first.next;
            first.next=reverse;
            reverse=first;
            first=second;
        }
        return reverse;
    }
    /*public Node reverse(Node first){
        //递归版的实现
        if(first==null) return null;
        if(first.next==null) return first;
        Node second =first.next;
        Node rest=reverse(second);
        second.next=first;
        first.next=null;
        return rest;
    }*/
}
