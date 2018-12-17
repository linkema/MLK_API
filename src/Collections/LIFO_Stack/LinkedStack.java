package Collections.LIFO_Stack;

import java.util.Iterator;

public class LinkedStack<Item> implements Stack {
    private Node first;//栈顶
    private int N;//元素数量
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

    public void push(Item item){
        //向栈顶添加元素
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public Item pop(){
        //从栈顶删除元素
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    @Override
    public Object seek() {
        return first.item;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current=first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
