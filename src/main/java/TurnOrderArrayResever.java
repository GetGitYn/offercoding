/**
 * 求翻转排序数组中的最小数
 *翻转数组：将递增排序数组中的前n个搬到数组末尾
 * 翻转的排序数组可以被划分为两个数组： 一个从前往后升序数组，一个从后往前降序 如果是递增，前面的数组的第一位一定大于最后一位
 *
 */
public class TurnOrderArrayResever {

    /**
     * 1，如果翻转了0个数字到末尾，那么开始的第一个数据即为最小
     * 2，最常见情况：二分查找，
     * 3，如果在二分查找过程中出现指针一所指向的值与中间值与指针二所指向的值相等，二分查找无法使用，那么只能使用排序查找
     * @param arr
     * @return
     */
    public static int getMin(int[] arr){
        int low=0;
        int high=arr.length-1;
        int mid=low;
        while(arr[low]>=arr[high]){// 如果真的进行了翻转，那么最后一个数字必定小于第一个数字

            if(high-1==low){
               mid=high;
               break;
            }
            mid=(low+high)/2;
            if(arr[mid]==arr[low]&&arr[low]==arr[high]){
                return searchMin(arr,low,high);
            }
            if(arr[mid]>=arr[low]){
                low=mid;
            } else{
               high=mid;
            }
        }
        return arr[mid];
    }

    public static int searchMin(int[] arr,int indexlow,int indexhigh){
        int result=arr[indexlow];
        for(int i=indexlow+1;i<=indexhigh;i++){
            if(result>arr[i]){
                result=arr[i];
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr={3,4,5,5,5,5,0,0,0,1,1,1};
        System.out.println(getMin(arr));
    }

}
