public class BinaryQuery {

    public static int binarySearch(int[] arr,int low,int high,int flag){
        if(low>high){return -1;}
        int middle=(high-low)/2+low;
        if(arr[middle]>flag){
            return  binarySearch(arr,low,middle-1,flag);
        }else if(arr[middle]<flag){
            return  binarySearch(arr,middle+1,high,flag);
        }else{
           return middle+1;
        }

    }

    public static void main(String[] args) {
        int arr[]={1,2,4,5,5,6,7,10,13,13};
        int i= binarySearch(arr,0,arr.length-1,7);
            System.out.println(i);
        }
}
