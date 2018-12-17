package Collections.LIFO_Stack;

import java.util.Iterator;
/**
 * @apiNote :stack
 * @param :栈数据结构的几个实现方法接口
 * @time :2018.12.06
 */
public interface Stack<Item> {
    int N = 0;
    boolean isEmpty();
    int size();
    //void push();
    Item pop();
    Iterator<Item> iterator();
    Item seek();//返回最近添加的元素不弹出
}
