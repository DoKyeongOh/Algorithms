package org.example.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj1715 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        int buf = 0;
        int cValue = 0;

        for (int i=0 ; i<count ; i++)
            numList.add(Integer.parseInt(br.readLine()));

        if (numList.size() < 2) {
            System.out.println(0);
            return;
        }

        int size = numList.size();
        Collections.sort(numList);
        for (int i=0 ; i<size ; i++) {
            buf = numList.remove(0) + numList.remove(0);
            cValue += buf;
            if (putItem(numList, buf).size() == 0)
                break;
        }
        System.out.println(cValue);
    }

    public static List<Integer> putItem(List<Integer> list, int value){
        if (value > list.get(list.size()-1)) {
            list.add(value);
            return list;
        }

        for (int i=0 ; i<list.size() ; i++) {
            if (list.get(i) <= value)
                continue;

            list.add(i, value);
            break;
        }
        return list;
    }

}
