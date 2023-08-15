package org.example.programmers.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스_게임 {
    public static void main(String[] args) {
        System.out.println(solution3(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1})); // 5
        System.out.println(solution3(7, 3, new int[]{5, 5, 5, 5, 2, 3, 1})); // 5
        System.out.println(solution3(1, 6, new int[]{2, 2, 2, 2, 3, 3, 1})); // 7
        System.out.println(solution3(10, 1,new int[]{2, 2, 2, 2, 2, 10})); // 6
        System.out.println(solution3(10, 1,new int[]{2, 2, 2, 2, 10})); // 5
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = k;
        if (k >= enemy.length) {
            return enemy.length;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int en : enemy) {
            if (queue.size() < k) {
                queue.add(en);
                continue;
            }

            if (en > queue.peek()) {
                queue.add(en);
                en = queue.poll();
            }

            n-= en;
            if (n < 0) {
                break;
            }

            answer++;
        }

        return answer;
    }

    public static int solution2(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {
            queue.add(e);
            answer++;
            n -= e;
            if (n < 0) {
                if(k==0){
                    return answer-1;
                }
                n = n + queue.poll();
                k--;
            }
        }

        return enemy.length;
    }

    public static int solution3(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0 ; i<enemy.length ; i++) {
            n -= enemy[i];
            queue.add(enemy[i]);

            new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return 0;
                }
            };
            if (n >= 0) {
                continue;
            }

            if (k <= 0) {
                return i;
            }

            n += queue.poll();
            k--;
        }
        return enemy.length;
    }
}
