package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Boj1541 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] items = br.readLine().split("-");
        int answer = 0;
        for (int i=0 ; i< items.length ; i++) {
            String[] nums = items[i].split("\\+");
            int item = 0;
            for (int j=0 ; j< nums.length ; j++) {
                
            }
        }
    }
}
