package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Boj11047 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] items = br.readLine().split(" ");
        int mc = Integer.parseInt(items[0]);
        int target = Integer.parseInt(items[1]);

        int[] money = new int[mc];

        for (int i=0 ; i<mc ; i++)
            money[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=mc-1 ; i>=0 ; i--) {
            count += (int) target / money[i];
            target = target % money[i];
            if (target == 0)
                break;
        }
        System.out.println(count);

    }
}