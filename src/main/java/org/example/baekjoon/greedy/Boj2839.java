package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Boj2839 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int input = Integer.parseInt(br.readLine());
        int max = (int) input / 5;
        int answer = -1;

        for (int i=max ; i>=0 ; i--) {
            int nmg = input - (5*i);
            if (nmg == 0) {
                answer = i;
                break;
            }
            if (nmg%3 == 0) {
                answer = (int) nmg/3 + i;
                break;
            }
        }

        System.out.println(answer);

    }
}
