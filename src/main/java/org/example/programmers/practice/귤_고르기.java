package org.example.programmers.practice;

import java.util.*;


public class 귤_고르기 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int t : tangerine) {
            if (!map.containsKey(t)) {
                map.put(t, 0);
                list.add(t);
            }
            map.replace(t, map.get(t) + 1);
        }

        Collections.sort(list, (t1, t2) -> map.get(t2) - map.get(t1));

        int answer = 0;
        for (int i : list) {
            k -= map.get(i);
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
