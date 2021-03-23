/**
 * 二进制位运算中1的个数
 *  如果是正数，每次向右移动，最高位补0
 *  如果是负数，每次向右移动，最高位补1
 *  一个数据与1进行与运行，如果最低位是1，结果是1，如果最低位是0，结果是0
 *  但是如果数据是负数，不段右移与1进行与运算，最后形成死循环
 *  常规解法，输入的数字不动，将1进行左移动，循环次数由int 占据的位数决定
 *
 *  特殊解法：
 *  把一个整数减1（结果就是：最右边的一变成0，最右边1的之后位数由1变成0，左边的位数不变） 的结果与他本身进行&运算，所得结果是把最右边的1变成0
 *
 */
public class BinaryCountOne {

    public static int countOne(int n){
        int count=0;
        int flag=1;
        while(flag!=0){

            if((flag&n)!=0){// 负数进行与运算时数据也为负数
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }

    public static int countOneBy1(int n){
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOne(-4));
        System.out.println(countOneBy1(-4));
    }

}
