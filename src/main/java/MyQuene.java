import java.util.Stack;

/**
 * 使用两个栈实现队列的功能
 *
 * 栈：先进后出
 * 队列：先进先出
 *
 * 队列： 1234 压入-》 出口：《-1234
 * 1234 压入栈1-》 出口：4321
 *  当栈2为空时  把栈1压入栈2-》出口：1234
 * 此时 stack2.pop=quene.pop
 *
 * quene.push
 * quene.push=stack1.push
 *
 *
 *
 */
public class MyQuene<E> {
    public Stack<E> stack1;
    public Stack<E> stack2;

    public E pop(){
        if(stack2.isEmpty()&&stack1.isEmpty()){return null;}
        if(stack2.isEmpty()){
            while(!stack1.empty())
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public void push(E i){
        stack1.push(i);
    }
}
