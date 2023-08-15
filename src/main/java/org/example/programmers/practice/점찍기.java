package org.example.programmers.practice;

public class 점찍기 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    public static long solution(int k, int d) {
        long answer = 0;
        long limit = (long) Math.pow(d, 2);
        for (long a=0 ; a<=d ; a+=k) {
            long b = (long) Math.sqrt(limit - Math.pow(a, 2));
            answer += b/k + 1;
        }
        return answer;
    }
}
