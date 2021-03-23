import org.apache.commons.lang.StringUtils;

/**
 * 找出重复数字
 * 修改数组 n个数字 都在0-n-1 的范围内
 *
 * n+1 个数字在 1-n 的范围内 找出重复数字 不能修改数组
 */
public class Test3 {

    /* 思路：
     * 既然每个数字都在1-N 的范围内 ，
     * 没有重复时，每个数字-1应该刚好等于其数组下标
     * 故对数组中的数字进行交换，从数组中的第一个数字开始进行循环，根据其值把其放到其下标处
     * 判断其下标处的值是否等于要放置的值，不等时进行交换，并查找被交换的值的所应在的位置，直到该位置与所放置的值相等
     * 继续下一个位置的判断
     *
     */
    public static int getDuplication(int[] arr){
        int a=-1;
        for(int i=0;i<=arr.length-1;i++){
            while(arr[i]!=i){
                if(arr[i]==arr[arr[i]]){
                    a=arr[i];
                }
                int temp=arr[i-1];
                 arr[i-1]=arr[temp];
                 arr[temp]=arr[i-1];

            }
        }
     return a;
    }

    /**
     * 思路：
     * n+1 个数字在1-n 的范围 必定存在重复数字
     * 二分查找的思想，查找n+1 个数字在1-n/2 范围内的个数，如果大于n+1/2 那么重复数字必定在1-n/2 范围内，反之必定在n/2-n 的范围内
     * 不断递归查找，直到最后剩下一个数字
     * @param arr
     * @return
     */
    public static int getDuplicationWithoutChangeArray(int[] arr){
      int a=-1;
      int start=0;
      int end=arr.length-1;
      while(start<=end){
        int middle=(end-start)/2+start;
        // 循环数组，统计范围内数字的个数
        int count=rangeCount(arr,start,middle,arr.length);
        //结束条件
        if(start==end){
            return count>1?start:-1;
        }
        //根据个数调整范围位置，middle 总是根据范围变化的，同时也利用middle 调整范围
        if(count>=middle+1){
            start=middle+1;
        }else{
            end=middle;

        }
      }
      return a;
    }
 public static int rangeCount(int[] arr,int start,int middle,int length){
        int a=0;
         for(int i=0;i<=length;i++){
             if((arr[i]>=start)&&(arr[i]<=middle)){
                 a++;
             }
         }
        return a;
 }


}
