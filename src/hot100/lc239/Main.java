package hot100.lc239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc239
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/2 14:41
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = maxSlidingWindow(nums, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(i == res.length - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }

    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 0 || k == 0 ) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        MyDeque myDeque = new MyDeque();
        for(int i = 0; i < k; i++){
            myDeque.push(nums[i]);
        }
        res[index++] = myDeque.peek();

        for(int i = k; i < nums.length; i++){
            myDeque.poll(nums[i-k]);
            myDeque.push(nums[i]);
            res[index++] = myDeque.peek();
        }

        return res;
    }

}

class MyDeque{

    private Deque<Integer> deque;

    public MyDeque(){
        deque = new LinkedList<>();
    }

    public void poll(int value){
        if(!deque.isEmpty() && deque.peekFirst() == value){
            deque.pollFirst();
        }
    }

    public void push(int value){
        while(!deque.isEmpty() && value > deque.peekLast()){
            deque.pollLast();
        }
        deque.offerLast(value);
    }
    public int peek(){
        return deque.peekFirst();
    }
}
