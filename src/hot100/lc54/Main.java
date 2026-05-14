package hot100.lc54;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc54
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/14 16:21
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


            List<Integer> result = spiralOrder(matrix);


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(i == result.size() - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }
    }

    // 边界收缩法
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        // 定义四堵墙
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // 按照 右 -> 下 -> 左 -> 上 的顺序无限循环
        while (true) {
            // 1. 向右走：遍历当前 top 行
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++; // 上边界下移
            if (top > bottom) break; // 若上下边界交错，说明所有元素已被榨干，跳出

            // 2. 向下走：遍历当前 right 列
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--; // 右边界左移
            if (left > right) break; // 若左右边界交错，跳出

            // 3. 向左走：遍历当前 bottom 行
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--; // 下边界上移
            if (top > bottom) break;

            // 4. 向上走：遍历当前 left 列
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++; // 左边界右移
            if (left > right) break;
        }

        return res;
    }

}
