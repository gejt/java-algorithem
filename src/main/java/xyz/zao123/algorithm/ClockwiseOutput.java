package xyz.zao123.algorithm;

/**
 * 顺时针打印矩阵
 *  1  2  3  4
 *  5  6  7  8
 *  9  10 11 12
 *  13 14 15 16
 *  输出  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class ClockwiseOutput {

    public static void main(String[] args){

        int[][] num = new int[100][100];
        int n = 4;
        int count =1;

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                num[i][j]=count++;
            }
        }

        output(num,0,n-1);

    }

    public static void output(int[][] num,int start,int end){

        if(start>end || end<=0)return;

        for(int i=start;i<=end;i++){
            System.out.print(num[start][i]+" ");
        }
        for(int i=start+1;i<=end;i++){
            System.out.print(num[i][end]+" ");
        }

        for(int i=end-1;i>=start;i--){
            System.out.print(num[end][i]+" ");
        }
        for(int i=end-1;i>start;i--){
            System.out.print(num[i][start]+" ");
        }

        output(num,start+1,end-1);
    }
}
