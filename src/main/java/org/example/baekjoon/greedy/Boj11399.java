package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Boj11399 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] times = new int[inputs.length];
        for (int i=0 ; i<n ; i++)
            times[i] = Integer.parseInt(inputs[i]);

        Arrays.sort(times);

        int sum = 0;
        int answer = 0;
        for (int t : times) {
            sum += t;
            answer += sum;
        }

        System.out.println(answer);
    }
}