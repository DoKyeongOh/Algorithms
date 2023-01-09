package org.example.programmers.practice;

import junit.framework.TestCase;

public class 테이블_해시함수Test extends TestCase {

    public void testSolution() {
        assertEquals(4, 테이블_해시함수.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }
}