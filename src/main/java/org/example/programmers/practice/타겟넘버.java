package org.example.programmers.practice;

public class 타겟넘버 {

    public static void main(String[] args) {
        count = 0;
        int[] input1 = {1, 1, 1, 1, 1};
        System.out.println(solution(input1, 3));

        count = 0;
        int[] input2 = {4, 1, 2, 1};
        System.out.println(solution(input2, 4));
    }

    static int count = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    public static void dfs(int[] numbers, int target, int depth, int sum) {
        if (numbers.length == depth) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(numbers, target, depth+1, sum - numbers[depth]);
        dfs(numbers, target, depth+1, sum + numbers[depth]);
    }
}
