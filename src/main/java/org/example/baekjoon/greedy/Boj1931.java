package org.example.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Boj1931 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int iCount = Integer.parseInt(br.readLine());
        int[][] cos = new int[iCount][2];

        for (int i=0 ; i<iCount ; i++) {
            String[] items = br.readLine().split(" ");
            cos[i][0] = Integer.parseInt(items[0]);
            cos[i][1] = Integer.parseInt(items[1]);
        }

        Arrays.sort(cos, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0]-o1[1];
            return o1[1] - o2[1];
        });

        int count = 0;
        int lastEnd = 0;
        for (int[] co : cos) {
            if (lastEnd > co[0])
                continue;

            lastEnd = co[1];
            count++;
        }

        System.out.println(count);

    }
}
