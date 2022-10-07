package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj2606 {

    static Map<String, List<String>> graph;

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int pc = Integer.parseInt(br.readLine());
        int lc = Integer.parseInt(br.readLine());
        graph = new HashMap<>();

        for (int i=0 ; i<lc ; i++) {
            String[] li = br.readLine().split(" ");
            if (!graph.containsKey(li[0]))
                graph.put(li[0], new ArrayList<>());
            if (!graph.containsKey(li[1]))
                graph.put(li[1], new ArrayList<>());

            graph.get(li[0]).add(li[1]);
            graph.get(li[1]).add(li[0]);
        }

        int count = dfs(new HashMap<>(), "1");
        System.out.println(count-1);

    }

    public static int dfs(Map<String, Boolean> map, String point){
        if (!map.containsKey(point)) {
            map.put(point, true);
        }
        for (String p : graph.get(point)) {
            if (!map.containsKey(p))
                dfs(map, p);
        }
        return map.keySet().size();
    }

}
