package dynamicprogarmming;


/**
 * 题目：
 * 一个长度位n 的绳子剪成若干段，若干段长度之乘积的最优解
 * 动态规划题目：
 * f(n)=max(f(i)*f(n-i))
 * 思路：
 * 可以建立一个一维数组，计算当绳子长度位n 时的最优解，
 * 其中 f(0)=0,f(1)=1,f(2)=2,f(3)=3
 * 其中第一层循环i 为绳子长度 ,第二层 j 通过利用一维数组i-1 之前的值，对所有可能进行计算，求出f(i)=f(j)*f(i-j) 的最优解
 * 效率：
 *
 * 其他：此题目可以使用贪婪算法求出最优解
 * 原因：当 n>5 时 2（n-2）>n /3(n-3)>n /3(n-3)>2(n-2)
 *
 */
public class MaxCutRepoLength {
    public static void main(String[] args) {
       
    }
}
