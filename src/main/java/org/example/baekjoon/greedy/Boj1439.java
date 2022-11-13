package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj1439 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] input = br.readLine().split("");
        int one=0; int zero=0;
        String pre = "";

        for (String s : input) {
            if (s.equals(pre))
                continue;

            if (s.equals("1")) one++;
            else zero++;
        }

        int answer = one > zero ? zero : one;
        if (one + zero == 1)
            answer = 0;

        System.out.println(answer);
    }

}
