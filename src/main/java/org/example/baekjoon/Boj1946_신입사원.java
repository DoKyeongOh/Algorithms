package org.example.baekjoon;

import java.io.*;

public class Boj1946_신입사원 {
    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
    }
    

    public static void solution(BufferedReader br) throws IOException {
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {

            int testCase = Integer.parseInt(br.readLine());
            int[] arr1 = new int[testCase];

            for (int n = 0; n < testCase; n++) {
                String[] scores = br.readLine().split(" ");
                arr1[Integer.parseInt(scores[0])-1] = Integer.parseInt(scores[1]);
            }

            int count = 0;
            int std = arr1[0];
            for (int n = 0; n < testCase; n++) {
                if (arr1[n] <= std) {
                    std = arr1[n];
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}
