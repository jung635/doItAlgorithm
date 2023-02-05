package ch4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // N개의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N]; // 3 5 2 7
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] answer = new int[N];
        for(int i = 1; i < N; i++) {
            int input = array[i];
            while (!stack.isEmpty() && array[stack.peek()] < input) {
                answer[stack.pop()] = input;
            }
            stack.push(i);
        }

        for(int i = 0; i < N; i++) {
            if(answer[i] > 0) bw.write(String.valueOf(answer[i]));
            else bw.write("-1");
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
