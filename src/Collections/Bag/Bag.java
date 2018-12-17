package Collections.Bag;


import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;//链表的首节点
    private class Node {
            //定义节点的内部类
            Item item;
            Node next;
        }
        public boolean isEmpty(){

            return first==null;
        }
        public void add(Item item){
            //向栈顶添加元素
            Node oldfirst=first;
            first=new Node ();
            first.item=item;
            first.next=oldfirst;
        }
        public Iterator<Item> iterator() {

            return new ListIterator ();
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

