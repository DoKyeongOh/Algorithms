package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Boj2217 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        int min = 10000;
        int[] ws = new int[count];

        for (int i=0 ; i<count ; i++) {
            ws[i] = Integer.parseInt(br.readLine());
            if (min > ws[i])
                min = ws[i];
        }

        Arrays.sort(ws);
        int max = ws[count-1];
        int sum = max;
        int mid = 0;
        for (int i=count-2 ; i>=0 ; i--) {
            sum += ws[i];
            mid = sum * (count-i);
            if (mid > max)
                max=mid;
        }
    }
}
