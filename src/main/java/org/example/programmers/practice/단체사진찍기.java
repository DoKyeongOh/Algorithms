package org.example.programmers.practice;

public class 단체사진찍기 {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    static int answer = 0;
    public static int solution(int n, String[] data) {
        answer = 0;
        String[] names = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visited = new boolean[8];
        dfs(names, data, visited, "");
        return answer;
    }

    public static void dfs(String[] names, String[] data, boolean[] visited, String line) {
        if (line.length() == 7) {
            if (check(line, data)) {
                answer++;
            }
            return;
        }
        for (int i=0 ; i<names.length ; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(names, data, visited, line + names[i]);
            visited[i] = false;
        }
    }

    public static boolean check(String line, String[] data) {
        for (String d : data) {
            String[] items = d.split("");
            int start = line.indexOf(items[0]);
            int end = line.indexOf(items[2]);
            int length = Integer.parseInt(items[4]);
            if (items[3].equals("<")) {
                if (length+1 <= Math.abs(start - end))
                    return false;
            } else if (items[3].equals(">")) {
                if (length+1 >= Math.abs(start - end))
                    return false;
            } else {
                if (length+1 != Math.abs(start - end))
                    return false;
            }
        }
        return true;
    }

}
