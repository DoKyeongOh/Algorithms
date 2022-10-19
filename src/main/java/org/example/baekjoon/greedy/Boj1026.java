package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Boj1026 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] items = br.readLine().split("");
        int n = Integer.parseInt(items[0]);
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        items = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++)
            arrA[i] = Integer.parseInt(items[i]);

        items = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++)
            arrB[i] = Integer.parseInt(items[i]);

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int sum = 0;
        for (int i=0 ; i<n ; i++)
            sum += arrA[i] * arrB[n-i-1];

        System.out.println(sum);
    }

}
