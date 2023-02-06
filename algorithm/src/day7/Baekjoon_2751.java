package day7;

import java.io.*;

//합병 절렬 사용
public class Baekjoon_2751 {
    private static int[] answer; //answer를 merge안에서 선언하게되면, 크기가 N인 메모리를 할당하는 것은 O(N)시간이 걸려 총 시간복잡도가 O(N^2)이 된다. 따라서 전역에 선언함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); //N개의 수
        int[] array = new int[N];
        answer = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        sort(array, 0, array.length - 1);
        for(int i = 0; i < N; i++) {
            bw.write(array[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        int firstIndex = start;
        int secondIndex = mid + 1;
        int answerIndex = start;


        while(firstIndex <= mid && secondIndex <= end) {
            if(array[firstIndex] < array[secondIndex]) answer[answerIndex++] = array[firstIndex++];
            else answer[answerIndex++] = array[secondIndex++];
        }

        //남아 있는 값 일괄 복사
        while (firstIndex <= mid) {
            answer[answerIndex++] = array[firstIndex++];
        }
        while (secondIndex <= end) {
            answer[answerIndex++] = array[secondIndex++];
        }

        for(int i = start; i <= end; i++) {
            array[i] = answer[i];
        }
    }

    private static void sort(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if(start < end) {
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, end);
        }
    }
}
