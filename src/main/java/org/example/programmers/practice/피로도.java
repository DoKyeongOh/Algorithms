package org.example.programmers.practice;

public class 피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int value = solution(k, dungeons);
        System.out.println(value);
    }

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int answer = dfs(visited, k, dungeons, 0);
        return answer;
    }

    public static int dfs(boolean[] visited, int k, int[][] dungeons, int depth) {
        int max = depth;
        for (int i=0 ; i<dungeons.length ; i++) {
            if (visited[i] || k<dungeons[i][0])
                continue;
            visited[i] = true;
            max = Math.max(max, dfs(visited, k - dungeons[i][1], dungeons, depth+1));
            visited[i] = false;
        }
        return max;
    }
}
