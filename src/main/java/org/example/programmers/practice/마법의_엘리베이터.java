package org.example.programmers.practice;

public class 마법의_엘리베이터 {
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
        System.out.println(solution(155));
        System.out.println(solution(154));
        System.out.println(solution(646));
        System.out.println(solution(45));
        System.out.println(solution(55));
        System.out.println(solution(65));
    }

    public static int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int now = storey % 10;
            storey = storey / 10;

            if (now > 5) {
                answer += 10 - now;
                storey++;
            } else if (now < 5) {
                answer += now;
            } else {
                int next = storey % 10;
                if (next < 5) {
                    answer += now;
                } else {
                    answer += 10 - now;
                    storey++;
                }
            }
        }

        return answer;
    }
}
