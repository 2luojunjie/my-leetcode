package hot100.lc56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc56
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/5 20:41
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        //处理多组测试用例（EOF模式）
        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            int n = Integer.parseInt(line);

            int[][] intervals = new int[n][2];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                intervals[i][0] = Integer.parseInt(st.nextToken());
                intervals[i][1] = Integer.parseInt(st.nextToken());
            }

            int[][] res = merge(intervals);
            for (int[] interval : res) {
                System.out.println(interval[0] + " " + interval[1]);
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 按照区间的起点升序排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(res.isEmpty() || interval[0] > res.get(res.size()-1)[1]){
                // 两个区间没有重叠
                res.add(new int[]{interval[0], interval[1]});
            }else {
                // 有重叠，区别合并
                int[] tempInterval = res.get(res.size() - 1);
                tempInterval[1] = Math.max(tempInterval[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
