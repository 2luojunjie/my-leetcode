package hot100.lc48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc48
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/14 21:27
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            if (n == 0) continue;

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rotate(matrix);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[i][j]).append(j == n - 1 ? "" : " ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }

    // 转置 + 翻转
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 转置
        for (int i = 0; i < n; i++) {
            // j 从 i 开始，只遍历右上半区，防止交换两次又变回原样
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 水平翻转每一行
        for (int i = 0; i < n; i++) {
            // j 只需要遍历到一半 n/2，左右指针向中间靠拢交换
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                // 当前元素与对应的右侧元素交换
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
