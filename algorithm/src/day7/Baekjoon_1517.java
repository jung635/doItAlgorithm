package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1517 {
    static long[] tmp;
    static long[] array;
    static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new long[N];
        tmp = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        mergeSort(0, array.length - 1);
        //System.out.println(Arrays.toString(array));
        System.out.println(count);
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, end);
        }
    }

    static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int firstIndex = start;
        int secondIndex = mid + 1;
        int tmpIndex = start;

        while(firstIndex <= mid && secondIndex <= end) {
            if(array[firstIndex] <= array[secondIndex]) tmp[tmpIndex ++] = array[firstIndex ++]; //같은 케이스의 경우에 count 체크가 되어서는 안된다.
            else {
                count = count + secondIndex - tmpIndex;
                tmp[tmpIndex ++] = array[secondIndex ++];
            }
        }

        while(firstIndex <= mid) {
            tmp[tmpIndex ++] = array[firstIndex ++];
        }

        while(secondIndex <= end) {
            tmp[tmpIndex ++] = array[secondIndex ++];
        }

        for(int i = start; i <= end; i ++) {
            array[i] = tmp[i];
        }

    }
}
