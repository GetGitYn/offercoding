public class QiuckSort {

    public static void quickSort(int[] arr,int low,int high){
        if(low>high){//说明此时序列中只有一个数，可以退出递归
            return;
        }
      int i=low;
      int j=high;
      int flag=arr[low];
      //通过这段代码找到flag的位置
      while (i<j) {
          while ((i < j) && (arr[j] >= flag)) {
              j--;
          }
          while ((i < j) && (arr[i] <= flag)) {
              i++;
          }
          if (i < j) {
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }
      // 找到数据应该在的位置放过去
          int temp=arr[i];
          arr[i]=arr[low];
          arr[low]=temp;
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
      }

    public static void main(String[] args) {
        int arr[]={8,6,5,3,1,0,5,4,3,5,2};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<=arr.length-1;i++){
            System.out.println(arr[i]);
        }
    }
}
