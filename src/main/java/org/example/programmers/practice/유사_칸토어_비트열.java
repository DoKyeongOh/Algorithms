package org.example.programmers.practice;

public class 유사_칸토어_비트열 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 17)); // 8
        System.out.println(solution(4, 30, 118)); // 39
        System.out.println(solution(3, 1, 125)); // 64
        System.out.println(solution(4, 27, 68)); // 15
    }

    public static int solution(int n, long l, long r) {
        return countOne(n, r) - countOne(n, l-1);
    }
/*
* 1101111011000001101111011
* 1101111011000001101111011
* 0000000000000000000000000
* 1101111011000001101111011
* 1101111011000001101111011
* */

    public static int countOne(int n, long target) {
        int answer = 0;
        int exCount = 0;
        long section = 1;
        for (int i=0 ; i<n-1 ; i++) {
            exCount++;
            section *= 5;
        }

        while (section > 0) {
            long mok = target / section;
            long nmg = target % section;
            if (mok == 0) {

            } else if (mok == 1) {
                answer += Math.pow(4, exCount) * mok;
                target = nmg;
            } else if (mok == 2) {
                answer += Math.pow(4, exCount) * mok;
                target = 0;
            } else {
                answer += Math.pow(4, exCount) * (mok-1);
                target = nmg;
            }
            section /= 5;
            exCount--;
        }
        return answer;
    }
}
