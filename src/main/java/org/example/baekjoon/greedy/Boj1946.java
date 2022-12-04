package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Boj1946 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution2(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int testCount = Integer.parseInt(br.readLine());

        for (int i=0 ; i<testCount ; i++) {
            int itemCount = Integer.parseInt(br.readLine());
            int[] arr = new int[itemCount+1];

            for (int n=0 ; n<itemCount ; n++) {
                String[] items = br.readLine().split(" ");
                arr[Integer.parseInt(items[0])] = Integer.parseInt(items[1]);
            }

            int count = 0;
            int min = arr[1];
            for (int n=1 ; n<=itemCount ; n++) {
                if (arr[n] > min)
                    continue;

                min=arr[n];
                count++;
            }
            System.out.println(count);
        }
    }

    public static void solution2(BufferedReader br) throws IOException {
        int testCount = Integer.parseInt(br.readLine());

        for (int i=0 ; i<testCount ; i++) {
            int itemCount = Integer.parseInt(br.readLine());
            int[][] rateArr = new int[itemCount][2];
            int aWinner = 0;
            int bWinner = 0;

            for (int n=0 ; n<itemCount ; n++) {
                String[] items = br.readLine().split(" ");
                rateArr[n][0] = Integer.parseInt(items[0]);
                rateArr[n][1] = Integer.parseInt(items[1]);
                if (rateArr[n][0]==1)
                    aWinner = n;
                if (rateArr[n][1]==1)
                    bWinner = n;
            }

            int count= rateArr.length;
            int minA = rateArr[bWinner][0];
            int minB = rateArr[aWinner][1];
            for (int n=0 ; n<itemCount ; n++) {

            }
            System.out.println(count);

        }
    }



}
