package dynamicprogarmming;


/**
 * 题目：
 * 求解矩阵中是否包含某个路径的全部字符
 *
 * 思路：假设第n个字符为dn,在路径中第n+1 个字符为dn+1,搜索dn中的上下左右，查找是否含有dn+1字符，如果没有，返回dn-1
 */
public class PathInMatrix {

    public static boolean getPath(){
        boolean result=false;
        String strs="";//将矩阵字符定义为一个一维数组
        String path="";//将路径定义为一个字符串
        int rows=3;
        int columns=4;
        boolean[] visited=new boolean[rows*columns];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        for(int row=0;row<rows;row++){
            for(int column=0;column<columns;column++){
                if(hasVisitedPath(strs.toCharArray(),rows,columns,row,column,strs.toCharArray(),0,visited)){
                    return true;
                }

            }
        }

        return result;
    }

        public static boolean hasVisitedPath(char[] matrix,int rows,int columns,int row,int column,char[] strpath,int pathlength,boolean[] visited ){
        if((row>rows)||(column>columns)||(matrix[row*columns+column]!=strpath[pathlength])||visited[row*columns+row]==true){
            return false;
        }
        if(pathlength==strpath.length-1){
            return true;
        }
        visited[row*columns+row]=true;
        boolean hasPathNext=hasVisitedPath( matrix, rows, columns,row, column+1, strpath, pathlength+1, visited)
                          || hasVisitedPath( matrix, rows, columns,row, column-1, strpath, pathlength+1, visited)
                          || hasVisitedPath( matrix, rows, columns,row+1, column, strpath, pathlength+1, visited)
                          || hasVisitedPath( matrix, rows, columns,row-1, column, strpath, pathlength+1, visited);

        if(!hasPathNext){
            visited[row*columns+row]=false;
        }
        return hasPathNext;
    }
}
