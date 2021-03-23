import java.util.Queue;

/**
 * 用两个队列实现栈的插入与删除
 *
 * stack :4321
 * quene1:1234
 * quene2:123
 * quene1:4
 * 入栈：
 * quene1 :5678
 * quene2:123567
 *
 * @param <E>
 */
public class MyStack<E> {

    public Queue<E> queue1;
    public Queue<E> queue2;

    public  E pop(){
       if(queue1.isEmpty()){return null;}
       while(queue1.size()!=1){
           queue2.add(queue1.peek());
       }
         E e=queue1.peek();
        while(queue2.size()>0){
            queue1.add(queue2.peek());
        }
          return e;
    }
    public void add(E e){
       queue1.add(e);

    }
}
