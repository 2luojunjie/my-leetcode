package hot100.lc240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc240
 * Description:
 *编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @Author: Luojunjie
 * @Create 2026/5/15 10:34
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 || n == 0) {
                System.out.println();
                continue;
            }

            // 读取矩阵
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            line = br.readLine();
            int target = Integer.parseInt(line);

            boolean res = searchMatrix(matrix, target);
            System.out.println(res);
        }
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        //排除法
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0){

            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) {
                j--;
                continue;
            }
            if(matrix[i][j] < target) {
                i++;
                continue;
            }
        }
        return false;
    }
}
