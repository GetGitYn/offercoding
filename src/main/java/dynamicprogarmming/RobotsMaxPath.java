package dynamicprogarmming;

/**
 * m行n列的格子，机器人可以上下左右行走，但是不能进入行列标与数列标数位和大于K的格子，机器人可以达到多少个格子
 * 求四个方向 的和，四个方向中如果存在重叠的，如果已经被标记为true,其他的不会再统计了
 */
public class RobotsMaxPath {

    public static int movingCount(int threshold,int rows,int columns){
        if(rows<0||columns<0||threshold<0){
            return 0;
        }
        boolean[] visited=new boolean[rows*columns];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }

      return movingCountCore(threshold,rows,columns,0,0,visited);
    }
    public static int movingCountCore(int threshold,int rows,int columns,int row,int col,boolean[] visited){
     //int count=0;
     if(checkdata(threshold,rows,columns,row,col,visited)){
         visited[row*columns+col]=true;
         return 1+movingCountCore(threshold,rows,columns,row,col+1,visited)
                 +movingCountCore(threshold,rows,columns,row,col-1,visited)
                 +movingCountCore(threshold,rows,columns,row-1,col,visited)
                 +movingCountCore(threshold,rows,columns,row+1,col,visited);
     }
     return 0;

    }
    public static boolean checkdata(int threshold,int rows,int columns,int row,int column,boolean[] visited){
        if(row>0&&column>0&&row<rows&&column<columns&&!visited[row*columns+column]&&getDigitalCount(column)+getDigitalCount(row)<=threshold){
            return true;
        }
        return false;
    }
    public static int getDigitalCount(int number){
        int sum=0;
        while(number>0){
            sum+=number%10;
            number=number/10;
        }
        return sum;
    }
 /* public static int movingCount(int threshold, int rows, int cols) {
      int visited[][] = new int[rows][cols]; //记录是否已经走过
      return helper(0, 0, rows, cols, visited, threshold);
  }

    private static int helper(int i, int j, int rows, int cols, int[][] visited, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || visited[i][j] == 1) {
            return 0;
        }
        visited[i][j] = 1;
        return helper(i - 1, j, rows, cols, visited, threshold)
                + helper(i + 1, j, rows, cols, visited, threshold)
                + helper(i, j - 1, rows, cols, visited, threshold)
                + helper(i, j + 1, rows, cols, visited, threshold)
                + 1;
    }

    private static int numSum(int number) {
        int sum = 0;
        while (number>0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
*/
    public static void main(String[] args) {
       System.out.println( movingCount(18,38,38));
    }

}
