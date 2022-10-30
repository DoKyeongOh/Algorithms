package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Boj10162 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int[] times = {300, 60, 10};
        int bc = times.length;
        int tl = Integer.parseInt(br.readLine());

        int[] counts = new int[bc];
        for (int i=0 ; i<bc ; i++) {
            counts[i] = (int) tl / times[i];
            tl = tl % times[i];
        }

        if (tl != 0) {
            System.out.println(-1);
            return;
        }

        String answer = "";
        for (int c : counts)
            answer = answer + c + " ";

        System.out.println(answer.trim());
        return;
    }
}
