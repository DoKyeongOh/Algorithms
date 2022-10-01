package org.example.baekjoon;

import java.io.*;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.*;

public class Boj1260 {

    static Map<String, List<String>> graph;

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] items = br.readLine().split(" ");
        int pointCount = Integer.parseInt(items[0]);
        int lineCount = Integer.parseInt(items[1]);
        String startPoint = items[2];

        graph = new HashMap<>();

        // 그래프 형태 만들기
        for (int i=0 ; i<lineCount ; i++) {
            items = br.readLine().split(" ");
            String p1 = items[0];
            String p2 = items[1];
            if (!graph.containsKey(p1))
                graph.put(p1, new ArrayList<String>());
            if (!graph.containsKey(p2))
                graph.put(p2, new ArrayList<String>());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        for (String s : graph.keySet())
            Collections.sort(graph.get(s));

        List<String> dfsList = new ArrayList<>();
        dfsList.add(startPoint);
        List<String> bfsList = new ArrayList<>();
        bfsList.add(startPoint);

        List<String> dfs = dfsFunc(pointCount, dfsList);
        List<String> bfs = bfsFunc(pointCount, bfsList, 0);
        print(dfs); print(bfs);
    }

    public static List<String> dfsFunc(int max, List<String> answer){
        String now = answer.get(answer.size()-1);
        if (!graph.containsKey(now))
            return answer;
        for (String s : graph.get(now)) {
            if (!answer.contains(s)) {
                answer.add(s);
                answer = dfsFunc(max, answer);
            }
        }
        return answer;
    }

    public static List<String> bfsFunc(int max, List<String> answer, int idx){
        String now = answer.get(idx);
        if (!graph.containsKey(now))
            return answer;
        for (String s : graph.get(now)) {
            if (!answer.contains(s))
                answer.add(s);
        }

        if (idx < answer.size()-1) {
            idx++;
            answer = bfsFunc(max, answer, idx);
        }

        return answer;
    }

    public static void print(List<String> item){
        String value = "";
        for (String s : item)
            value = value + s + " ";

        value = value.substring(0, value.length()-1);
        System.out.println(value);
    }
}