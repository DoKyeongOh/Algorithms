package org.example.programmers.practice;

public class 이모티콘_할인행사 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000}));
        System.out.println(solution(
                new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                new int[]{300, 1500, 1600, 4900}));
    }

    private static boolean[][] visited;
    private static int[] discounts = {90, 80, 70, 60};

    public static int[] solution(int[][] users, int[] emoticons) {
        visited = new boolean[emoticons.length][4];
        dfs(users, emoticons);

        return null;
    }

    public static int[] dfs(int[][] users, int[] emoticons) {
        int joinCount = 0;
        int totalPrice = 0;
        for (int[] user : users) {
            int price = 0;
            for (int e=0 ; e< emoticons.length ; e++) {
                if (user[0] > discounts[e])
                    continue;
                price += emoticons[e] * (100 - discounts[e]) / 100;
                if (price > user[1]) {
                    joinCount++;
                    price = 0;
                    break;
                }
            }
            totalPrice += price;
        }

        for (int i=0 ; i< visited.length ; i++) {
            for (int j=0 ; j<5 ; j++) {
                visited[i][j] = true;

            }
        }

        return null;
    }
}
