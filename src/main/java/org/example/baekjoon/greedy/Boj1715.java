package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Boj1715 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution2(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        int buf = 0;

        for (int i=0 ; i<count ; i++)
            list.add(Integer.parseInt(br.readLine()));

        if (list.size() < 2) {
            System.out.println(0);
            return;
        }

        int size = list.size();
        Collections.sort(list);
        for (int i=0 ; i<size ; i++) {
            buf = list.remove(0) + list.remove(0);
            answer += buf;

            if (list.size() == 0)
                break;

            for (int n=list.size()-1 ; n>=0 ; n--) {
                if (buf < list.get(n))
                    continue;

                if (n==list.size()-1)
                    list.add(buf);
                else
                    list.add(n+1, buf);
                buf = 0;
                break;
            }
            if (buf != 0)
                list.add(0, buf);
        }
        System.out.println(answer);
    }

    public static void solution2(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0 ; i<count ; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int answer = 0;
        int buf = 0;
        for (int i=0 ; i<count ; i++) {
            if (pq.size() < 2)
                break;
            buf = pq.poll() + pq.poll();
            answer+= buf;
            pq.add(buf);
        }
        System.out.println(answer);

    }

}
