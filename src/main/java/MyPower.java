/**
 * 数值的整数次方
 * 难点1：
 * 当次方数为 正数，负数，0
 *  难点2:
 *  快速求解数据的次方 当次方为偶数时：
 *
 *  当次方为奇数时：
 *  *    n     n/2     n/2
 *  *  a    = a    * a     * a
 */
public class MyPower {

    public static Double myPower(double base,int exp){
        int tmp=exp;
        double sum=1.0;
        if(base==0.0&&exp<0){return null;}
        if(base==0.0&&exp>0){return new Double(0);}
        if((base==0.0&&exp==0)||(base==1.0)||(exp==0)){return new Double(1.0);}
        if(exp<0){ exp=-exp;}

       while(exp!=0){
           if((exp&1)==1){
               sum*=base;
           }
           base*=base;
           exp=exp>>1;
       }
       return tmp>0?sum:1/sum;
    }
    
}
