package ch4;

import java.io.*;
import java.util.Stack;

public class Baekjoon_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //1 ~ n 이하의 정수
        Stack stack = new Stack();
        int stackNum = 0;

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(stack.isEmpty() || input > (int)stack.lastElement()) {
                for(int j = stackNum + 1; j <= input; j++) {
                    sb.append("+\n");
                    stack.push(j);
                }
                stackNum = input;
            }else if((int)stack.peek() != input) {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }

            sb.append("-\n");
            stack.pop();
        }

        System.out.println(sb);
        br.close();
    }
}
