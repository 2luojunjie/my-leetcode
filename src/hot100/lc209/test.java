package hot100.lc209;

/**
 * ClassName: test
 * Package: hot100.lc209
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/2 22:05
 * Version 1.0
 */
import java.io.*;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        String fileName = "algo_test_data.txt";
        int lines = 100000; // 模拟 10 万行输入
        int numsPerLine = 50; // 每行 50 个数字（共计 500 万个数字）

        System.out.println("正在生成模拟判题文件 (10万行数据，请稍候)...");
        generateTestData(fileName, lines, numsPerLine);
        System.out.println("文件生成完毕！准备开始真实 I/O 竞速\n");

        // --- 真实环境测试 1: readLine() + split() ---
        System.out.println("▶️ 开始测试: readLine().split(\" \")");
        long startSplit = System.currentTimeMillis();

        BufferedReader br1 = new BufferedReader(new FileReader(fileName));
        String line1;
        int count1 = 0;
        while ((line1 = br1.readLine()) != null) {
            // 算法题中常见的错误写法：每读一行，就 split 一次
            String[] parts = line1.split(" ");
            for (String s : parts) {
                int num = Integer.parseInt(s); // 模拟解析数字
                count1++;
            }
        }
        br1.close();

        long endSplit = System.currentTimeMillis();
        System.out.println("✅ split() 读取并解析了 " + count1 + " 个数字");
        System.out.println("⏱️ split() 耗时: " + (endSplit - startSplit) + " ms\n");

        // 强制垃圾回收，保证测试公平
        System.gc();
        try { Thread.sleep(500); } catch (Exception e) {}

        // --- 真实环境测试 2: readLine() + StringTokenizer ---
        System.out.println("▶️ 开始测试: readLine() + StringTokenizer");
        long startTokenizer = System.currentTimeMillis();

        BufferedReader br2 = new BufferedReader(new FileReader(fileName));
        String line2;
        int count2 = 0;
        StringTokenizer st = null;
        while ((line2 = br2.readLine()) != null) {
            // 标准快读写法：丢进切菜机
            st = new StringTokenizer(line2);
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken()); // 模拟解析数字
                count2++;
            }
        }
        br2.close();

        long endTokenizer = System.currentTimeMillis();
        System.out.println("✅ StringTokenizer 读取并解析了 " + count2 + " 个数字");
        System.out.println("⏱️ StringTokenizer 耗时: " + (endTokenizer - startTokenizer) + " ms\n");

        System.out.println("🎉 最终结论: 在真实 I/O 环境下，StringTokenizer 比 split 快约 " +
                String.format("%.2f", (float)(endSplit - startSplit) / (endTokenizer - startTokenizer)) + " 倍!");

        // 测试结束，删除临时文件
        new File(fileName).delete();
    }

    // 生成测试数据的辅助方法
    private static void generateTestData(String fileName, int lines, int numsPerLine) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < numsPerLine; j++) {
                bw.write("12345 "); // 模拟一个数字
            }
            bw.write("\n");
        }
        bw.close();
    }
}