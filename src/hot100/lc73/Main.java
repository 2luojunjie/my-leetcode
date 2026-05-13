package hot100.lc73;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc73
 * Description:给定一个 m x n 的矩阵，如果一个元素为 0 ，
 * 则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @Author: Luojunjie
 * @Create 2026/5/13 14:52
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m == 0 || n == 0) continue;
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            setZeros(matrix);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[i][j]).append(j == n - 1 ? "" : " ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());

        }
    }
    public static void setZeros(int[][] matrix){
        //借用矩阵的第一行和第一列做标记，空间复杂度O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        // 看第一行、第一列是否有0
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                colFlag = true;
                break;
            }
        }
        //把0的信息贴到第一行和第一列
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //处理第一行和第一列
        if(rowFlag){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(colFlag){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
