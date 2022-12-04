package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Boj13305 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        Long[] len = new Long[count-1];
        Long[] oil = new Long[count];

        String[] items = br.readLine().split(" ");
        for (int i=0 ; i<count-1 ; i++)
            len[i] = Long.parseLong(items[i]);

        items = br.readLine().split(" ");
        for (int i=0 ; i<count ; i++)
            oil[i] = Long.parseLong(items[i]);

        long min = oil[0];
        long total = 0;
        for (int i=0 ; i<count-1 ; i++) {
            if (oil[i] < min)
                min = oil[i];
            total += min * len[i];
        }

        System.out.println(total);
    }
}
