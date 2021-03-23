/**
 * 求斐波拉契数列的第N项
 * 用循环实现递归
 * 递归算法：易于实现，但是消耗大量时间空间，一般不在生产中使用
 * 青蛙跳台阶：
 * 一只青蛙一次可以条一级台阶，也可以跳两级台阶，跳n级台阶有多少种跳法
 *  n 级台阶可以为： 最后一次跳1级*（n-1级台阶的跳法) +最后一次跳两级台阶（n-2级台阶的跳法）
 *  【在最后一次剩下两级台阶时，如果一级一级的跳，那么这种跳法会被计算为最后一次跳一级】
 *  实质：斐波拉契数列
 *  如果：一只青蛙一次可以跳1级，2级或者n 级
 *  那么n级台阶的跳法：
 *  f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4)+。。。+1
 *  f(n)=Sn-1
 *  2f(n)=sn=f(n+1)
 *  f(1)=1
 *   f(n)=   (n-1)
 *         2
 *
 */
public class Fibonacci {

    public static int countFibN(int n){// 在该方式计算中，对空间和时间的空间消耗
        if(n==0){ return 0;
        } else if(n==1){return 1;
        } else{
            return countFibN(n-1)+countFibN(n-2);
        }
    }

    public static int countFibNUseFor(int n){
        int count3=0;
        int count2=1;
        int count1=0;
        for(int i=2;i<=n;i++){
          count3=count2+count1;
          count1=count2;
          count2=count3;
        }

         return count3;
    }

    public static void main(String[] args) {
      System.out.println(countFibN(10)+"="+countFibNUseFor(10));
    }

}
